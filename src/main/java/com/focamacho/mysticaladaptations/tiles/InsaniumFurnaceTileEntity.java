package com.focamacho.mysticaladaptations.tiles;

import com.blakebr0.cucumber.util.Localizable;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.init.ModTileEntities;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;

public class InsaniumFurnaceTileEntity extends AbstractFurnaceTileEntity {
    public InsaniumFurnaceTileEntity() {
        super(ModTileEntities.INSANIUM_FURNACE.get(), IRecipeType.SMELTING);
    }

    protected ITextComponent getDefaultName() {
        return Localizable.of(String.format("container.mysticaladaptations.insanium_furnace")).build();
    }

    protected Container createMenu(int id, PlayerInventory player) {
        return new FurnaceContainer(id, player, this, this.dataAccess);
    }

    protected int getBurnDuration(ItemStack stack) {
        return (int) ((double) super.getBurnDuration(stack) * 0.1D);
    }

    protected int getTotalCookTime() {
        return (int) ((double) super.getTotalCookTime() * 0.01D);
    }

}
