package com.focamacho.mysticaladaptations.tiles;

import com.blakebr0.cucumber.util.Localizable;
import com.focamacho.mysticaladaptations.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class InsaniumFurnaceTileEntity extends AbstractFurnaceBlockEntity {

    // Insanium Furnace Values
    private static final double burnTimeMultiplier = 0.1D;
    private static final double cookTimeMultiplier = 0.01D;

    public InsaniumFurnaceTileEntity(BlockPos pos, BlockState state) {
        super(ModTileEntities.INSANIUM_FURNACE.get(), pos, state, RecipeType.SMELTING);
    }

    @Override
    protected Component getDefaultName() {
        return Localizable.of("container.mysticaladaptations.insanium_furnace").build();
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new FurnaceMenu(id, player, this, this.dataAccess);
    }

    @Override
    protected int getBurnDuration(ItemStack stack) {
        return (int) (super.getBurnDuration(stack) * InsaniumFurnaceTileEntity.burnTimeMultiplier);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        ItemStack itemstack = this.items.get(slot);
        boolean flag = !stack.isEmpty() && stack.sameItem(itemstack) && ItemStack.tagMatches(stack, itemstack);
        this.items.set(slot, stack);
        if (stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }

        if (slot == 0 && !flag) {
            this.cookingTotalTime = (int) (getTotalCookTime(level, this) * InsaniumFurnaceTileEntity.cookTimeMultiplier);
            this.cookingProgress = 0;
            this.setChanged();
        }

    }

    private static int getTotalCookTime(Level p_222693_, AbstractFurnaceBlockEntity p_222694_) {
        return p_222694_.quickCheck.getRecipeFor(p_222694_, p_222693_).map(AbstractCookingRecipe::getCookingTime).orElse(200);
    }

    protected boolean canBurn(Recipe<?> recipe, NonNullList<ItemStack> items, int maxStackSize) {
        if (!items.get(0).isEmpty() && recipe != null) {
            ItemStack itemstack = ((Recipe<WorldlyContainer>) recipe).assemble(this);
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = items.get(2);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!itemstack1.sameItem(itemstack)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= maxStackSize && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
                }
            }
        } else {
            return false;
        }
    }

    protected boolean burn(Recipe<?> recipe, NonNullList<ItemStack> items, int maxStackSize) {
        if (recipe != null && this.canBurn(recipe, items, maxStackSize)) {
            ItemStack itemstack = items.get(0);
            ItemStack itemstack1 = ((Recipe<WorldlyContainer>) recipe).assemble(this);
            ItemStack itemstack2 = items.get(2);
            if (itemstack2.isEmpty()) {
                items.set(2, itemstack1.copy());
            } else if (itemstack2.is(itemstack1.getItem())) {
                itemstack2.grow(itemstack1.getCount());
            }

            if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !items.get(1).isEmpty() && items.get(1).is(Items.BUCKET)) {
                items.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            itemstack.shrink(1);
            return true;
        } else {
            return false;
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, InsaniumFurnaceTileEntity tile) {
        var flag = tile.isLit();
        var flag1 = false;

        if (tile.isLit()) {
            --tile.litTime;
        }

        var stack = tile.items.get(1);
        if (tile.isLit() || !stack.isEmpty() && !tile.items.get(0).isEmpty()) {
            Recipe<?> recipe = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, tile, level).orElse(null);
            int i = tile.getMaxStackSize();
            if (!tile.isLit() && tile.canBurn(recipe, tile.items, i)) {
                tile.litTime = tile.getBurnDuration(stack);
                tile.litDuration = tile.litTime;
                if (tile.isLit()) {
                    flag1 = true;
                    if (stack.hasCraftingRemainingItem())
                        tile.items.set(1, stack.getCraftingRemainingItem());
                    else
                    if (!stack.isEmpty()) {
                        stack.shrink(1);

                        if (stack.isEmpty()) {
                            tile.items.set(1, stack.getCraftingRemainingItem());
                        }
                    }
                }
            }

            if (tile.isLit() && tile.canBurn(recipe, tile.items, i)) {
                ++tile.cookingProgress;
                if (tile.cookingProgress == tile.cookingTotalTime) {
                    tile.cookingProgress = 0;
                    tile.cookingTotalTime = (int) (getTotalCookTime(level, tile) * InsaniumFurnaceTileEntity.cookTimeMultiplier);
                    if (tile.burn(recipe, tile.items, i)) {
                        tile.setRecipeUsed(recipe);
                    }

                }
            } else {
                tile.cookingProgress = 0;
            }
        } else if (!tile.isLit() && tile.cookingProgress > 0) {
            tile.cookingProgress = Mth.clamp(tile.cookingProgress - 2, 0, tile.cookingTotalTime);
        }

        if (flag != tile.isLit()) {
            flag1 = true;
            state = state.setValue(AbstractFurnaceBlock.LIT, tile.isLit());
            level.setBlock(pos, state, 3);
        }

        if (flag1) {
            setChanged(level, pos, state);
        }
    }

}