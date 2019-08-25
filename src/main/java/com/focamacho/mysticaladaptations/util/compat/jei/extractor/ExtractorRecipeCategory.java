package com.focamacho.mysticaladaptations.util.compat.jei.extractor;

import com.focamacho.mysticaladaptations.util.Reference;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

public class ExtractorRecipeCategory extends BlankRecipeCategory<IRecipeWrapper> {

	public static final String ID = "mysticaladaptations:extractor_jei";
	protected static final int inputSlot = 0;
	protected static final int toolSlot = 1;
	protected static final int outputSlot = 2;
	private static final ResourceLocation JEI_GUI_TEXTURES = new ResourceLocation(Reference.MOD_ID, "textures/gui/jei.png");

	private final IDrawable background;

	public ExtractorRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(JEI_GUI_TEXTURES, 0, 18, 72, 18);
	}

	@Override
	public String getUid() {
		return ID;
	}

	@Override
	public String getTitle() {
		return I18n.translateToLocal("jei.mysticaladaptations.extractor");
	}

	@Override
	public String getModName() {
		return Reference.NAME;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}
	
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(inputSlot, true, 0, 0);
		guiItemStacks.init(toolSlot, true, 27, 0);
		guiItemStacks.init(outputSlot, false, 54, 0);

		guiItemStacks.set(ingredients);
	}

}
