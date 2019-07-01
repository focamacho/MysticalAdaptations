package com.focamacho.mysticaladaptations.util.compat.jei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.blakebr0.mysticalagriculture.util.ModChecker;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.lib.BlocksList;
import com.focamacho.mysticaladaptations.lib.EntitiesList;
import com.focamacho.mysticaladaptations.lib.ItemsList;
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
	            ItemStack NetherStarSeeds = new ItemStack(Item.getByNameOrId("mysticalagradditions:nether_star_seeds"));
	            ItemStack AwakenedSeeds = new ItemStack(Item.getByNameOrId("mysticalagradditions:awakened_draconium_seeds"));
	            ItemStack DragonEggSeeds = new ItemStack(Item.getByNameOrId("mysticalagradditions:dragon_egg_seeds"));
	            ItemStack NeutroniumSeeds = new ItemStack(Item.getByNameOrId("mysticalagradditions:neutronium_seeds"));
	            for(ItemStack item : ExtractorItemStacks.getItemStacks(ItemsList.Netherstar, BlocksList.Netherstar, EntitiesList.Netherstar)) {
	            	extractorRecipies.add(new ExtractorRecipe(NetherStarSeeds, item));
	        	}
	            for(ItemStack item : ExtractorItemStacks.getItemStacks(ItemsList.Awakened, BlocksList.Awakened, EntitiesList.Awakened)) {
	            	extractorRecipies.add(new ExtractorRecipe(AwakenedSeeds, item));
	        	}
	            for(ItemStack item : ExtractorItemStacks.getItemStacks(ItemsList.DragonEgg, BlocksList.DragonEgg, EntitiesList.DragonEgg)) {
	            	extractorRecipies.add(new ExtractorRecipe(DragonEggSeeds, item));
	        	}
	            for(ItemStack item : ExtractorItemStacks.getItemStacks(ItemsList.Neutronium, BlocksList.Neutronium, EntitiesList.Neutronium)) {
	            	extractorRecipies.add(new ExtractorRecipe(NeutroniumSeeds, item));
	        	}
	        }

	        registry.addRecipes(extractorRecipies, ExtractorRecipeCategory.ID);
        }
    }
}