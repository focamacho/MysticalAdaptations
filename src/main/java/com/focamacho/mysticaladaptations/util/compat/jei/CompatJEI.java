package com.focamacho.mysticaladaptations.util.compat.jei;

import com.blakebr0.mysticalagriculture.compat.jei.reprocessor.ReprocessorCategory;
import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModBlocks;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipe;
import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipes;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.focamacho.mysticaladaptations.util.compat.jei.extractor.ExtractorItemStacks;
import com.focamacho.mysticaladaptations.util.compat.jei.extractor.ExtractorRecipe;
import com.focamacho.mysticaladaptations.util.compat.jei.extractor.ExtractorRecipeCategory;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.LinkedList;
import java.util.List;

@JEIPlugin
public class CompatJEI implements IModPlugin {
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		if(ModConfig.JEI_COMPAT) registry.addRecipeCategories(new ExtractorRecipeCategory(jeiHelpers.getGuiHelper()));
	}
	
    @Override
    public void register(IModRegistry registry) {  
		List<ExtractorRecipe> extractorRecipies = new LinkedList<>();
        if(ModConfig.JEI_COMPAT && ModConfig.ENABLE_SEED_EXTRACTORS) {
            registry.addRecipeCatalyst(new ItemStack(ModItems.INFERIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.PRUDENTIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.INTERMEDIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.SUPERIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.SUPREMIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
	        if(ModCheck.MYSTICAL_AGRADDITIONS) registry.addRecipeCatalyst(new ItemStack(ModItems.INSANIUM_SEED_EXTRACTOR), ExtractorRecipeCategory.ID);
	        
            for(SeedExtractorRecipe recipe : SeedExtractorRecipes.allRecipes) {
            	for(ItemStack item : ExtractorItemStacks.getItemStacks(recipe)) {
            		extractorRecipies.add(new ExtractorRecipe(recipe.getSeed(), item, recipe.getTier()));
            	}
            }
	        
            if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_REPROCESSOR && com.blakebr0.mysticalagriculture.config.ModConfig.confSeedReprocessor) {
            	registry.addRecipeCatalyst(new ItemStack(ModBlocks.INSANIUM_REPROCESSOR_BLOCK), ReprocessorCategory.UID);
            }
            
	        if(ModConfig.EXPERIENCE_SEEDS_DROP) {
	        	registry.addIngredientInfo(new ItemStack(Type.EXPERIENCE.getSeed()), VanillaTypes.ITEM, new TextComponentTranslation("jei.mysticaladaptations.experience_seeds_drop").getFormattedText() + " " + (ModConfig.EXTRACTOR_ANY_TIER ? "1" : Type.EXPERIENCE.getTier()) + " " + (!ModConfig.EXTRACTOR_LOWER_TIER ? "." : new TextComponentTranslation("jei.mysticaladaptations.experience_seeds_drop_higher").getFormattedText()) + "\n\n" + new TextComponentTranslation("jei.mysticaladaptations.experience_seeds_drop_chance").getFormattedText() + " " + ModConfig.EXPERIENCE_SEEDS_DROP_CHANCE + "%");
	        }
	        
	        registry.addRecipes(extractorRecipies, ExtractorRecipeCategory.ID);
        }
    }
}