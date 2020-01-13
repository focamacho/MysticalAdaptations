package com.focamacho.mysticaladaptations.init;

import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.ModToolMaterials;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.items.InsaniumArmor;
import com.focamacho.mysticaladaptations.items.InsaniumArrow;
import com.focamacho.mysticaladaptations.items.InsaniumAxe;
import com.focamacho.mysticaladaptations.items.InsaniumBow;
import com.focamacho.mysticaladaptations.items.InsaniumFishingRod;
import com.focamacho.mysticaladaptations.items.InsaniumHoe;
import com.focamacho.mysticaladaptations.items.InsaniumPaxel;
import com.focamacho.mysticaladaptations.items.InsaniumPickaxe;
import com.focamacho.mysticaladaptations.items.InsaniumScythe;
import com.focamacho.mysticaladaptations.items.InsaniumShears;
import com.focamacho.mysticaladaptations.items.InsaniumShovel;
import com.focamacho.mysticaladaptations.items.InsaniumSickle;
import com.focamacho.mysticaladaptations.items.InsaniumSword;
import com.focamacho.mysticaladaptations.items.InsaniumWateringCan;
import com.focamacho.mysticaladaptations.items.ItemBase;
import com.focamacho.mysticaladaptations.items.SeedExtractor;
import com.focamacho.mysticaladaptations.lib.ModToolMaterial;
import com.focamacho.mysticaladaptations.util.ModCheck;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Seed Extractors
	public static Item INFERIUM_SEED_EXTRACTOR;
	public static Item PRUDENTIUM_SEED_EXTRACTOR;
	public static Item INTERMEDIUM_SEED_EXTRACTOR;
	public static Item SUPERIUM_SEED_EXTRACTOR;
	public static Item SUPREMIUM_SEED_EXTRACTOR;

	//Mystical Agradditions Compat
	public static Item INSANIUM_SEED_EXTRACTOR;
	
	//Crafting Items
	public static Item GEAR;
	public static Item GEAR_ARMOR;
	public static Item GEAR_INSANIUM_ARROW_HEAD;
	public static Item INSANIUM_FERTILIZATION_CORE;
	
	//Insanium Armor
	public static Item INSANIUM_HELMET;
	public static Item INSANIUM_CHESTPLATE;
	public static Item INSANIUM_LEGGINGS;
	public static Item INSANIUM_BOOTS;
			
	//Insanium Tools
	public static Item INSANIUM_SWORD;
	public static Item INSANIUM_PICKAXE;
	public static Item INSANIUM_SHOVEL;
	public static Item INSANIUM_AXE;
	public static Item INSANIUM_HOE;
	public static Item INSANIUM_SHEARS;
	public static Item INSANIUM_BOW;
	public static Item INSANIUM_SICKLE;
	public static Item INSANIUM_SCYTHE;
	public static Item INSANIUM_FISHING_ROD;
	public static Item INSANIUM_ARROW;
	public static Item WATERING_CAN_INSANIUM;
	public static Item INSANIUM_PAXEL;
	
	public static void init() {
		//Seed Extractors
		if(ModConfig.ENABLE_SEED_EXTRACTORS) {
			INFERIUM_SEED_EXTRACTOR = new SeedExtractor("inferium_seed_extractor", ModToolMaterials.INFERIUM, ModConfig.INFERIUM_DURABILITY, 1);
			PRUDENTIUM_SEED_EXTRACTOR = new SeedExtractor("prudentium_seed_extractor", ModToolMaterials.PRUDENTIUM, ModConfig.PRUDENTIUM_DURABILITY, 2);
			INTERMEDIUM_SEED_EXTRACTOR = new SeedExtractor("intermedium_seed_extractor", ModToolMaterials.INTERMEDIUM, ModConfig.INTERMEDIUM_DURABILITY, 3);
			SUPERIUM_SEED_EXTRACTOR = new SeedExtractor("superium_seed_extractor", ModToolMaterials.SUPERIUM, ModConfig.SUPERIUM_DURABILITY, 4);
			SUPREMIUM_SEED_EXTRACTOR = new SeedExtractor("supremium_seed_extractor", ModToolMaterials.SUPREMIUM, ModConfig.SUPREMIUM_DURABILITY, 5);
			
			ITEMS.add(INFERIUM_SEED_EXTRACTOR);
			ITEMS.add(PRUDENTIUM_SEED_EXTRACTOR);
			ITEMS.add(INTERMEDIUM_SEED_EXTRACTOR);
			ITEMS.add(SUPERIUM_SEED_EXTRACTOR);
			ITEMS.add(SUPREMIUM_SEED_EXTRACTOR);
			
			if(ModCheck.MYSTICAL_AGRADDITIONS) {
				INSANIUM_SEED_EXTRACTOR = new SeedExtractor("insanium_seed_extractor", ModToolMaterial.INSANIUM, ModConfig.INSANIUM_DURABILITY, 6);
				ITEMS.add(INSANIUM_SEED_EXTRACTOR);
			}
		}
		
		if(ModCheck.MYSTICAL_AGRADDITIONS) {
			//Crafting Items
			GEAR = new ItemBase("gear");
			GEAR_ARMOR = new ItemBase("gear_armor");
			GEAR_INSANIUM_ARROW_HEAD = new ItemBase("gear_insanium_arrow_head");
			INSANIUM_FERTILIZATION_CORE = new ItemBase("insanium_fertilization_core");
			
			ITEMS.add(GEAR);
			ITEMS.add(GEAR_ARMOR);
			ITEMS.add(GEAR_INSANIUM_ARROW_HEAD);
			ITEMS.add(INSANIUM_FERTILIZATION_CORE);
			
			//Insanium Armor
			if(ModConfig.INSANIUM_ARMOR) {
				INSANIUM_HELMET = new InsaniumArmor("insanium_helmet", ModToolMaterial.INSANIUM_ARMOR, 0, EntityEquipmentSlot.HEAD);
				INSANIUM_CHESTPLATE = new InsaniumArmor("insanium_chestplate", ModToolMaterial.INSANIUM_ARMOR, 0, EntityEquipmentSlot.CHEST);
				INSANIUM_LEGGINGS = new InsaniumArmor("insanium_leggings", ModToolMaterial.INSANIUM_ARMOR, 0, EntityEquipmentSlot.LEGS);
				INSANIUM_BOOTS = new InsaniumArmor("insanium_boots", ModToolMaterial.INSANIUM_ARMOR, 0, EntityEquipmentSlot.FEET);
			
				ITEMS.add(INSANIUM_HELMET);
				ITEMS.add(INSANIUM_CHESTPLATE);
				ITEMS.add(INSANIUM_LEGGINGS);
				ITEMS.add(INSANIUM_BOOTS);
			}
			
			//Insanium Tools
			if(ModConfig.INSANIUM_TOOLS) {
				INSANIUM_SWORD = new InsaniumSword("insanium_sword", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
				INSANIUM_PICKAXE = new InsaniumPickaxe("insanium_pickaxe", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
				INSANIUM_SHOVEL = new InsaniumShovel("insanium_shovel", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
				INSANIUM_AXE = new InsaniumAxe("insanium_axe", ModToolMaterial.INSANIUM, 30.0F, TextFormatting.DARK_PURPLE);
				INSANIUM_HOE = new InsaniumHoe("insanium_hoe", ModToolMaterial.INSANIUM, 2, TextFormatting.DARK_PURPLE);
				INSANIUM_SHEARS = new InsaniumShears("insanium_shears", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
				INSANIUM_BOW = new InsaniumBow("insanium_bow", ModToolMaterial.INSANIUM, 1.0F, TextFormatting.DARK_PURPLE);
				INSANIUM_SICKLE = new InsaniumSickle("insanium_sickle", 2, ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
				INSANIUM_SCYTHE = new InsaniumScythe("insanium_scythe", 1, ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
				INSANIUM_FISHING_ROD = new InsaniumFishingRod("insanium_fishing_rod", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
				INSANIUM_ARROW = new InsaniumArrow("insanium_arrow");
				INSANIUM_PAXEL = new InsaniumPaxel("insanium_paxel", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
				
				ITEMS.add(INSANIUM_SWORD);
				ITEMS.add(INSANIUM_PICKAXE);
				ITEMS.add(INSANIUM_SHOVEL);
				ITEMS.add(INSANIUM_AXE);
				ITEMS.add(INSANIUM_HOE);
				ITEMS.add(INSANIUM_SHEARS);
				ITEMS.add(INSANIUM_BOW);
				ITEMS.add(INSANIUM_SICKLE);
				ITEMS.add(INSANIUM_SCYTHE);
				ITEMS.add(INSANIUM_FISHING_ROD);
				ITEMS.add(INSANIUM_ARROW);
				ITEMS.add(INSANIUM_PAXEL);
				
				if(com.blakebr0.mysticalagriculture.config.ModConfig.confWateringCans) {
					WATERING_CAN_INSANIUM = new InsaniumWateringCan("watering_can_insanium");
					
					ITEMS.add(WATERING_CAN_INSANIUM);
				}
			}
		}
	}
}
