package com.focamacho.mysticaladaptations.util.handlers;

import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipe;
import com.focamacho.mysticaladaptations.util.DummyRecipe;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.google.common.collect.Lists;

import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import scala.actors.threadpool.Arrays;

public class CraftingHandler {
	
	public static final List<Item> seedItems = getAllSeedItems();
	//Recipes that will not be removed
	public static final List<Item> recipeWhitelist = getAllWhitelistRecipes();
	
	public static void removeRecipes() {
		List<Item> seedsItems = seedItems;
		List<Item> recipesWhitelist = recipeWhitelist;
		if(ModConfig.REMOVE_SEED_RECIPES || ModConfig.REMOVE_MOBS_SEED_RECIPES) {
			 ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
		     ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValues());
		     
		     for (IRecipe r : recipes) {
	             Item output = r.getRecipeOutput().getItem();
	             if(!recipesWhitelist.contains(output)) {
		             for(Item seed : seedsItems) {
			             if (output == seed){
			                 recipeRegistry.remove(r.getRegistryName());
			                 recipeRegistry.register(DummyRecipe.from(r));
			             }
		             }
	             }
		     }
		     
		}
	}
	
	public static List<Item> getAllSeedItems() {
		List<Item> seedItems = new ArrayList<Item>();
		for(Type type : Type.values()) {
			seedItems.add(type.getSeed());
		}
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.REMOVE_AGRADDITIONS_RECIPES) {
			for(com.blakebr0.mysticalagradditions.lib.CropType.Type type : com.blakebr0.mysticalagradditions.lib.CropType.Type.values()) {
				seedItems.add(type.getSeed());
			}
		}
		return seedItems;
	}
	
	public static List<Item> getAllWhitelistRecipes() {
		List<Item> recipeWhitelist = new ArrayList<Item>();
		Type[] mobTypes;
		//Return empty whitelist
		if(ModConfig.REMOVE_SEED_RECIPES && ModConfig.REMOVE_MOBS_SEED_RECIPES) return recipeWhitelist;
		
		mobTypes = getMobTypes();
		//Add non-mob seeds to whitelist
		if(!ModConfig.REMOVE_SEED_RECIPES) {
			boolean isMobType;
			for(Type type : Type.values()) {
				isMobType = false;
				for(Type mobType : mobTypes) {
					if(type.equals(mobType)) isMobType = true;
				}
				if(!isMobType) recipeWhitelist.add(type.getSeed());
			}
		}
		
		//Add mob seeds to whitelist
		if(!ModConfig.REMOVE_MOBS_SEED_RECIPES) {
			boolean isMobType;
			for(Type type : Type.values()) {
				isMobType = false;
				for(Type mobType : mobTypes) {
					if(type.equals(mobType)) isMobType = true;
				}
				if(isMobType) recipeWhitelist.add(type.getSeed());
			}
		}
		
		return recipeWhitelist;
	}
	
	public static Type[] getMobTypes() {
		Type[] mobTypes = new Type[] {Type.BASALZ, Type.BLAZE, Type.BLITZ, Type.BLIZZ, Type.CHICKEN, Type.COW, Type.CREEPER, Type.ENDERMAN, Type.GHAST, Type.GUARDIAN, Type.PIG, Type.RABBIT, Type.SHEEP, Type.SKELETON, Type.SPIDER, Type.WITHER_SKELETON, Type.ZOMBIE, Type.SLIME};
		return mobTypes;
	}

}
