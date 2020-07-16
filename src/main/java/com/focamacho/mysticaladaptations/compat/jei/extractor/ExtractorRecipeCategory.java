/*package com.focamacho.mysticaladaptations.compat.jei.extractor;

import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.Reference;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ExtractorRecipeCategory implements IRecipeCategory<ExtractorRecipe> {

	public static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "extractor_jei");
	protected static final int inputSlot = 0;
	protected static final int toolSlot = 1;
	protected static final int outputSlot = 2;
	private static final ResourceLocation JEI_GUI_TEXTURES = new ResourceLocation(Reference.MOD_ID, "textures/gui/jei.png");

	private final IDrawable background;
	private final IDrawable icon;

	public ExtractorRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(JEI_GUI_TEXTURES, 0, 18, 72, 18);
		icon = guiHelper.createDrawableIngredient(new ItemStack(ModItems.INFERIUM_EXTRACTOR));
	}


	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public Class<? extends ExtractorRecipe> getRecipeClass() {
		return ExtractorRecipe.class;
	}

	@Override
	public ResourceLocation getUid() {
		return ID;
	}

	@Override
	public String getTitle() {
		return "eae";
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setIngredients(ExtractorRecipe recipe, IIngredients ingredients) {
		ingredients.setInputs(VanillaTypes.ITEM, recipe.getInputs());
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getOutput());
	}

	@Override
	public void setRecipe(IRecipeLayout layout, ExtractorRecipe recipe, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = layout.getItemStacks();

		guiItemStacks.init(inputSlot, true, 0, 0);
		guiItemStacks.init(toolSlot, true, 27, 0);
		guiItemStacks.init(outputSlot, false, 54, 0);

		guiItemStacks.set(ingredients);
	}

}
*/