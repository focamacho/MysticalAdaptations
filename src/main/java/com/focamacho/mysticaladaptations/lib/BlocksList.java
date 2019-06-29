package com.focamacho.mysticaladaptations.lib;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.blakebr0.mysticalagriculture.blocks.ModBlocks;
import com.blakebr0.mysticalagriculture.lib.CropType;
import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.blakebr0.mysticalagriculture.util.ModChecker;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class BlocksList {
	
	public static final List<Block> Water = getBlocksFromConfig(ModConfig.water_seeds);
	public static final List<Block> Wood = getBlocksFromConfig(ModConfig.wood_seeds);
	public static final List<Block> Copper = getBlocksFromConfig(ModConfig.copper_seeds);
	public static final List<Block> Tin = getBlocksFromConfig(ModConfig.tin_seeds);
	public static final List<Block> Platinum = getBlocksFromConfig(ModConfig.platinum_seeds);
	public static final List<Block> Alubrass = getBlocksFromConfig(ModConfig.aluminum_brass_seeds);
	public static final List<Block> Aluminum = getBlocksFromConfig(ModConfig.aluminum_seeds);
	public static final List<Block> Alumite = getBlocksFromConfig(ModConfig.alumite_seeds);
	public static final List<Block> Ardite = getBlocksFromConfig(ModConfig.ardite_seeds);
	public static final List<Block> QuartzBlack = getBlocksFromConfig(ModConfig.black_quartz_seeds);
	public static final List<Block> Boron = getBlocksFromConfig(ModConfig.boron_seeds);
	public static final List<Block> Brass = getBlocksFromConfig(ModConfig.brass_seeds);
	public static final List<Block> Bronze = getBlocksFromConfig(ModConfig.bronze_seeds);
	public static final List<Block> Chrome = getBlocksFromConfig(ModConfig.chrome_seeds);
	public static final List<Block> Coal = getBlocksFromConfig(ModConfig.coal_seeds);
	public static final List<Block> Cobalt = getBlocksFromConfig(ModConfig.cobalt_seeds);
	public static final List<Block> ConductiveIron = getBlocksFromConfig(ModConfig.conductive_iron_seeds);
	public static final List<Block> Constantan = getBlocksFromConfig(ModConfig.constantan_seeds);
	public static final List<Block> DarkSteel = getBlocksFromConfig(ModConfig.dark_steel_seeds);
	public static final List<Block> Diamond = getBlocksFromConfig(ModConfig.diamond_seeds);
	public static final List<Block> Draconium = getBlocksFromConfig(ModConfig.draconium_seeds);
	public static final List<Block> Dirt = getBlocksFromConfig(ModConfig.dirt_seeds);
	public static final List<Block> ElectricalSteel = getBlocksFromConfig(ModConfig.electrical_steel_seeds);
	public static final List<Block> Electrum = getBlocksFromConfig(ModConfig.electrum_seeds);
	public static final List<Block> Emerald = getBlocksFromConfig(ModConfig.emerald_seeds);
	public static final List<Block> EndSteel = getBlocksFromConfig(ModConfig.end_steel_seeds);
	public static final List<Block> Enderium = getBlocksFromConfig(ModConfig.enderium_seeds);
	public static final List<Block> EnergeticAlloy = getBlocksFromConfig(ModConfig.energetic_alloy_seeds);
	public static final List<Block> RefinedGlowstone = getBlocksFromConfig(ModConfig.glowstone_ingot_seeds);
	public static final List<Block> Glowstone = getBlocksFromConfig(ModConfig.glowstone_seeds);
	public static final List<Block> Gold = getBlocksFromConfig(ModConfig.gold_seeds);
	public static final List<Block> InfinityDust = getBlocksFromConfig(ModConfig.grains_of_infinity_seeds);
	public static final List<Block> Invar = getBlocksFromConfig(ModConfig.invar_seeds);
	public static final List<Block> Iridium = getBlocksFromConfig(ModConfig.iridium_seeds);
	public static final List<Block> Iron = getBlocksFromConfig(ModConfig.iron_seeds);
	public static final List<Block> Knightslime = getBlocksFromConfig(ModConfig.knightslime_seeds);
	public static final List<Block> Lapis = getBlocksFromConfig(ModConfig.lapis_lazuli_seeds);
	public static final List<Block> Lead = getBlocksFromConfig(ModConfig.lead_seeds);
	public static final List<Block> Limestone = getBlocksFromConfig(ModConfig.limestone_seeds);
	public static final List<Block> Lithium = getBlocksFromConfig(ModConfig.lithium_seeds);
	public static final List<Block> Lumium = getBlocksFromConfig(ModConfig.lumium_seeds);
	public static final List<Block> Magnesium = getBlocksFromConfig(ModConfig.magnesium_seeds);
	public static final List<Block> Manyullyn = getBlocksFromConfig(ModConfig.manyullyn_seeds);
	public static final List<Block> Marble = getBlocksFromConfig(ModConfig.marble_seeds);
	public static final List<Block> Mithril = getBlocksFromConfig(ModConfig.mithril_seeds);
	public static final List<Block> Quartz = getBlocksFromConfig(ModConfig.nether_quartz_seeds);
	public static final List<Block> Nickel = getBlocksFromConfig(ModConfig.nickel_seeds);
	public static final List<Block> Obsidian = getBlocksFromConfig(ModConfig.obsidian_seeds);
	public static final List<Block> Osmium = getBlocksFromConfig(ModConfig.osmium_seeds);
	public static final List<Block> Peridot = getBlocksFromConfig(ModConfig.peridot_seeds);
	public static final List<Block> PulsatingIron = getBlocksFromConfig(ModConfig.pulsating_iron_seeds);
	public static final List<Block> RedstoneAlloy = getBlocksFromConfig(ModConfig.redstone_alloy_seeds);
	public static final List<Block> Redstone = getBlocksFromConfig(ModConfig.redstone_seeds);
	public static final List<Block> RefinedObsidian = getBlocksFromConfig(ModConfig.refined_obsidian_seeds);
	public static final List<Block> Ruby = getBlocksFromConfig(ModConfig.ruby_seeds);
	public static final List<Block> Sapphire = getBlocksFromConfig(ModConfig.sapphire_seeds);
	public static final List<Block> Signalum = getBlocksFromConfig(ModConfig.signalum_seeds);
	public static final List<Block> Silver = getBlocksFromConfig(ModConfig.silver_seeds);
	public static final List<Block> Slate = getBlocksFromConfig(ModConfig.slate_seeds);
	public static final List<Block> Slime = getBlocksFromConfig(ModConfig.slime_seeds);
	public static final List<Block> Soularium = getBlocksFromConfig(ModConfig.soularium_seeds);
	public static final List<Block> Steel = getBlocksFromConfig(ModConfig.steel_seeds);
	public static final List<Block> Thorium = getBlocksFromConfig(ModConfig.thorium_seeds);
	public static final List<Block> Titanium = getBlocksFromConfig(ModConfig.titanium_seeds);
	public static final List<Block> Tungsten = getBlocksFromConfig(ModConfig.tungsten_seeds);
	public static final List<Block> Uranium = getBlocksFromConfig(ModConfig.uranium_seeds);
	public static final List<Block> VibrantAlloy = getBlocksFromConfig(ModConfig.vibrant_alloy_seeds);
	public static final List<Block> Zinc = getBlocksFromConfig(ModConfig.zinc_seeds);
	public static final List<Block> Abyssalnite = getBlocksFromConfig(ModConfig.abyssalnite_seeds);
	public static final List<Block> Adamantine = getBlocksFromConfig(ModConfig.adamantine_seeds);
	public static final List<Block> Apatite = getBlocksFromConfig(ModConfig.apatite_seeds);
	public static final List<Block> Aquarium = getBlocksFromConfig(ModConfig.aquarium_seeds);
	public static final List<Block> Basalt = getBlocksFromConfig(ModConfig.basalt_seeds);
	public static final List<Block> ColdIron = getBlocksFromConfig(ModConfig.cold_iron_seeds);
	public static final List<Block> CompressedIron = getBlocksFromConfig(ModConfig.compressed_iron_seeds);
	public static final List<Block> Coralium = getBlocksFromConfig(ModConfig.coralium_seeds);
	public static final List<Block> Dawnstone = getBlocksFromConfig(ModConfig.dawnstone_seeds);
	public static final List<Block> Desh = getBlocksFromConfig(ModConfig.desh_seeds);
	public static final List<Block> Dreadium = getBlocksFromConfig(ModConfig.dreadium_seeds);
	public static final List<Block> End = getBlocksFromConfig(ModConfig.end_seeds);
	public static final List<Block> Fiery = getBlocksFromConfig(ModConfig.fiery_ingot_seeds);
	public static final List<Block> FluxedElectrum = getBlocksFromConfig(ModConfig.fluxed_electrum_seeds);
	public static final List<Block> Jade = getBlocksFromConfig(ModConfig.jade_seeds);
	public static final List<Block> Knightmetal = getBlocksFromConfig(ModConfig.knightmetal_seeds);
	public static final List<Block> Nether = getBlocksFromConfig(ModConfig.nether_seeds);
	public static final List<Block> Octine = getBlocksFromConfig(ModConfig.octine_seeds);
	public static final List<Block> SlimyBone = getBlocksFromConfig(ModConfig.slimy_bone_seeds);
	public static final List<Block> StarSteel = getBlocksFromConfig(ModConfig.star_steel_seeds);
	public static final List<Block> Steeleaf = getBlocksFromConfig(ModConfig.steeleaf_seeds);
	public static final List<Block> Syrmorite = getBlocksFromConfig(ModConfig.syrmorite_seeds);
	public static final List<Block> Thaumium = getBlocksFromConfig(ModConfig.thaumium_seeds);
	public static final List<Block> Tritanium = getBlocksFromConfig(ModConfig.tritanium_seeds);
	public static final List<Block> Valonite = getBlocksFromConfig(ModConfig.valonite_seeds);
	public static final List<Block> VoidMetal = getBlocksFromConfig(ModConfig.void_metal_seeds);
	public static final List<Block> Ice = getBlocksFromConfig(ModConfig.ice_seeds);
	public static final List<Block> Amber = getBlocksFromConfig(ModConfig.amber_seeds);
	public static final List<Block> CertusQuartz = getBlocksFromConfig(ModConfig.certus_quartz_seeds);
	public static final List<Block> DarkGem = getBlocksFromConfig(ModConfig.dark_gem_seeds);
	public static final List<Block> Elementium = getBlocksFromConfig(ModConfig.elementium_seeds);
	public static final List<Block> EnderAmethyst = getBlocksFromConfig(ModConfig.ender_amethyst_seeds);
	public static final List<Block> EnderBiotite = getBlocksFromConfig(ModConfig.ender_biotite_seeds);
	public static final List<Block> Fluix = getBlocksFromConfig(ModConfig.fluix_seeds);
	public static final List<Block> IronWood = getBlocksFromConfig(ModConfig.ironwood_seeds);
	public static final List<Block> Malachite = getBlocksFromConfig(ModConfig.malachite_seeds);
	public static final List<Block> Manasteel = getBlocksFromConfig(ModConfig.manasteel_seeds);
	public static final List<Block> Menril = getBlocksFromConfig(ModConfig.menril_seeds);
	public static final List<Block> MeteoricIron = getBlocksFromConfig(ModConfig.meteoric_iron_seeds);
	public static final List<Block> QuartzEnrichedIron = getBlocksFromConfig(ModConfig.quartz_enriched_iron_seeds);
	public static final List<Block> RockCrystal = getBlocksFromConfig(ModConfig.rock_crystal_seeds);
	public static final List<Block> SkyStone = getBlocksFromConfig(ModConfig.sky_stone_seeds);
	public static final List<Block> Tanzanite = getBlocksFromConfig(ModConfig.tanzanite_seeds);
	public static final List<Block> Terrasteel = getBlocksFromConfig(ModConfig.terrasteel_seeds);
	public static final List<Block> Topaz = getBlocksFromConfig(ModConfig.topaz_seeds);
	public static final List<Block> BlueTopaz = getBlocksFromConfig(ModConfig.blue_topaz_seeds);
	public static final List<Block> Chimerite = getBlocksFromConfig(ModConfig.chimerite_seeds);
	public static final List<Block> Graphite = getBlocksFromConfig(ModConfig.graphite_seeds);
	public static final List<Block> Moonstone = getBlocksFromConfig(ModConfig.moonstone_seeds);
	public static final List<Block> Sunstone = getBlocksFromConfig(ModConfig.sunstone_seeds);
	public static final List<Block> Vinteum = getBlocksFromConfig(ModConfig.vinteum_seeds);
	public static final List<Block> Yellorium = getBlocksFromConfig(ModConfig.yellorium_seeds);
	public static final List<Block> MysticalFlower = getBlocksFromConfig(ModConfig.mystical_flower_seeds);
	public static final List<Block> Nature = getBlocksFromConfig(ModConfig.nature_seeds);
	public static final List<Block> Stone = getBlocksFromConfig(ModConfig.stone_seeds);
	public static final List<Block> Fire = getBlocksFromConfig(ModConfig.fire_seeds);
	public static final List<Block> Aquamarine = getBlocksFromConfig(ModConfig.aquamarine_seeds);
	public static final List<Block> Dilithium = getBlocksFromConfig(ModConfig.dilithium_seeds);
	public static final List<Block> IridiumOre = getBlocksFromConfig(ModConfig.iridium_ore_seeds);
	public static final List<Block> Rubber = getBlocksFromConfig(ModConfig.rubber_seeds);
	public static final List<Block> Starmetal = getBlocksFromConfig(ModConfig.starmetal_seeds);
	public static final List<Block> Uranium238 = getBlocksFromConfig(ModConfig.uranium_238_seeds);
	public static final List<Block> Quicksilver = getBlocksFromConfig(ModConfig.quicksilver_seeds);
	public static final List<Block> Dye = getBlocksFromConfig(ModConfig.dye_seeds);
	public static final List<Block> Netherstar = getBlocksFromConfig(ModConfig.nether_star_seeds);
	public static final List<Block> Awakened = getBlocksFromConfig(ModConfig.awakened_draconium_seeds);
	public static final List<Block> DragonEgg = getBlocksFromConfig(ModConfig.dragon_egg_seeds);
	public static final List<Block> Neutronium = getBlocksFromConfig(ModConfig.neutronium_seeds);
	public static final List<Block> Silicon = getBlocksFromConfig(ModConfig.silicon_seeds);
	public static final List<Block> Basalz = getBlocksFromConfig(ModConfig.basalz_seeds);
	public static final List<Block> Blaze = getBlocksFromConfig(ModConfig.blaze_seeds);
	public static final List<Block> Blitz = getBlocksFromConfig(ModConfig.blitz_seeds);
	public static final List<Block> Blizz = getBlocksFromConfig(ModConfig.blizz_seeds);
	public static final List<Block> Chicken = getBlocksFromConfig(ModConfig.chicken_seeds);
	public static final List<Block> Cow = getBlocksFromConfig(ModConfig.cow_seeds);
	public static final List<Block> Creeper = getBlocksFromConfig(ModConfig.creeper_seeds);
	public static final List<Block> Enderman = getBlocksFromConfig(ModConfig.enderman_seeds);
	public static final List<Block> Ghast = getBlocksFromConfig(ModConfig.ghast_seeds);
	public static final List<Block> Guardian = getBlocksFromConfig(ModConfig.guardian_seeds);
	public static final List<Block> Pig = getBlocksFromConfig(ModConfig.pig_seeds);
	public static final List<Block> Rabbit = getBlocksFromConfig(ModConfig.rabbit_seeds);
	public static final List<Block> Sheep = getBlocksFromConfig(ModConfig.sheep_seeds);
	public static final List<Block> Skeleton = getBlocksFromConfig(ModConfig.skeleton_seeds);
	public static final List<Block> Spider = getBlocksFromConfig(ModConfig.spider_seeds);
	public static final List<Block> WitherSkeleton = getBlocksFromConfig(ModConfig.wither_skeleton_seeds);
	public static final List<Block> Zombie = getBlocksFromConfig(ModConfig.zombie_seeds);
	
	public static List<Block> getBlocksFromConfig(String config) {
		List<Block> allBlocks = new ArrayList<Block>();
		String[] blockList = config.split(";");
		if(!(blockList.length <= 0)) {
			for(String block : blockList) {
				if(block.startsWith("ore:")) {
					//nothing
				} else if(block.startsWith("entity")) {
					//nothing
				} else {
					String[] split = block.split(":");
					if(split.length > 2) {
						ItemStack blockA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]), 1, Integer.parseInt(split[2]));
						if(blockA.getItem() == Items.AIR) {
							Block blockB = Block.getBlockFromName(split[0] + ":" + split[1]);
							if(blockB != null) {
								allBlocks.add(blockB);
							}
						}
					} else if(split.length == 2){
						ItemStack blockA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]));
						if(blockA.getItem() == Items.AIR) {
							Block blockB = Block.getBlockFromName(split[0] + ":" + split[1]);
							if(blockB != null) {
								allBlocks.add(blockB);
							}
						}
					}
				}
			}
		}
		return allBlocks;
	}
	
}
