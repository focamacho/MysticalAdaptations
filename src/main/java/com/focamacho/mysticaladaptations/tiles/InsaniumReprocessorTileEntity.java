package com.focamacho.mysticaladaptations.tiles;

import com.blakebr0.cucumber.energy.BaseEnergyStorage;
import com.blakebr0.cucumber.helper.StackHelper;
import com.blakebr0.cucumber.inventory.BaseItemStackHandler;
import com.blakebr0.cucumber.inventory.SidedItemStackHandlerWrapper;
import com.blakebr0.cucumber.tileentity.BaseInventoryTileEntity;
import com.blakebr0.cucumber.util.Localizable;
import com.blakebr0.mysticalagriculture.api.crafting.IReprocessorRecipe;
import com.blakebr0.mysticalagriculture.api.crafting.RecipeTypes;
import com.blakebr0.mysticalagriculture.crafting.recipe.ReprocessorRecipe;
import com.focamacho.mysticaladaptations.container.InsaniumReprocessorContainer;
import com.focamacho.mysticaladaptations.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class InsaniumReprocessorTileEntity extends BaseInventoryTileEntity implements INamedContainerProvider, ITickableTileEntity {
    private static final int FUEL_TICK_MULTIPLIER = 20;
    private final BaseItemStackHandler inventory;
    private final BaseEnergyStorage energy;
    private final LazyOptional<IItemHandlerModifiable>[] inventoryCapabilities;
    private final LazyOptional<IEnergyStorage> energyCapability = LazyOptional.of(this::getEnergy);
    private ReprocessorRecipe recipe;
    private int progress;
    private int fuelLeft;
    private int fuelItemValue;
    private int oldEnergy;

    //Insanium Reprocessor Values
    private final int operationTime = 1;
    private final int fuelUsage = 2880;
    private final int fuelCapacity = 860000;

    public InsaniumReprocessorTileEntity() {
        super(ModTileEntities.INSANIUM_REPROCESSOR.get());
        this.inventory = new BaseItemStackHandler(3);
        this.energy = new BaseEnergyStorage(this.fuelCapacity);
        this.inventoryCapabilities = SidedItemStackHandlerWrapper.create(this.inventory, new Direction[] { Direction.UP, Direction.DOWN, Direction.NORTH }, this::canInsertStackSided, null);

        this.inventory.setOutputSlots(2);
    }

    @Override
    public BaseItemStackHandler getInventory() {
        return this.inventory;
    }

    @Override
    public void load(BlockState state, CompoundNBT tag) {
        super.load(state, tag);
        this.progress = tag.getInt("Progress");
        this.fuelLeft = tag.getInt("FuelLeft");
        this.fuelItemValue = tag.getInt("FuelItemValue");
        this.energy.setEnergy(tag.getInt("Energy"));
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        tag = super.save(tag);
        tag.putInt("Progress", this.progress);
        tag.putInt("FuelLeft", this.fuelLeft);
        tag.putInt("FuelItemValue", this.fuelItemValue);
        tag.putInt("Energy", this.energy.getEnergyStored());

        return tag;
    }

    @Override
    public void tick() {
        World world = this.getLevel();
        if (world == null || world.isClientSide())
            return;

        boolean mark = false;

        if (this.energy.getEnergyStored() < this.energy.getMaxEnergyStored()) {
            ItemStack fuel = this.inventory.getStackInSlot(1);

            if (this.fuelLeft <= 0 && !fuel.isEmpty()) {
                this.fuelItemValue = ForgeHooks.getBurnTime(fuel);

                if (this.fuelItemValue > 0) {
                    this.fuelLeft = this.fuelItemValue *= FUEL_TICK_MULTIPLIER;
                    this.inventory.extractItemSuper(1, 1, false);

                    mark = true;
                }
            }

            if (this.fuelLeft > 0) {
                int fuelPerTick = Math.min(Math.min(this.fuelLeft, this.fuelUsage * 2), this.energy.getMaxEnergyStored() - this.energy.getEnergyStored());

                this.fuelLeft -= this.energy.receiveEnergy(fuelPerTick, false);

                if (this.fuelLeft <= 0)
                    this.fuelItemValue = 0;

                mark = true;
            }
        }

        if (this.energy.getEnergyStored() >= this.fuelUsage) {
            ItemStack input = this.inventory.getStackInSlot(0);
            ItemStack output = this.inventory.getStackInSlot(2);

            if (!input.isEmpty()) {
                if (this.recipe == null || !this.recipe.matches(this.inventory)) {
                    IReprocessorRecipe recipe = world.getRecipeManager().getRecipeFor(RecipeTypes.REPROCESSOR, this.inventory.toIInventory(), world).orElse(null);
                    this.recipe = recipe instanceof ReprocessorRecipe ? (ReprocessorRecipe) recipe : null;
                }

                if (this.recipe != null) {
                    ItemStack recipeOutput = this.recipe.getCraftingResult(this.inventory);
                    if (!recipeOutput.isEmpty() && (output.isEmpty() || StackHelper.canCombineStacks(output, recipeOutput))) {
                        this.progress++;
                        this.energy.extractEnergy(this.fuelUsage, false);

                        if (this.progress >= this.operationTime) {
                            this.inventory.extractItemSuper(0, 1, false);

                            ItemStack result = StackHelper.combineStacks(output, recipeOutput);
                            this.inventory.setStackInSlot(2, result);

                            this.progress = 0;
                        }

                        mark = true;
                    }
                }
            } else {
                if (this.progress > 0) {
                    this.progress = 0;
                    this.recipe = null;
                    mark = true;
                }
            }
        }

        if (this.oldEnergy != this.energy.getEnergyStored()) {
            this.oldEnergy = this.energy.getEnergyStored();

            mark = true;
        }

        if (mark) {
            this.markDirtyAndDispatch();
        }
    }

    @Override
    public ITextComponent getDisplayName() {
        return Localizable.of("container.mysticalagriculture.reprocessor").build();
    }

    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
        return InsaniumReprocessorContainer.create(id, playerInventory, this::isUsableByPlayer, this.inventory, this.getBlockPos());
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (!this.isRemoved()) {
            if (cap == CapabilityEnergy.ENERGY) {
                return CapabilityEnergy.ENERGY.orEmpty(cap, this.energyCapability);
            }

            if (side != null && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
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

    public BaseEnergyStorage getEnergy() {
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

    public int getOperationTime() {
        return operationTime;
    }

    private boolean canInsertStackSided(int slot, ItemStack stack, Direction direction) {
        if (direction == null)
            return true;
        if (slot == 0 && direction == Direction.UP)
            return true;
        if (slot == 1 && direction == Direction.NORTH)
            return FurnaceTileEntity.isFuel(stack);

        return false;
    }

}
