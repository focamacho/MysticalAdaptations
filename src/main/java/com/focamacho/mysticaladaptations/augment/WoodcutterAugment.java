package com.focamacho.mysticaladaptations.augment;

import com.blakebr0.cucumber.util.ToolTools;
import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.*;
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
        float f = player.rotationPitch;
        float f1 = player.rotationYaw;
        Vec3d vec3d = player.getEyePosition(1.0F);
        float f2 = MathHelper.cos(-f1 * 0.017453292F - 3.1415927F);
        float f3 = MathHelper.sin(-f1 * 0.017453292F - 3.1415927F);
        float f4 = -MathHelper.cos(-f * 0.017453292F);
        float f5 = MathHelper.sin(-f * 0.017453292F);
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = player.getAttribute(PlayerEntity.REACH_DISTANCE).getValue();
        Vec3d vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        World world = player.getEntityWorld();
        BlockRayTraceResult ray = world.rayTraceBlocks(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, player));
        int side = ray.getFace().ordinal();
        return !this.harvest(stack, world, pos, side, player);
    }

    private boolean harvest(ItemStack stack, World world, BlockPos pos, int side, PlayerEntity player) {
        boolean woodcutter = true;

        if (player.isSneaking()) {
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
        return hardness < 0.0F || extra && !harvest ? false : ToolTools.breakBlocksAOE(stack, world, player, pos);
    }

    private boolean isWood(Block block) {
        return BlockTags.getCollection().getOrCreate(new ResourceLocation("minecraft:logs")).contains(block);
    }
}
