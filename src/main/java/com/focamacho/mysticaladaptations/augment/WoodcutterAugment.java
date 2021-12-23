package com.focamacho.mysticaladaptations.augment;

import com.blakebr0.cucumber.helper.BlockHelper;
import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

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
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, Player player) {
        Level world = player.getCommandSenderWorld();
        return !this.harvest(stack, world, pos, player);
    }

    private boolean harvest(ItemStack stack, Level world, BlockPos pos, Player player) {
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
            if (woodcutter && hardness >= 0.2F && stack.isCorrectToolForDrops(state)) {
                toHarvest.forEach((woodPos) -> {
                    if(woodPos != pos){
                        this.tryHarvest(world, woodPos, true, stack, player);
                    }
                });
            }

            return true;
        }
    }

    private boolean tryHarvest(Level world, BlockPos pos, boolean extra, ItemStack stack, Player player) {
        BlockState state = world.getBlockState(pos);
        float hardness = state.getDestroySpeed(world, pos);
        Item item = stack.getItem();
        boolean harvest = (state.canHarvestBlock(world, pos, player) || item.isCorrectToolForDrops(stack, state)) && (!extra || item.getDestroySpeed(stack, world.getBlockState(pos)) > 1.0F);
        return !(hardness < 0.0F) && (!extra || harvest) && BlockHelper.breakBlocksAOE(stack, world, player, pos);
    }

    private boolean isWood(Block block) {
        //Tag minecraft:logs never will be null
        return Objects.requireNonNull(BlockTags.getAllTags().getTag(new ResourceLocation("minecraft", "logs"))).contains(block);
    }
}
