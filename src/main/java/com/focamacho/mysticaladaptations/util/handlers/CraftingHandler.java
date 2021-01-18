package com.focamacho.mysticaladaptations.util.handlers;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModRecipes;
import com.focamacho.mysticaladaptations.util.DummyRecipe;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class CraftingHandler {
	
	public static final List<Item> seedItems = getAllSeedItems();
	//Recipes that will not be removed
	public static final List<Item> recipeWhitelist = getAllWhitelistRecipes();
	
	public static void removeRecipes() {
		if(ModConfig.REMOVE_SEED_RECIPES || ModConfig.REMOVE_MOBS_SEED_RECIPES) {
			 ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
			List<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());
		     
		     for (IRecipe r : recipes) {
	             Item output = r.getRecipeOutput().getItem();
	             if(!recipeWhitelist.contains(output)) {
		             for(Item seed : seedItems) {
			             if (output == seed){
			                 recipeRegistry.remove(r.getRegistryName());
			                 recipeRegistry.register(DummyRecipe.from(r));
			             }
		             }
	             }
		     }
		     
		     if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.REMOVE_AGRADDITIONS_RECIPES) {
		    	ResourceLocation[] seedsAgradditions = {new ResourceLocation("mysticalagradditions:nether_star_seeds"), new ResourceLocation("mysticalagradditions:awakened_draconium_seeds"), new ResourceLocation("mysticalagradditions:dragon_egg_seeds"), new ResourceLocation("mysticalagradditions:neutronium_seeds")};
		    	for(ResourceLocation resource : seedsAgradditions) {
		    		if(recipeRegistry.getValue(resource) != null) {
		    			IRecipe recipe = recipeRegistry.getValue(resource);
		    			if(recipe != null) {
							recipeRegistry.remove(recipe.getRegistryName());
							recipeRegistry.register(DummyRecipe.from(recipe));
						}
		    		}
		    	}
		     }
		     
		}
	}
	
	public static List<Item> getAllSeedItems() {
		List<Item> seedItems = new ArrayList<>();
		for(Type type : Type.values()) {
			seedItems.add(type.getSeed());
		}
		return seedItems;
	}
	
	public static List<Item> getAllWhitelistRecipes() {
		List<Item> recipeWhitelist = new ArrayList<>();

		//Return empty whitelist
		if(ModConfig.REMOVE_SEED_RECIPES && ModConfig.REMOVE_MOBS_SEED_RECIPES) return recipeWhitelist;

		//Add non-mob seeds to whitelist
		if(!ModConfig.REMOVE_SEED_RECIPES) {
			for(Type type : Type.values()) {
				if(!isMobType(type)) recipeWhitelist.add(type.getSeed());
			}
		}
		
		//Add mob seeds to whitelist
		if(!ModConfig.REMOVE_MOBS_SEED_RECIPES) {
			for(Type type : Type.values()) {
				if(isMobType(type)) recipeWhitelist.add(type.getSeed());
			}
		}
		
		return recipeWhitelist;
	}
	
	public static boolean isMobType(Type seedType) {
		Type[] types = new Type[] {Type.BASALZ, Type.BLAZE, Type.BLITZ, Type.BLIZZ, Type.CHICKEN, Type.COW, Type.CREEPER, Type.ENDERMAN, Type.GHAST, Type.GUARDIAN, Type.PIG, Type.RABBIT, Type.SHEEP, Type.SKELETON, Type.SPIDER, Type.WITHER_SKELETON, Type.ZOMBIE, Type.SLIME};
		for(Type type : types) {
			if(seedType.equals(type)) return true;
		}
		return false;
	}
	
	@SubscribeEvent
	public void recipes(RegistryEvent.Register<IRecipe> e) {
		ModRecipes.initRecipes();
	}

}
