package com.focamacho.mysticaladaptations.lib;

import java.util.ArrayList;
import java.util.List;

import com.focamacho.mysticaladaptations.config.ModConfig;

import cofh.thermalfoundation.entity.projectile.EntityBlitzBolt;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class EntitiesList {

	public static final List<ResourceLocation> Water = getEntitiesFromConfig(ModConfig.water_seeds);
	public static final List<ResourceLocation> Wood = getEntitiesFromConfig(ModConfig.wood_seeds);
	public static final List<ResourceLocation> Copper = getEntitiesFromConfig(ModConfig.copper_seeds);
	public static final List<ResourceLocation> Tin = getEntitiesFromConfig(ModConfig.tin_seeds);
	public static final List<ResourceLocation> Platinum = getEntitiesFromConfig(ModConfig.platinum_seeds);
	public static final List<ResourceLocation> Alubrass = getEntitiesFromConfig(ModConfig.aluminum_brass_seeds);
	public static final List<ResourceLocation> Aluminum = getEntitiesFromConfig(ModConfig.aluminum_seeds);
	public static final List<ResourceLocation> Alumite = getEntitiesFromConfig(ModConfig.alumite_seeds);
	public static final List<ResourceLocation> Ardite = getEntitiesFromConfig(ModConfig.ardite_seeds);
	public static final List<ResourceLocation> QuartzBlack = getEntitiesFromConfig(ModConfig.black_quartz_seeds);
	public static final List<ResourceLocation> Boron = getEntitiesFromConfig(ModConfig.boron_seeds);
	public static final List<ResourceLocation> Brass = getEntitiesFromConfig(ModConfig.brass_seeds);
	public static final List<ResourceLocation> Bronze = getEntitiesFromConfig(ModConfig.bronze_seeds);
	public static final List<ResourceLocation> Chrome = getEntitiesFromConfig(ModConfig.chrome_seeds);
	public static final List<ResourceLocation> Coal = getEntitiesFromConfig(ModConfig.coal_seeds);
	public static final List<ResourceLocation> Cobalt = getEntitiesFromConfig(ModConfig.cobalt_seeds);
	public static final List<ResourceLocation> ConductiveIron = getEntitiesFromConfig(ModConfig.conductive_iron_seeds);
	public static final List<ResourceLocation> Constantan = getEntitiesFromConfig(ModConfig.constantan_seeds);
	public static final List<ResourceLocation> DarkSteel = getEntitiesFromConfig(ModConfig.dark_steel_seeds);
	public static final List<ResourceLocation> Diamond = getEntitiesFromConfig(ModConfig.diamond_seeds);
	public static final List<ResourceLocation> Draconium = getEntitiesFromConfig(ModConfig.draconium_seeds);
	public static final List<ResourceLocation> Dirt = getEntitiesFromConfig(ModConfig.dirt_seeds);
	public static final List<ResourceLocation> ElectricalSteel = getEntitiesFromConfig(ModConfig.electrical_steel_seeds);
	public static final List<ResourceLocation> Electrum = getEntitiesFromConfig(ModConfig.electrum_seeds);
	public static final List<ResourceLocation> Emerald = getEntitiesFromConfig(ModConfig.emerald_seeds);
	public static final List<ResourceLocation> EndSteel = getEntitiesFromConfig(ModConfig.end_steel_seeds);
	public static final List<ResourceLocation> Enderium = getEntitiesFromConfig(ModConfig.enderium_seeds);
	public static final List<ResourceLocation> EnergeticAlloy = getEntitiesFromConfig(ModConfig.energetic_alloy_seeds);
	public static final List<ResourceLocation> RefinedGlowstone = getEntitiesFromConfig(ModConfig.glowstone_ingot_seeds);
	public static final List<ResourceLocation> Glowstone = getEntitiesFromConfig(ModConfig.glowstone_seeds);
	public static final List<ResourceLocation> Gold = getEntitiesFromConfig(ModConfig.gold_seeds);
	public static final List<ResourceLocation> InfinityDust = getEntitiesFromConfig(ModConfig.grains_of_infinity_seeds);
	public static final List<ResourceLocation> Invar = getEntitiesFromConfig(ModConfig.invar_seeds);
	public static final List<ResourceLocation> Iridium = getEntitiesFromConfig(ModConfig.iridium_seeds);
	public static final List<ResourceLocation> Iron = getEntitiesFromConfig(ModConfig.iron_seeds);
	public static final List<ResourceLocation> Knightslime = getEntitiesFromConfig(ModConfig.knightslime_seeds);
	public static final List<ResourceLocation> Lapis = getEntitiesFromConfig(ModConfig.lapis_lazuli_seeds);
	public static final List<ResourceLocation> Lead = getEntitiesFromConfig(ModConfig.lead_seeds);
	public static final List<ResourceLocation> Limestone = getEntitiesFromConfig(ModConfig.limestone_seeds);
	public static final List<ResourceLocation> Lithium = getEntitiesFromConfig(ModConfig.lithium_seeds);
	public static final List<ResourceLocation> Lumium = getEntitiesFromConfig(ModConfig.lumium_seeds);
	public static final List<ResourceLocation> Magnesium = getEntitiesFromConfig(ModConfig.magnesium_seeds);
	public static final List<ResourceLocation> Manyullyn = getEntitiesFromConfig(ModConfig.manyullyn_seeds);
	public static final List<ResourceLocation> Marble = getEntitiesFromConfig(ModConfig.marble_seeds);
	public static final List<ResourceLocation> Mithril = getEntitiesFromConfig(ModConfig.mithril_seeds);
	public static final List<ResourceLocation> Quartz = getEntitiesFromConfig(ModConfig.nether_quartz_seeds);
	public static final List<ResourceLocation> Nickel = getEntitiesFromConfig(ModConfig.nickel_seeds);
	public static final List<ResourceLocation> Obsidian = getEntitiesFromConfig(ModConfig.obsidian_seeds);
	public static final List<ResourceLocation> Osmium = getEntitiesFromConfig(ModConfig.osmium_seeds);
	public static final List<ResourceLocation> Peridot = getEntitiesFromConfig(ModConfig.peridot_seeds);
	public static final List<ResourceLocation> PulsatingIron = getEntitiesFromConfig(ModConfig.pulsating_iron_seeds);
	public static final List<ResourceLocation> RedstoneAlloy = getEntitiesFromConfig(ModConfig.redstone_alloy_seeds);
	public static final List<ResourceLocation> Redstone = getEntitiesFromConfig(ModConfig.redstone_seeds);
	public static final List<ResourceLocation> RefinedObsidian = getEntitiesFromConfig(ModConfig.refined_obsidian_seeds);
	public static final List<ResourceLocation> Ruby = getEntitiesFromConfig(ModConfig.ruby_seeds);
	public static final List<ResourceLocation> Sapphire = getEntitiesFromConfig(ModConfig.sapphire_seeds);
	public static final List<ResourceLocation> Signalum = getEntitiesFromConfig(ModConfig.signalum_seeds);
	public static final List<ResourceLocation> Silver = getEntitiesFromConfig(ModConfig.silver_seeds);
	public static final List<ResourceLocation> Slate = getEntitiesFromConfig(ModConfig.slate_seeds);
	public static final List<ResourceLocation> Slime = getEntitiesFromConfig(ModConfig.slime_seeds);
	public static final List<ResourceLocation> Soularium = getEntitiesFromConfig(ModConfig.soularium_seeds);
	public static final List<ResourceLocation> Steel = getEntitiesFromConfig(ModConfig.steel_seeds);
	public static final List<ResourceLocation> Thorium = getEntitiesFromConfig(ModConfig.thorium_seeds);
	public static final List<ResourceLocation> Titanium = getEntitiesFromConfig(ModConfig.titanium_seeds);
	public static final List<ResourceLocation> Tungsten = getEntitiesFromConfig(ModConfig.tungsten_seeds);
	public static final List<ResourceLocation> Uranium = getEntitiesFromConfig(ModConfig.uranium_seeds);
	public static final List<ResourceLocation> VibrantAlloy = getEntitiesFromConfig(ModConfig.vibrant_alloy_seeds);
	public static final List<ResourceLocation> Zinc = getEntitiesFromConfig(ModConfig.zinc_seeds);
	public static final List<ResourceLocation> Abyssalnite = getEntitiesFromConfig(ModConfig.abyssalnite_seeds);
	public static final List<ResourceLocation> Adamantine = getEntitiesFromConfig(ModConfig.adamantine_seeds);
	public static final List<ResourceLocation> Apatite = getEntitiesFromConfig(ModConfig.apatite_seeds);
	public static final List<ResourceLocation> Aquarium = getEntitiesFromConfig(ModConfig.aquarium_seeds);
	public static final List<ResourceLocation> Basalt = getEntitiesFromConfig(ModConfig.basalt_seeds);
	public static final List<ResourceLocation> ColdIron = getEntitiesFromConfig(ModConfig.cold_iron_seeds);
	public static final List<ResourceLocation> CompressedIron = getEntitiesFromConfig(ModConfig.compressed_iron_seeds);
	public static final List<ResourceLocation> Coralium = getEntitiesFromConfig(ModConfig.coralium_seeds);
	public static final List<ResourceLocation> Dawnstone = getEntitiesFromConfig(ModConfig.dawnstone_seeds);
	public static final List<ResourceLocation> Desh = getEntitiesFromConfig(ModConfig.desh_seeds);
	public static final List<ResourceLocation> Dreadium = getEntitiesFromConfig(ModConfig.dreadium_seeds);
	public static final List<ResourceLocation> End = getEntitiesFromConfig(ModConfig.end_seeds);
	public static final List<ResourceLocation> Fiery = getEntitiesFromConfig(ModConfig.fiery_ingot_seeds);
	public static final List<ResourceLocation> FluxedElectrum = getEntitiesFromConfig(ModConfig.fluxed_electrum_seeds);
	public static final List<ResourceLocation> Jade = getEntitiesFromConfig(ModConfig.jade_seeds);
	public static final List<ResourceLocation> Knightmetal = getEntitiesFromConfig(ModConfig.knightmetal_seeds);
	public static final List<ResourceLocation> Nether = getEntitiesFromConfig(ModConfig.nether_seeds);
	public static final List<ResourceLocation> Octine = getEntitiesFromConfig(ModConfig.octine_seeds);
	public static final List<ResourceLocation> SlimyBone = getEntitiesFromConfig(ModConfig.slimy_bone_seeds);
	public static final List<ResourceLocation> StarSteel = getEntitiesFromConfig(ModConfig.star_steel_seeds);
	public static final List<ResourceLocation> Steeleaf = getEntitiesFromConfig(ModConfig.steeleaf_seeds);
	public static final List<ResourceLocation> Syrmorite = getEntitiesFromConfig(ModConfig.syrmorite_seeds);
	public static final List<ResourceLocation> Thaumium = getEntitiesFromConfig(ModConfig.thaumium_seeds);
	public static final List<ResourceLocation> Tritanium = getEntitiesFromConfig(ModConfig.tritanium_seeds);
	public static final List<ResourceLocation> Valonite = getEntitiesFromConfig(ModConfig.valonite_seeds);
	public static final List<ResourceLocation> VoidMetal = getEntitiesFromConfig(ModConfig.void_metal_seeds);
	public static final List<ResourceLocation> Ice = getEntitiesFromConfig(ModConfig.ice_seeds);
	public static final List<ResourceLocation> Amber = getEntitiesFromConfig(ModConfig.amber_seeds);
	public static final List<ResourceLocation> CertusQuartz = getEntitiesFromConfig(ModConfig.certus_quartz_seeds);
	public static final List<ResourceLocation> DarkGem = getEntitiesFromConfig(ModConfig.dark_gem_seeds);
	public static final List<ResourceLocation> Elementium = getEntitiesFromConfig(ModConfig.elementium_seeds);
	public static final List<ResourceLocation> EnderAmethyst = getEntitiesFromConfig(ModConfig.ender_amethyst_seeds);
	public static final List<ResourceLocation> EnderBiotite = getEntitiesFromConfig(ModConfig.ender_biotite_seeds);
	public static final List<ResourceLocation> Fluix = getEntitiesFromConfig(ModConfig.fluix_seeds);
	public static final List<ResourceLocation> IronWood = getEntitiesFromConfig(ModConfig.ironwood_seeds);
	public static final List<ResourceLocation> Malachite = getEntitiesFromConfig(ModConfig.malachite_seeds);
	public static final List<ResourceLocation> Manasteel = getEntitiesFromConfig(ModConfig.manasteel_seeds);
	public static final List<ResourceLocation> Menril = getEntitiesFromConfig(ModConfig.menril_seeds);
	public static final List<ResourceLocation> MeteoricIron = getEntitiesFromConfig(ModConfig.meteoric_iron_seeds);
	public static final List<ResourceLocation> QuartzEnrichedIron = getEntitiesFromConfig(ModConfig.quartz_enriched_iron_seeds);
	public static final List<ResourceLocation> RockCrystal = getEntitiesFromConfig(ModConfig.rock_crystal_seeds);
	public static final List<ResourceLocation> SkyStone = getEntitiesFromConfig(ModConfig.sky_stone_seeds);
	public static final List<ResourceLocation> Tanzanite = getEntitiesFromConfig(ModConfig.tanzanite_seeds);
	public static final List<ResourceLocation> Terrasteel = getEntitiesFromConfig(ModConfig.terrasteel_seeds);
	public static final List<ResourceLocation> Topaz = getEntitiesFromConfig(ModConfig.topaz_seeds);
	public static final List<ResourceLocation> BlueTopaz = getEntitiesFromConfig(ModConfig.blue_topaz_seeds);
	public static final List<ResourceLocation> Chimerite = getEntitiesFromConfig(ModConfig.chimerite_seeds);
	public static final List<ResourceLocation> Graphite = getEntitiesFromConfig(ModConfig.graphite_seeds);
	public static final List<ResourceLocation> Moonstone = getEntitiesFromConfig(ModConfig.moonstone_seeds);
	public static final List<ResourceLocation> Sunstone = getEntitiesFromConfig(ModConfig.sunstone_seeds);
	public static final List<ResourceLocation> Vinteum = getEntitiesFromConfig(ModConfig.vinteum_seeds);
	public static final List<ResourceLocation> Yellorium = getEntitiesFromConfig(ModConfig.yellorium_seeds);
	public static final List<ResourceLocation> MysticalFlower = getEntitiesFromConfig(ModConfig.mystical_flower_seeds);
	public static final List<ResourceLocation> Nature = getEntitiesFromConfig(ModConfig.nature_seeds);
	public static final List<ResourceLocation> Stone = getEntitiesFromConfig(ModConfig.stone_seeds);
	public static final List<ResourceLocation> Fire = getEntitiesFromConfig(ModConfig.fire_seeds);
	public static final List<ResourceLocation> Aquamarine = getEntitiesFromConfig(ModConfig.aquamarine_seeds);
	public static final List<ResourceLocation> Dilithium = getEntitiesFromConfig(ModConfig.dilithium_seeds);
	public static final List<ResourceLocation> IridiumOre = getEntitiesFromConfig(ModConfig.iridium_ore_seeds);
	public static final List<ResourceLocation> Rubber = getEntitiesFromConfig(ModConfig.rubber_seeds);
	public static final List<ResourceLocation> Starmetal = getEntitiesFromConfig(ModConfig.starmetal_seeds);
	public static final List<ResourceLocation> Uranium238 = getEntitiesFromConfig(ModConfig.uranium_238_seeds);
	public static final List<ResourceLocation> Quicksilver = getEntitiesFromConfig(ModConfig.quicksilver_seeds);
	public static final List<ResourceLocation> Dye = getEntitiesFromConfig(ModConfig.dye_seeds);
	public static final List<ResourceLocation> Netherstar = getEntitiesFromConfig(ModConfig.nether_star_seeds);
	public static final List<ResourceLocation> Awakened = getEntitiesFromConfig(ModConfig.awakened_draconium_seeds);
	public static final List<ResourceLocation> DragonEgg = getEntitiesFromConfig(ModConfig.dragon_egg_seeds);
	public static final List<ResourceLocation> Neutronium = getEntitiesFromConfig(ModConfig.neutronium_seeds);
	public static final List<ResourceLocation> Silicon = getEntitiesFromConfig(ModConfig.silicon_seeds);
	public static final List<ResourceLocation> Basalz = getEntitiesFromConfig(ModConfig.basalz_seeds);
	public static final List<ResourceLocation> Blaze = getEntitiesFromConfig(ModConfig.blaze_seeds);
	public static final List<ResourceLocation> Blitz = getEntitiesFromConfig(ModConfig.blitz_seeds);
	public static final List<ResourceLocation> Blizz = getEntitiesFromConfig(ModConfig.blizz_seeds);
	public static final List<ResourceLocation> Chicken = getEntitiesFromConfig(ModConfig.chicken_seeds);
	public static final List<ResourceLocation> Cow = getEntitiesFromConfig(ModConfig.cow_seeds);
	public static final List<ResourceLocation> Creeper = getEntitiesFromConfig(ModConfig.creeper_seeds);
	public static final List<ResourceLocation> Enderman = getEntitiesFromConfig(ModConfig.enderman_seeds);
	public static final List<ResourceLocation> Ghast = getEntitiesFromConfig(ModConfig.ghast_seeds);
	public static final List<ResourceLocation> Guardian = getEntitiesFromConfig(ModConfig.guardian_seeds);
	public static final List<ResourceLocation> Pig = getEntitiesFromConfig(ModConfig.pig_seeds);
	public static final List<ResourceLocation> Rabbit = getEntitiesFromConfig(ModConfig.rabbit_seeds);
	public static final List<ResourceLocation> Sheep = getEntitiesFromConfig(ModConfig.sheep_seeds);
	public static final List<ResourceLocation> Skeleton = getEntitiesFromConfig(ModConfig.skeleton_seeds);
	public static final List<ResourceLocation> Spider = getEntitiesFromConfig(ModConfig.spider_seeds);
	public static final List<ResourceLocation> WitherSkeleton = getEntitiesFromConfig(ModConfig.wither_skeleton_seeds);
	public static final List<ResourceLocation> Zombie = getEntitiesFromConfig(ModConfig.zombie_seeds);
	
	public static List<ResourceLocation> getEntitiesFromConfig(String config) {
		List<EntityEntry> entityRegistry = ForgeRegistries.ENTITIES.getValues();
		String[] entityList = config.split(";");
		List<ResourceLocation> allEntities = new ArrayList<ResourceLocation>();
		if(!(entityList.length <= 0)) {
			for(String entity : entityList) {
				if(entity.startsWith("entity")) {
					String[] split = entity.split(":");
					for(EntityEntry entityE : entityRegistry) {
						ResourceLocation entityR = new ResourceLocation(split[1] + ":" + split[2]);
						if(entityE.getRegistryName().equals(entityR)) allEntities.add(entityR);
					}
				}
			}
		}
		return allEntities;
	}
		
}
