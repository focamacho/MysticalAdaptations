package com.focamacho.mysticaladaptations.init;

import com.blakebr0.mysticalagradditions.item.EssencePaxelItem;
import com.blakebr0.mysticalagriculture.item.EssenceWateringCanItem;
import com.blakebr0.mysticalagriculture.item.armor.EssenceBootsItem;
import com.blakebr0.mysticalagriculture.item.armor.EssenceChestplateItem;
import com.blakebr0.mysticalagriculture.item.armor.EssenceHelmetItem;
import com.blakebr0.mysticalagriculture.item.armor.EssenceLeggingsItem;
import com.blakebr0.mysticalagriculture.item.tool.*;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.config.ConfigHolder;
import com.focamacho.mysticaladaptations.lib.ModArmorMaterial;
import com.focamacho.mysticaladaptations.lib.ModItemTier;
import com.focamacho.mysticaladaptations.util.Utils;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static List<Item> allItems = new ArrayList<Item>();

	public static Item INSANIUM_SWORD = new EssenceSwordItem(ModItemTier.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }};
	public static Item INSANIUM_PICKAXE = new EssencePickaxeItem(ModItemTier.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }};
	public static Item INSANIUM_SHOVEL = new EssenceShovelItem(ModItemTier.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }};
	public static Item INSANIUM_AXE = new EssenceAxeItem(ModItemTier.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }};
	public static Item INSANIUM_HOE = new EssenceHoeItem(ModItemTier.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }};
	public static Item INSANIUM_STAFF = new EssenceStaffItem(6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }};
	public static Item INSANIUM_PAXEL = new EssencePaxelItem(ModItemTier.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }};
	public static Item INSANIUM_WATERING_CAN = new EssenceWateringCanItem(13, 0.5, Utils.getColorFromTier(6), p -> p.group(MysticalAdaptations.creativeTab));

	public static Item INSANIUM_HELMET = new EssenceHelmetItem(ModArmorMaterial.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumArmorAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumArmor ? 30 : 0; }};
	public static Item INSANIUM_CHESTPLATE = new EssenceChestplateItem(ModArmorMaterial.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumArmorAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumArmor ? 30 : 0; }};
	public static Item INSANIUM_LEGGINGS = new EssenceLeggingsItem(ModArmorMaterial.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumArmorAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumArmor ? 30 : 0; }};
	public static Item INSANIUM_BOOTS = new EssenceBootsItem(ModArmorMaterial.INSANIUM, 6, 1, p -> p.group(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumArmorAugments; }@Override public int getItemEnchantability() { return ConfigHolder.enchantableInsaniumArmor ? 30 : 0; }};

	public static void initItems() {
		INSANIUM_SWORD.setRegistryName(Utils.getRegistryName("insanium_sword"));
		INSANIUM_PICKAXE.setRegistryName(Utils.getRegistryName("insanium_pickaxe"));
		INSANIUM_SHOVEL.setRegistryName(Utils.getRegistryName("insanium_shovel"));
		INSANIUM_AXE.setRegistryName(Utils.getRegistryName("insanium_axe"));
		INSANIUM_HOE.setRegistryName(Utils.getRegistryName("insanium_hoe"));
		INSANIUM_STAFF.setRegistryName(Utils.getRegistryName("insanium_staff"));
		INSANIUM_WATERING_CAN.setRegistryName(Utils.getRegistryName("insanium_watering_can"));
		INSANIUM_HELMET.setRegistryName(Utils.getRegistryName("insanium_helmet"));
		INSANIUM_CHESTPLATE.setRegistryName(Utils.getRegistryName("insanium_chestplate"));
		INSANIUM_LEGGINGS.setRegistryName(Utils.getRegistryName("insanium_leggings"));
		INSANIUM_BOOTS.setRegistryName(Utils.getRegistryName("insanium_boots"));
		INSANIUM_PAXEL.setRegistryName(Utils.getRegistryName("insanium_paxel"));

		allItems.add(INSANIUM_SWORD);
		allItems.add(INSANIUM_PICKAXE);
		allItems.add(INSANIUM_SHOVEL);
		allItems.add(INSANIUM_AXE);
		allItems.add(INSANIUM_HOE);
		allItems.add(INSANIUM_STAFF);
		allItems.add(INSANIUM_WATERING_CAN);
		allItems.add(INSANIUM_HELMET);
		allItems.add(INSANIUM_CHESTPLATE);
		allItems.add(INSANIUM_LEGGINGS);
		allItems.add(INSANIUM_BOOTS);
		allItems.add(INSANIUM_PAXEL);
	}

}
