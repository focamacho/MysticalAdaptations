package com.focamacho.mysticaladaptations.util.compat.jei.extractor;

import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.lib.BlocksList;
import com.focamacho.mysticaladaptations.lib.EntitiesList;
import com.focamacho.mysticaladaptations.lib.ItemsList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.FluidContainerColorer;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;
import net.minecraftforge.fluids.capability.wrappers.FluidBlockWrapper;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import scala.actors.scheduler.DrainableForkJoinPool;

public class ExtractorItemStacks {

	public static List<ItemStack> getItemStacksFromType(Type type) {
		List<ItemStack> allItems = new ArrayList<ItemStack>();
		if(type == Type.DIRT) return getItemStacks(ItemsList.Dirt, BlocksList.Dirt, EntitiesList.Dirt);
		else if(type == Type.RUBBER) return getItemStacks(ItemsList.Rubber, BlocksList.Rubber, EntitiesList.Rubber);
	    else if(type == Type.WOOD) return getItemStacks(ItemsList.Wood, BlocksList.Wood, EntitiesList.Wood);
	    else if(type == Type.STONE) return getItemStacks(ItemsList.Stone, BlocksList.Stone, EntitiesList.Stone);
		else if(type == Type.NATURE) return getItemStacks(ItemsList.Nature, BlocksList.Nature, EntitiesList.Nature);
		else if(type == Type.COPPER) return getItemStacks(ItemsList.Copper, BlocksList.Copper, EntitiesList.Copper);
		else if(type == Type.TIN) return getItemStacks(ItemsList.Tin, BlocksList.Tin, EntitiesList.Tin);
		else if(type == Type.PLATINUM) return getItemStacks(ItemsList.Platinum, BlocksList.Platinum, EntitiesList.Platinum);
		else if(type == Type.ALUMINUM_BRASS) return getItemStacks(ItemsList.Alubrass, BlocksList.Alubrass, EntitiesList.Alubrass);
		else if(type == Type.ALUMINUM) return getItemStacks(ItemsList.Aluminum, BlocksList.Aluminum, EntitiesList.Aluminum);
		else if(type == Type.ALUMITE) return getItemStacks(ItemsList.Alumite, BlocksList.Alumite, EntitiesList.Alumite);
		else if(type == Type.ARDITE) return getItemStacks(ItemsList.Ardite, BlocksList.Ardite, EntitiesList.Ardite);
		else if(type == Type.BLACK_QUARTZ) return getItemStacks(ItemsList.QuartzBlack, BlocksList.QuartzBlack, EntitiesList.QuartzBlack);
		else if(type == Type.BORON) return getItemStacks(ItemsList.Boron, BlocksList.Boron, EntitiesList.Boron);
		else if(type == Type.BRASS) return getItemStacks(ItemsList.Brass, BlocksList.Brass, EntitiesList.Brass);
		else if(type == Type.BRONZE) return getItemStacks(ItemsList.Bronze, BlocksList.Bronze, EntitiesList.Bronze);
		else if(type == Type.CHROME) return getItemStacks(ItemsList.Chrome, BlocksList.Chrome, EntitiesList.Chrome);
		else if(type == Type.COAL) return getItemStacks(ItemsList.Coal, BlocksList.Coal, EntitiesList.Coal);
		else if(type == Type.COBALT) return getItemStacks(ItemsList.Cobalt, BlocksList.Cobalt, EntitiesList.Cobalt);
		else if(type == Type.CONDUCTIVE_IRON) return getItemStacks(ItemsList.ConductiveIron, BlocksList.ConductiveIron, EntitiesList.ConductiveIron);
		else if(type == Type.CONSTANTAN) return getItemStacks(ItemsList.Constantan, BlocksList.Constantan, EntitiesList.Constantan);
		else if(type == Type.DARK_STEEL) return getItemStacks(ItemsList.DarkSteel, BlocksList.DarkSteel, EntitiesList.DarkSteel);
		else if(type == Type.DIAMOND) return getItemStacks(ItemsList.Diamond, BlocksList.Diamond, EntitiesList.Diamond);
		else if(type == Type.DRACONIUM) return getItemStacks(ItemsList.Draconium, BlocksList.Draconium, EntitiesList.Draconium);
		else if(type == Type.DYE) return getItemStacks(ItemsList.Dye, BlocksList.Dye, EntitiesList.Dye);
		else if(type == Type.ELECTRICAL_STEEL) return getItemStacks(ItemsList.ElectricalSteel, BlocksList.ElectricalSteel, EntitiesList.ElectricalSteel);
		else if(type == Type.ELECTRUM) return getItemStacks(ItemsList.Electrum, BlocksList.Electrum, EntitiesList.Electrum);
		else if(type == Type.EMERALD) return getItemStacks(ItemsList.Emerald, BlocksList.Emerald, EntitiesList.Emerald);
		else if(type == Type.END_STEEL) return getItemStacks(ItemsList.EndSteel, BlocksList.EndSteel, EntitiesList.EndSteel);
		else if(type == Type.ENDERIUM) return getItemStacks(ItemsList.Enderium, BlocksList.Enderium, EntitiesList.Enderium);
		else if(type == Type.ENERGETIC_ALLOY) return getItemStacks(ItemsList.EnergeticAlloy, BlocksList.EnergeticAlloy, EntitiesList.EnergeticAlloy);
		else if(type == Type.GLOWSTONE_INGOT) return getItemStacks(ItemsList.RefinedGlowstone, BlocksList.RefinedGlowstone, EntitiesList.RefinedGlowstone);
		else if(type == Type.GLOWSTONE) return getItemStacks(ItemsList.Glowstone, BlocksList.Glowstone, EntitiesList.Glowstone);
		else if(type == Type.GOLD) return getItemStacks(ItemsList.Gold, BlocksList.Gold, EntitiesList.Gold);
		else if(type == Type.GRAINS_OF_INFINITY) return getItemStacks(ItemsList.InfinityDust, BlocksList.InfinityDust, EntitiesList.InfinityDust);
		else if(type == Type.ICE) return getItemStacks(ItemsList.Ice, BlocksList.Ice, EntitiesList.Ice);
		else if(type == Type.INVAR) return getItemStacks(ItemsList.Invar, BlocksList.Invar, EntitiesList.Invar);
		else if(type == Type.IRIDIUM) return getItemStacks(ItemsList.Iridium, BlocksList.Iridium, EntitiesList.Iridium);
		else if(type == Type.IRON) return getItemStacks(ItemsList.Iron, BlocksList.Iron, EntitiesList.Iron);
		else if(type == Type.KNIGHTSLIME) return getItemStacks(ItemsList.Knightslime, BlocksList.Knightslime, EntitiesList.Knightslime);
		else if(type == Type.LAPIS_LAZULI) return getItemStacks(ItemsList.Lapis, BlocksList.Lapis, EntitiesList.Lapis);
		else if(type == Type.LEAD) return getItemStacks(ItemsList.Lead, BlocksList.Lead, EntitiesList.Lead);
		else if(type == Type.LIMESTONE) return getItemStacks(ItemsList.Limestone, BlocksList.Limestone, EntitiesList.Limestone);
		else if(type == Type.LITHIUM) return getItemStacks(ItemsList.Lithium, BlocksList.Lithium, EntitiesList.Lithium);
		else if(type == Type.LUMIUM) return getItemStacks(ItemsList.Lumium, BlocksList.Lumium, EntitiesList.Lumium);
		else if(type == Type.MAGNESIUM) return getItemStacks(ItemsList.Magnesium, BlocksList.Magnesium, EntitiesList.Magnesium);
		else if(type == Type.MANYULLYN) return getItemStacks(ItemsList.Manyullyn, BlocksList.Manyullyn, EntitiesList.Manyullyn);
		else if(type == Type.MARBLE) return getItemStacks(ItemsList.Marble, BlocksList.Marble, EntitiesList.Marble);
		else if(type == Type.MITHRIL) return getItemStacks(ItemsList.Mithril, BlocksList.Mithril, EntitiesList.Mithril);
		else if(type == Type.NETHER_QUARTZ) return getItemStacks(ItemsList.Quartz, BlocksList.Quartz, EntitiesList.Quartz);
		else if(type == Type.NICKEL) return getItemStacks(ItemsList.Nickel, BlocksList.Nickel, EntitiesList.Nickel);
		else if(type == Type.OBSIDIAN) return getItemStacks(ItemsList.Obsidian, BlocksList.Obsidian, EntitiesList.Obsidian);
		else if(type == Type.OSMIUM) return getItemStacks(ItemsList.Osmium, BlocksList.Osmium, EntitiesList.Osmium);
		else if(type == Type.PERIDOT) return getItemStacks(ItemsList.Peridot, BlocksList.Peridot, EntitiesList.Peridot);
		else if(type == Type.PULSATING_IRON) return getItemStacks(ItemsList.PulsatingIron, BlocksList.PulsatingIron, EntitiesList.PulsatingIron);
		else if(type == Type.REDSTONE_ALLOY) return getItemStacks(ItemsList.RedstoneAlloy, BlocksList.RedstoneAlloy, EntitiesList.RedstoneAlloy);
		else if(type == Type.REDSTONE) return getItemStacks(ItemsList.Redstone, BlocksList.Redstone, EntitiesList.Redstone);
		else if(type == Type.REFINED_OBSIDIAN) return getItemStacks(ItemsList.RefinedObsidian, BlocksList.RefinedObsidian, EntitiesList.RefinedObsidian);
		else if(type == Type.RUBY) return getItemStacks(ItemsList.Ruby, BlocksList.Ruby, EntitiesList.Ruby);
		else if(type == Type.SAPPHIRE) return getItemStacks(ItemsList.Sapphire, BlocksList.Sapphire, EntitiesList.Sapphire);
		else if(type == Type.SIGNALUM) return getItemStacks(ItemsList.Signalum, BlocksList.Signalum, EntitiesList.Signalum);
		else if(type == Type.SILVER) return getItemStacks(ItemsList.Silver, BlocksList.Silver, EntitiesList.Silver);
		else if(type == Type.SLATE) return getItemStacks(ItemsList.Slate, BlocksList.Slate, EntitiesList.Slate);
		else if(type == Type.SLIME) return getItemStacks(ItemsList.Slime, BlocksList.Slime, EntitiesList.Slime);
		else if(type == Type.SOULARIUM) return getItemStacks(ItemsList.Soularium, BlocksList.Soularium, EntitiesList.Soularium);
		else if(type == Type.STEEL) return getItemStacks(ItemsList.Steel, BlocksList.Steel, EntitiesList.Steel);
		else if(type == Type.THORIUM) return getItemStacks(ItemsList.Thorium, BlocksList.Thorium, EntitiesList.Thorium);
		else if(type == Type.TITANIUM) return getItemStacks(ItemsList.Titanium, BlocksList.Titanium, EntitiesList.Titanium);
		else if(type == Type.TUNGSTEN) return getItemStacks(ItemsList.Tungsten, BlocksList.Tungsten, EntitiesList.Tungsten);
		else if(type == Type.URANIUM) return getItemStacks(ItemsList.Uranium, BlocksList.Uranium, EntitiesList.Uranium);
		else if(type == Type.VIBRANT_ALLOY) return getItemStacks(ItemsList.VibrantAlloy, BlocksList.VibrantAlloy, EntitiesList.VibrantAlloy);
		else if(type == Type.ZINC) return getItemStacks(ItemsList.Zinc, BlocksList.Zinc, EntitiesList.Zinc);
		else if(type == Type.ABYSSALNITE) return getItemStacks(ItemsList.Abyssalnite, BlocksList.Abyssalnite, EntitiesList.Abyssalnite);
		else if(type == Type.ADAMANTINE) return getItemStacks(ItemsList.Adamantine, BlocksList.Adamantine, EntitiesList.Adamantine);
		else if(type == Type.APATITE) return getItemStacks(ItemsList.Apatite, BlocksList.Apatite, EntitiesList.Apatite);
		else if(type == Type.AQUARIUM) return getItemStacks(ItemsList.Aquarium, BlocksList.Aquarium, EntitiesList.Aquarium);
		else if(type == Type.BASALT) return getItemStacks(ItemsList.Basalt, BlocksList.Basalt, EntitiesList.Basalt);
		else if(type == Type.COLD_IRON) return getItemStacks(ItemsList.ColdIron, BlocksList.ColdIron, EntitiesList.ColdIron);
		else if(type == Type.COMPRESSED_IRON) return getItemStacks(ItemsList.CompressedIron, BlocksList.CompressedIron, EntitiesList.CompressedIron);
		else if(type == Type.CORALIUM) return getItemStacks(ItemsList.Coralium, BlocksList.Coralium, EntitiesList.Coralium);
		else if(type == Type.DAWNSTONE) return getItemStacks(ItemsList.Dawnstone, BlocksList.Dawnstone, EntitiesList.Dawnstone);
		else if(type == Type.DESH) return getItemStacks(ItemsList.Desh, BlocksList.Desh, EntitiesList.Desh);
		else if(type == Type.DREADIUM) return getItemStacks(ItemsList.Dreadium, BlocksList.Dreadium, EntitiesList.Dreadium);
		else if(type == Type.END) return getItemStacks(ItemsList.End, BlocksList.End, EntitiesList.End);
		else if(type == Type.FIERY_INGOT) return getItemStacks(ItemsList.Fiery, BlocksList.Fiery, EntitiesList.Fiery);
		else if(type == Type.FLUXED_ELECTRUM) return getItemStacks(ItemsList.FluxedElectrum, BlocksList.FluxedElectrum, EntitiesList.FluxedElectrum);
		else if(type == Type.JADE) return getItemStacks(ItemsList.Jade, BlocksList.Jade, EntitiesList.Jade);
		else if(type == Type.KNIGHTMETAL) return getItemStacks(ItemsList.Knightmetal, BlocksList.Knightmetal, EntitiesList.Knightmetal);
		else if(type == Type.NETHER) return getItemStacks(ItemsList.Nether, BlocksList.Nether, EntitiesList.Nether);
		else if(type == Type.OCTINE) return getItemStacks(ItemsList.Octine, BlocksList.Octine, EntitiesList.Octine);
		else if(type == Type.SLIMY_BONE) return getItemStacks(ItemsList.SlimyBone, BlocksList.SlimyBone, EntitiesList.SlimyBone);
		else if(type == Type.STAR_STEEL) return getItemStacks(ItemsList.StarSteel, BlocksList.StarSteel, EntitiesList.StarSteel);
		else if(type == Type.STEELEAF) return getItemStacks(ItemsList.Steeleaf, BlocksList.Steeleaf, EntitiesList.Steeleaf);
		else if(type == Type.SYRMORITE) return getItemStacks(ItemsList.Syrmorite, BlocksList.Syrmorite, EntitiesList.Syrmorite);
		else if(type == Type.THAUMIUM) return getItemStacks(ItemsList.Thaumium, BlocksList.Thaumium, EntitiesList.Thaumium);
		else if(type == Type.TRITANIUM) return getItemStacks(ItemsList.Tritanium, BlocksList.Tritanium, EntitiesList.Tritanium);
		else if(type == Type.VALONITE) return getItemStacks(ItemsList.Valonite, BlocksList.Valonite, EntitiesList.Valonite);
		else if(type == Type.VOID_METAL) return getItemStacks(ItemsList.VoidMetal, BlocksList.VoidMetal, EntitiesList.VoidMetal);
		else if(type == Type.AMBER) return getItemStacks(ItemsList.Amber, BlocksList.Amber, EntitiesList.Amber);
		else if(type == Type.CERTUS_QUARTZ) return getItemStacks(ItemsList.CertusQuartz, BlocksList.CertusQuartz, EntitiesList.CertusQuartz);
		else if(type == Type.DARK_GEM) return getItemStacks(ItemsList.DarkGem, BlocksList.DarkGem, EntitiesList.DarkGem);
		else if(type == Type.ELEMENTIUM) return getItemStacks(ItemsList.Elementium, BlocksList.Elementium, EntitiesList.Elementium);
		else if(type == Type.ENDER_AMETHYST) return getItemStacks(ItemsList.EnderAmethyst, BlocksList.EnderAmethyst, EntitiesList.EnderAmethyst);
		else if(type == Type.ENDER_BIOTITE) return getItemStacks(ItemsList.EnderBiotite, BlocksList.EnderBiotite, EntitiesList.EnderBiotite);
		else if(type == Type.FLUIX) return getItemStacks(ItemsList.Fluix, BlocksList.Fluix, EntitiesList.Fluix);
		else if(type == Type.IRONWOOD) return getItemStacks(ItemsList.IronWood, BlocksList.IronWood, EntitiesList.IronWood);
		else if(type == Type.MALACHITE) return getItemStacks(ItemsList.Malachite, BlocksList.Malachite, EntitiesList.Malachite);
		else if(type == Type.MANASTEEL) return getItemStacks(ItemsList.Manasteel, BlocksList.Manasteel, EntitiesList.Manasteel);
		else if(type == Type.MENRIL) return getItemStacks(ItemsList.Menril, BlocksList.Menril, EntitiesList.Menril);
		else if(type == Type.METEORIC_IRON) return getItemStacks(ItemsList.MeteoricIron, BlocksList.MeteoricIron, EntitiesList.MeteoricIron);
		else if(type == Type.QUARTZ_ENRICHED_IRON) return getItemStacks(ItemsList.QuartzEnrichedIron, BlocksList.QuartzEnrichedIron, EntitiesList.QuartzEnrichedIron);
		else if(type == Type.ROCK_CRYSTAL) return getItemStacks(ItemsList.RockCrystal, BlocksList.RockCrystal, EntitiesList.RockCrystal);
		else if(type == Type.SKY_STONE) return getItemStacks(ItemsList.SkyStone, BlocksList.SkyStone, EntitiesList.SkyStone);
		else if(type == Type.TANZANITE) return getItemStacks(ItemsList.Tanzanite, BlocksList.Tanzanite, EntitiesList.Tanzanite);
		else if(type == Type.TERRASTEEL) return getItemStacks(ItemsList.Terrasteel, BlocksList.Terrasteel, EntitiesList.Terrasteel);
		else if(type == Type.TOPAZ) return getItemStacks(ItemsList.Topaz, BlocksList.Topaz, EntitiesList.Topaz);
		else if(type == Type.BLUE_TOPAZ) return getItemStacks(ItemsList.BlueTopaz, BlocksList.BlueTopaz, EntitiesList.BlueTopaz);
		else if(type == Type.CHIMERITE) return getItemStacks(ItemsList.Chimerite, BlocksList.Chimerite, EntitiesList.Chimerite);
		else if(type == Type.GRAPHITE) return getItemStacks(ItemsList.Graphite, BlocksList.Graphite, EntitiesList.Graphite);
		else if(type == Type.MOONSTONE) return getItemStacks(ItemsList.Moonstone, BlocksList.Moonstone, EntitiesList.Moonstone);
		else if(type == Type.SUNSTONE) return getItemStacks(ItemsList.Sunstone, BlocksList.Sunstone, EntitiesList.Sunstone);
		else if(type == Type.VINTEUM) return getItemStacks(ItemsList.Vinteum, BlocksList.Vinteum, EntitiesList.Vinteum);
		else if(type == Type.YELLORIUM) return getItemStacks(ItemsList.Yellorium, BlocksList.Yellorium, EntitiesList.Yellorium);
		else if(type == Type.MYSTICAL_FLOWER) return getItemStacks(ItemsList.MysticalFlower, BlocksList.MysticalFlower, EntitiesList.MysticalFlower);
		else if(type == Type.WATER) return getItemStacks(ItemsList.Water, BlocksList.Water, EntitiesList.Water);
		else if(type == Type.FIRE) return getItemStacks(ItemsList.Fire, BlocksList.Fire, EntitiesList.Fire);
		else if(type == Type.AQUAMARINE) return getItemStacks(ItemsList.Aquamarine, BlocksList.Aquamarine, EntitiesList.Aquamarine);
		else if(type == Type.DILITHIUM) return getItemStacks(ItemsList.Dilithium, BlocksList.Dilithium, EntitiesList.Dilithium);
		else if(type == Type.IRIDIUM_ORE) return getItemStacks(ItemsList.IridiumOre, BlocksList.IridiumOre, EntitiesList.IridiumOre);
		else if(type == Type.STARMETAL) return getItemStacks(ItemsList.Starmetal, BlocksList.Starmetal, EntitiesList.Starmetal);
		else if(type == Type.URANIUM_238) return getItemStacks(ItemsList.Uranium238, BlocksList.Uranium238, EntitiesList.Uranium238);
		else if(type == Type.QUICKSILVER) return getItemStacks(ItemsList.Quicksilver, BlocksList.Quicksilver, EntitiesList.Quicksilver);
		else if(type == Type.SILICON) return getItemStacks(ItemsList.Silicon, BlocksList.Silicon, EntitiesList.Silicon);
		else if(type == Type.BASALZ) return getItemStacks(ItemsList.Basalz, BlocksList.Basalz, EntitiesList.Basalz);
		else if(type == Type.BLAZE) return getItemStacks(ItemsList.Blaze, BlocksList.Blaze, EntitiesList.Blaze);
		else if(type == Type.BLITZ) return getItemStacks(ItemsList.Blitz, BlocksList.Blitz, EntitiesList.Blitz);
		else if(type == Type.BLIZZ) return getItemStacks(ItemsList.Blizz, BlocksList.Blizz, EntitiesList.Blizz);
		else if(type == Type.CHICKEN) return getItemStacks(ItemsList.Chicken, BlocksList.Chicken, EntitiesList.Chicken);
		else if(type == Type.COW) return getItemStacks(ItemsList.Cow, BlocksList.Cow, EntitiesList.Cow);
		else if(type == Type.CREEPER) return getItemStacks(ItemsList.Creeper, BlocksList.Creeper, EntitiesList.Creeper);
		else if(type == Type.ENDERMAN) return getItemStacks(ItemsList.Enderman, BlocksList.Enderman, EntitiesList.Enderman);
		else if(type == Type.GHAST) return getItemStacks(ItemsList.Ghast, BlocksList.Ghast, EntitiesList.Ghast);
		else if(type == Type.GUARDIAN) return getItemStacks(ItemsList.Guardian, BlocksList.Guardian, EntitiesList.Guardian);
		else if(type == Type.PIG) return getItemStacks(ItemsList.Pig, BlocksList.Pig, EntitiesList.Pig);
		else if(type == Type.RABBIT) return getItemStacks(ItemsList.Rabbit, BlocksList.Rabbit, EntitiesList.Rabbit);
		else if(type == Type.SHEEP) return getItemStacks(ItemsList.Sheep, BlocksList.Sheep, EntitiesList.Sheep);
		else if(type == Type.SKELETON) return getItemStacks(ItemsList.Skeleton, BlocksList.Skeleton, EntitiesList.Skeleton);
		else if(type == Type.SPIDER) return getItemStacks(ItemsList.Spider, BlocksList.Spider, EntitiesList.Spider);
		else if(type == Type.WITHER_SKELETON) return getItemStacks(ItemsList.WitherSkeleton, BlocksList.WitherSkeleton, EntitiesList.WitherSkeleton);
		else if(type == Type.ZOMBIE) return getItemStacks(ItemsList.Zombie, BlocksList.Zombie, EntitiesList.Zombie);
		return allItems;
	}
	
	public static List<ItemStack> getItemStacks(List<ItemStack> itemsList, List<Block> blocksList, List<ResourceLocation> entitiesList){
		List<ItemStack> allItems = new ArrayList<ItemStack>();
		for(ItemStack item : itemsList) {
			allItems.add(item);
		}
		for(Block block : blocksList) {
			if(Block.isEqualTo(block, Blocks.WATER)) allItems.add(new ItemStack(Items.WATER_BUCKET));
			else if(Block.isEqualTo(block, Blocks.LAVA)) allItems.add(new ItemStack(Items.LAVA_BUCKET));
			else allItems.add(new ItemStack(Item.getItemFromBlock(block)));
		}
		for(ResourceLocation entity : entitiesList) {
			allItems.add(getSpawnEgg(entity));
		}
		return allItems;
	}
	
	public static ItemStack getSpawnEgg(ResourceLocation entity){
		ItemStack egg = new ItemStack(Items.SPAWN_EGG);
        ItemMonsterPlacer.applyEntityIdToItemStack(egg, entity);
		return egg;
	}
	
}
