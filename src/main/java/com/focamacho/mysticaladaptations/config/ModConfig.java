package com.focamacho.mysticaladaptations.config;

import java.io.File;

import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.util.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModConfig 
{
	public static Configuration config;
	public static ModConfig instance;
	
	public static int INFERIUM_DURABILITY;
	public static int PRUDENTIUM_DURABILITY;
	public static int INTERMEDIUM_DURABILITY;
	public static int SUPERIUM_DURABILITY;
	public static int SUPREMIUM_DURABILITY;
	public static int INSANIUM_DURABILITY;
	
	public static boolean MOB_SEED_DROP;
	public static boolean EXTRACTOR_LOWER_TIER;
	public static boolean EXTRACTOR_ANY_TIER;
	
	public static boolean NETHERSTAR_BLOCK;
	public static boolean SILICON_BLOCK;
	
	@SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if(eventArgs.getModID().equals(Reference.MOD_ID)) {
            ModConfig.syncConfig();
        }
    }
	
	public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
	}
	
	public static void syncConfig() {
	
		String category;
		
		category = "Seed Extractor Durability";
		config.addCustomCategoryComment(category, "Set the durability of the Seed Extractors");
		INFERIUM_DURABILITY = config.getInt("INFERIUM_DURABILITY", category, 15, 1, 2147483647, "Inferium Seed Extractor Durability.");
		PRUDENTIUM_DURABILITY = config.getInt("PRUDENTIUM_DURABILITY", category, 15, 1, 2147483647, "Prudentium Seed Extractor Durability.");
		INTERMEDIUM_DURABILITY = config.getInt("INTERMEDIUM_DURABILITY", category, 15, 1, 2147483647, "Intermedium Seed Extractor Durability.");
		SUPERIUM_DURABILITY = config.getInt("SUPERIUM_DURABILITY", category, 15, 1, 2147483647, "Superium Seed Extractor Durability.");
		SUPREMIUM_DURABILITY = config.getInt("SUPREMIUM_DURABILITY", category, 15, 1, 2147483647, "Supremium Seed Extractor Durability.");
		INSANIUM_DURABILITY = config.getInt("INSANIUM_DURABILITY", category, 15, 1, 2147483647, "Supremium Seed Extractor Durability. (Only if Mystical Agradditions is loaded)");
		
		category = "Additional Mechanics";
		config.addCustomCategoryComment(category, "Some additional mechanics available");
		MOB_SEED_DROP = config.getBoolean("MOB_SEED_DROP", category, true, "Kill a mob using a Seed Extractor to get its seed.");
		EXTRACTOR_LOWER_TIER = config.getBoolean("EXTRACTOR_LOWER_TIER", category, true, "Seed Extractor of larger tiers can pick lower tier seeds.");
		EXTRACTOR_ANY_TIER = config.getBoolean("EXTRACTOR_ANY_TIER", category, false, "Seed extractors can collect any seed, regardless of the tier.");
	
		category = "Blocks(Enable/Disable)";
		config.addCustomCategoryComment(category, "Enable/Disable Blocks");
		NETHERSTAR_BLOCK = config.getBoolean("NETHERSTAR_BLOCK", category, true, "Netherstar Block");
		SILICON_BLOCK = config.getBoolean("SILICON_BLOCK", category, true, "Silicon Block");
		
		if(config.hasChanged()){
			config.save();
		}
	}
} 