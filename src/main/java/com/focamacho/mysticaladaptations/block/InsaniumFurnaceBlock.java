package com.focamacho.mysticaladaptations.block;

import com.blakebr0.mysticalagriculture.lib.ModTooltips;
import com.focamacho.mysticaladaptations.init.ModTileEntities;
import com.focamacho.mysticaladaptations.tiles.InsaniumFurnaceTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TextComponent;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class InsaniumFurnaceBlock extends AbstractFurnaceBlock {

    public InsaniumFurnaceBlock() {
        super(Properties.copy(Blocks.FURNACE));
    }

    @Override
    protected void openContainer(Level world, BlockPos pos, Player player) {
        BlockEntity tile = world.getBlockEntity(pos);
        if (tile instanceof InsaniumFurnaceTileEntity) {
            player.openMenu((InsaniumFurnaceTileEntity) tile);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new InsaniumFurnaceTileEntity(pos, state);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {}

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tile = world.getBlockEntity(pos);
            if (tile instanceof InsaniumFurnaceTileEntity) {
                InsaniumFurnaceTileEntity furnace = (InsaniumFurnaceTileEntity) tile;
                Containers.dropContents(world, pos, furnace);
            }
        }

        super.onRemove(state, world, pos, newState, isMoving);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, BlockGetter world, List<Component> tooltip, TooltipFlag flag) {
        double cookingSpeedDifference = 200D * 0.01D;
        double cookingSpeedValue = Math.ceil(((200D - cookingSpeedDifference) / cookingSpeedDifference) * 100D) + 100D;
        Component cookingSpeed = Component.literal(String.valueOf((int) cookingSpeedValue)).append("%");
        double burnTimeDifference = (1600D * 0.1D) / cookingSpeedDifference;
        double burnTimeValue = Math.ceil(((burnTimeDifference - 8D) / 8D) * 100D) + 100D;
        Component fuelEfficiency = Component.literal(String.valueOf((int) burnTimeValue)).append("%");
        tooltip.add(ModTooltips.COOKING_SPEED.args(cookingSpeed).build());
        tooltip.add(ModTooltips.FUEL_EFFICIENCY.args(fuelEfficiency).build());
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTicker(level, type);
    }

    protected <T extends BlockEntity> BlockEntityTicker<T> createTicker(Level level, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, ModTileEntities.INSANIUM_FURNACE.get(), InsaniumFurnaceTileEntity::tick);
    }

}