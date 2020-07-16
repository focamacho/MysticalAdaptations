/*package com.focamacho.mysticaladaptations.compat.jei;

import com.focamacho.mysticaladaptations.compat.jei.extractor.ExtractorItemStacks;
import com.focamacho.mysticaladaptations.compat.jei.extractor.ExtractorRecipe;
import com.focamacho.mysticaladaptations.compat.jei.extractor.ExtractorRecipeCategory;
import com.focamacho.mysticaladaptations.config.ConfigHolder;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.item.extractor.SeedExtractorRecipeHandler;
import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipe;
import com.focamacho.mysticaladaptations.util.Reference;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class CompatJEI implements IModPlugin {

    public static final ResourceLocation UID = new ResourceLocation(Reference.MOD_ID, "jei_plugin");

    @Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
        System.out.println("rodei");
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		if(ConfigHolder.COMPAT_JEI) registry.addRecipeCategories(new ExtractorRecipeCategory(jeiHelpers.getGuiHelper()));
	}

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
        if(ConfigHolder.COMPAT_JEI) {
            registry.addRecipeCatalyst(new ItemStack(ModItems.INFERIUM_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.PRUDENTIUM_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.TERTIUM_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.IMPERIUM_EXTRACTOR), ExtractorRecipeCategory.ID);
            registry.addRecipeCatalyst(new ItemStack(ModItems.SUPREMIUM_EXTRACTOR), ExtractorRecipeCategory.ID);
        }
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if(ConfigHolder.COMPAT_JEI) {
            List<ExtractorRecipe> extractorRecipes = new ArrayList<ExtractorRecipe>();
            for(SeedExtractorRecipe recipe : SeedExtractorRecipeHandler.allRecipes) {
                for(ItemStack item : ExtractorItemStacks.getItemStacks(recipe)){
                    extractorRecipes.add(new ExtractorRecipe(new ItemStack(recipe.getSeed()), item, recipe.getTier()));
                }
            }
        }
    }

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

}*/