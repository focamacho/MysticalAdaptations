package com.focamacho.mysticaladaptations.util.compat.crafttweaker;

import java.util.ArrayList;
import java.util.List;

import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipe;
import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipes;

import crafttweaker.CraftTweakerAPI;
import net.minecraft.item.ItemStack;

public class CompatCT {

	public static List<ItemStack> toRemove = new ArrayList<ItemStack>();
	public static List<SeedExtractorRecipe> toAdd = new ArrayList<SeedExtractorRecipe>();
	
	public static void preInit() {
		CraftTweakerAPI.registerClass(CTSeedExtractor.class);
	}
	
	public static void init() {
		//Remove Recipes
		for(ItemStack item : toRemove) {
			List<SeedExtractorRecipe> toRemove = new ArrayList<SeedExtractorRecipe>();
			for(SeedExtractorRecipe recipe : SeedExtractorRecipes.allRecipes) {
				if(recipe.getSeed().getItem().equals(item.getItem())) {
					toRemove.add(recipe);
				}
			}
			SeedExtractorRecipes.allRecipes.removeAll(toRemove);
		}
		//Add Recipes
		for(SeedExtractorRecipe recipe : toAdd) {
			SeedExtractorRecipes.allRecipes.add(recipe);
		}
	}
}
