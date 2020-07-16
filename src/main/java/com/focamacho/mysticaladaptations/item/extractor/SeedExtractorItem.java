package com.focamacho.mysticaladaptations.item.extractor;

import com.focamacho.mysticaladaptations.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class SeedExtractorItem extends Item {

    private static int tier;

    public SeedExtractorItem(Properties properties, int tier){
        super(properties);
        this.tier = tier;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        Item seed = null;
        RayTraceResult rayTrace = this.rayTrace(world, player, RayTraceContext.FluidMode.SOURCE_ONLY);
        SeedExtractorItem extractor = (SeedExtractorItem) player.getHeldItem(hand).getItem();

        if(rayTrace != null && rayTrace.getType() == RayTraceResult.Type.BLOCK){
            BlockRayTraceResult blockRaytrace = (BlockRayTraceResult) rayTrace;

            BlockPos pos = blockRaytrace.getPos();
            Block block = world.getBlockState(pos).getBlock();
            Item item = block.asItem();

            seed = SeedExtractorRecipeHandler.getSeedFromBlock(extractor, item, block);
            if(seed != null) {
                if(!world.isRemote()){
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(seed));
                    world.addEntity(itemEntity);
                    itemEntity.onCollideWithPlayer(player);
                } else {
                    for(int i = 0; i < 10; ++i) {
                        double d0 = random.nextGaussian() * 0.02D;
                        double d1 = random.nextGaussian() * 0.02D;
                        double d2 = random.nextGaussian() * 0.02D;
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double)((float)pos.getX() + random.nextFloat()), (double)pos.getY() + (double)random.nextFloat() * world.getBlockState(pos).getShape(world, pos).getEnd(Direction.Axis.Y), (double)((float)pos.getZ() + random.nextFloat()), d0, d1, d2);
                    }
                    world.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1, 1);
                }
            }

        }

        return super.onItemRightClick(world, player, hand);
    }

    public static int getTier() {
        return tier;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent(TextFormatting.GRAY + new TranslationTextComponent("tooltip.mysticalagriculture.tier").getString() + Utils.getColorFromTier(this.tier) + this.tier));
    }
}
