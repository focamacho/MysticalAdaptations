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
	
	public static final Item INFERIUM_SEED_EXTRACTOR = new SeedExtractor("inferium_seed_extractor", ModToolMaterials.INFERIUM, ModConfig.INFERIUM_DURABILITY, 1, ModConfig.ENABLE_SEED_EXTRACTORS);
	public static final Item PRUDENTIUM_SEED_EXTRACTOR = new SeedExtractor("prudentium_seed_extractor", ModToolMaterials.PRUDENTIUM, ModConfig.PRUDENTIUM_DURABILITY, 2, ModConfig.ENABLE_SEED_EXTRACTORS);
	public static final Item INTERMEDIUM_SEED_EXTRACTOR = new SeedExtractor("intermedium_seed_extractor", ModToolMaterials.INTERMEDIUM, ModConfig.INTERMEDIUM_DURABILITY, 3, ModConfig.ENABLE_SEED_EXTRACTORS);
	public static final Item SUPERIUM_SEED_EXTRACTOR = new SeedExtractor("superium_seed_extractor", ModToolMaterials.SUPERIUM, ModConfig.SUPERIUM_DURABILITY, 4, ModConfig.ENABLE_SEED_EXTRACTORS);
	public static final Item SUPREMIUM_SEED_EXTRACTOR = new SeedExtractor("supremium_seed_extractor", ModToolMaterials.SUPREMIUM, ModConfig.SUPREMIUM_DURABILITY, 5, ModConfig.ENABLE_SEED_EXTRACTORS);

	//Mystical Agradditions Compat
	public static final Item INSANIUM_SEED_EXTRACTOR = new SeedExtractor("insanium_seed_extractor", ModToolMaterial.INSANIUM, ModConfig.INSANIUM_DURABILITY, 6, ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.ENABLE_SEED_EXTRACTORS);
	public static final Item GEAR = new ItemBase("gear", ModCheck.MYSTICAL_AGRADDITIONS);
	public static final Item GEAR_ARMOR = new ItemBase("gear_armor", ModCheck.MYSTICAL_AGRADDITIONS);
	public static final Item GEAR_INSANIUM_ARROW_HEAD = new ItemBase("gear_insanium_arrow_head", ModCheck.MYSTICAL_AGRADDITIONS);
	public static final Item INSANIUM_FERTILIZATION_CORE = new ItemBase("insanium_fertilization_core", ModCheck.MYSTICAL_AGRADDITIONS);
	
	public static InsaniumArmor INSANIUM_HELMET = new InsaniumArmor("insanium_helmet", ModToolMaterial.INSANIUM_ARMOR, 0, EntityEquipmentSlot.HEAD);
	public static InsaniumArmor INSANIUM_CHESTPLATE = new InsaniumArmor("insanium_chestplate", ModToolMaterial.INSANIUM_ARMOR, 0, EntityEquipmentSlot.CHEST);
	public static InsaniumArmor INSANIUM_LEGGINGS = new InsaniumArmor("insanium_leggings", ModToolMaterial.INSANIUM_ARMOR, 0, EntityEquipmentSlot.LEGS);
	public static InsaniumArmor INSANIUM_BOOTS = new InsaniumArmor("insanium_boots", ModToolMaterial.INSANIUM_ARMOR, 0, EntityEquipmentSlot.FEET);
			
	public static InsaniumSword INSANIUM_SWORD = new InsaniumSword("insanium_sword", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
	public static InsaniumPickaxe INSANIUM_PICKAXE = new InsaniumPickaxe("insanium_pickaxe", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
	public static InsaniumShovel INSANIUM_SHOVEL = new InsaniumShovel("insanium_shovel", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
	public static InsaniumAxe INSANIUM_AXE = new InsaniumAxe("insanium_axe", ModToolMaterial.INSANIUM, 30.0F, TextFormatting.DARK_PURPLE);
	public static InsaniumHoe INSANIUM_HOE = new InsaniumHoe("insanium_hoe", ModToolMaterial.INSANIUM, 2, TextFormatting.DARK_PURPLE);
	public static InsaniumShears INSANIUM_SHEARS = new InsaniumShears("insanium_shears", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
	public static InsaniumBow INSANIUM_BOW = new InsaniumBow("insanium_bow", ModToolMaterial.INSANIUM, 1.0F, TextFormatting.DARK_PURPLE);
	public static InsaniumSickle INSANIUM_SICKLE = new InsaniumSickle("insanium_sickle", 2, ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
	public static InsaniumScythe INSANIUM_SCYTHE = new InsaniumScythe("insanium_scythe", 1, ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
	public static InsaniumFishingRod INSANIUM_FISHING_ROD = new InsaniumFishingRod("insanium_fishing_rod", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
	public static InsaniumArrow INSANIUM_ARROW = new InsaniumArrow("insanium_arrow");
	public static InsaniumWateringCan WATERING_CAN_INSANIUM = new InsaniumWateringCan("watering_can_insanium");
	public static InsaniumPaxel INSANIUM_PAXEL = new InsaniumPaxel("insanium_paxel", ModToolMaterial.INSANIUM, TextFormatting.DARK_PURPLE);
	
}
