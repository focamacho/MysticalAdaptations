package com.focamacho.mysticaladaptations.util;

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
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class BlockCheck {
	
	public static final List<ItemStack> Water = getBlockConfig(ModConfig.water_seeds);
	public static final List<ItemStack> Wood = getBlockConfig(ModConfig.wood_seeds);
	public static final List<ItemStack> Copper = getBlockConfig(ModConfig.copper_seeds);
	public static final List<ItemStack> Tin = getBlockConfig(ModConfig.tin_seeds);
	public static final List<ItemStack> Platinum = getBlockConfig(ModConfig.platinum_seeds);
	public static final List<ItemStack> Alubrass = getBlockConfig(ModConfig.aluminum_brass_seeds);
	public static final List<ItemStack> Aluminum = getBlockConfig(ModConfig.aluminum_seeds);
	public static final List<ItemStack> Alumite = getBlockConfig(ModConfig.alumite_seeds);
	public static final List<ItemStack> Ardite = getBlockConfig(ModConfig.ardite_seeds);
	public static final List<ItemStack> QuartzBlack = getBlockConfig(ModConfig.black_quartz_seeds);
	public static final List<ItemStack> Boron = getBlockConfig(ModConfig.boron_seeds);
	public static final List<ItemStack> Brass = getBlockConfig(ModConfig.brass_seeds);
	public static final List<ItemStack> Bronze = getBlockConfig(ModConfig.bronze_seeds);
	public static final List<ItemStack> Chrome = getBlockConfig(ModConfig.chrome_seeds);
	public static final List<ItemStack> Coal = getBlockConfig(ModConfig.coal_seeds);
	public static final List<ItemStack> Cobalt = getBlockConfig(ModConfig.cobalt_seeds);
	public static final List<ItemStack> ConductiveIron = getBlockConfig(ModConfig.conductive_iron_seeds);
	public static final List<ItemStack> Constantan = getBlockConfig(ModConfig.constantan_seeds);
	public static final List<ItemStack> DarkSteel = getBlockConfig(ModConfig.dark_steel_seeds);
	public static final List<ItemStack> Diamond = getBlockConfig(ModConfig.diamond_seeds);
	public static final List<ItemStack> Draconium = getBlockConfig(ModConfig.draconium_seeds);
	public static final List<ItemStack> Dirt = getBlockConfig(ModConfig.dirt_seeds);
	public static final List<ItemStack> ElectricalSteel = getBlockConfig(ModConfig.electrical_steel_seeds);
	public static final List<ItemStack> Electrum = getBlockConfig(ModConfig.electrum_seeds);
	public static final List<ItemStack> Emerald = getBlockConfig(ModConfig.emerald_seeds);
	public static final List<ItemStack> EndSteel = getBlockConfig(ModConfig.end_steel_seeds);
	public static final List<ItemStack> Enderium = getBlockConfig(ModConfig.enderium_seeds);
	public static final List<ItemStack> EnergeticAlloy = getBlockConfig(ModConfig.energetic_alloy_seeds);
	public static final List<ItemStack> RefinedGlowstone = getBlockConfig(ModConfig.glowstone_ingot_seeds);
	public static final List<ItemStack> Glowstone = getBlockConfig(ModConfig.glowstone_seeds);
	public static final List<ItemStack> Gold = getBlockConfig(ModConfig.gold_seeds);
	public static final List<ItemStack> InfinityDust = getBlockConfig(ModConfig.grains_of_infinity_seeds);
	public static final List<ItemStack> Invar = getBlockConfig(ModConfig.invar_seeds);
	public static final List<ItemStack> Iridium = getBlockConfig(ModConfig.iridium_seeds);
	public static final List<ItemStack> Iron = getBlockConfig(ModConfig.iron_seeds);
	public static final List<ItemStack> Knightslime = getBlockConfig(ModConfig.knightslime_seeds);
	public static final List<ItemStack> Lapis = getBlockConfig(ModConfig.lapis_lazuli_seeds);
	public static final List<ItemStack> Lead = getBlockConfig(ModConfig.lead_seeds);
	public static final List<ItemStack> Limestone = getBlockConfig(ModConfig.limestone_seeds);
	public static final List<ItemStack> Lithium = getBlockConfig(ModConfig.lithium_seeds);
	public static final List<ItemStack> Lumium = getBlockConfig(ModConfig.lumium_seeds);
	public static final List<ItemStack> Magnesium = getBlockConfig(ModConfig.magnesium_seeds);
	public static final List<ItemStack> Manyullyn = getBlockConfig(ModConfig.manyullyn_seeds);
	public static final List<ItemStack> Marble = getBlockConfig(ModConfig.marble_seeds);
	public static final List<ItemStack> Mithril = getBlockConfig(ModConfig.mithril_seeds);
	public static final List<ItemStack> Quartz = getBlockConfig(ModConfig.nether_quartz_seeds);
	public static final List<ItemStack> Nickel = getBlockConfig(ModConfig.nickel_seeds);
	public static final List<ItemStack> Obsidian = getBlockConfig(ModConfig.obsidian_seeds);
	public static final List<ItemStack> Osmium = getBlockConfig(ModConfig.osmium_seeds);
	public static final List<ItemStack> Peridot = getBlockConfig(ModConfig.peridot_seeds);
	public static final List<ItemStack> PulsatingIron = getBlockConfig(ModConfig.pulsating_iron_seeds);
	public static final List<ItemStack> RedstoneAlloy = getBlockConfig(ModConfig.redstone_alloy_seeds);
	public static final List<ItemStack> Redstone = getBlockConfig(ModConfig.redstone_seeds);
	public static final List<ItemStack> RefinedObsidian = getBlockConfig(ModConfig.refined_obsidian_seeds);
	public static final List<ItemStack> Ruby = getBlockConfig(ModConfig.ruby_seeds);
	public static final List<ItemStack> Sapphire = getBlockConfig(ModConfig.sapphire_seeds);
	public static final List<ItemStack> Signalum = getBlockConfig(ModConfig.signalum_seeds);
	public static final List<ItemStack> Silver = getBlockConfig(ModConfig.silver_seeds);
	public static final List<ItemStack> Slate = getBlockConfig(ModConfig.slate_seeds);
	public static final List<ItemStack> Slime = getBlockConfig(ModConfig.slime_seeds);
	public static final List<ItemStack> Soularium = getBlockConfig(ModConfig.soularium_seeds);
	public static final List<ItemStack> Steel = getBlockConfig(ModConfig.steel_seeds);
	public static final List<ItemStack> Thorium = getBlockConfig(ModConfig.thorium_seeds);
	public static final List<ItemStack> Titanium = getBlockConfig(ModConfig.titanium_seeds);
	public static final List<ItemStack> Tungsten = getBlockConfig(ModConfig.tungsten_seeds);
	public static final List<ItemStack> Uranium = getBlockConfig(ModConfig.uranium_seeds);
	public static final List<ItemStack> VibrantAlloy = getBlockConfig(ModConfig.vibrant_alloy_seeds);
	public static final List<ItemStack> Zinc = getBlockConfig(ModConfig.zinc_seeds);
	public static final List<ItemStack> Abyssalnite = getBlockConfig(ModConfig.abyssalnite_seeds);
	public static final List<ItemStack> Adamantine = getBlockConfig(ModConfig.adamantine_seeds);
	public static final List<ItemStack> Apatite = getBlockConfig(ModConfig.apatite_seeds);
	public static final List<ItemStack> Aquarium = getBlockConfig(ModConfig.aquarium_seeds);
	public static final List<ItemStack> Basalt = getBlockConfig(ModConfig.basalt_seeds);
	public static final List<ItemStack> ColdIron = getBlockConfig(ModConfig.cold_iron_seeds);
	public static final List<ItemStack> CompressedIron = getBlockConfig(ModConfig.compressed_iron_seeds);
	public static final List<ItemStack> Coralium = getBlockConfig(ModConfig.coralium_seeds);
	public static final List<ItemStack> Dawstone = getBlockConfig(ModConfig.dawnstone_seeds);
	public static final List<ItemStack> Desh = getBlockConfig(ModConfig.desh_seeds);
	public static final List<ItemStack> Dreadium = getBlockConfig(ModConfig.dreadium_seeds);
	public static final List<ItemStack> End = getBlockConfig(ModConfig.end_seeds);
	public static final List<ItemStack> Fiery = getBlockConfig(ModConfig.fiery_ingot_seeds);
	public static final List<ItemStack> FluxedElectrum = getBlockConfig(ModConfig.fluxed_electrum_seeds);
	public static final List<ItemStack> Jade = getBlockConfig(ModConfig.jade_seeds);
	public static final List<ItemStack> Knightmetal = getBlockConfig(ModConfig.knightmetal_seeds);
	public static final List<ItemStack> Nether = getBlockConfig(ModConfig.nether_seeds);
	public static final List<ItemStack> Octine = getBlockConfig(ModConfig.octine_seeds);
	public static final List<ItemStack> SlimyBone = getBlockConfig(ModConfig.slimy_bone_seeds);
	public static final List<ItemStack> StarSteel = getBlockConfig(ModConfig.star_steel_seeds);
	public static final List<ItemStack> Steeleaf = getBlockConfig(ModConfig.steeleaf_seeds);
	public static final List<ItemStack> Syrmorite = getBlockConfig(ModConfig.syrmorite_seeds);
	public static final List<ItemStack> Thaumium = getBlockConfig(ModConfig.thaumium_seeds);
	public static final List<ItemStack> Tritanium = getBlockConfig(ModConfig.tritanium_seeds);
	public static final List<ItemStack> Valonite = getBlockConfig(ModConfig.valonite_seeds);
	public static final List<ItemStack> VoidMetal = getBlockConfig(ModConfig.void_metal_seeds);
	public static final List<ItemStack> Ice =  getBlockConfig(ModConfig.ice_seeds);
	public static final List<ItemStack> Amber = getBlockConfig(ModConfig.amber_seeds);
	public static final List<ItemStack> CertusQuartz = getBlockConfig(ModConfig.certus_quartz_seeds);
	public static final List<ItemStack> DarkGem = getBlockConfig(ModConfig.dark_gem_seeds);
	public static final List<ItemStack> Elementium = getBlockConfig(ModConfig.elementium_seeds);
	public static final List<ItemStack> EnderAmethyst = getBlockConfig(ModConfig.ender_amethyst_seeds);
	public static final List<ItemStack> EnderBiotite = getBlockConfig(ModConfig.ender_biotite_seeds);
	public static final List<ItemStack> Fluix = getBlockConfig(ModConfig.fluix_seeds);
	public static final List<ItemStack> IronWood = getBlockConfig(ModConfig.ironwood_seeds);
	public static final List<ItemStack> Malachite = getBlockConfig(ModConfig.malachite_seeds);
	public static final List<ItemStack> Manasteel = getBlockConfig(ModConfig.manasteel_seeds);
	public static final List<ItemStack> Menril = getBlockConfig(ModConfig.menril_seeds);
	public static final List<ItemStack> MeteoricIron = getBlockConfig(ModConfig.meteoric_iron_seeds);
	public static final List<ItemStack> QuartzEnrichedIron = getBlockConfig(ModConfig.quartz_enriched_iron_seeds);
	public static final List<ItemStack> RockCrystal = getBlockConfig(ModConfig.rock_crystal_seeds);
	public static final List<ItemStack> SkyStone = getBlockConfig(ModConfig.sky_stone_seeds);
	public static final List<ItemStack> Tanzanite = getBlockConfig(ModConfig.tanzanite_seeds);
	public static final List<ItemStack> Terrasteel = getBlockConfig(ModConfig.terrasteel_seeds);
	public static final List<ItemStack> Topaz = getBlockConfig(ModConfig.topaz_seeds);
	public static final List<ItemStack> BlueTopaz = getBlockConfig(ModConfig.blue_topaz_seeds);
	public static final List<ItemStack> Chimerite = getBlockConfig(ModConfig.chimerite_seeds);
	public static final List<ItemStack> Graphite = getBlockConfig(ModConfig.graphite_seeds);
	public static final List<ItemStack> Moonstone = getBlockConfig(ModConfig.moonstone_seeds);
	public static final List<ItemStack> Sunstone = getBlockConfig(ModConfig.sunstone_seeds);
	public static final List<ItemStack> Vinteum = getBlockConfig(ModConfig.vinteum_seeds);
	public static final List<ItemStack> Yellorium = getBlockConfig(ModConfig.yellorium_seeds);
	public static final List<ItemStack> MysticalFlower = getBlockConfig(ModConfig.mystical_flower_seeds);
	public static final List<ItemStack> Nature = getBlockConfig(ModConfig.nature_seeds);
	public static final List<ItemStack> Stone = getBlockConfig(ModConfig.stone_seeds);
	public static final List<ItemStack> Fire = getBlockConfig(ModConfig.fire_seeds);
	public static final List<ItemStack> Aquamarine = getBlockConfig(ModConfig.aquamarine_seeds);
	public static final List<ItemStack> Dilithium = getBlockConfig(ModConfig.dilithium_seeds);
	public static final List<ItemStack> IridiumOre = getBlockConfig(ModConfig.iridium_ore_seeds);
	public static final List<ItemStack> Rubber = getBlockConfig(ModConfig.rubber_seeds);
	public static final List<ItemStack> Starmetal = getBlockConfig(ModConfig.starmetal_seeds);
	public static final List<ItemStack> Uranium238 = getBlockConfig(ModConfig.uranium_238_seeds);
	public static final List<ItemStack> Quicksilver = getBlockConfig(ModConfig.quicksilver_seeds);
	public static final List<ItemStack> Dye = getBlockConfig(ModConfig.dye_seeds);
	public static final List<ItemStack> Netherstar = getBlockConfig(ModConfig.nether_star_seeds);
	public static final List<ItemStack> Awakened = getBlockConfig(ModConfig.awakened_draconium_seeds);
	public static final List<ItemStack> DragonEgg = getBlockConfig(ModConfig.dragon_egg_seeds);
	public static final List<ItemStack> Neutronium = getBlockConfig(ModConfig.neutronium_seeds);
	public static final List<ItemStack> Silicon = getBlockConfig(ModConfig.silicon_seeds);
	public static final List<Block> WaterBlock = getBlockConfig2(ModConfig.water_seeds);
	public static final List<Block> WoodBlock = getBlockConfig2(ModConfig.wood_seeds);
	public static final List<Block> CopperBlock = getBlockConfig2(ModConfig.copper_seeds);
	public static final List<Block> TinBlock = getBlockConfig2(ModConfig.tin_seeds);
	public static final List<Block> PlatinumBlock = getBlockConfig2(ModConfig.platinum_seeds);
	public static final List<Block> AlubrassBlock = getBlockConfig2(ModConfig.aluminum_brass_seeds);
	public static final List<Block> AluminumBlock = getBlockConfig2(ModConfig.aluminum_seeds);
	public static final List<Block> AlumiteBlock = getBlockConfig2(ModConfig.alumite_seeds);
	public static final List<Block> ArditeBlock = getBlockConfig2(ModConfig.ardite_seeds);
	public static final List<Block> QuartzBlackBlock = getBlockConfig2(ModConfig.black_quartz_seeds);
	public static final List<Block> BoronBlock = getBlockConfig2(ModConfig.boron_seeds);
	public static final List<Block> BrassBlock = getBlockConfig2(ModConfig.brass_seeds);
	public static final List<Block> BronzeBlock = getBlockConfig2(ModConfig.bronze_seeds);
	public static final List<Block> ChromeBlock = getBlockConfig2(ModConfig.chrome_seeds);
	public static final List<Block> CoalBlock = getBlockConfig2(ModConfig.coal_seeds);
	public static final List<Block> CobaltBlock = getBlockConfig2(ModConfig.cobalt_seeds);
	public static final List<Block> ConductiveIronBlock = getBlockConfig2(ModConfig.conductive_iron_seeds);
	public static final List<Block> ConstantanBlock = getBlockConfig2(ModConfig.constantan_seeds);
	public static final List<Block> DarkSteelBlock = getBlockConfig2(ModConfig.dark_steel_seeds);
	public static final List<Block> DiamondBlock = getBlockConfig2(ModConfig.diamond_seeds);
	public static final List<Block> DraconiumBlock = getBlockConfig2(ModConfig.draconium_seeds);
	public static final List<Block> DirtBlock = getBlockConfig2(ModConfig.dirt_seeds);
	public static final List<Block> ElectricalSteelBlock = getBlockConfig2(ModConfig.electrical_steel_seeds);
	public static final List<Block> ElectrumBlock = getBlockConfig2(ModConfig.electrum_seeds);
	public static final List<Block> EmeraldBlock = getBlockConfig2(ModConfig.emerald_seeds);
	public static final List<Block> EndSteelBlock = getBlockConfig2(ModConfig.end_steel_seeds);
	public static final List<Block> EnderiumBlock = getBlockConfig2(ModConfig.enderium_seeds);
	public static final List<Block> EnergeticAlloyBlock = getBlockConfig2(ModConfig.energetic_alloy_seeds);
	public static final List<Block> RefinedGlowstoneBlock = getBlockConfig2(ModConfig.glowstone_ingot_seeds);
	public static final List<Block> GlowstoneBlock = getBlockConfig2(ModConfig.glowstone_seeds);
	public static final List<Block> GoldBlock = getBlockConfig2(ModConfig.gold_seeds);
	public static final List<Block> InfinityDustBlock = getBlockConfig2(ModConfig.grains_of_infinity_seeds);
	public static final List<Block> InvarBlock = getBlockConfig2(ModConfig.invar_seeds);
	public static final List<Block> IridiumBlock = getBlockConfig2(ModConfig.iridium_seeds);
	public static final List<Block> IronBlock = getBlockConfig2(ModConfig.iron_seeds);
	public static final List<Block> KnightslimeBlock = getBlockConfig2(ModConfig.knightslime_seeds);
	public static final List<Block> LapisBlock = getBlockConfig2(ModConfig.lapis_lazuli_seeds);
	public static final List<Block> LeadBlock = getBlockConfig2(ModConfig.lead_seeds);
	public static final List<Block> LimestoneBlock = getBlockConfig2(ModConfig.limestone_seeds);
	public static final List<Block> LithiumBlock = getBlockConfig2(ModConfig.lithium_seeds);
	public static final List<Block> LumiumBlock = getBlockConfig2(ModConfig.lumium_seeds);
	public static final List<Block> MagnesiumBlock = getBlockConfig2(ModConfig.magnesium_seeds);
	public static final List<Block> ManyullynBlock = getBlockConfig2(ModConfig.manyullyn_seeds);
	public static final List<Block> MarbleBlock = getBlockConfig2(ModConfig.marble_seeds);
	public static final List<Block> MithrilBlock = getBlockConfig2(ModConfig.mithril_seeds);
	public static final List<Block> QuartzBlock = getBlockConfig2(ModConfig.nether_quartz_seeds);
	public static final List<Block> NickelBlock = getBlockConfig2(ModConfig.nickel_seeds);
	public static final List<Block> ObsidianBlock = getBlockConfig2(ModConfig.obsidian_seeds);
	public static final List<Block> OsmiumBlock = getBlockConfig2(ModConfig.osmium_seeds);
	public static final List<Block> PeridotBlock = getBlockConfig2(ModConfig.peridot_seeds);
	public static final List<Block> PulsatingIronBlock = getBlockConfig2(ModConfig.pulsating_iron_seeds);
	public static final List<Block> RedstoneAlloyBlock = getBlockConfig2(ModConfig.redstone_alloy_seeds);
	public static final List<Block> RedstoneBlock = getBlockConfig2(ModConfig.redstone_seeds);
	public static final List<Block> RefinedObsidianBlock = getBlockConfig2(ModConfig.refined_obsidian_seeds);
	public static final List<Block> RubyBlock = getBlockConfig2(ModConfig.ruby_seeds);
	public static final List<Block> SapphireBlock = getBlockConfig2(ModConfig.sapphire_seeds);
	public static final List<Block> SignalumBlock = getBlockConfig2(ModConfig.signalum_seeds);
	public static final List<Block> SilverBlock = getBlockConfig2(ModConfig.silver_seeds);
	public static final List<Block> SlateBlock = getBlockConfig2(ModConfig.slate_seeds);
	public static final List<Block> SlimeBlock = getBlockConfig2(ModConfig.slime_seeds);
	public static final List<Block> SoulariumBlock = getBlockConfig2(ModConfig.soularium_seeds);
	public static final List<Block> SteelBlock = getBlockConfig2(ModConfig.steel_seeds);
	public static final List<Block> ThoriumBlock = getBlockConfig2(ModConfig.thorium_seeds);
	public static final List<Block> TitaniumBlock = getBlockConfig2(ModConfig.titanium_seeds);
	public static final List<Block> TungstenBlock = getBlockConfig2(ModConfig.tungsten_seeds);
	public static final List<Block> UraniumBlock = getBlockConfig2(ModConfig.uranium_seeds);
	public static final List<Block> VibrantAlloyBlock = getBlockConfig2(ModConfig.vibrant_alloy_seeds);
	public static final List<Block> ZincBlock = getBlockConfig2(ModConfig.zinc_seeds);
	public static final List<Block> AbyssalniteBlock = getBlockConfig2(ModConfig.abyssalnite_seeds);
	public static final List<Block> AdamantineBlock = getBlockConfig2(ModConfig.adamantine_seeds);
	public static final List<Block> ApatiteBlock = getBlockConfig2(ModConfig.apatite_seeds);
	public static final List<Block> AquariumBlock = getBlockConfig2(ModConfig.aquarium_seeds);
	public static final List<Block> BasaltBlock = getBlockConfig2(ModConfig.basalt_seeds);
	public static final List<Block> ColdIronBlock = getBlockConfig2(ModConfig.cold_iron_seeds);
	public static final List<Block> CompressedIronBlock = getBlockConfig2(ModConfig.compressed_iron_seeds);
	public static final List<Block> CoraliumBlock = getBlockConfig2(ModConfig.coralium_seeds);
	public static final List<Block> DawstoneBlock = getBlockConfig2(ModConfig.dawnstone_seeds);
	public static final List<Block> DeshBlock = getBlockConfig2(ModConfig.desh_seeds);
	public static final List<Block> DreadiumBlock = getBlockConfig2(ModConfig.dreadium_seeds);
	public static final List<Block> EndBlock = getBlockConfig2(ModConfig.end_seeds);
	public static final List<Block> FieryBlock = getBlockConfig2(ModConfig.fiery_ingot_seeds);
	public static final List<Block> FluxedElectrumBlock = getBlockConfig2(ModConfig.fluxed_electrum_seeds);
	public static final List<Block> JadeBlock = getBlockConfig2(ModConfig.jade_seeds);
	public static final List<Block> KnightmetalBlock = getBlockConfig2(ModConfig.knightmetal_seeds);
	public static final List<Block> NetherBlock = getBlockConfig2(ModConfig.nether_seeds);
	public static final List<Block> OctineBlock = getBlockConfig2(ModConfig.octine_seeds);
	public static final List<Block> SlimyBoneBlock = getBlockConfig2(ModConfig.slimy_bone_seeds);
	public static final List<Block> StarSteelBlock = getBlockConfig2(ModConfig.star_steel_seeds);
	public static final List<Block> SteeleafBlock = getBlockConfig2(ModConfig.steeleaf_seeds);
	public static final List<Block> SyrmoriteBlock = getBlockConfig2(ModConfig.syrmorite_seeds);
	public static final List<Block> ThaumiumBlock = getBlockConfig2(ModConfig.thaumium_seeds);
	public static final List<Block> TritaniumBlock = getBlockConfig2(ModConfig.tritanium_seeds);
	public static final List<Block> ValoniteBlock = getBlockConfig2(ModConfig.valonite_seeds);
	public static final List<Block> VoidMetalBlock = getBlockConfig2(ModConfig.void_metal_seeds);
	public static final List<Block> IceBlock = getBlockConfig2(ModConfig.ice_seeds);
	public static final List<Block> AmberBlock = getBlockConfig2(ModConfig.amber_seeds);
	public static final List<Block> CertusQuartzBlock = getBlockConfig2(ModConfig.certus_quartz_seeds);
	public static final List<Block> DarkGemBlock = getBlockConfig2(ModConfig.dark_gem_seeds);
	public static final List<Block> ElementiumBlock = getBlockConfig2(ModConfig.elementium_seeds);
	public static final List<Block> EnderAmethystBlock = getBlockConfig2(ModConfig.ender_amethyst_seeds);
	public static final List<Block> EnderBiotiteBlock = getBlockConfig2(ModConfig.ender_biotite_seeds);
	public static final List<Block> FluixBlock = getBlockConfig2(ModConfig.fluix_seeds);
	public static final List<Block> IronWoodBlock = getBlockConfig2(ModConfig.ironwood_seeds);
	public static final List<Block> MalachiteBlock = getBlockConfig2(ModConfig.malachite_seeds);
	public static final List<Block> ManasteelBlock = getBlockConfig2(ModConfig.manasteel_seeds);
	public static final List<Block> MenrilBlock = getBlockConfig2(ModConfig.menril_seeds);
	public static final List<Block> MeteoricIronBlock = getBlockConfig2(ModConfig.meteoric_iron_seeds);
	public static final List<Block> QuartzEnrichedIronBlock = getBlockConfig2(ModConfig.quartz_enriched_iron_seeds);
	public static final List<Block> RockCrystalBlock = getBlockConfig2(ModConfig.rock_crystal_seeds);
	public static final List<Block> SkyStoneBlock = getBlockConfig2(ModConfig.sky_stone_seeds);
	public static final List<Block> TanzaniteBlock = getBlockConfig2(ModConfig.tanzanite_seeds);
	public static final List<Block> TerrasteelBlock = getBlockConfig2(ModConfig.terrasteel_seeds);
	public static final List<Block> TopazBlock = getBlockConfig2(ModConfig.topaz_seeds);
	public static final List<Block> BlueTopazBlock = getBlockConfig2(ModConfig.blue_topaz_seeds);
	public static final List<Block> ChimeriteBlock = getBlockConfig2(ModConfig.chimerite_seeds);
	public static final List<Block> GraphiteBlock = getBlockConfig2(ModConfig.graphite_seeds);
	public static final List<Block> MoonstoneBlock = getBlockConfig2(ModConfig.moonstone_seeds);
	public static final List<Block> SunstoneBlock = getBlockConfig2(ModConfig.sunstone_seeds);
	public static final List<Block> VinteumBlock = getBlockConfig2(ModConfig.vinteum_seeds);
	public static final List<Block> YelloriumBlock = getBlockConfig2(ModConfig.yellorium_seeds);
	public static final List<Block> MysticalFlowerBlock = getBlockConfig2(ModConfig.mystical_flower_seeds);
	public static final List<Block> NatureBlock = getBlockConfig2(ModConfig.nature_seeds);
	public static final List<Block> StoneBlock = getBlockConfig2(ModConfig.stone_seeds);
	public static final List<Block> FireBlock = getBlockConfig2(ModConfig.fire_seeds);
	public static final List<Block> AquamarineBlock = getBlockConfig2(ModConfig.aquamarine_seeds);
	public static final List<Block> DilithiumBlock = getBlockConfig2(ModConfig.dilithium_seeds);
	public static final List<Block> IridiumOreBlock = getBlockConfig2(ModConfig.iridium_ore_seeds);
	public static final List<Block> RubberBlock = getBlockConfig2(ModConfig.rubber_seeds);
	public static final List<Block> StarmetalBlock = getBlockConfig2(ModConfig.starmetal_seeds);
	public static final List<Block> Uranium238Block = getBlockConfig2(ModConfig.uranium_238_seeds);
	public static final List<Block> QuicksilverBlock = getBlockConfig2(ModConfig.quicksilver_seeds);
	public static final List<Block> DyeBlock = getBlockConfig2(ModConfig.dye_seeds);
	public static final List<Block> NetherstarBlock = getBlockConfig2(ModConfig.nether_star_seeds);
	public static final List<Block> AwakenedBlock = getBlockConfig2(ModConfig.awakened_draconium_seeds);
	public static final List<Block> DragonEggBlock = getBlockConfig2(ModConfig.dragon_egg_seeds);
	public static final List<Block> NeutroniumBlock = getBlockConfig2(ModConfig.neutronium_seeds);
	public static final List<Block> SiliconBlock = getBlockConfig2(ModConfig.silicon_seeds);
	
	public static List<ItemStack> getBlockConfig(String config) {
		List<ItemStack> allBlocks = new ArrayList<ItemStack>();
		String[] blockList = config.split(";");
		if(!(blockList.length <= 0)) {
			for(String block : blockList) {
				if(block.startsWith("ore:")) {
					String[] split = block.split(":");
					allBlocks.addAll(getBlockListFromOredict(split[1]));
				} else {
					String[] split = block.split(":");
					if(split.length > 2) {
						ItemStack blockA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]), 1, Integer.parseInt(split[2]));
						if(!(blockA.getItem() == Items.AIR)) {
							allBlocks.add(blockA);
						}
					} else if(split.length == 2){
						ItemStack blockA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]));
						if(!(blockA.getItem() == Items.AIR)) {
							allBlocks.add(blockA);
						}
					}
				}
			}
		}
		System.out.println("Registrado todos esses itens: " + allBlocks);
		return allBlocks;
	}
	
	public static List<Block> getBlockConfig2(String config) {
		List<Block> allBlocks = new ArrayList<Block>();
		String[] blockList = config.split(";");
		if(!(blockList.length <= 0)) {
			for(String block : blockList) {
				if(block.startsWith("ore:")) {
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
		System.out.println("Registrado todos esses blocos: " + allBlocks);
		return allBlocks;
	}
	
	public static List<ItemStack> getBlockListFromOredict(String ore) {
		List<ItemStack> oreItems = OreDictionary.getOres(ore);
		return oreItems;
	}
	
	public static ItemStack getSeedFromBlock(ItemStack extractor, ItemStack blockItem, Block block) {
		if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Dirt, BlockCheck.DirtBlock, Type.DIRT)) return returnSeedItem(Type.DIRT);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Rubber, BlockCheck.RubberBlock, Type.RUBBER)) return returnSeedItem(Type.RUBBER);
	    else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Wood, BlockCheck.WoodBlock, Type.WOOD)) return returnSeedItem(Type.WOOD);
	    else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Stone, BlockCheck.StoneBlock, Type.STONE)) return returnSeedItem(Type.STONE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Nature, BlockCheck.NatureBlock,  Type.NATURE)) return returnSeedItem(Type.NATURE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Copper, BlockCheck.CopperBlock, Type.COPPER)) return returnSeedItem(Type.COPPER);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Tin, BlockCheck.TinBlock, Type.TIN)) return returnSeedItem(Type.TIN);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Platinum, BlockCheck.PlatinumBlock, Type.PLATINUM)) return returnSeedItem(Type.PLATINUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Alubrass, BlockCheck.AlubrassBlock, Type.ALUMINUM_BRASS)) return returnSeedItem(Type.ALUMINUM_BRASS);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Aluminum, BlockCheck.AluminumBlock, Type.ALUMINUM)) return returnSeedItem(Type.ALUMINUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Alumite, BlockCheck.AlumiteBlock, Type.ALUMITE)) return returnSeedItem(Type.ALUMITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Ardite, BlockCheck.ArditeBlock, Type.ARDITE)) return returnSeedItem(Type.ARDITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.QuartzBlack, BlockCheck.QuartzBlackBlock, Type.BLACK_QUARTZ)) return returnSeedItem(Type.BLACK_QUARTZ);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Boron, BlockCheck.BoronBlock, Type.BORON)) return returnSeedItem(Type.BORON);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Brass, BlockCheck.BrassBlock, Type.BRASS)) return returnSeedItem(Type.BRASS);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Bronze, BlockCheck.BronzeBlock, Type.BRONZE)) return returnSeedItem(Type.BRONZE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Chrome, BlockCheck.ChromeBlock, Type.CHROME)) return returnSeedItem(Type.CHROME);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Coal, BlockCheck.CoalBlock, Type.COAL)) return returnSeedItem(Type.COAL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Cobalt, BlockCheck.CobaltBlock, Type.COBALT)) return returnSeedItem(Type.COBALT);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.ConductiveIron, BlockCheck.ConductiveIronBlock, Type.CONDUCTIVE_IRON)) return returnSeedItem(Type.CONDUCTIVE_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Constantan, BlockCheck.ConstantanBlock, Type.CONSTANTAN)) return returnSeedItem(Type.CONSTANTAN);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.DarkSteel, BlockCheck.DarkSteelBlock, Type.DARK_STEEL)) return returnSeedItem(Type.DARK_STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Diamond, BlockCheck.DiamondBlock, Type.DIAMOND)) return returnSeedItem(Type.DIAMOND);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Draconium, BlockCheck.DraconiumBlock, Type.DRACONIUM)) return returnSeedItem(Type.DRACONIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Dye, BlockCheck.DyeBlock, Type.DYE)) return returnSeedItem(Type.DYE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.ElectricalSteel, BlockCheck.ElectricalSteelBlock, Type.ELECTRICAL_STEEL)) return returnSeedItem(Type.ELECTRICAL_STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Electrum, BlockCheck.ElectrumBlock, Type.ELECTRUM)) return returnSeedItem(Type.ELECTRUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Emerald, BlockCheck.EmeraldBlock, Type.EMERALD)) return returnSeedItem(Type.EMERALD);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.EndSteel, BlockCheck.EndSteelBlock, Type.END_STEEL)) return returnSeedItem(Type.END_STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Enderium, BlockCheck.EnderiumBlock, Type.ENDERIUM)) return returnSeedItem(Type.ENDERIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.EnergeticAlloy, BlockCheck.EnergeticAlloyBlock, Type.ENERGETIC_ALLOY)) return returnSeedItem(Type.ENERGETIC_ALLOY);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.RefinedGlowstone, BlockCheck.RefinedGlowstoneBlock, Type.GLOWSTONE_INGOT)) return returnSeedItem(Type.GLOWSTONE_INGOT);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Glowstone, BlockCheck.GlowstoneBlock, Type.GLOWSTONE)) return returnSeedItem(Type.GLOWSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Gold, BlockCheck.GoldBlock, Type.GOLD)) return returnSeedItem(Type.GOLD);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.InfinityDust, BlockCheck.InfinityDustBlock, Type.GRAINS_OF_INFINITY)) return returnSeedItem(Type.GRAINS_OF_INFINITY);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Ice, BlockCheck.IceBlock, Type.ICE)) return returnSeedItem(Type.ICE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Invar, BlockCheck.InvarBlock, Type.INVAR)) return returnSeedItem(Type.INVAR);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Iridium, BlockCheck.IridiumBlock, Type.IRIDIUM)) return returnSeedItem(Type.IRIDIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Iron, BlockCheck.IronBlock, Type.IRON)) return returnSeedItem(Type.IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Knightslime, BlockCheck.KnightslimeBlock, Type.KNIGHTSLIME)) return returnSeedItem(Type.KNIGHTSLIME);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Lapis, BlockCheck.LapisBlock, Type.LAPIS_LAZULI)) return returnSeedItem(Type.LAPIS_LAZULI);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Lead, BlockCheck.LeadBlock, Type.LEAD)) return returnSeedItem(Type.LEAD);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Limestone, BlockCheck.LimestoneBlock, Type.LIMESTONE)) return returnSeedItem(Type.LIMESTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Lithium, BlockCheck.LithiumBlock, Type.LITHIUM)) return returnSeedItem(Type.LITHIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Lumium, BlockCheck.LumiumBlock, Type.LUMIUM)) return returnSeedItem(Type.LUMIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Magnesium, BlockCheck.MagnesiumBlock, Type.MAGNESIUM)) return returnSeedItem(Type.MAGNESIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Manyullyn, BlockCheck.ManyullynBlock, Type.MANYULLYN)) return returnSeedItem(Type.MANYULLYN);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Marble, BlockCheck.MarbleBlock, Type.MARBLE)) return returnSeedItem(Type.MARBLE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Mithril, BlockCheck.MithrilBlock, Type.MITHRIL)) return returnSeedItem(Type.MITHRIL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Quartz, BlockCheck.QuartzBlock, Type.NETHER_QUARTZ)) return returnSeedItem(Type.NETHER_QUARTZ);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Nickel, BlockCheck.NickelBlock, Type.NICKEL)) return returnSeedItem(Type.NICKEL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Obsidian, BlockCheck.ObsidianBlock, Type.OBSIDIAN)) return returnSeedItem(Type.OBSIDIAN);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Osmium, BlockCheck.OsmiumBlock, Type.OSMIUM)) return returnSeedItem(Type.OSMIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Peridot, BlockCheck.PeridotBlock, Type.PERIDOT)) return returnSeedItem(Type.PERIDOT);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.PulsatingIron, BlockCheck.PulsatingIronBlock, Type.PULSATING_IRON)) return returnSeedItem(Type.PULSATING_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.RedstoneAlloy, BlockCheck.RedstoneAlloyBlock, Type.REDSTONE_ALLOY)) return returnSeedItem(Type.REDSTONE_ALLOY);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Redstone, BlockCheck.RedstoneBlock, Type.REDSTONE)) return returnSeedItem(Type.REDSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.RefinedObsidian, BlockCheck.RefinedObsidianBlock, Type.REFINED_OBSIDIAN)) return returnSeedItem(Type.REFINED_OBSIDIAN);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Ruby, BlockCheck.RubyBlock, Type.RUBY)) return returnSeedItem(Type.RUBY);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Sapphire, BlockCheck.SapphireBlock, Type.SAPPHIRE)) return returnSeedItem(Type.SAPPHIRE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Signalum, BlockCheck.SignalumBlock, Type.SIGNALUM)) return returnSeedItem(Type.SIGNALUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Silver, BlockCheck.SilverBlock, Type.SILVER)) return returnSeedItem(Type.SILVER);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Slate, BlockCheck.SlateBlock, Type.SLATE)) return returnSeedItem(Type.SLATE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Slime, BlockCheck.SlimeBlock, Type.SLIME)) return returnSeedItem(Type.SLIME);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Soularium, BlockCheck.SoulariumBlock, Type.SOULARIUM)) return returnSeedItem(Type.SOULARIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Steel, BlockCheck.SteelBlock, Type.STEEL)) return returnSeedItem(Type.STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Thorium, BlockCheck.ThoriumBlock, Type.THORIUM)) return returnSeedItem(Type.THORIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Titanium, BlockCheck.TitaniumBlock, Type.TITANIUM)) return returnSeedItem(Type.TITANIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Tungsten, BlockCheck.TungstenBlock, Type.TUNGSTEN)) return returnSeedItem(Type.TUNGSTEN);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Uranium, BlockCheck.UraniumBlock, Type.URANIUM)) return returnSeedItem(Type.URANIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.VibrantAlloy, BlockCheck.VibrantAlloyBlock, Type.VIBRANT_ALLOY)) return returnSeedItem(Type.VIBRANT_ALLOY);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Zinc, BlockCheck.ZincBlock, Type.ZINC)) return returnSeedItem(Type.ZINC);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Abyssalnite, BlockCheck.AbyssalniteBlock, Type.ABYSSALNITE)) return returnSeedItem(Type.ABYSSALNITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Adamantine, BlockCheck.AdamantineBlock, Type.ADAMANTINE)) return returnSeedItem(Type.ADAMANTINE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Apatite, BlockCheck.ApatiteBlock, Type.APATITE)) return returnSeedItem(Type.APATITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Aquarium, BlockCheck.AquariumBlock, Type.AQUARIUM)) return returnSeedItem(Type.AQUARIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Basalt, BlockCheck.BasaltBlock, Type.BASALT)) return returnSeedItem(Type.BASALT);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.ColdIron, BlockCheck.ColdIronBlock, Type.COLD_IRON)) return returnSeedItem(Type.COLD_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.CompressedIron, BlockCheck.CompressedIronBlock, Type.COMPRESSED_IRON)) return returnSeedItem(Type.COMPRESSED_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Coralium, BlockCheck.CoraliumBlock, Type.CORALIUM)) return returnSeedItem(Type.CORALIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Dawstone, BlockCheck.DawstoneBlock, Type.DAWNSTONE)) return returnSeedItem(Type.DAWNSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Desh, BlockCheck.DeshBlock, Type.DESH)) return returnSeedItem(Type.DESH);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Dreadium, BlockCheck.DreadiumBlock, Type.DREADIUM)) return returnSeedItem(Type.DREADIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.End, BlockCheck.EndBlock, Type.END)) return returnSeedItem(Type.END);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Fiery, BlockCheck.FieryBlock, Type.FIERY_INGOT)) return returnSeedItem(Type.FIERY_INGOT);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.FluxedElectrum, BlockCheck.FluxedElectrumBlock, Type.FLUXED_ELECTRUM)) return returnSeedItem(Type.FLUXED_ELECTRUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Jade, BlockCheck.JadeBlock, Type.JADE)) return returnSeedItem(Type.JADE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Knightmetal, BlockCheck.KnightmetalBlock, Type.KNIGHTMETAL)) return returnSeedItem(Type.KNIGHTMETAL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Nether, BlockCheck.NetherBlock, Type.NETHER)) return returnSeedItem(Type.NETHER);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Octine, BlockCheck.OctineBlock, Type.OCTINE)) return returnSeedItem(Type.OCTINE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.SlimyBone, BlockCheck.SlimyBoneBlock, Type.SLIMY_BONE)) return returnSeedItem(Type.SLIMY_BONE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.StarSteel, BlockCheck.StarSteelBlock, Type.STAR_STEEL)) return returnSeedItem(Type.STAR_STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Steeleaf, BlockCheck.SteeleafBlock, Type.STEELEAF)) return returnSeedItem(Type.STEELEAF);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Syrmorite, BlockCheck.SyrmoriteBlock, Type.SYRMORITE)) return returnSeedItem(Type.SYRMORITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Thaumium, BlockCheck.ThaumiumBlock, Type.THAUMIUM)) return returnSeedItem(Type.THAUMIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Tritanium, BlockCheck.TritaniumBlock, Type.TRITANIUM)) return returnSeedItem(Type.TRITANIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Valonite, BlockCheck.ValoniteBlock, Type.VALONITE)) return returnSeedItem(Type.VALONITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.VoidMetal, BlockCheck.VoidMetalBlock, Type.VOID_METAL)) return returnSeedItem(Type.VOID_METAL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Amber, BlockCheck.AmberBlock, Type.AMBER)) return returnSeedItem(Type.AMBER);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.CertusQuartz, BlockCheck.CertusQuartzBlock, Type.CERTUS_QUARTZ)) return returnSeedItem(Type.CERTUS_QUARTZ);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.DarkGem, BlockCheck.DarkGemBlock, Type.DARK_GEM)) return returnSeedItem(Type.DARK_GEM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Elementium, BlockCheck.ElementiumBlock, Type.ELEMENTIUM)) return returnSeedItem(Type.ELEMENTIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.EnderAmethyst, BlockCheck.EnderAmethystBlock, Type.ENDER_AMETHYST)) return returnSeedItem(Type.ENDER_AMETHYST);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.EnderBiotite, BlockCheck.EnderBiotiteBlock, Type.ENDER_BIOTITE)) return returnSeedItem(Type.ENDER_BIOTITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Fluix, BlockCheck.FluixBlock, Type.FLUIX)) return returnSeedItem(Type.FLUIX);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.IronWood, BlockCheck.IronWoodBlock, Type.IRONWOOD)) return returnSeedItem(Type.IRONWOOD);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Malachite, BlockCheck.MalachiteBlock, Type.MALACHITE)) return returnSeedItem(Type.MALACHITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Manasteel, BlockCheck.ManasteelBlock, Type.MANASTEEL)) return returnSeedItem(Type.MANASTEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Menril, BlockCheck.MenrilBlock, Type.MENRIL)) return returnSeedItem(Type.MENRIL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.MeteoricIron, BlockCheck.MeteoricIronBlock, Type.METEORIC_IRON)) return returnSeedItem(Type.METEORIC_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.QuartzEnrichedIron, BlockCheck.QuartzEnrichedIronBlock, Type.QUARTZ_ENRICHED_IRON)) return returnSeedItem(Type.QUARTZ_ENRICHED_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.RockCrystal, BlockCheck.RockCrystalBlock, Type.ROCK_CRYSTAL)) return returnSeedItem(Type.ROCK_CRYSTAL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.SkyStone, BlockCheck.SkyStoneBlock, Type.SKY_STONE)) return returnSeedItem(Type.SKY_STONE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Tanzanite, BlockCheck.TanzaniteBlock, Type.TANZANITE)) return returnSeedItem(Type.TANZANITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Terrasteel, BlockCheck.TerrasteelBlock, Type.TERRASTEEL)) return returnSeedItem(Type.TERRASTEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Topaz, BlockCheck.TopazBlock, Type.TOPAZ)) return returnSeedItem(Type.TOPAZ);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.BlueTopaz, BlockCheck.BlueTopazBlock, Type.BLUE_TOPAZ)) return returnSeedItem(Type.BLUE_TOPAZ);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Chimerite, BlockCheck.ChimeriteBlock, Type.CHIMERITE)) return returnSeedItem(Type.CHIMERITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Graphite, BlockCheck.GraphiteBlock, Type.GRAPHITE)) return returnSeedItem(Type.GRAPHITE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Moonstone, BlockCheck.MoonstoneBlock, Type.MOONSTONE)) return returnSeedItem(Type.MOONSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Sunstone, BlockCheck.SunstoneBlock, Type.SUNSTONE)) return returnSeedItem(Type.SUNSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Vinteum, BlockCheck.VinteumBlock, Type.VINTEUM)) return returnSeedItem(Type.VINTEUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Yellorium, BlockCheck.YelloriumBlock, Type.YELLORIUM)) return returnSeedItem(Type.YELLORIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.MysticalFlower, BlockCheck.MysticalFlowerBlock, Type.MYSTICAL_FLOWER)) return returnSeedItem(Type.MYSTICAL_FLOWER);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Water, BlockCheck.WaterBlock, Type.WATER)) return returnSeedItem(Type.WATER);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Fire, BlockCheck.FireBlock, Type.FIRE)) return returnSeedItem(Type.FIRE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Aquamarine, BlockCheck.AquamarineBlock, Type.AQUAMARINE)) return returnSeedItem(Type.AQUAMARINE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Dilithium, BlockCheck.DilithiumBlock, Type.DILITHIUM)) return returnSeedItem(Type.DILITHIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.IridiumOre, BlockCheck.IridiumOreBlock, Type.IRIDIUM_ORE)) return returnSeedItem(Type.IRIDIUM_ORE);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Starmetal, BlockCheck.StarmetalBlock, Type.STARMETAL)) return returnSeedItem(Type.STARMETAL);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Uranium238, BlockCheck.Uranium238Block, Type.URANIUM_238)) return returnSeedItem(Type.URANIUM_238);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Quicksilver, BlockCheck.QuicksilverBlock, Type.QUICKSILVER)) return returnSeedItem(Type.QUICKSILVER);
		else if(checkBlockAndTier(extractor, blockItem, block, BlockCheck.Silicon, BlockCheck.SiliconBlock, Type.SILICON)) return returnSeedItem(Type.SILICON);
		else if(ModCheck.MYSTICAL_AGRADDITIONS) {
			if(verifyTier(6, extractor) || ModConfig.EXTRACTOR_ANY_TIER) {
				if(checkBlock(blockItem, block, BlockCheck.Netherstar, BlockCheck.NetherstarBlock)) return new ItemStack(Item.getByNameOrId("mysticalagradditions:nether_star_seeds"));
				else if(checkBlock(blockItem, block, BlockCheck.Awakened, BlockCheck.AwakenedBlock)) return new ItemStack(Item.getByNameOrId("mysticalagradditions:awakened_draconium_seeds"));
				else if(checkBlock(blockItem, block, BlockCheck.DragonEgg, BlockCheck.DragonEggBlock)) return new ItemStack(Item.getByNameOrId("mysticalagradditions:dragon_egg_seeds"));
				else if(checkBlock(blockItem, block, BlockCheck.Neutronium, BlockCheck.NeutroniumBlock)) return new ItemStack(Item.getByNameOrId("mysticalagradditions:neutronium_seeds"));
			}
		}
		return null;
	}
	
	public static ItemStack returnSeedItem(CropType.Type seed) {
		return new ItemStack(seed.getSeed());
	}
	
	public static boolean verifyTier(CropType.Type seed, ItemStack extractor) {
		if(!ModConfig.EXTRACTOR_ANY_TIER) {
			if(ModConfig.EXTRACTOR_LOWER_TIER) {
				if(extractor.getTagCompound().getInteger("tier") >= seed.getTier()) return true;
				else return false;
			} else {
				if(extractor.getTagCompound().getInteger("tier") == seed.getTier()) return true;
				else return false;
			}
		} else return true;
	}
	
	public static boolean verifyTier(int tier, ItemStack extractor) {
		if(!ModConfig.EXTRACTOR_ANY_TIER) {
			if(ModConfig.EXTRACTOR_LOWER_TIER) {
				if(extractor.getTagCompound().getInteger("tier") >= tier) return true;
				else return false;
			} else {
				if(extractor.getTagCompound().getInteger("tier") == tier) return true;
				else return false;
			}
		} else return true;
	}
	
	public static boolean checkBlockAndTier(ItemStack extractor, ItemStack blockItem, Block block, List<ItemStack> itemList, List<Block> blockList, CropType.Type seed) {
		if(checkBlock(blockItem, block, itemList, blockList) && verifyTier(seed, extractor) && seed.isEnabled()) return true;
		else return false;
	}
	
	public static boolean checkBlock(ItemStack blockItem, Block block, List<ItemStack> itemList, List<Block> blockList) {
		if(!(itemList == null || itemList.isEmpty())) {
			for(ItemStack b : itemList) {
				if(OreDictionary.itemMatches(b, blockItem, false)) {
					return true;
				}
			}
		} else if(!(blockList == null || blockList.isEmpty())) {
			for(Block b : blockList) {
				if(Block.isEqualTo(b, block)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
