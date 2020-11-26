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
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class WoodcutterAugment extends Augment {

    public WoodcutterAugment(ResourceLocation id) {
        super(id, 6, EnumSet.of(AugmentType.AXE), 15654992, 2825844);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, PlayerEntity player) {
        World world = player.getEntityWorld();
        BlockRayTraceResult trace = BlockHelper.rayTraceBlocks(world, player);
        int side = trace.getFace().ordinal();
        return !this.harvest(stack, world, pos, side, player);
    }

    private boolean harvest(ItemStack stack, World world, BlockPos pos, int side, PlayerEntity player) {
        boolean woodcutter = true;

        if (player.isCrouching()) {
            woodcutter = false;
        }

        BlockPos blockPos = pos;
        List<BlockPos> toHarvest = new ArrayList<BlockPos>();

        if(woodcutter) {
            do {
                toHarvest.add(blockPos);
                blockPos = blockPos.up();
            } while (isWood(world.getBlockState(blockPos).getBlock()));
        } else toHarvest.add(pos);

        BlockState state = world.getBlockState(pos);
        float hardness = state.getBlockHardness(world, pos);
        if (!this.tryHarvest(world, pos, false, stack, player)) {
            return false;
        } else {
            Block block = state.getBlock();
            if (woodcutter && hardness >= 0.2F && block.getHarvestTool(state) == null || stack.getToolTypes().stream().anyMatch((t) -> {
                return block.isToolEffective(state, t);
            })) {
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
        float hardness = state.getBlockHardness(world, pos);
        Item item = stack.getItem();
        boolean harvest = (ForgeHooks.canHarvestBlock(state, player, world, pos) || item.canHarvestBlock(stack, state)) && (!extra || item.getDestroySpeed(stack, world.getBlockState(pos)) > 1.0F);
        return hardness < 0.0F || extra && !harvest ? false : BlockHelper.breakBlocksAOE(stack, world, player, pos);
    }

    private boolean isWood(Block block) {
        return BlockTags.getCollection().get(new ResourceLocation("minecraft:logs")).contains(block);
    }
}
