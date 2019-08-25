package com.focamacho.mysticaladaptations;

import java.io.File;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.proxy.CommonProxy;
import com.focamacho.mysticaladaptations.util.Reference;
import com.focamacho.mysticaladaptations.util.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static File config;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInitRegistries(event);
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		
	}
	
	public static final CreativeTabs tabMysticalAdaptations = new CreativeTabs("tab.mysticaladaptations.name") {		
		@Override
		public ItemStack getTabIconItem() {
			return ModConfig.ENABLE_SEED_EXTRACTORS ? new ItemStack(ModItems.SUPREMIUM_SEED_EXTRACTOR) : new ItemStack(Items.WOODEN_HOE);
		}
		
		@SideOnly(Side.CLIENT)
		public boolean hasSearchBar() {
			return false;
		}
	}; 
	
}
