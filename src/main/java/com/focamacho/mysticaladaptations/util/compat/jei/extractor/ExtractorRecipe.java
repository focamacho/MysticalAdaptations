package com.focamacho.mysticaladaptations.util.compat.jei.extractor;

import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;

public class ExtractorRecipe extends BlankRecipeWrapper {

	private List<ItemStack> inputs = new ArrayList<ItemStack>();
	private ItemStack tool;
	private ItemStack output;
	
	public ExtractorRecipe(ItemStack seed, ItemStack item, int tier) {
		output = seed;
		inputs.add(item);
		if(!ModConfig.EXTRACTOR_ANY_TIER) {
			switch(tier) {
				case 1:
					tool = new ItemStack(ModItems.INFERIUM_SEED_EXTRACTOR);
					break;
				case 2:
					tool = new ItemStack(ModItems.PRUDENTIUM_SEED_EXTRACTOR);
					break;
				case 3:
					tool = new ItemStack(ModItems.INTERMEDIUM_SEED_EXTRACTOR);
					break;
				case 4:
					tool = new ItemStack(ModItems.SUPERIUM_SEED_EXTRACTOR);
					break;
				case 5:
					tool = new ItemStack(ModItems.SUPREMIUM_SEED_EXTRACTOR);
					break;	
				case 6:
					tool = new ItemStack(ModItems.INSANIUM_SEED_EXTRACTOR);
					break;
			}
		} else {
			tool = new ItemStack(ModItems.INFERIUM_SEED_EXTRACTOR);
		}
		
		inputs.add(tool);
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputs(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
	}

}