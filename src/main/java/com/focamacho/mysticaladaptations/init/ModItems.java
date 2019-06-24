package com.focamacho.mysticaladaptations.init;

import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.ModToolMaterials;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.items.ItemBase;
import com.focamacho.mysticaladaptations.items.SeedExtractor;
import com.focamacho.mysticaladaptations.lib.ModToolMaterial;
import com.focamacho.mysticaladaptations.util.BlockCheck;
import com.focamacho.mysticaladaptations.util.ModCheck;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item INFERIUM_SEED_EXTRACTOR = new SeedExtractor("inferium_seed_extractor", ModToolMaterials.INFERIUM, ModConfig.INFERIUM_DURABILITY, 1, true);
	public static final Item PRUDENTIUM_SEED_EXTRACTOR = new SeedExtractor("prudentium_seed_extractor", ModToolMaterials.PRUDENTIUM, ModConfig.PRUDENTIUM_DURABILITY, 2, true);
	public static final Item INTERMEDIUM_SEED_EXTRACTOR = new SeedExtractor("intermedium_seed_extractor", ModToolMaterials.INTERMEDIUM, ModConfig.INTERMEDIUM_DURABILITY, 3, true);
	public static final Item SUPERIUM_SEED_EXTRACTOR = new SeedExtractor("superium_seed_extractor", ModToolMaterials.SUPERIUM, ModConfig.SUPERIUM_DURABILITY, 4, true);
	public static final Item SUPREMIUM_SEED_EXTRACTOR = new SeedExtractor("supremium_seed_extractor", ModToolMaterials.SUPREMIUM, ModConfig.SUPREMIUM_DURABILITY, 5, true);

	public static final Item GEAR = new ItemBase("gear", ModCheck.MYSTICAL_AGRADDITIONS);
	public static final Item INSANIUM_SEED_EXTRACTOR = new SeedExtractor("insanium_seed_extractor", ModToolMaterial.INSANIUM, ModConfig.INSANIUM_DURABILITY, 6, ModCheck.MYSTICAL_AGRADDITIONS);

}
