package com.focamacho.mysticaladaptations.lib;

import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType;
import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.util.ModCheck;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlockCheck {

	public static ItemStack getSeedFromBlock(ItemStack extractor, ItemStack blockItem, Block block) {
		if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Dirt, BlocksList.Dirt, Type.DIRT)) return returnSeedItem(Type.DIRT);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Rubber, BlocksList.Rubber, Type.RUBBER)) return returnSeedItem(Type.RUBBER);
	    else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Wood, BlocksList.Wood, Type.WOOD)) return returnSeedItem(Type.WOOD);
	    else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Stone, BlocksList.Stone, Type.STONE)) return returnSeedItem(Type.STONE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Nature, BlocksList.Nature, Type.NATURE)) return returnSeedItem(Type.NATURE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Copper, BlocksList.Copper, Type.COPPER)) return returnSeedItem(Type.COPPER);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Tin, BlocksList.Tin, Type.TIN)) return returnSeedItem(Type.TIN);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Platinum, BlocksList.Platinum, Type.PLATINUM)) return returnSeedItem(Type.PLATINUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Alubrass, BlocksList.Alubrass, Type.ALUMINUM_BRASS)) return returnSeedItem(Type.ALUMINUM_BRASS);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Aluminum, BlocksList.Aluminum, Type.ALUMINUM)) return returnSeedItem(Type.ALUMINUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Alumite, BlocksList.Alumite, Type.ALUMITE)) return returnSeedItem(Type.ALUMITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Ardite, BlocksList.Ardite, Type.ARDITE)) return returnSeedItem(Type.ARDITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.QuartzBlack, BlocksList.QuartzBlack, Type.BLACK_QUARTZ)) return returnSeedItem(Type.BLACK_QUARTZ);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Boron, BlocksList.Boron, Type.BORON)) return returnSeedItem(Type.BORON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Brass, BlocksList.Brass, Type.BRASS)) return returnSeedItem(Type.BRASS);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Bronze, BlocksList.Bronze, Type.BRONZE)) return returnSeedItem(Type.BRONZE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Chrome, BlocksList.Chrome, Type.CHROME)) return returnSeedItem(Type.CHROME);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Coal, BlocksList.Coal, Type.COAL)) return returnSeedItem(Type.COAL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Cobalt, BlocksList.Cobalt, Type.COBALT)) return returnSeedItem(Type.COBALT);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.ConductiveIron, BlocksList.ConductiveIron, Type.CONDUCTIVE_IRON)) return returnSeedItem(Type.CONDUCTIVE_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Constantan, BlocksList.Constantan, Type.CONSTANTAN)) return returnSeedItem(Type.CONSTANTAN);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.DarkSteel, BlocksList.DarkSteel, Type.DARK_STEEL)) return returnSeedItem(Type.DARK_STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Diamond, BlocksList.Diamond, Type.DIAMOND)) return returnSeedItem(Type.DIAMOND);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Draconium, BlocksList.Draconium, Type.DRACONIUM)) return returnSeedItem(Type.DRACONIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Dye, BlocksList.Dye, Type.DYE)) return returnSeedItem(Type.DYE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.ElectricalSteel, BlocksList.ElectricalSteel, Type.ELECTRICAL_STEEL)) return returnSeedItem(Type.ELECTRICAL_STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Electrum, BlocksList.Electrum, Type.ELECTRUM)) return returnSeedItem(Type.ELECTRUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Emerald, BlocksList.Emerald, Type.EMERALD)) return returnSeedItem(Type.EMERALD);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.EndSteel, BlocksList.EndSteel, Type.END_STEEL)) return returnSeedItem(Type.END_STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Enderium, BlocksList.Enderium, Type.ENDERIUM)) return returnSeedItem(Type.ENDERIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.EnergeticAlloy, BlocksList.EnergeticAlloy, Type.ENERGETIC_ALLOY)) return returnSeedItem(Type.ENERGETIC_ALLOY);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.RefinedGlowstone, BlocksList.RefinedGlowstone, Type.GLOWSTONE_INGOT)) return returnSeedItem(Type.GLOWSTONE_INGOT);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Glowstone, BlocksList.Glowstone, Type.GLOWSTONE)) return returnSeedItem(Type.GLOWSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Gold, BlocksList.Gold, Type.GOLD)) return returnSeedItem(Type.GOLD);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.InfinityDust, BlocksList.InfinityDust, Type.GRAINS_OF_INFINITY)) return returnSeedItem(Type.GRAINS_OF_INFINITY);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Ice, BlocksList.Ice, Type.ICE)) return returnSeedItem(Type.ICE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Invar, BlocksList.Invar, Type.INVAR)) return returnSeedItem(Type.INVAR);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Iridium, BlocksList.Iridium, Type.IRIDIUM)) return returnSeedItem(Type.IRIDIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Iron, BlocksList.Iron, Type.IRON)) return returnSeedItem(Type.IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Knightslime, BlocksList.Knightslime, Type.KNIGHTSLIME)) return returnSeedItem(Type.KNIGHTSLIME);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Lapis, BlocksList.Lapis, Type.LAPIS_LAZULI)) return returnSeedItem(Type.LAPIS_LAZULI);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Lead, BlocksList.Lead, Type.LEAD)) return returnSeedItem(Type.LEAD);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Limestone, BlocksList.Limestone, Type.LIMESTONE)) return returnSeedItem(Type.LIMESTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Lithium, BlocksList.Lithium, Type.LITHIUM)) return returnSeedItem(Type.LITHIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Lumium, BlocksList.Lumium, Type.LUMIUM)) return returnSeedItem(Type.LUMIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Magnesium, BlocksList.Magnesium, Type.MAGNESIUM)) return returnSeedItem(Type.MAGNESIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Manyullyn, BlocksList.Manyullyn, Type.MANYULLYN)) return returnSeedItem(Type.MANYULLYN);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Marble, BlocksList.Marble, Type.MARBLE)) return returnSeedItem(Type.MARBLE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Mithril, BlocksList.Mithril, Type.MITHRIL)) return returnSeedItem(Type.MITHRIL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Quartz, BlocksList.Quartz, Type.NETHER_QUARTZ)) return returnSeedItem(Type.NETHER_QUARTZ);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Nickel, BlocksList.Nickel, Type.NICKEL)) return returnSeedItem(Type.NICKEL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Obsidian, BlocksList.Obsidian, Type.OBSIDIAN)) return returnSeedItem(Type.OBSIDIAN);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Osmium, BlocksList.Osmium, Type.OSMIUM)) return returnSeedItem(Type.OSMIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Peridot, BlocksList.Peridot, Type.PERIDOT)) return returnSeedItem(Type.PERIDOT);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.PulsatingIron, BlocksList.PulsatingIron, Type.PULSATING_IRON)) return returnSeedItem(Type.PULSATING_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.RedstoneAlloy, BlocksList.RedstoneAlloy, Type.REDSTONE_ALLOY)) return returnSeedItem(Type.REDSTONE_ALLOY);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Redstone, BlocksList.Redstone, Type.REDSTONE)) return returnSeedItem(Type.REDSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.RefinedObsidian, BlocksList.RefinedObsidian, Type.REFINED_OBSIDIAN)) return returnSeedItem(Type.REFINED_OBSIDIAN);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Ruby, BlocksList.Ruby, Type.RUBY)) return returnSeedItem(Type.RUBY);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Sapphire, BlocksList.Sapphire, Type.SAPPHIRE)) return returnSeedItem(Type.SAPPHIRE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Signalum, BlocksList.Signalum, Type.SIGNALUM)) return returnSeedItem(Type.SIGNALUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Silver, BlocksList.Silver, Type.SILVER)) return returnSeedItem(Type.SILVER);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Slate, BlocksList.Slate, Type.SLATE)) return returnSeedItem(Type.SLATE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Slime, BlocksList.Slime, Type.SLIME)) return returnSeedItem(Type.SLIME);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Soularium, BlocksList.Soularium, Type.SOULARIUM)) return returnSeedItem(Type.SOULARIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Steel, BlocksList.Steel, Type.STEEL)) return returnSeedItem(Type.STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Thorium, BlocksList.Thorium, Type.THORIUM)) return returnSeedItem(Type.THORIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Titanium, BlocksList.Titanium, Type.TITANIUM)) return returnSeedItem(Type.TITANIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Tungsten, BlocksList.Tungsten, Type.TUNGSTEN)) return returnSeedItem(Type.TUNGSTEN);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Uranium, BlocksList.Uranium, Type.URANIUM)) return returnSeedItem(Type.URANIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.VibrantAlloy, BlocksList.VibrantAlloy, Type.VIBRANT_ALLOY)) return returnSeedItem(Type.VIBRANT_ALLOY);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Zinc, BlocksList.Zinc, Type.ZINC)) return returnSeedItem(Type.ZINC);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Abyssalnite, BlocksList.Abyssalnite, Type.ABYSSALNITE)) return returnSeedItem(Type.ABYSSALNITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Adamantine, BlocksList.Adamantine, Type.ADAMANTINE)) return returnSeedItem(Type.ADAMANTINE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Apatite, BlocksList.Apatite, Type.APATITE)) return returnSeedItem(Type.APATITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Aquarium, BlocksList.Aquarium, Type.AQUARIUM)) return returnSeedItem(Type.AQUARIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Basalt, BlocksList.Basalt, Type.BASALT)) return returnSeedItem(Type.BASALT);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.ColdIron, BlocksList.ColdIron, Type.COLD_IRON)) return returnSeedItem(Type.COLD_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.CompressedIron, BlocksList.CompressedIron, Type.COMPRESSED_IRON)) return returnSeedItem(Type.COMPRESSED_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Coralium, BlocksList.Coralium, Type.CORALIUM)) return returnSeedItem(Type.CORALIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Dawnstone, BlocksList.Dawnstone, Type.DAWNSTONE)) return returnSeedItem(Type.DAWNSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Desh, BlocksList.Desh, Type.DESH)) return returnSeedItem(Type.DESH);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Dreadium, BlocksList.Dreadium, Type.DREADIUM)) return returnSeedItem(Type.DREADIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.End, BlocksList.End, Type.END)) return returnSeedItem(Type.END);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Fiery, BlocksList.Fiery, Type.FIERY_INGOT)) return returnSeedItem(Type.FIERY_INGOT);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.FluxedElectrum, BlocksList.FluxedElectrum, Type.FLUXED_ELECTRUM)) return returnSeedItem(Type.FLUXED_ELECTRUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Jade, BlocksList.Jade, Type.JADE)) return returnSeedItem(Type.JADE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Knightmetal, BlocksList.Knightmetal, Type.KNIGHTMETAL)) return returnSeedItem(Type.KNIGHTMETAL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Nether, BlocksList.Nether, Type.NETHER)) return returnSeedItem(Type.NETHER);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Octine, BlocksList.Octine, Type.OCTINE)) return returnSeedItem(Type.OCTINE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.SlimyBone, BlocksList.SlimyBone, Type.SLIMY_BONE)) return returnSeedItem(Type.SLIMY_BONE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.StarSteel, BlocksList.StarSteel, Type.STAR_STEEL)) return returnSeedItem(Type.STAR_STEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Steeleaf, BlocksList.Steeleaf, Type.STEELEAF)) return returnSeedItem(Type.STEELEAF);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Syrmorite, BlocksList.Syrmorite, Type.SYRMORITE)) return returnSeedItem(Type.SYRMORITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Thaumium, BlocksList.Thaumium, Type.THAUMIUM)) return returnSeedItem(Type.THAUMIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Tritanium, BlocksList.Tritanium, Type.TRITANIUM)) return returnSeedItem(Type.TRITANIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Valonite, BlocksList.Valonite, Type.VALONITE)) return returnSeedItem(Type.VALONITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.VoidMetal, BlocksList.VoidMetal, Type.VOID_METAL)) return returnSeedItem(Type.VOID_METAL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Amber, BlocksList.Amber, Type.AMBER)) return returnSeedItem(Type.AMBER);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.CertusQuartz, BlocksList.CertusQuartz, Type.CERTUS_QUARTZ)) return returnSeedItem(Type.CERTUS_QUARTZ);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.DarkGem, BlocksList.DarkGem, Type.DARK_GEM)) return returnSeedItem(Type.DARK_GEM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Elementium, BlocksList.Elementium, Type.ELEMENTIUM)) return returnSeedItem(Type.ELEMENTIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.EnderAmethyst, BlocksList.EnderAmethyst, Type.ENDER_AMETHYST)) return returnSeedItem(Type.ENDER_AMETHYST);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.EnderBiotite, BlocksList.EnderBiotite, Type.ENDER_BIOTITE)) return returnSeedItem(Type.ENDER_BIOTITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Fluix, BlocksList.Fluix, Type.FLUIX)) return returnSeedItem(Type.FLUIX);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.IronWood, BlocksList.IronWood, Type.IRONWOOD)) return returnSeedItem(Type.IRONWOOD);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Malachite, BlocksList.Malachite, Type.MALACHITE)) return returnSeedItem(Type.MALACHITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Manasteel, BlocksList.Manasteel, Type.MANASTEEL)) return returnSeedItem(Type.MANASTEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Menril, BlocksList.Menril, Type.MENRIL)) return returnSeedItem(Type.MENRIL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.MeteoricIron, BlocksList.MeteoricIron, Type.METEORIC_IRON)) return returnSeedItem(Type.METEORIC_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.QuartzEnrichedIron, BlocksList.QuartzEnrichedIron, Type.QUARTZ_ENRICHED_IRON)) return returnSeedItem(Type.QUARTZ_ENRICHED_IRON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.RockCrystal, BlocksList.RockCrystal, Type.ROCK_CRYSTAL)) return returnSeedItem(Type.ROCK_CRYSTAL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.SkyStone, BlocksList.SkyStone, Type.SKY_STONE)) return returnSeedItem(Type.SKY_STONE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Tanzanite, BlocksList.Tanzanite, Type.TANZANITE)) return returnSeedItem(Type.TANZANITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Terrasteel, BlocksList.Terrasteel, Type.TERRASTEEL)) return returnSeedItem(Type.TERRASTEEL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Topaz, BlocksList.Topaz, Type.TOPAZ)) return returnSeedItem(Type.TOPAZ);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.BlueTopaz, BlocksList.BlueTopaz, Type.BLUE_TOPAZ)) return returnSeedItem(Type.BLUE_TOPAZ);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Chimerite, BlocksList.Chimerite, Type.CHIMERITE)) return returnSeedItem(Type.CHIMERITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Graphite, BlocksList.Graphite, Type.GRAPHITE)) return returnSeedItem(Type.GRAPHITE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Moonstone, BlocksList.Moonstone, Type.MOONSTONE)) return returnSeedItem(Type.MOONSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Sunstone, BlocksList.Sunstone, Type.SUNSTONE)) return returnSeedItem(Type.SUNSTONE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Vinteum, BlocksList.Vinteum, Type.VINTEUM)) return returnSeedItem(Type.VINTEUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Yellorium, BlocksList.Yellorium, Type.YELLORIUM)) return returnSeedItem(Type.YELLORIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.MysticalFlower, BlocksList.MysticalFlower, Type.MYSTICAL_FLOWER)) return returnSeedItem(Type.MYSTICAL_FLOWER);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Water, BlocksList.Water, Type.WATER)) return returnSeedItem(Type.WATER);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Fire, BlocksList.Fire, Type.FIRE)) return returnSeedItem(Type.FIRE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Aquamarine, BlocksList.Aquamarine, Type.AQUAMARINE)) return returnSeedItem(Type.AQUAMARINE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Dilithium, BlocksList.Dilithium, Type.DILITHIUM)) return returnSeedItem(Type.DILITHIUM);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.IridiumOre, BlocksList.IridiumOre, Type.IRIDIUM_ORE)) return returnSeedItem(Type.IRIDIUM_ORE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Starmetal, BlocksList.Starmetal, Type.STARMETAL)) return returnSeedItem(Type.STARMETAL);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Uranium238, BlocksList.Uranium238, Type.URANIUM_238)) return returnSeedItem(Type.URANIUM_238);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Quicksilver, BlocksList.Quicksilver, Type.QUICKSILVER)) return returnSeedItem(Type.QUICKSILVER);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Silicon, BlocksList.Silicon, Type.SILICON)) return returnSeedItem(Type.SILICON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Basalz, BlocksList.Basalz, Type.BASALZ)) return returnSeedItem(Type.BASALZ);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Blaze, BlocksList.Blaze, Type.BLAZE)) return returnSeedItem(Type.BLAZE);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Blitz, BlocksList.Blitz, Type.BLITZ)) return returnSeedItem(Type.BLITZ);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Blizz, BlocksList.Blizz, Type.BLIZZ)) return returnSeedItem(Type.BLIZZ);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Chicken, BlocksList.Chicken, Type.CHICKEN)) return returnSeedItem(Type.CHICKEN);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Cow, BlocksList.Cow, Type.COW)) return returnSeedItem(Type.COW);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Creeper, BlocksList.Creeper, Type.CREEPER)) return returnSeedItem(Type.CREEPER);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Enderman, BlocksList.Enderman, Type.ENDERMAN)) return returnSeedItem(Type.ENDERMAN);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Ghast, BlocksList.Ghast, Type.GHAST)) return returnSeedItem(Type.GHAST);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Guardian, BlocksList.Guardian, Type.GUARDIAN)) return returnSeedItem(Type.GUARDIAN);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Pig, BlocksList.Pig, Type.PIG)) return returnSeedItem(Type.PIG);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Rabbit, BlocksList.Rabbit, Type.RABBIT)) return returnSeedItem(Type.RABBIT);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Sheep, BlocksList.Sheep, Type.SHEEP)) return returnSeedItem(Type.SHEEP);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Skeleton, BlocksList.Skeleton, Type.SKELETON)) return returnSeedItem(Type.SKELETON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Spider, BlocksList.Spider, Type.SPIDER)) return returnSeedItem(Type.SPIDER);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.WitherSkeleton, BlocksList.WitherSkeleton, Type.WITHER_SKELETON)) return returnSeedItem(Type.WITHER_SKELETON);
		else if(checkBlockAndTier(extractor, blockItem, block, ItemsList.Zombie, BlocksList.Zombie, Type.ZOMBIE)) return returnSeedItem(Type.ZOMBIE);
		else if(ModCheck.MYSTICAL_AGRADDITIONS) {
			if(checkTier(6, extractor) || ModConfig.EXTRACTOR_ANY_TIER) {
				if(checkBlock(blockItem, block, ItemsList.Netherstar, BlocksList.Netherstar)) return new ItemStack(Item.getByNameOrId("mysticalagradditions:nether_star_seeds"));
				else if(checkBlock(blockItem, block, ItemsList.Awakened, BlocksList.Awakened)) return new ItemStack(Item.getByNameOrId("mysticalagradditions:awakened_draconium_seeds"));
				else if(checkBlock(blockItem, block, ItemsList.DragonEgg, BlocksList.DragonEgg)) return new ItemStack(Item.getByNameOrId("mysticalagradditions:dragon_egg_seeds"));
				else if(checkBlock(blockItem, block, ItemsList.Neutronium, BlocksList.Neutronium)) return new ItemStack(Item.getByNameOrId("mysticalagradditions:neutronium_seeds"));
			}
		}
		return null;
	}
	
	public static ItemStack returnSeedItem(CropType.Type seed) {
		return new ItemStack(seed.getSeed());
	}
	
	public static boolean checkTier(CropType.Type seed, ItemStack extractor) {
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
	
	public static boolean checkTier(int tier, ItemStack extractor) {
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
		if(checkBlock(blockItem, block, itemList, blockList) && checkTier(seed, extractor) && seed.isEnabled()) return true;
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
