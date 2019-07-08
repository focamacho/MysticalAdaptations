package com.focamacho.mysticaladaptations.util.handlers;

import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType;
import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.blakebr0.mysticalagriculture.util.ModChecker;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.util.DummyRecipe;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.google.common.collect.Lists;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.ForgeRegistry;

public class CraftingHandler {
	
	public static final List<Item> seedItems = getAllSeedItems();
	
	public static void removeRecipes() {
		if(ModConfig.REMOVE_SEED_RECIPES) {
			 ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
		     ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValues());
		     
		     for (IRecipe r : recipes) {
	             ItemStack output = r.getRecipeOutput();
	             for(Item seed : seedItems) {
		             if (output.getItem() == seed){
		                 recipeRegistry.remove(r.getRegistryName());
		                 recipeRegistry.register(DummyRecipe.from(r));
		             }
	             }
		     }
		}	
	}
	
	public static List<Item> getAllSeedItems() {
		List<Type> seedTypes = Lists.newArrayList(Type.values());
		List<Item> seedItems = new ArrayList<Item>();
		for(Type type : seedTypes) {
			seedItems.add(type.getSeed());
		}
		return seedItems;
	}
}
