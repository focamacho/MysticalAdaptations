package com.focamacho.mysticaladaptations.tileentity;

import com.blakebr0.cucumber.util.Localizable;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;

public class InsaniumFurnaceTileEntity extends AbstractFurnaceTileEntity {
    public InsaniumFurnaceTileEntity() {
        super(MysticalAdaptations.RegistryEvents.INSANIUM_FURNACE, IRecipeType.SMELTING);
    }

    protected ITextComponent getDefaultName() {
        return Localizable.of(String.format("container.mysticaladaptations.insanium_furnace")).build();
    }

    protected Container createMenu(int id, PlayerInventory player) {
        return new FurnaceContainer(id, player, this, this.furnaceData);
    }

    protected int getBurnTime(ItemStack stack) {
        return (int) ((double) super.getBurnTime(stack) * 0.1D);
    }

    protected int getCookTime() {
        return (int) ((double) super.getCookTime() * 0.01D);
    }

}
