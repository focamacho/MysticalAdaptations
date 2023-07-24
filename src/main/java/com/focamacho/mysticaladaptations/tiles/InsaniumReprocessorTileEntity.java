package com.focamacho.mysticaladaptations.tiles;

import com.blakebr0.cucumber.energy.BaseEnergyStorage;
import com.blakebr0.cucumber.helper.StackHelper;
import com.blakebr0.cucumber.inventory.BaseItemStackHandler;
import com.blakebr0.cucumber.inventory.SidedItemStackHandlerWrapper;
import com.blakebr0.cucumber.tileentity.BaseInventoryTileEntity;
import com.blakebr0.cucumber.util.Localizable;
import com.blakebr0.mysticalagriculture.crafting.recipe.ReprocessorRecipe;
import com.blakebr0.mysticalagriculture.init.ModRecipeTypes;
import com.focamacho.mysticaladaptations.container.InsaniumReprocessorContainer;
import com.focamacho.mysticaladaptations.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandlerModifiable;

public class InsaniumReprocessorTileEntity extends BaseInventoryTileEntity implements MenuProvider {

    private static final int FUEL_TICK_MULTIPLIER = 20;
    private final BaseItemStackHandler inventory;
    private final BaseEnergyStorage energy;
    private final LazyOptional<IItemHandlerModifiable>[] inventoryCapabilities;
    private final LazyOptional<IEnergyStorage> energyCapability = LazyOptional.of(this::getEnergy);
    private ReprocessorRecipe recipe;
    private int progress;
    private int fuelLeft;
    private int fuelItemValue;

    //Insanium Reprocessor Values
    private static final int fuelUsage = 11520;
    private static final int fuelCapacity = 2560000;

    public InsaniumReprocessorTileEntity(BlockPos pos, BlockState state) {
        super(ModTileEntities.INSANIUM_REPROCESSOR.get(), pos, state);
        this.inventory = createInventoryHandler(null);
        this.energy = new BaseEnergyStorage(fuelCapacity, this::markDirtyAndDispatch);
        this.inventoryCapabilities = SidedItemStackHandlerWrapper.create(this.inventory, new Direction[]{Direction.UP, Direction.DOWN, Direction.NORTH}, this::canInsertStackSided, null);
    }

    @Override
    public BaseItemStackHandler getInventory() {
        return this.inventory;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.progress = tag.getInt("Progress");
        this.fuelLeft = tag.getInt("FuelLeft");
        this.fuelItemValue = tag.getInt("FuelItemValue");
        this.energy.deserializeNBT(tag.get("Energy"));
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        tag.putInt("Progress", this.progress);
        tag.putInt("FuelLeft", this.fuelLeft);
        tag.putInt("FuelItemValue", this.fuelItemValue);
        tag.put("Energy", this.energy.serializeNBT());
    }

    @Override
    public Component getDisplayName() {
        return Localizable.of("container.mysticalagriculture.reprocessor").build();
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
        return InsaniumReprocessorContainer.create(id, playerInventory, this::isUsableByPlayer, this.inventory, this.getBlockPos());
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (!this.isRemoved()) {
            if (cap == ForgeCapabilities.ENERGY) {
                return ForgeCapabilities.ENERGY.orEmpty(cap, this.energyCapability);
            }

            if (side != null && cap == ForgeCapabilities.ITEM_HANDLER) {
                if (side == Direction.UP) {
                    return this.inventoryCapabilities[0].cast();
                } else if (side == Direction.DOWN) {
                    return this.inventoryCapabilities[1].cast();
                } else {
                    return this.inventoryCapabilities[2].cast();
                }
            }
        }

        return super.getCapability(cap, side);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, InsaniumReprocessorTileEntity tile) {
        var mark = false;

        if (tile.energy.getEnergyStored() < tile.energy.getMaxEnergyStored()) {
            var fuel = tile.inventory.getStackInSlot(1);

            for(int i = 0; i < 4; i++) {
                if (tile.fuelLeft <= 0 && !fuel.isEmpty()) {
                    tile.fuelItemValue = ForgeHooks.getBurnTime(fuel, null);

                    if (tile.fuelItemValue > 0) {
                        tile.fuelLeft = tile.fuelItemValue *= FUEL_TICK_MULTIPLIER;
                        tile.inventory.setStackInSlot(1, StackHelper.shrink(tile.inventory.getStackInSlot(1), 1, false));

                        mark = true;
                    }
                }

                if (tile.fuelLeft > 0) {
                    var fuelPerTick = Math.min(Math.min(tile.fuelLeft, fuelUsage * 2), tile.energy.getMaxEnergyStored() - tile.energy.getEnergyStored());

                    tile.fuelLeft -= tile.energy.receiveEnergy(fuelPerTick, false);

                    if (tile.fuelLeft <= 0)
                        tile.fuelItemValue = 0;

                    mark = true;
                }
            }
        }

        if (tile.energy.getEnergyStored() >= fuelUsage) {
            for(int i = 0; i < Math.min(tile.energy.getEnergyStored() / fuelUsage, 4); i++) {
                var input = tile.inventory.getStackInSlot(0);
                var output = tile.inventory.getStackInSlot(2);

                if (!input.isEmpty()) {
                    if (tile.recipe == null || !tile.recipe.matches(tile.inventory)) {
                        var recipe = level.getRecipeManager().getRecipeFor(ModRecipeTypes.REPROCESSOR.get(), tile.inventory.toIInventory(), level).orElse(null);
                        tile.recipe = recipe instanceof ReprocessorRecipe ? (ReprocessorRecipe) recipe : null;
                    }

                    if (tile.recipe != null) {
                        var recipeOutput = tile.recipe.assemble(tile.inventory, level.registryAccess());
                        if (!recipeOutput.isEmpty() && (output.isEmpty() || StackHelper.canCombineStacks(output, recipeOutput))) {
                            tile.progress = 0;
                            tile.energy.extractEnergy(fuelUsage, false);

                            tile.inventory.setStackInSlot(0, StackHelper.shrink(tile.inventory.getStackInSlot(0), 1, false));

                            var result = StackHelper.combineStacks(output, recipeOutput);
                            tile.inventory.setStackInSlot(2, result);

                            mark = true;
                        }
                    } else break;
                } else {
                    if(tile.recipe != null) {
                        tile.recipe = null;
                        mark = true;
                    }

                    break;
                }
            }
        }

        if (mark) {
            tile.markDirtyAndDispatch();
        }
    }

    public static BaseItemStackHandler createInventoryHandler(Runnable onContentsChanged) {
        var inventory = BaseItemStackHandler.create(3, onContentsChanged);

        inventory.setOutputSlots(2);

        return inventory;
    }

    public EnergyStorage getEnergy() {
        return this.energy;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getFuelLeft() {
        return this.fuelLeft;
    }

    public int getFuelItemValue() {
        return this.fuelItemValue;
    }

    private boolean canInsertStackSided(int slot, ItemStack stack, Direction direction) {
        if (direction == null)
            return true;
        if (slot == 0 && direction == Direction.UP)
            return true;
        if (slot == 1 && direction == Direction.NORTH)
            return FurnaceBlockEntity.isFuel(stack);

        return false;
    }

}