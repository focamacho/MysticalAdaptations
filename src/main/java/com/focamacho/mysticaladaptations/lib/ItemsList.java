package com.focamacho.mysticaladaptations.lib;

import java.util.ArrayList;
import java.util.List;

import com.focamacho.mysticaladaptations.config.ModConfig;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class ItemsList {

	public static final List<ItemStack> Water = getItemsFromConfig(ModConfig.water_seeds);
	public static final List<ItemStack> Wood = getItemsFromConfig(ModConfig.wood_seeds);
	public static final List<ItemStack> Copper = getItemsFromConfig(ModConfig.copper_seeds);
	public static final List<ItemStack> Tin = getItemsFromConfig(ModConfig.tin_seeds);
	public static final List<ItemStack> Platinum = getItemsFromConfig(ModConfig.platinum_seeds);
	public static final List<ItemStack> Alubrass = getItemsFromConfig(ModConfig.aluminum_brass_seeds);
	public static final List<ItemStack> Aluminum = getItemsFromConfig(ModConfig.aluminum_seeds);
	public static final List<ItemStack> Alumite = getItemsFromConfig(ModConfig.alumite_seeds);
	public static final List<ItemStack> Ardite = getItemsFromConfig(ModConfig.ardite_seeds);
	public static final List<ItemStack> QuartzBlack = getItemsFromConfig(ModConfig.black_quartz_seeds);
	public static final List<ItemStack> Boron = getItemsFromConfig(ModConfig.boron_seeds);
	public static final List<ItemStack> Brass = getItemsFromConfig(ModConfig.brass_seeds);
	public static final List<ItemStack> Bronze = getItemsFromConfig(ModConfig.bronze_seeds);
	public static final List<ItemStack> Chrome = getItemsFromConfig(ModConfig.chrome_seeds);
	public static final List<ItemStack> Coal = getItemsFromConfig(ModConfig.coal_seeds);
	public static final List<ItemStack> Cobalt = getItemsFromConfig(ModConfig.cobalt_seeds);
	public static final List<ItemStack> ConductiveIron = getItemsFromConfig(ModConfig.conductive_iron_seeds);
	public static final List<ItemStack> Constantan = getItemsFromConfig(ModConfig.constantan_seeds);
	public static final List<ItemStack> DarkSteel = getItemsFromConfig(ModConfig.dark_steel_seeds);
	public static final List<ItemStack> Diamond = getItemsFromConfig(ModConfig.diamond_seeds);
	public static final List<ItemStack> Draconium = getItemsFromConfig(ModConfig.draconium_seeds);
	public static final List<ItemStack> Dirt = getItemsFromConfig(ModConfig.dirt_seeds);
	public static final List<ItemStack> ElectricalSteel = getItemsFromConfig(ModConfig.electrical_steel_seeds);
	public static final List<ItemStack> Electrum = getItemsFromConfig(ModConfig.electrum_seeds);
	public static final List<ItemStack> Emerald = getItemsFromConfig(ModConfig.emerald_seeds);
	public static final List<ItemStack> EndSteel = getItemsFromConfig(ModConfig.end_steel_seeds);
	public static final List<ItemStack> Enderium = getItemsFromConfig(ModConfig.enderium_seeds);
	public static final List<ItemStack> EnergeticAlloy = getItemsFromConfig(ModConfig.energetic_alloy_seeds);
	public static final List<ItemStack> RefinedGlowstone = getItemsFromConfig(ModConfig.glowstone_ingot_seeds);
	public static final List<ItemStack> Glowstone = getItemsFromConfig(ModConfig.glowstone_seeds);
	public static final List<ItemStack> Gold = getItemsFromConfig(ModConfig.gold_seeds);
	public static final List<ItemStack> InfinityDust = getItemsFromConfig(ModConfig.grains_of_infinity_seeds);
	public static final List<ItemStack> Invar = getItemsFromConfig(ModConfig.invar_seeds);
	public static final List<ItemStack> Iridium = getItemsFromConfig(ModConfig.iridium_seeds);
	public static final List<ItemStack> Iron = getItemsFromConfig(ModConfig.iron_seeds);
	public static final List<ItemStack> Knightslime = getItemsFromConfig(ModConfig.knightslime_seeds);
	public static final List<ItemStack> Lapis = getItemsFromConfig(ModConfig.lapis_lazuli_seeds);
	public static final List<ItemStack> Lead = getItemsFromConfig(ModConfig.lead_seeds);
	public static final List<ItemStack> Limestone = getItemsFromConfig(ModConfig.limestone_seeds);
	public static final List<ItemStack> Lithium = getItemsFromConfig(ModConfig.lithium_seeds);
	public static final List<ItemStack> Lumium = getItemsFromConfig(ModConfig.lumium_seeds);
	public static final List<ItemStack> Magnesium = getItemsFromConfig(ModConfig.magnesium_seeds);
	public static final List<ItemStack> Manyullyn = getItemsFromConfig(ModConfig.manyullyn_seeds);
	public static final List<ItemStack> Marble = getItemsFromConfig(ModConfig.marble_seeds);
	public static final List<ItemStack> Mithril = getItemsFromConfig(ModConfig.mithril_seeds);
	public static final List<ItemStack> Quartz = getItemsFromConfig(ModConfig.nether_quartz_seeds);
	public static final List<ItemStack> Nickel = getItemsFromConfig(ModConfig.nickel_seeds);
	public static final List<ItemStack> Obsidian = getItemsFromConfig(ModConfig.obsidian_seeds);
	public static final List<ItemStack> Osmium = getItemsFromConfig(ModConfig.osmium_seeds);
	public static final List<ItemStack> Peridot = getItemsFromConfig(ModConfig.peridot_seeds);
	public static final List<ItemStack> PulsatingIron = getItemsFromConfig(ModConfig.pulsating_iron_seeds);
	public static final List<ItemStack> RedstoneAlloy = getItemsFromConfig(ModConfig.redstone_alloy_seeds);
	public static final List<ItemStack> Redstone = getItemsFromConfig(ModConfig.redstone_seeds);
	public static final List<ItemStack> RefinedObsidian = getItemsFromConfig(ModConfig.refined_obsidian_seeds);
	public static final List<ItemStack> Ruby = getItemsFromConfig(ModConfig.ruby_seeds);
	public static final List<ItemStack> Sapphire = getItemsFromConfig(ModConfig.sapphire_seeds);
	public static final List<ItemStack> Signalum = getItemsFromConfig(ModConfig.signalum_seeds);
	public static final List<ItemStack> Silver = getItemsFromConfig(ModConfig.silver_seeds);
	public static final List<ItemStack> Slate = getItemsFromConfig(ModConfig.slate_seeds);
	public static final List<ItemStack> Slime = getItemsFromConfig(ModConfig.slime_seeds);
	public static final List<ItemStack> Soularium = getItemsFromConfig(ModConfig.soularium_seeds);
	public static final List<ItemStack> Steel = getItemsFromConfig(ModConfig.steel_seeds);
	public static final List<ItemStack> Thorium = getItemsFromConfig(ModConfig.thorium_seeds);
	public static final List<ItemStack> Titanium = getItemsFromConfig(ModConfig.titanium_seeds);
	public static final List<ItemStack> Tungsten = getItemsFromConfig(ModConfig.tungsten_seeds);
	public static final List<ItemStack> Uranium = getItemsFromConfig(ModConfig.uranium_seeds);
	public static final List<ItemStack> VibrantAlloy = getItemsFromConfig(ModConfig.vibrant_alloy_seeds);
	public static final List<ItemStack> Zinc = getItemsFromConfig(ModConfig.zinc_seeds);
	public static final List<ItemStack> Abyssalnite = getItemsFromConfig(ModConfig.abyssalnite_seeds);
	public static final List<ItemStack> Adamantine = getItemsFromConfig(ModConfig.adamantine_seeds);
	public static final List<ItemStack> Apatite = getItemsFromConfig(ModConfig.apatite_seeds);
	public static final List<ItemStack> Aquarium = getItemsFromConfig(ModConfig.aquarium_seeds);
	public static final List<ItemStack> Basalt = getItemsFromConfig(ModConfig.basalt_seeds);
	public static final List<ItemStack> ColdIron = getItemsFromConfig(ModConfig.cold_iron_seeds);
	public static final List<ItemStack> CompressedIron = getItemsFromConfig(ModConfig.compressed_iron_seeds);
	public static final List<ItemStack> Coralium = getItemsFromConfig(ModConfig.coralium_seeds);
	public static final List<ItemStack> Dawnstone = getItemsFromConfig(ModConfig.dawnstone_seeds);
	public static final List<ItemStack> Desh = getItemsFromConfig(ModConfig.desh_seeds);
	public static final List<ItemStack> Dreadium = getItemsFromConfig(ModConfig.dreadium_seeds);
	public static final List<ItemStack> End = getItemsFromConfig(ModConfig.end_seeds);
	public static final List<ItemStack> Fiery = getItemsFromConfig(ModConfig.fiery_ingot_seeds);
	public static final List<ItemStack> FluxedElectrum = getItemsFromConfig(ModConfig.fluxed_electrum_seeds);
	public static final List<ItemStack> Jade = getItemsFromConfig(ModConfig.jade_seeds);
	public static final List<ItemStack> Knightmetal = getItemsFromConfig(ModConfig.knightmetal_seeds);
	public static final List<ItemStack> Nether = getItemsFromConfig(ModConfig.nether_seeds);
	public static final List<ItemStack> Octine = getItemsFromConfig(ModConfig.octine_seeds);
	public static final List<ItemStack> SlimyBone = getItemsFromConfig(ModConfig.slimy_bone_seeds);
	public static final List<ItemStack> StarSteel = getItemsFromConfig(ModConfig.star_steel_seeds);
	public static final List<ItemStack> Steeleaf = getItemsFromConfig(ModConfig.steeleaf_seeds);
	public static final List<ItemStack> Syrmorite = getItemsFromConfig(ModConfig.syrmorite_seeds);
	public static final List<ItemStack> Thaumium = getItemsFromConfig(ModConfig.thaumium_seeds);
	public static final List<ItemStack> Tritanium = getItemsFromConfig(ModConfig.tritanium_seeds);
	public static final List<ItemStack> Valonite = getItemsFromConfig(ModConfig.valonite_seeds);
	public static final List<ItemStack> VoidMetal = getItemsFromConfig(ModConfig.void_metal_seeds);
	public static final List<ItemStack> Ice =  getItemsFromConfig(ModConfig.ice_seeds);
	public static final List<ItemStack> Amber = getItemsFromConfig(ModConfig.amber_seeds);
	public static final List<ItemStack> CertusQuartz = getItemsFromConfig(ModConfig.certus_quartz_seeds);
	public static final List<ItemStack> DarkGem = getItemsFromConfig(ModConfig.dark_gem_seeds);
	public static final List<ItemStack> Elementium = getItemsFromConfig(ModConfig.elementium_seeds);
	public static final List<ItemStack> EnderAmethyst = getItemsFromConfig(ModConfig.ender_amethyst_seeds);
	public static final List<ItemStack> EnderBiotite = getItemsFromConfig(ModConfig.ender_biotite_seeds);
	public static final List<ItemStack> Fluix = getItemsFromConfig(ModConfig.fluix_seeds);
	public static final List<ItemStack> IronWood = getItemsFromConfig(ModConfig.ironwood_seeds);
	public static final List<ItemStack> Malachite = getItemsFromConfig(ModConfig.malachite_seeds);
	public static final List<ItemStack> Manasteel = getItemsFromConfig(ModConfig.manasteel_seeds);
	public static final List<ItemStack> Menril = getItemsFromConfig(ModConfig.menril_seeds);
	public static final List<ItemStack> MeteoricIron = getItemsFromConfig(ModConfig.meteoric_iron_seeds);
	public static final List<ItemStack> QuartzEnrichedIron = getItemsFromConfig(ModConfig.quartz_enriched_iron_seeds);
	public static final List<ItemStack> RockCrystal = getItemsFromConfig(ModConfig.rock_crystal_seeds);
	public static final List<ItemStack> SkyStone = getItemsFromConfig(ModConfig.sky_stone_seeds);
	public static final List<ItemStack> Tanzanite = getItemsFromConfig(ModConfig.tanzanite_seeds);
	public static final List<ItemStack> Terrasteel = getItemsFromConfig(ModConfig.terrasteel_seeds);
	public static final List<ItemStack> Topaz = getItemsFromConfig(ModConfig.topaz_seeds);
	public static final List<ItemStack> BlueTopaz = getItemsFromConfig(ModConfig.blue_topaz_seeds);
	public static final List<ItemStack> Chimerite = getItemsFromConfig(ModConfig.chimerite_seeds);
	public static final List<ItemStack> Graphite = getItemsFromConfig(ModConfig.graphite_seeds);
	public static final List<ItemStack> Moonstone = getItemsFromConfig(ModConfig.moonstone_seeds);
	public static final List<ItemStack> Sunstone = getItemsFromConfig(ModConfig.sunstone_seeds);
	public static final List<ItemStack> Vinteum = getItemsFromConfig(ModConfig.vinteum_seeds);
	public static final List<ItemStack> Yellorium = getItemsFromConfig(ModConfig.yellorium_seeds);
	public static final List<ItemStack> MysticalFlower = getItemsFromConfig(ModConfig.mystical_flower_seeds);
	public static final List<ItemStack> Nature = getItemsFromConfig(ModConfig.nature_seeds);
	public static final List<ItemStack> Stone = getItemsFromConfig(ModConfig.stone_seeds);
	public static final List<ItemStack> Fire = getItemsFromConfig(ModConfig.fire_seeds);
	public static final List<ItemStack> Aquamarine = getItemsFromConfig(ModConfig.aquamarine_seeds);
	public static final List<ItemStack> Dilithium = getItemsFromConfig(ModConfig.dilithium_seeds);
	public static final List<ItemStack> IridiumOre = getItemsFromConfig(ModConfig.iridium_ore_seeds);
	public static final List<ItemStack> Rubber = getItemsFromConfig(ModConfig.rubber_seeds);
	public static final List<ItemStack> Starmetal = getItemsFromConfig(ModConfig.starmetal_seeds);
	public static final List<ItemStack> Uranium238 = getItemsFromConfig(ModConfig.uranium_238_seeds);
	public static final List<ItemStack> Quicksilver = getItemsFromConfig(ModConfig.quicksilver_seeds);
	public static final List<ItemStack> Dye = getItemsFromConfig(ModConfig.dye_seeds);
	public static final List<ItemStack> Netherstar = getItemsFromConfig(ModConfig.nether_star_seeds);
	public static final List<ItemStack> Awakened = getItemsFromConfig(ModConfig.awakened_draconium_seeds);
	public static final List<ItemStack> DragonEgg = getItemsFromConfig(ModConfig.dragon_egg_seeds);
	public static final List<ItemStack> Neutronium = getItemsFromConfig(ModConfig.neutronium_seeds);
	public static final List<ItemStack> Silicon = getItemsFromConfig(ModConfig.silicon_seeds);
	public static final List<ItemStack> Basalz = getItemsFromConfig(ModConfig.basalz_seeds);
	public static final List<ItemStack> Blaze = getItemsFromConfig(ModConfig.blaze_seeds);
	public static final List<ItemStack> Blitz = getItemsFromConfig(ModConfig.blitz_seeds);
	public static final List<ItemStack> Blizz = getItemsFromConfig(ModConfig.blizz_seeds);
	public static final List<ItemStack> Chicken = getItemsFromConfig(ModConfig.chicken_seeds);
	public static final List<ItemStack> Cow = getItemsFromConfig(ModConfig.cow_seeds);
	public static final List<ItemStack> Creeper = getItemsFromConfig(ModConfig.creeper_seeds);
	public static final List<ItemStack> Enderman = getItemsFromConfig(ModConfig.enderman_seeds);
	public static final List<ItemStack> Ghast = getItemsFromConfig(ModConfig.ghast_seeds);
	public static final List<ItemStack> Guardian = getItemsFromConfig(ModConfig.guardian_seeds);
	public static final List<ItemStack> Pig = getItemsFromConfig(ModConfig.pig_seeds);
	public static final List<ItemStack> Rabbit = getItemsFromConfig(ModConfig.rabbit_seeds);
	public static final List<ItemStack> Sheep = getItemsFromConfig(ModConfig.sheep_seeds);
	public static final List<ItemStack> Skeleton = getItemsFromConfig(ModConfig.skeleton_seeds);
	public static final List<ItemStack> Spider = getItemsFromConfig(ModConfig.spider_seeds);
	public static final List<ItemStack> WitherSkeleton = getItemsFromConfig(ModConfig.wither_skeleton_seeds);
	public static final List<ItemStack> Zombie = getItemsFromConfig(ModConfig.zombie_seeds);
	
	public static List<ItemStack> getItemsFromConfig(String config) {
		List<ItemStack> allItems = new ArrayList<ItemStack>();
		String[] itemList = config.split(";");
		if(!(itemList.length <= 0)) {
			for(String item : itemList) {
				if(item.startsWith("ore:")) {
					String[] split = item.split(":");
					allItems.addAll(getItemListFromOredict(split[1]));
				} else if(item.startsWith("entity")) {
					//nothing
				} else {
					String[] split = item.split(":");
					if(split.length > 2) {
						ItemStack itemA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]), 1, Integer.parseInt(split[2]));
						if(!(itemA.getItem() == Items.AIR)) {
							allItems.add(itemA);
						}
					} else if(split.length == 2){
						ItemStack itemA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]));
						if(!(itemA.getItem() == Items.AIR)) {
							allItems.add(itemA);
						}
					}
				}
			}
		}
		return allItems;
	}
	
	public static List<ItemStack> getItemListFromOredict(String ore) {
		List<ItemStack> oreItems = OreDictionary.getOres(ore);
		return oreItems;
	}
	
}
