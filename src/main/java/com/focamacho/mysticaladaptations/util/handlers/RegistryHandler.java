package com.focamacho.mysticaladaptations.util.handlers;

import java.io.File;

import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.config.RecipesConfig;
import com.focamacho.mysticaladaptations.init.ModBlocks;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipes;
import com.focamacho.mysticaladaptations.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ModItems.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for(Block block : ModBlocks.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event) {
		ModConfig.init(new File(event.getModConfigurationDirectory(), "mysticaladaptations.cfg"));
		RecipesConfig.init(new File(event.getModConfigurationDirectory(), "mysticaladaptations_recipes.cfg"));
		MinecraftForge.EVENT_BUS.register(new ModConfig());
	}
	
	public static void initRegistries() {
		//OreDictionary
		if(ModConfig.NETHERSTAR_BLOCK) OreDictionary.registerOre("blockNetherStar", ModBlocks.NETHERSTAR_BLOCK);
		if(ModConfig.SILICON_BLOCK) OreDictionary.registerOre("blockSilicon", ModBlocks.SILICON_BLOCK);
		if(ModConfig.HOP_GRAPHITE_BLOCK) OreDictionary.registerOre("blockHOPGraphite", ModBlocks.HOP_GRAPHITE_BLOCK);
		MinecraftForge.EVENT_BUS.register(new SeedExtractorRecipes());
		MinecraftForge.EVENT_BUS.register(new MobDropsHandler());
		SeedExtractorRecipes.init();
	}
	
	public static void postInitRegistries() {
		CraftingHandler.removeRecipes();
	}
}
