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
import com.focamacho.mysticaladaptations.util.Reference;
import com.focamacho.mysticaladaptations.util.Utils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

	static final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

	public static RegistryObject<Item> INSANIUM_SWORD = items.register("insanium_sword", () -> new EssenceSwordItem(ModItemTier.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_PICKAXE = items.register("insanium_pickaxe", () -> new EssencePickaxeItem(ModItemTier.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_SHOVEL = items.register("insanium_shovel", () -> new EssenceShovelItem(ModItemTier.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_AXE = items.register("insanium_axe", () -> new EssenceAxeItem(ModItemTier.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_HOE = items.register("insanium_hoe", () -> new EssenceHoeItem(ModItemTier.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_STAFF = items.register("insanium_staff", () -> new EssenceStaffItem(6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_PAXEL = items.register("insanium_paxel", () -> new EssencePaxelItem(ModItemTier.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumToolsAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumTools ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_WATERING_CAN = items.register("insanium_watering_can", () -> new EssenceWateringCanItem(13, 0.5, Utils.getColorFromTier(6), p -> p.tab(MysticalAdaptations.creativeTab)));

	public static RegistryObject<Item> INSANIUM_HELMET = items.register("insanium_helmet", () -> new EssenceHelmetItem(ModArmorMaterial.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumArmorAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumArmor ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_CHESTPLATE = items.register("insanium_chestplate", () -> new EssenceChestplateItem(ModArmorMaterial.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumArmorAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumArmor ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_LEGGINGS = items.register("insanium_leggings", () -> new EssenceLeggingsItem(ModArmorMaterial.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumArmorAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumArmor ? 30 : 0; }});
	public static RegistryObject<Item> INSANIUM_BOOTS = items.register("insanium_boots", () -> new EssenceBootsItem(ModArmorMaterial.INSANIUM, 6, 1, p -> p.tab(MysticalAdaptations.creativeTab)){@Override public int getAugmentSlots() { return ConfigHolder.insaniumArmorAugments; }@Override public int getEnchantmentValue() { return ConfigHolder.enchantableInsaniumArmor ? 30 : 0; }});

}
