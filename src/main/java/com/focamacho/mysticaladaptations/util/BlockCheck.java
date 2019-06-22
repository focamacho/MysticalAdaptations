package com.focamacho.mysticaladaptations.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.blakebr0.mysticalagriculture.blocks.ModBlocks;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

public class BlockCheck {
	
	public static final List<ItemStack> Wood = OreDictionary.getOres("logWood");
	public static final List<ItemStack> Copper = OreDictionary.getOres("blockCopper");
	public static final List<ItemStack> Tin = OreDictionary.getOres("blockTin");
	public static final List<ItemStack> Platinum = OreDictionary.getOres("blockPlatinum");
	public static final List<ItemStack> Alubrass = OreDictionary.getOres("blockAlubrass");
	public static final List<ItemStack> Aluminum = OreDictionary.getOres("blockAluminum");
	public static final List<ItemStack> Alumite = OreDictionary.getOres("blockAlumite");
	public static final List<ItemStack> Ardite = OreDictionary.getOres("blockArdite");
	public static final List<ItemStack> QuartzBlack = OreDictionary.getOres("blockQuartzBlack");
	public static final List<ItemStack> Boron = OreDictionary.getOres("blockBoron");
	public static final List<ItemStack> Brass = OreDictionary.getOres("blockBrass");
	public static final List<ItemStack> Bronze = OreDictionary.getOres("blockBronze");
	public static final List<ItemStack> Chrome = OreDictionary.getOres("blockChrome");
	public static final List<ItemStack> Coal = OreDictionary.getOres("blockCoal");
	public static final List<ItemStack> Cobalt = OreDictionary.getOres("blockCobalt");
	public static final List<ItemStack> ConductiveIron = OreDictionary.getOres("blockConductiveIron");
	public static final List<ItemStack> Constantan = OreDictionary.getOres("blockConstantan");
	public static final List<ItemStack> DarkSteel = OreDictionary.getOres("blockDarkSteel");
	public static final List<ItemStack> Diamond = OreDictionary.getOres("blockDiamond");
	public static final List<ItemStack> Draconium = OreDictionary.getOres("blockDraconium");
	public static final List<ItemStack> Dirt = OreDictionary.getOres("dirt");
	public static final List<ItemStack> ElectricalSteel = OreDictionary.getOres("blockElectricalSteel");
	public static final List<ItemStack> Electrum = OreDictionary.getOres("blockElectrum");
	public static final List<ItemStack> Emerald = OreDictionary.getOres("blockEmerald");
	public static final List<ItemStack> EndSteel = OreDictionary.getOres("blockEndSteel");
	public static final List<ItemStack> Enderium = OreDictionary.getOres("blockEnderium");
	public static final List<ItemStack> EnergeticAlloy = OreDictionary.getOres("blockEnergeticAlloy");
	public static final List<ItemStack> RefinedGlowstone = OreDictionary.getOres("blockRefinedGlowstone");
	public static final List<ItemStack> Glowstone = OreDictionary.getOres("glowstone");
	public static final List<ItemStack> Gold = OreDictionary.getOres("blockGold");
	public static final List<ItemStack> InfinityDust = OreDictionary.getOres("compressedx1DustBedrock");
	public static final List<ItemStack> Invar = OreDictionary.getOres("blockInvar");
	public static final List<ItemStack> Iridium = OreDictionary.getOres("blockIridium");
	public static final List<ItemStack> Iron = OreDictionary.getOres("blockIron");
	public static final List<ItemStack> Knightslime = OreDictionary.getOres("blockKnightslime");
	public static final List<ItemStack> Lapis = OreDictionary.getOres("blockLapis");
	public static final List<ItemStack> Lead = OreDictionary.getOres("blockLead");
	public static final List<ItemStack> Limestone = OreDictionary.getOres("stoneLimestone");
	public static final List<ItemStack> Lithium = OreDictionary.getOres("blockLithium");
	public static final List<ItemStack> Lumium = OreDictionary.getOres("blockLumium");
	public static final List<ItemStack> Magnesium = OreDictionary.getOres("blockMagnesium");
	public static final List<ItemStack> Manyullyn = OreDictionary.getOres("blockManyullyn");
	public static final List<ItemStack> Marble = OreDictionary.getOres("stoneMarble");
	public static final List<ItemStack> Mithril = OreDictionary.getOres("blockMithril");
	public static final List<ItemStack> Quartz = OreDictionary.getOres("blockQuartz");
	public static final List<ItemStack> Nickel = OreDictionary.getOres("blockNickel");
	public static final List<ItemStack> Obsidian = OreDictionary.getOres("obsidian");
	public static final List<ItemStack> Osmium = OreDictionary.getOres("blockOsmium");
	public static final List<ItemStack> Peridot = OreDictionary.getOres("blockPeridot");
	public static final List<ItemStack> PulsatingIron = OreDictionary.getOres("blockPulsatingIron");
	public static final List<ItemStack> RedstoneAlloy = OreDictionary.getOres("blockRedstoneAlloy");
	public static final List<ItemStack> Redstone = OreDictionary.getOres("blockRedstone");
	public static final List<ItemStack> RefinedObsidian = OreDictionary.getOres("blockRefinedObsidian");
	public static final List<ItemStack> Ruby = OreDictionary.getOres("blockRuby");
	public static final List<ItemStack> Sapphire = OreDictionary.getOres("blockSapphire");
	public static final List<ItemStack> Signalum = OreDictionary.getOres("blockSignalum");
	public static final List<ItemStack> Silver = OreDictionary.getOres("blockSilver");
	public static final List<ItemStack> Slate = OreDictionary.getOres("slate");
	public static final List<ItemStack> Slime = OreDictionary.getOres("blockSlime");
	public static final List<ItemStack> Soularium = OreDictionary.getOres("blockSoularium");
	public static final List<ItemStack> Steel = OreDictionary.getOres("blockSteel");
	public static final List<ItemStack> Thorium = OreDictionary.getOres("blockThroium");
	public static final List<ItemStack> Titanium = OreDictionary.getOres("blockTitanium");
	public static final List<ItemStack> Tungsten = OreDictionary.getOres("blockTungsten");
	public static final List<ItemStack> Uranium = OreDictionary.getOres("blockUranium");
	public static final List<ItemStack> VibrantAlloy = OreDictionary.getOres("blockVibrantAlloy");
	public static final List<ItemStack> Zinc = OreDictionary.getOres("blockZinc");
	public static final List<ItemStack> Abyssalnite = OreDictionary.getOres("blockAbyssalnite");
	public static final List<ItemStack> Adamantine = OreDictionary.getOres("blockAdamantine");
	public static final List<ItemStack> Apatite = OreDictionary.getOres("blockApatite");
	public static final List<ItemStack> Aquarium = OreDictionary.getOres("blockAquarium");
	public static final List<ItemStack> Basalt = OreDictionary.getOres("stoneBasalt");
	public static final List<ItemStack> ColdIron = OreDictionary.getOres("blockColdiron");
	public static final List<ItemStack> CompressedIron = OreDictionary.getOres("blockIronCompressed");
	public static final List<ItemStack> Coralium = OreDictionary.getOres("blockLiquifiedCoralium");
	public static final List<ItemStack> Dawstone = OreDictionary.getOres("blockDawnstone");
	public static final List<ItemStack> Desh = OreDictionary.getOres("blockDesh");
	public static final List<ItemStack> Dreadium = OreDictionary.getOres("blockDreadium");
	public static final List<ItemStack> EndStone = OreDictionary.getOres("endstone");
	public static final List<ItemStack> Fiery = OreDictionary.getOres("blockFiery");
	public static final List<ItemStack> FluxedElectrum = OreDictionary.getOres("blockElectrumFlux");
	public static final List<ItemStack> Jade = OreDictionary.getOres("blockJade");
	public static final List<ItemStack> Knightmetal = OreDictionary.getOres("blockKnightmetal");
	public static final List<ItemStack> Netherrack = OreDictionary.getOres("netherrack");
	public static final List<ItemStack> Octine = OreDictionary.getOres("blockOctine");
	public static final List<ItemStack> SlimyBone = OreDictionary.getOres("blockBone");
	public static final List<ItemStack> StarSteel = OreDictionary.getOres("blockStarsteel");
	public static final List<ItemStack> Steeleaf = OreDictionary.getOres("blockSteeleaf");
	public static final List<ItemStack> Syrmorite = OreDictionary.getOres("blockSyrmorite");
	public static final List<ItemStack> Thaumium = OreDictionary.getOres("blockThaumium");
	public static final List<ItemStack> Tritanium = OreDictionary.getOres("blockTritanium");
	public static final List<ItemStack> Valonite = OreDictionary.getOres("blockValonite");
	public static final List<ItemStack> VoidMetal = OreDictionary.getOres("blockVoid");
	public static final List<ItemStack> Ice =  new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Blocks.ICE)));
	public static final List<ItemStack> Amber = ModChecker.BIOMES_O_PLENTY ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("biomesoplenty:gem_block"), 1, 7))) : null;
	public static final List<ItemStack> CertusQuartz = ModChecker.APPLIED_ENERGISTICS_2 ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("appliedenergistics2:quartz_block")))) : null;
	public static final List<ItemStack> DarkGem = ModChecker.EVILCRAFT ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("evilcraft:dark_block")))) : null;
	public static final List<ItemStack> Elementium = ModChecker.BOTANIA ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("botania:storage"), 1, 2))) : null;
	public static final List<ItemStack> EnderAmethyst = ModChecker.BIOMES_O_PLENTY ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("biomesoplenty:gem_block"), 1, 0))) : null;
	public static final List<ItemStack> EnderBiotite = ModChecker.QUARK ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("quark:biotite_block")))) : null;
	public static final List<ItemStack> Fluix = ModChecker.APPLIED_ENERGISTICS_2 ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("appliedenergistics2:fluix_block")))) : null;
	public static final List<ItemStack> IronWood = ModChecker.TWILIGHT_FOREST ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("twilightforest:block_storage"), 1, 0))) : null;
	public static final List<ItemStack> Malachite = ModChecker.BIOMES_O_PLENTY ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("biomesoplenty:gem_block"), 1, 5))) : null;
	public static final List<ItemStack> Manasteel = ModChecker.BOTANIA ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("botania:storage"), 1, 0))) : null;
	public static final List<ItemStack> Menril = ModChecker.INTEGRATED_DYNAMICS ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("integrateddynamics:crystalized_menril_block")))) : null;
	public static final List<ItemStack> MeteoricIron = ModChecker.GALACTICRAFT_CORE ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("galacticraftcore:basic_block_core"), 1, 12))) : null;
	public static final List<ItemStack> QuartzEnrichedIron = ModChecker.REFINED_STORAGE ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("refinedstorage:quartz_enriched_iron_block")))) : null;
	public static final List<ItemStack> RockCrystal = ModChecker.ASTRAL_SORCERY ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("astralsorcery:blockcustomore"), 1, 0))) : null;
	public static final List<ItemStack> SkyStone = ModChecker.APPLIED_ENERGISTICS_2 ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("appliedenergistics2:sky_stone_block")))) : null;
	public static final List<ItemStack> Tanzanite = ModChecker.BIOMES_O_PLENTY ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("biomesoplenty:gem_block"), 1, 4))) : null;
	public static final List<ItemStack> Terrasteel = ModChecker.BOTANIA ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("botania:storage"), 1, 1))) : null;
	public static final List<ItemStack> Topaz = ModChecker.BIOMES_O_PLENTY ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("biomesoplenty:gem_block"), 1, 3))) : null;
	public static final List<ItemStack> BlueTopaz = OreDictionary.getOres("blockBlueTopaz");
	public static final List<ItemStack> Chimerite = OreDictionary.getOres("blockChimerite");
	public static final List<ItemStack> Graphite = OreDictionary.getOres("blockGraphite");
	public static final List<ItemStack> Moonstone = OreDictionary.getOres("blockMoonstone");
	public static final List<ItemStack> Sunstone = OreDictionary.getOres("blockSunstone");
	public static final List<ItemStack> Vinteum = OreDictionary.getOres("blockVinteum");
	public static final List<ItemStack> Yellorium = OreDictionary.getOres("blockYellorium");
	public static final List<ItemStack> MysticalFlower = ModChecker.BOTANIA ? new ArrayList<ItemStack>(Arrays.asList(
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 0)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 1)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 2)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 3)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 4)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 5)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 6)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 7)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 8)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 9)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 10)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 11)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 12)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 13)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 14)),
			(new ItemStack(Item.getByNameOrId("botania:flower"), 1, 15)))): null;
	public static final List<ItemStack> Nature = new ArrayList<ItemStack>(Arrays.asList(
			(new ItemStack(Blocks.VINE)),
			(new ItemStack(Blocks.CACTUS)),
			(new ItemStack(Blocks.PUMPKIN)),
			(new ItemStack(Blocks.MELON_BLOCK)),
			(new ItemStack(Blocks.WATERLILY)),
			(new ItemStack(Blocks.TALLGRASS))));
	public static final List<Block> Water = new ArrayList<Block>(Arrays.asList(Blocks.WATER));
	public static final List<ItemStack> Stone = OreDictionary.getOres("stone");
	public static final List<Block> Fire = new ArrayList<Block>(Arrays.asList(Blocks.LAVA));
	public static final List<ItemStack> Aquamarine = ModChecker.ASTRAL_SORCERY ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("astralsorcery:blockcustomsandore"), 1, 0))) : null;
	public static final List<ItemStack> Dilithium = OreDictionary.getOres("oreDilithium");
	public static final List<ItemStack> IridiumOre = OreDictionary.getOres("oreIridium");
	public static final List<ItemStack> Rubber = OreDictionary.getOres("logRubber");
	public static final List<ItemStack> Starmetal = OreDictionary.getOres("oreAstralStarmetal");
	public static final List<ItemStack> Uranium238 = ModChecker.IC2 ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("ic2:resource"), 1, 10))) : null;
	public static final List<ItemStack> Quicksilver = ModChecker.THAUMCRAFT ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("thaumcraft:ore_cinnabar")))) : null;
	public static final List<Block> Dye = new ArrayList<Block>(Arrays.asList(
			(Blocks.RED_FLOWER),
			(Blocks.YELLOW_FLOWER)));
	/* Mystical Agradditions Compat
	public static final List<ItemStack> Netherstar = ModCheck.MYSTICAL_AGRADDITIONS ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("mysticalagradditions:special"), 1, 0))) : null;
	public static final List<ItemStack> Awakened = ModChecker.DRACONIC_EVOLUTION ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("draconicevolution:draconic_block")))) : null;
	public static final List<ItemStack> DragonEgg = ModCheck.MYSTICAL_AGRADDITIONS ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("mysticalagradditions:special"), 1, 1))) : null;
	public static final List<ItemStack> Neutronium = ModCheck.AVARITIA ? new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getByNameOrId("avaritia:block_resource"), 1, 0))) : null;
	*/
}
