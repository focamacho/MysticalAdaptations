package com.focamacho.mysticaladaptations.block;

import com.blakebr0.cucumber.block.BaseTileEntityBlock;
import com.blakebr0.mysticalagriculture.lib.ModTooltips;
import com.focamacho.mysticaladaptations.tiles.InsaniumReprocessorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class InsaniumReprocessorBlock extends BaseTileEntityBlock {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public InsaniumReprocessorBlock() {
        super(Material.IRON, SoundType.METAL, 3.5F, 3.5F);
        this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new InsaniumReprocessorTileEntity();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!world.isRemote()) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof InsaniumReprocessorTileEntity) {
                player.openContainer((INamedContainerProvider) tile);
            }
        }

        return ActionResultType.SUCCESS;
    }

    @Override
    public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof InsaniumReprocessorTileEntity) {
                InsaniumReprocessorTileEntity furnace = (InsaniumReprocessorTileEntity) tile;
                InventoryHelper.dropItems(world, pos, furnace.getInventory().getStacks());
            }
        }

        super.onReplaced(state, world, pos, newState, isMoving);
    }
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, IBlockReader world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(ModTooltips.REPROCESSOR_SPEED.args(1).build());
        tooltip.add(ModTooltips.REPROCESSOR_FUEL_RATE.args(38).build());
        tooltip.add(ModTooltips.REPROCESSOR_FUEL_CAPACITY.args(40000).build());
    }

}