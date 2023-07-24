package com.focamacho.mysticaladaptations.block;

import com.blakebr0.cucumber.block.BaseTileEntityBlock;
import com.blakebr0.cucumber.lib.Tooltips;
import com.blakebr0.mysticalagriculture.lib.ModTooltips;
import com.focamacho.mysticaladaptations.init.ModTileEntities;
import com.focamacho.mysticaladaptations.tiles.InsaniumReprocessorTileEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.text.NumberFormat;
import java.util.List;

public class InsaniumReprocessorBlock extends BaseTileEntityBlock {

    private static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public InsaniumReprocessorBlock() {
        super(SoundType.METAL, 3.5F, 3.5F, true);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new InsaniumReprocessorTileEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide()) {
            BlockEntity tile = world.getBlockEntity(pos);
            if (tile instanceof InsaniumReprocessorTileEntity) {
                NetworkHooks.openScreen((ServerPlayer) player, (MenuProvider) tile, pos);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tile = world.getBlockEntity(pos);
            if (tile instanceof InsaniumReprocessorTileEntity) {
                InsaniumReprocessorTileEntity furnace = (InsaniumReprocessorTileEntity) tile;
                Containers.dropContents(world, pos, furnace.getInventory().getStacks());
            }
        }

        super.onRemove(state, world, pos, newState, isMoving);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, BlockGetter world, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            tooltip.add(ModTooltips.MACHINE_SPEED.args(Component.literal(NumberFormat.getInstance().format(0.25)).withStyle(ChatFormatting.DARK_PURPLE)).build());
            tooltip.add(ModTooltips.MACHINE_FUEL_RATE.args(Component.literal(NumberFormat.getInstance().format(11520)).withStyle(ChatFormatting.DARK_PURPLE)).build());
            tooltip.add(ModTooltips.MACHINE_FUEL_CAPACITY.args(Component.literal(NumberFormat.getInstance().format(2560000)).withStyle(ChatFormatting.DARK_PURPLE)).build());
        } else {
            tooltip.add(Tooltips.HOLD_SHIFT_FOR_INFO.build());
        }
    }

    @Override
    protected <T extends BlockEntity> BlockEntityTicker<T> getServerTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTicker(type, ModTileEntities.INSANIUM_REPROCESSOR.get(), InsaniumReprocessorTileEntity::tick);
    }

}