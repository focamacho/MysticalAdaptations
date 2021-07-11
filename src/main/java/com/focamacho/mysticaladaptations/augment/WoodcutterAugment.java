package com.focamacho.mysticaladaptations.augment;

import com.blakebr0.cucumber.helper.BlockHelper;
import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

/*
 * TO-DO:
 * Make it cuts the entire tree
 */
public class WoodcutterAugment extends Augment {

    public WoodcutterAugment(ResourceLocation id) {
        super(id, 6, EnumSet.of(AugmentType.AXE), 15654992, 2825844);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, PlayerEntity player) {
        World world = player.getCommandSenderWorld();
        return !this.harvest(stack, world, pos, player);
    }

    private boolean harvest(ItemStack stack, World world, BlockPos pos, PlayerEntity player) {
        boolean woodcutter = !player.isCrouching();

        BlockPos blockPos = pos;
        List<BlockPos> toHarvest = new ArrayList<>();

        if(woodcutter) {
            do {
                toHarvest.add(blockPos);
                blockPos = blockPos.above();
            } while (isWood(world.getBlockState(blockPos).getBlock()));
        } else toHarvest.add(pos);

        BlockState state = world.getBlockState(pos);
        float hardness = state.getDestroySpeed(world, pos);
        if (!this.tryHarvest(world, pos, false, stack, player)) {
            return false;
        } else {
            Block block = state.getBlock();
            if (woodcutter && hardness >= 0.2F && block.getHarvestTool(state) == null || stack.getToolTypes().stream().anyMatch((t) -> block.isToolEffective(state, t))) {
                toHarvest.forEach((woodPos) -> {
                    if(woodPos != pos){
                        this.tryHarvest(world, woodPos, true, stack, player);
                    }
                });
            }

            return true;
        }
    }

    private boolean tryHarvest(World world, BlockPos pos, boolean extra, ItemStack stack, PlayerEntity player) {
        BlockState state = world.getBlockState(pos);
        float hardness = state.getDestroySpeed(world, pos);
        Item item = stack.getItem();
        boolean harvest = (ForgeHooks.canHarvestBlock(state, player, world, pos) || item.canHarvestBlock(stack, state)) && (!extra || item.getDestroySpeed(stack, world.getBlockState(pos)) > 1.0F);
        return !(hardness < 0.0F) && (!extra || harvest) && BlockHelper.breakBlocksAOE(stack, world, player, pos);
    }

    private boolean isWood(Block block) {
        //Tag minecraft:logs never will be null
        return Objects.requireNonNull(BlockTags.getAllTags().getTag(new ResourceLocation("minecraft", "logs"))).contains(block);
    }
}
