package com.focamacho.mysticaladaptations.util.compat.crafttweaker;

import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipe;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.mysticaladaptations.SeedExtractor")
public class CTSeedExtractor {
	
	@ZenMethod
	public static void addExtractorRecipe(String[] inputs, IItemStack result, int tier) {
		CompatCT.toAdd.add(new SeedExtractorRecipe(inputs, CraftTweakerMC.getItemStack(result), tier));
	}
	
	@ZenMethod
	public static void removeExtractorRecipe(IItemStack result) {
		CompatCT.toRemove.add(CraftTweakerMC.getItemStack(result));
	}

}
