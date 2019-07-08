package com.focamacho.mysticaladaptations.util.compat.jei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.blakebr0.mysticalagriculture.util.ModChecker;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipes;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.focamacho.mysticaladaptations.util.compat.jei.extractor.ExtractorItemStacks;
import com.focamacho.mysticaladaptations.util.compat.jei.extractor.ExtractorRecipe;
import com.focamacho.mysticaladaptations.util.compat.jei.extractor.ExtractorRecipeCategory;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class CompatJEI implements IModPlugin {
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		if(ModConfig.JEI_COMPAT) registry.addRecipeCategories(new ExtractorRecipeCategory(jeiHelpers.getGuiHelper()));
	}
	
    @Override
    public void register(IModRegistry registry) {  
		List<ExtractorRecipe> extractorRecipies = new LinkedList<ExtractorRecipe>();
        IJeiHelpers helpers = registry.getJeiHelpers();
        IRecipeTransferRegistry transfer = registry.getRecipeTransferRegistry();
        if(ModConfig.JEI_COMPAT) {
            registry.addRecipeCatalyst(new ItemStack(ModItems.INFERIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.PRUDENTIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.INTERMEDIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.SUPERIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.SUPREMIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
	        for(Type seed : Type.values()){
	        	if(seed.isEnabled()) {
		        	for(ItemStack item : ExtractorItemStacks.getItemStacksFromType(seed)) {
		        		extractorRecipies.add(new ExtractorRecipe(seed, item));
		        	}
	        	}
	        }
	
	        if(ModCheck.MYSTICAL_AGRADDITIONS) {
	        	registry.addRecipeCatalyst(new ItemStack(ModItems.INSANIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
	            for(ItemStack item : ExtractorItemStacks.getItemStacks(SeedExtractorRecipes.nether_star_seeds)) {
	            	extractorRecipies.add(new ExtractorRecipe(SeedExtractorRecipes.nether_star_seeds.getSeed(), item));
	        	}
	            for(ItemStack item : ExtractorItemStacks.getItemStacks(SeedExtractorRecipes.awakened_draconium_seeds)) {
	            	extractorRecipies.add(new ExtractorRecipe(SeedExtractorRecipes.awakened_draconium_seeds.getSeed(), item));
	        	}
	            for(ItemStack item : ExtractorItemStacks.getItemStacks(SeedExtractorRecipes.dragon_egg_seeds)) {
	            	extractorRecipies.add(new ExtractorRecipe(SeedExtractorRecipes.dragon_egg_seeds.getSeed(), item));
	        	}
	            for(ItemStack item : ExtractorItemStacks.getItemStacks(SeedExtractorRecipes.neutronium_seeds)) {
	            	extractorRecipies.add(new ExtractorRecipe(SeedExtractorRecipes.neutronium_seeds.getSeed(), item));
	        	}
	        }

	        registry.addRecipes(extractorRecipies, ExtractorRecipeCategory.ID);
        }
    }
}