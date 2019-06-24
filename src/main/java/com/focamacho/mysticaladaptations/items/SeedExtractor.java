package com.focamacho.mysticaladaptations.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;
import javax.sound.midi.Soundbank;

import com.blakebr0.mysticalagriculture.lib.CropType;
import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.IHasModel;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.google.common.collect.Multimap;
import com.focamacho.mysticaladaptations.util.BlockCheck;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.functions.SetAttributes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import scala.reflect.api.Trees.TryExtractor;

public class SeedExtractor extends Item implements IHasModel{

	public ToolMaterial toolMaterial;
	NBTTagCompound tier = new NBTTagCompound();
	
	public SeedExtractor(String name, ToolMaterial material, int durability, int tier, boolean register) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxDamage(durability);
		setCreativeTab(Main.tabMysticalAdaptations);
		setMaxStackSize(1);
		this.toolMaterial = material;
		this.tier.setInteger("tier", tier);
		if(register) ModItems.ITEMS.add(this);
	}
	
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        ItemStack seed = null;
        
    	ItemStack itemstack = player.getHeldItem(hand);
        RayTraceResult raytraceresult = this.rayTrace(worldIn, player, true);
        BlockPos pos = null;

        if (raytraceresult == null) return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK) return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        else {
	        pos = raytraceresult.getBlockPos();
	        IBlockState iblockstate = worldIn.getBlockState(pos);
	        ItemStack blockItem = iblockstate.getBlock().getPickBlock(iblockstate, raytraceresult, worldIn, pos, player);
	       	if(player.canPlayerEdit(pos, raytraceresult.sideHit, itemstack)) {
		       if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Dirt, Type.DIRT)) seed = returnSeedItem(Type.DIRT);
		       else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Wood, Type.WOOD)) seed = returnSeedItem(Type.WOOD);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Stone, Type.STONE)) seed = returnSeedItem(Type.STONE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Nature, Type.NATURE)) seed = returnSeedItem(Type.NATURE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Copper, Type.COPPER)) seed = returnSeedItem(Type.COPPER);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Tin, Type.TIN)) seed = returnSeedItem(Type.TIN);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Platinum, Type.PLATINUM)) seed = returnSeedItem(Type.PLATINUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Alubrass, Type.ALUMINUM_BRASS)) seed = returnSeedItem(Type.ALUMINUM_BRASS);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Aluminum, Type.ALUMINUM)) seed = returnSeedItem(Type.ALUMINUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Alumite, Type.ALUMITE)) seed = returnSeedItem(Type.ALUMITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Ardite, Type.ARDITE)) seed = returnSeedItem(Type.ARDITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.QuartzBlack, Type.BLACK_QUARTZ)) seed = returnSeedItem(Type.BLACK_QUARTZ);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Boron, Type.BORON)) seed = returnSeedItem(Type.BORON);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Brass, Type.BRASS)) seed = returnSeedItem(Type.BRASS);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Bronze, Type.BRONZE)) seed = returnSeedItem(Type.BRONZE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Chrome, Type.CHROME)) seed = returnSeedItem(Type.CHROME);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Coal, Type.COAL)) seed = returnSeedItem(Type.COAL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Cobalt, Type.COBALT)) seed = returnSeedItem(Type.COBALT);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.ConductiveIron, Type.CONDUCTIVE_IRON)) seed = returnSeedItem(Type.CONDUCTIVE_IRON);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Constantan, Type.CONSTANTAN)) seed = returnSeedItem(Type.CONSTANTAN);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.DarkSteel, Type.DARK_STEEL)) seed = returnSeedItem(Type.DARK_STEEL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Diamond, Type.DIAMOND)) seed = returnSeedItem(Type.DIAMOND);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Draconium, Type.DRACONIUM)) seed = returnSeedItem(Type.DRACONIUM);
			   else if(checkNonSolidBlock(iblockstate.getBlock(), BlockCheck.Dye) && verifyTier(Type.DYE, itemstack)) seed = returnSeedItem(Type.DYE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.ElectricalSteel, Type.ELECTRICAL_STEEL)) seed = returnSeedItem(Type.ELECTRICAL_STEEL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Electrum, Type.ELECTRUM)) seed = returnSeedItem(Type.ELECTRUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Emerald, Type.EMERALD)) seed = returnSeedItem(Type.EMERALD);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.EndSteel, Type.END_STEEL)) seed = returnSeedItem(Type.END_STEEL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Enderium, Type.ENDERIUM)) seed = returnSeedItem(Type.ENDERIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.EnergeticAlloy, Type.ENERGETIC_ALLOY)) seed = returnSeedItem(Type.ENERGETIC_ALLOY);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.RefinedGlowstone, Type.GLOWSTONE_INGOT)) seed = returnSeedItem(Type.GLOWSTONE_INGOT);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Glowstone, Type.GLOWSTONE)) seed = returnSeedItem(Type.GLOWSTONE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Gold, Type.GOLD)) seed = returnSeedItem(Type.GOLD);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.InfinityDust, Type.GRAINS_OF_INFINITY)) seed = returnSeedItem(Type.GRAINS_OF_INFINITY);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Ice, Type.ICE)) seed = returnSeedItem(Type.ICE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Invar, Type.INVAR)) seed = returnSeedItem(Type.INVAR);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Iridium, Type.IRIDIUM)) seed = returnSeedItem(Type.IRIDIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Iron, Type.IRON)) seed = returnSeedItem(Type.IRON);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Knightslime, Type.KNIGHTSLIME)) seed = returnSeedItem(Type.KNIGHTSLIME);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Lapis, Type.LAPIS_LAZULI)) seed = returnSeedItem(Type.LAPIS_LAZULI);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Lead, Type.LEAD)) seed = returnSeedItem(Type.LEAD);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Limestone, Type.LIMESTONE)) seed = returnSeedItem(Type.LIMESTONE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Lithium, Type.LITHIUM)) seed = returnSeedItem(Type.LITHIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Lumium, Type.LUMIUM)) seed = returnSeedItem(Type.LUMIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Magnesium, Type.MAGNESIUM)) seed = returnSeedItem(Type.MAGNESIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Manyullyn, Type.MANYULLYN)) seed = returnSeedItem(Type.MANYULLYN);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Marble, Type.MARBLE)) seed = returnSeedItem(Type.MARBLE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Mithril, Type.MITHRIL)) seed = returnSeedItem(Type.MITHRIL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Quartz, Type.NETHER_QUARTZ)) seed = returnSeedItem(Type.NETHER_QUARTZ);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Nickel, Type.NICKEL)) seed = returnSeedItem(Type.NICKEL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Obsidian, Type.OBSIDIAN)) seed = returnSeedItem(Type.OBSIDIAN);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Osmium, Type.OSMIUM)) seed = returnSeedItem(Type.OSMIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Peridot, Type.PERIDOT)) seed = returnSeedItem(Type.PERIDOT);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.PulsatingIron, Type.PULSATING_IRON)) seed = returnSeedItem(Type.PULSATING_IRON);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.RedstoneAlloy, Type.REDSTONE_ALLOY)) seed = returnSeedItem(Type.REDSTONE_ALLOY);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Redstone, Type.REDSTONE)) seed = returnSeedItem(Type.REDSTONE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.RefinedObsidian, Type.REFINED_OBSIDIAN)) seed = returnSeedItem(Type.REFINED_OBSIDIAN);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Ruby, Type.RUBY)) seed = returnSeedItem(Type.RUBY);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Sapphire, Type.SAPPHIRE)) seed = returnSeedItem(Type.SAPPHIRE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Signalum, Type.SIGNALUM)) seed = returnSeedItem(Type.SIGNALUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Silver, Type.SILVER)) seed = returnSeedItem(Type.SILVER);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Slate, Type.SLATE)) seed = returnSeedItem(Type.SLATE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Slime, Type.SLIME)) seed = returnSeedItem(Type.SLIME);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Soularium, Type.SOULARIUM)) seed = returnSeedItem(Type.SOULARIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Steel, Type.STEEL)) seed = returnSeedItem(Type.STEEL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Thorium, Type.THORIUM)) seed = returnSeedItem(Type.THORIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Titanium, Type.TITANIUM)) seed = returnSeedItem(Type.TITANIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Tungsten, Type.TUNGSTEN)) seed = returnSeedItem(Type.TUNGSTEN);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Uranium, Type.URANIUM)) seed = returnSeedItem(Type.URANIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.VibrantAlloy, Type.VIBRANT_ALLOY)) seed = returnSeedItem(Type.VIBRANT_ALLOY);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Zinc, Type.ZINC)) seed = returnSeedItem(Type.ZINC);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Abyssalnite, Type.ABYSSALNITE)) seed = returnSeedItem(Type.ABYSSALNITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Adamantine, Type.ADAMANTINE)) seed = returnSeedItem(Type.ADAMANTINE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Apatite, Type.APATITE)) seed = returnSeedItem(Type.APATITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Aquarium, Type.AQUARIUM)) seed = returnSeedItem(Type.AQUARIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Basalt, Type.BASALT)) seed = returnSeedItem(Type.BASALT);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.ColdIron, Type.COLD_IRON)) seed = returnSeedItem(Type.COLD_IRON);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.CompressedIron, Type.COMPRESSED_IRON)) seed = returnSeedItem(Type.COMPRESSED_IRON);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Coralium, Type.CORALIUM)) seed = returnSeedItem(Type.CORALIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Dawstone, Type.DAWNSTONE)) seed = returnSeedItem(Type.DAWNSTONE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Desh, Type.DESH)) seed = returnSeedItem(Type.DESH);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Dreadium, Type.DREADIUM)) seed = returnSeedItem(Type.DREADIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.EndStone, Type.END)) seed = returnSeedItem(Type.END);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Fiery, Type.FIERY_INGOT)) seed = returnSeedItem(Type.FIERY_INGOT);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.FluxedElectrum, Type.FLUXED_ELECTRUM)) seed = returnSeedItem(Type.FLUXED_ELECTRUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Jade, Type.JADE)) seed = returnSeedItem(Type.JADE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Knightmetal, Type.KNIGHTMETAL)) seed = returnSeedItem(Type.KNIGHTMETAL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Netherrack, Type.NETHER)) seed = returnSeedItem(Type.NETHER);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Octine, Type.OCTINE)) seed = returnSeedItem(Type.OCTINE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.SlimyBone, Type.SLIMY_BONE)) seed = returnSeedItem(Type.SLIMY_BONE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.StarSteel, Type.STAR_STEEL)) seed = returnSeedItem(Type.STAR_STEEL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Steeleaf, Type.STEELEAF)) seed = returnSeedItem(Type.STEELEAF);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Syrmorite, Type.SYRMORITE)) seed = returnSeedItem(Type.SYRMORITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Thaumium, Type.THAUMIUM)) seed = returnSeedItem(Type.THAUMIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Tritanium, Type.TRITANIUM)) seed = returnSeedItem(Type.TRITANIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Valonite, Type.VALONITE)) seed = returnSeedItem(Type.VALONITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.VoidMetal, Type.VOID_METAL)) seed = returnSeedItem(Type.VOID_METAL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Amber, Type.AMBER)) seed = returnSeedItem(Type.AMBER);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.CertusQuartz, Type.CERTUS_QUARTZ)) seed = returnSeedItem(Type.CERTUS_QUARTZ);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.DarkGem, Type.DARK_GEM)) seed = returnSeedItem(Type.DARK_GEM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Elementium, Type.ELEMENTIUM)) seed = returnSeedItem(Type.ELEMENTIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.EnderAmethyst, Type.ENDER_AMETHYST)) seed = returnSeedItem(Type.ENDER_AMETHYST);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.EnderBiotite, Type.ENDER_BIOTITE)) seed = returnSeedItem(Type.ENDER_BIOTITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Fluix, Type.FLUIX)) seed = returnSeedItem(Type.FLUIX);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.IronWood, Type.IRONWOOD)) seed = returnSeedItem(Type.IRONWOOD);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Malachite, Type.MALACHITE)) seed = returnSeedItem(Type.MALACHITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Manasteel, Type.MANASTEEL)) seed = returnSeedItem(Type.MANASTEEL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Menril, Type.MENRIL)) seed = returnSeedItem(Type.MENRIL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.MeteoricIron, Type.METEORIC_IRON)) seed = returnSeedItem(Type.METEORIC_IRON);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.QuartzEnrichedIron, Type.QUARTZ_ENRICHED_IRON)) seed = returnSeedItem(Type.QUARTZ_ENRICHED_IRON);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.RockCrystal, Type.ROCK_CRYSTAL)) seed = returnSeedItem(Type.ROCK_CRYSTAL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.SkyStone, Type.SKY_STONE)) seed = returnSeedItem(Type.SKY_STONE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Tanzanite, Type.TANZANITE)) seed = returnSeedItem(Type.TANZANITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Terrasteel, Type.TERRASTEEL)) seed = returnSeedItem(Type.TERRASTEEL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Topaz, Type.TOPAZ)) seed = returnSeedItem(Type.TOPAZ);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.BlueTopaz, Type.BLUE_TOPAZ)) seed = returnSeedItem(Type.BLUE_TOPAZ);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Chimerite, Type.CHIMERITE)) seed = returnSeedItem(Type.CHIMERITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Graphite, Type.GRAPHITE)) seed = returnSeedItem(Type.GRAPHITE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Moonstone, Type.MOONSTONE)) seed = returnSeedItem(Type.MOONSTONE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Sunstone, Type.SUNSTONE)) seed = returnSeedItem(Type.SUNSTONE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Vinteum, Type.VINTEUM)) seed = returnSeedItem(Type.VINTEUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Yellorium, Type.YELLORIUM)) seed = returnSeedItem(Type.YELLORIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.MysticalFlower, Type.MYSTICAL_FLOWER)) seed = returnSeedItem(Type.MYSTICAL_FLOWER);
			   else if(checkNonSolidBlock(iblockstate.getBlock(), BlockCheck.Water) && verifyTier(Type.WATER, itemstack)) seed = returnSeedItem(Type.WATER);
			   else if(checkNonSolidBlock(iblockstate.getBlock(), BlockCheck.Fire) && verifyTier(Type.FIRE, itemstack)) seed = returnSeedItem(Type.FIRE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Aquamarine, Type.AQUAMARINE)) seed = returnSeedItem(Type.AQUAMARINE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Dilithium, Type.DILITHIUM)) seed = returnSeedItem(Type.DILITHIUM);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.IridiumOre, Type.IRIDIUM_ORE)) seed = returnSeedItem(Type.IRIDIUM_ORE);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Rubber, Type.RUBBER)) seed = returnSeedItem(Type.RUBBER);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Starmetal, Type.STARMETAL)) seed = returnSeedItem(Type.STARMETAL);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Uranium238, Type.URANIUM_238)) seed = returnSeedItem(Type.URANIUM_238);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Quicksilver, Type.QUICKSILVER)) seed = returnSeedItem(Type.QUICKSILVER);
			   else if(checkBlockAndTier(itemstack, blockItem, BlockCheck.Silicon, Type.SILICON)) seed = returnSeedItem(Type.SILICON);
			   else if(ModCheck.MYSTICAL_AGRADDITIONS) {
				   if(verifyTier(6, itemstack)) {
					   if(checkBlock(blockItem, BlockCheck.Netherstar)) seed = new ItemStack(Item.getByNameOrId("mysticalagradditions:nether_star_seeds"));
					   else if(checkBlock(blockItem, BlockCheck.Awakened)) seed = new ItemStack(Item.getByNameOrId("mysticalagradditions:awakened_draconium_seeds"));
					   else if(checkNonSolidBlock(iblockstate.getBlock(), BlockCheck.DragonEgg)) seed = new ItemStack(Item.getByNameOrId("mysticalagradditions:dragon_egg_seeds"));
					   else if(checkBlock(blockItem, BlockCheck.Neutronium)) seed = new ItemStack(Item.getByNameOrId("mysticalagradditions:neutronium_seeds"));
				   }
			   }
		       
		       if(seed != null) {
		    	   if(!worldIn.isRemote) {
		    		   seedExtractorUse(worldIn, player, itemstack, seed, pos);
		    	   } else {
		    		   spawnParticles(pos, worldIn, EnumParticleTypes.BLOCK_CRACK, iblockstate);
		    	   }
		    	   worldIn.playSound(null, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
		    	   return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	        	}
		   }
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
    }
    
	public ItemStack returnSeedItem(CropType.Type seed) {
		return new ItemStack(seed.getSeed());
	}
	
	public void seedExtractorUse(World worldIn, EntityPlayer player, ItemStack extractor, ItemStack seed, BlockPos pos) {
      	worldIn.setBlockToAir(pos);
      	EntityItem seedDrop = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), seed);
		player.getCooldownTracker().setCooldown(extractor.getItem(), 20);
	    worldIn.spawnEntity(seedDrop);
	    extractor.damageItem(1, player);
	}
	
	public boolean verifyTier(CropType.Type seed, ItemStack extractor) {
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
	
	public boolean verifyTier(int tier, ItemStack extractor) {
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
	
	public boolean checkBlockAndTier(ItemStack extractor, ItemStack blockItem, List<ItemStack> blockList, CropType.Type seed) {
		if(checkBlock(blockItem, blockList) && verifyTier(seed, extractor) && seed.isEnabled()) return true;
		else return false;
	}
	
	public boolean checkBlock(ItemStack blockItem, List<ItemStack> blockList) {
		if(blockList == null || blockList.isEmpty()) return false;
		else {
			for(ItemStack item : blockList) {
				if(OreDictionary.itemMatches(item, blockItem, false)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkNonSolidBlock(Block block, List<Block> blockList) {
		if(blockList == null || blockList.isEmpty()) return false;
		else {
			for(Block b : blockList) {
				if(b == block) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void spawnParticles(BlockPos pos, World world, EnumParticleTypes particleType, IBlockState state) {
		Random rand = new Random();

		for (int k = 0; k < 20; ++k) {
			double xCoord = pos.getX() + (rand.nextDouble() * 0.6D) - 0.3D;
			double yCoord = pos.getY() + (rand.nextDouble() * 0.6D);
			double zCoord = pos.getZ() + (rand.nextDouble() * 0.6D) - 0.3D;
			double xSpeed = rand.nextGaussian() * 0.02D;
			double ySpeed = rand.nextGaussian() * 0.2D;
			double zSpeed = rand.nextGaussian() * 0.02D;
			world.spawnParticle(particleType, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed, Block.getStateId(state));
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flagIn) {
		switch(tier.getInteger("tier")) {
			case 1:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.YELLOW + tier.getInteger("tier"));
				break;
			case 2:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.GREEN + tier.getInteger("tier"));
				break;
			case 3:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.GOLD + tier.getInteger("tier"));
				break;
			case 4:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.AQUA + tier.getInteger("tier"));
				break;
			case 5:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.RED + tier.getInteger("tier"));
				break;
			case 6:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.DARK_PURPLE + tier.getInteger("tier"));
				break;
		}
		if(!itemstack.hasTagCompound()) itemstack.setTagCompound(new NBTTagCompound());
		if(!itemstack.getTagCompound().hasKey("tier")) itemstack.setTagCompound(this.tier);
	}
	
	@Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot){
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if(equipmentSlot == EntityEquipmentSlot.MAINHAND){
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.toolMaterial.getAttackDamage() - 1.0F, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3.4D, 0));
        }
        return multimap;
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
		
}
