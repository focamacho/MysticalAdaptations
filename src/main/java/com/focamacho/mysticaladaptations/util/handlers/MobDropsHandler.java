package com.focamacho.mysticaladaptations.util.handlers;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.blakebr0.mysticalagriculture.lib.CropType;
import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.blakebr0.mysticalagriculture.util.ModChecker;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.items.SeedExtractor;
import com.focamacho.mysticaladaptations.lib.EntitiesList;
import com.focamacho.mysticaladaptations.util.ModCheck;

import cofh.thermalfoundation.entity.monster.EntityBasalz;
import cofh.thermalfoundation.entity.monster.EntityBlitz;
import cofh.thermalfoundation.entity.monster.EntityBlizz;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropsHandler{

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event){
    	if(event.isRecentlyHit() && event.getSource().getTrueSource() != null && event.getSource().getTrueSource() instanceof EntityPlayer) {
    		EntityLivingBase player = ((EntityPlayer) event.getSource().getTrueSource());
			ItemStack weapon = ((EntityPlayer) event.getSource().getTrueSource()).getHeldItemMainhand();
			if(!weapon.isEmpty() && weapon.getItem() instanceof SeedExtractor) {
				if(ModConfig.MOB_SEED_DROP) {
					if(verifyEntity(event.getEntityLiving(), EntitiesList.Water) && checkTier(Type.WATER, weapon)) dropItem(event, returnSeedItem(Type.WATER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Wood) && checkTier(Type.WOOD, weapon)) dropItem(event, returnSeedItem(Type.WOOD), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Copper) && checkTier(Type.COPPER, weapon)) dropItem(event, returnSeedItem(Type.COPPER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Tin) && checkTier(Type.TIN, weapon)) dropItem(event, returnSeedItem(Type.TIN), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Platinum) && checkTier(Type.PLATINUM, weapon)) dropItem(event, returnSeedItem(Type.PLATINUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Alubrass) && checkTier(Type.ALUMINUM_BRASS, weapon)) dropItem(event, returnSeedItem(Type.ALUMINUM_BRASS), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Aluminum) && checkTier(Type.ALUMINUM, weapon)) dropItem(event, returnSeedItem(Type.ALUMINUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Alumite) && checkTier(Type.ALUMITE, weapon)) dropItem(event, returnSeedItem(Type.ALUMITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Ardite) && checkTier(Type.ARDITE, weapon)) dropItem(event, returnSeedItem(Type.ARDITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.QuartzBlack) && checkTier(Type.BLACK_QUARTZ, weapon)) dropItem(event, returnSeedItem(Type.BLACK_QUARTZ), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Boron) && checkTier(Type.BORON, weapon)) dropItem(event, returnSeedItem(Type.BORON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Brass) && checkTier(Type.BRASS, weapon)) dropItem(event, returnSeedItem(Type.BRASS), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Bronze) && checkTier(Type.BRONZE, weapon)) dropItem(event, returnSeedItem(Type.BRONZE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Chrome) && checkTier(Type.CHROME, weapon)) dropItem(event, returnSeedItem(Type.CHROME), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Coal) && checkTier(Type.COAL, weapon)) dropItem(event, returnSeedItem(Type.COAL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Cobalt) && checkTier(Type.COBALT, weapon)) dropItem(event, returnSeedItem(Type.COBALT), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.ConductiveIron) && checkTier(Type.CONDUCTIVE_IRON, weapon)) dropItem(event, returnSeedItem(Type.CONDUCTIVE_IRON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Constantan) && checkTier(Type.CONSTANTAN, weapon)) dropItem(event, returnSeedItem(Type.CONSTANTAN), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.DarkSteel) && checkTier(Type.DARK_STEEL, weapon)) dropItem(event, returnSeedItem(Type.DARK_STEEL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Diamond) && checkTier(Type.DIAMOND, weapon)) dropItem(event, returnSeedItem(Type.DIAMOND), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Draconium) && checkTier(Type.DRACONIUM, weapon)) dropItem(event, returnSeedItem(Type.DRACONIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Dirt) && checkTier(Type.DIRT, weapon)) dropItem(event, returnSeedItem(Type.DIRT), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.ElectricalSteel) && checkTier(Type.ELECTRICAL_STEEL, weapon)) dropItem(event, returnSeedItem(Type.ELECTRICAL_STEEL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Electrum) && checkTier(Type.ELECTRUM, weapon)) dropItem(event, returnSeedItem(Type.ELECTRUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Emerald) && checkTier(Type.EMERALD, weapon)) dropItem(event, returnSeedItem(Type.EMERALD), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.EndSteel) && checkTier(Type.END_STEEL, weapon)) dropItem(event, returnSeedItem(Type.END_STEEL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Enderium) && checkTier(Type.ENDERIUM, weapon)) dropItem(event, returnSeedItem(Type.ENDERIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.EnergeticAlloy) && checkTier(Type.ENERGETIC_ALLOY, weapon)) dropItem(event, returnSeedItem(Type.ENERGETIC_ALLOY), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.RefinedGlowstone) && checkTier(Type.GLOWSTONE_INGOT, weapon)) dropItem(event, returnSeedItem(Type.GLOWSTONE_INGOT), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Glowstone) && checkTier(Type.GLOWSTONE, weapon)) dropItem(event, returnSeedItem(Type.GLOWSTONE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Gold) && checkTier(Type.GOLD, weapon)) dropItem(event, returnSeedItem(Type.GOLD), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.InfinityDust) && checkTier(Type.GRAINS_OF_INFINITY, weapon)) dropItem(event, returnSeedItem(Type.GRAINS_OF_INFINITY), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Invar) && checkTier(Type.INVAR, weapon)) dropItem(event, returnSeedItem(Type.INVAR), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Iridium) && checkTier(Type.IRIDIUM, weapon)) dropItem(event, returnSeedItem(Type.IRIDIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Iron) && checkTier(Type.IRON, weapon)) dropItem(event, returnSeedItem(Type.IRON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Knightslime) && checkTier(Type.KNIGHTSLIME, weapon)) dropItem(event, returnSeedItem(Type.KNIGHTSLIME), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Lapis) && checkTier(Type.LAPIS_LAZULI, weapon)) dropItem(event, returnSeedItem(Type.LAPIS_LAZULI), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Lead) && checkTier(Type.LEAD, weapon)) dropItem(event, returnSeedItem(Type.LEAD), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Limestone) && checkTier(Type.LIMESTONE, weapon)) dropItem(event, returnSeedItem(Type.LIMESTONE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Lithium) && checkTier(Type.LITHIUM, weapon)) dropItem(event, returnSeedItem(Type.LITHIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Lumium) && checkTier(Type.LUMIUM, weapon)) dropItem(event, returnSeedItem(Type.LUMIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Magnesium) && checkTier(Type.MAGNESIUM, weapon)) dropItem(event, returnSeedItem(Type.MAGNESIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Manyullyn) && checkTier(Type.MANYULLYN, weapon)) dropItem(event, returnSeedItem(Type.MANYULLYN), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Marble) && checkTier(Type.MARBLE, weapon)) dropItem(event, returnSeedItem(Type.MARBLE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Mithril) && checkTier(Type.MITHRIL, weapon)) dropItem(event, returnSeedItem(Type.MITHRIL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Quartz) && checkTier(Type.NETHER_QUARTZ, weapon)) dropItem(event, returnSeedItem(Type.NETHER_QUARTZ), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Nickel) && checkTier(Type.NICKEL, weapon)) dropItem(event, returnSeedItem(Type.NICKEL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Obsidian) && checkTier(Type.OBSIDIAN, weapon)) dropItem(event, returnSeedItem(Type.OBSIDIAN), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Osmium) && checkTier(Type.OSMIUM, weapon)) dropItem(event, returnSeedItem(Type.OSMIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Peridot) && checkTier(Type.PERIDOT, weapon)) dropItem(event, returnSeedItem(Type.PERIDOT), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.PulsatingIron) && checkTier(Type.PULSATING_IRON, weapon)) dropItem(event, returnSeedItem(Type.PULSATING_IRON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.RedstoneAlloy) && checkTier(Type.REDSTONE_ALLOY, weapon)) dropItem(event, returnSeedItem(Type.REDSTONE_ALLOY), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Redstone) && checkTier(Type.REDSTONE, weapon)) dropItem(event, returnSeedItem(Type.REDSTONE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.RefinedObsidian) && checkTier(Type.REFINED_OBSIDIAN, weapon)) dropItem(event, returnSeedItem(Type.REFINED_OBSIDIAN), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Ruby) && checkTier(Type.RUBY, weapon)) dropItem(event, returnSeedItem(Type.RUBY), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Sapphire) && checkTier(Type.SAPPHIRE, weapon)) dropItem(event, returnSeedItem(Type.SAPPHIRE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Signalum) && checkTier(Type.SIGNALUM, weapon)) dropItem(event, returnSeedItem(Type.SIGNALUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Silver) && checkTier(Type.SILVER, weapon)) dropItem(event, returnSeedItem(Type.SILVER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Slate) && checkTier(Type.SLATE, weapon)) dropItem(event, returnSeedItem(Type.SLATE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Slime) && checkTier(Type.SLIME, weapon)) dropItem(event, returnSeedItem(Type.SLIME), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Soularium) && checkTier(Type.SOULARIUM, weapon)) dropItem(event, returnSeedItem(Type.SOULARIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Steel) && checkTier(Type.STEEL, weapon)) dropItem(event, returnSeedItem(Type.STEEL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Thorium) && checkTier(Type.THORIUM, weapon)) dropItem(event, returnSeedItem(Type.THORIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Titanium) && checkTier(Type.TITANIUM, weapon)) dropItem(event, returnSeedItem(Type.TITANIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Tungsten) && checkTier(Type.TUNGSTEN, weapon)) dropItem(event, returnSeedItem(Type.TUNGSTEN), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Uranium) && checkTier(Type.URANIUM, weapon)) dropItem(event, returnSeedItem(Type.URANIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.VibrantAlloy) && checkTier(Type.VIBRANT_ALLOY, weapon)) dropItem(event, returnSeedItem(Type.VIBRANT_ALLOY), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Zinc) && checkTier(Type.ZINC, weapon)) dropItem(event, returnSeedItem(Type.ZINC), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Abyssalnite) && checkTier(Type.ABYSSALNITE, weapon)) dropItem(event, returnSeedItem(Type.ABYSSALNITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Adamantine) && checkTier(Type.ADAMANTINE, weapon)) dropItem(event, returnSeedItem(Type.ADAMANTINE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Apatite) && checkTier(Type.APATITE, weapon)) dropItem(event, returnSeedItem(Type.APATITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Aquarium) && checkTier(Type.AQUARIUM, weapon)) dropItem(event, returnSeedItem(Type.AQUARIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Basalt) && checkTier(Type.BASALT, weapon)) dropItem(event, returnSeedItem(Type.BASALT), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.ColdIron) && checkTier(Type.COLD_IRON, weapon)) dropItem(event, returnSeedItem(Type.COLD_IRON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.CompressedIron) && checkTier(Type.COMPRESSED_IRON, weapon)) dropItem(event, returnSeedItem(Type.COMPRESSED_IRON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Coralium) && checkTier(Type.CORALIUM, weapon)) dropItem(event, returnSeedItem(Type.CORALIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Dawnstone) && checkTier(Type.DAWNSTONE, weapon)) dropItem(event, returnSeedItem(Type.DAWNSTONE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Desh) && checkTier(Type.DESH, weapon)) dropItem(event, returnSeedItem(Type.DESH), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Dreadium) && checkTier(Type.DREADIUM, weapon)) dropItem(event, returnSeedItem(Type.DREADIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.End) && checkTier(Type.END, weapon)) dropItem(event, returnSeedItem(Type.END), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Fiery) && checkTier(Type.FIERY_INGOT, weapon)) dropItem(event, returnSeedItem(Type.FIERY_INGOT), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.FluxedElectrum) && checkTier(Type.FLUXED_ELECTRUM, weapon)) dropItem(event, returnSeedItem(Type.FLUXED_ELECTRUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Jade) && checkTier(Type.JADE, weapon)) dropItem(event, returnSeedItem(Type.JADE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Knightmetal) && checkTier(Type.KNIGHTMETAL, weapon)) dropItem(event, returnSeedItem(Type.KNIGHTMETAL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Nether) && checkTier(Type.NETHER, weapon)) dropItem(event, returnSeedItem(Type.NETHER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Octine) && checkTier(Type.OCTINE, weapon)) dropItem(event, returnSeedItem(Type.OCTINE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.SlimyBone) && checkTier(Type.SLIMY_BONE, weapon)) dropItem(event, returnSeedItem(Type.SLIMY_BONE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.StarSteel) && checkTier(Type.STAR_STEEL, weapon)) dropItem(event, returnSeedItem(Type.STAR_STEEL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Steeleaf) && checkTier(Type.STEELEAF, weapon)) dropItem(event, returnSeedItem(Type.STEELEAF), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Syrmorite) && checkTier(Type.SYRMORITE, weapon)) dropItem(event, returnSeedItem(Type.SYRMORITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Thaumium) && checkTier(Type.THAUMIUM, weapon)) dropItem(event, returnSeedItem(Type.THAUMIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Tritanium) && checkTier(Type.TRITANIUM, weapon)) dropItem(event, returnSeedItem(Type.TRITANIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Valonite) && checkTier(Type.VALONITE, weapon)) dropItem(event, returnSeedItem(Type.VALONITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.VoidMetal) && checkTier(Type.VOID_METAL, weapon)) dropItem(event, returnSeedItem(Type.VOID_METAL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Ice) && checkTier(Type.ICE, weapon)) dropItem(event, returnSeedItem(Type.ICE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Amber) && checkTier(Type.AMBER, weapon)) dropItem(event, returnSeedItem(Type.AMBER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.CertusQuartz) && checkTier(Type.CERTUS_QUARTZ, weapon)) dropItem(event, returnSeedItem(Type.CERTUS_QUARTZ), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.DarkGem) && checkTier(Type.DARK_GEM, weapon)) dropItem(event, returnSeedItem(Type.DARK_GEM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Elementium) && checkTier(Type.ELEMENTIUM, weapon)) dropItem(event, returnSeedItem(Type.ELEMENTIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.EnderAmethyst) && checkTier(Type.ENDER_AMETHYST, weapon)) dropItem(event, returnSeedItem(Type.ENDER_AMETHYST), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.EnderBiotite) && checkTier(Type.ENDER_BIOTITE, weapon)) dropItem(event, returnSeedItem(Type.ENDER_BIOTITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Fluix) && checkTier(Type.FLUIX, weapon)) dropItem(event, returnSeedItem(Type.FLUIX), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.IronWood) && checkTier(Type.IRONWOOD, weapon)) dropItem(event, returnSeedItem(Type.IRONWOOD), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Malachite) && checkTier(Type.MALACHITE, weapon)) dropItem(event, returnSeedItem(Type.MALACHITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Manasteel) && checkTier(Type.MANASTEEL, weapon)) dropItem(event, returnSeedItem(Type.MANASTEEL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Menril) && checkTier(Type.MENRIL, weapon)) dropItem(event, returnSeedItem(Type.MENRIL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.MeteoricIron) && checkTier(Type.METEORIC_IRON, weapon)) dropItem(event, returnSeedItem(Type.METEORIC_IRON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.QuartzEnrichedIron) && checkTier(Type.QUARTZ_ENRICHED_IRON, weapon)) dropItem(event, returnSeedItem(Type.QUARTZ_ENRICHED_IRON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.RockCrystal) && checkTier(Type.ROCK_CRYSTAL, weapon)) dropItem(event, returnSeedItem(Type.ROCK_CRYSTAL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.SkyStone) && checkTier(Type.SKY_STONE, weapon)) dropItem(event, returnSeedItem(Type.SKY_STONE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Tanzanite) && checkTier(Type.TANZANITE, weapon)) dropItem(event, returnSeedItem(Type.TANZANITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Terrasteel) && checkTier(Type.TERRASTEEL, weapon)) dropItem(event, returnSeedItem(Type.TERRASTEEL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Topaz) && checkTier(Type.TOPAZ, weapon)) dropItem(event, returnSeedItem(Type.TOPAZ), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.BlueTopaz) && checkTier(Type.BLUE_TOPAZ, weapon)) dropItem(event, returnSeedItem(Type.BLUE_TOPAZ), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Chimerite) && checkTier(Type.CHIMERITE, weapon)) dropItem(event, returnSeedItem(Type.CHIMERITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Graphite) && checkTier(Type.GRAPHITE, weapon)) dropItem(event, returnSeedItem(Type.GRAPHITE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Moonstone) && checkTier(Type.MOONSTONE, weapon)) dropItem(event, returnSeedItem(Type.MOONSTONE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Sunstone) && checkTier(Type.SUNSTONE, weapon)) dropItem(event, returnSeedItem(Type.SUNSTONE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Vinteum) && checkTier(Type.VINTEUM, weapon)) dropItem(event, returnSeedItem(Type.VINTEUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Yellorium) && checkTier(Type.YELLORIUM, weapon)) dropItem(event, returnSeedItem(Type.YELLORIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.MysticalFlower) && checkTier(Type.MYSTICAL_FLOWER, weapon)) dropItem(event, returnSeedItem(Type.MYSTICAL_FLOWER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Nature) && checkTier(Type.NATURE, weapon)) dropItem(event, returnSeedItem(Type.NATURE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Stone) && checkTier(Type.STONE, weapon)) dropItem(event, returnSeedItem(Type.STONE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Fire) && checkTier(Type.FIRE, weapon)) dropItem(event, returnSeedItem(Type.FIRE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Aquamarine) && checkTier(Type.AQUAMARINE, weapon)) dropItem(event, returnSeedItem(Type.AQUAMARINE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Dilithium) && checkTier(Type.DILITHIUM, weapon)) dropItem(event, returnSeedItem(Type.DILITHIUM), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.IridiumOre) && checkTier(Type.IRIDIUM_ORE, weapon)) dropItem(event, returnSeedItem(Type.IRIDIUM_ORE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Rubber) && checkTier(Type.RUBBER, weapon)) dropItem(event, returnSeedItem(Type.RUBBER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Starmetal) && checkTier(Type.STARMETAL, weapon)) dropItem(event, returnSeedItem(Type.STARMETAL), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Uranium238) && checkTier(Type.URANIUM_238, weapon)) dropItem(event, returnSeedItem(Type.URANIUM_238), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Quicksilver) && checkTier(Type.QUICKSILVER, weapon)) dropItem(event, returnSeedItem(Type.QUICKSILVER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Dye) && checkTier(Type.DYE, weapon)) dropItem(event, returnSeedItem(Type.DYE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Silicon) && checkTier(Type.SILICON, weapon)) dropItem(event, returnSeedItem(Type.SILICON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Basalz) && checkTier(Type.BASALZ, weapon)) dropItem(event, returnSeedItem(Type.BASALZ), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Blaze) && checkTier(Type.BLAZE, weapon)) dropItem(event, returnSeedItem(Type.BLAZE), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Blitz) && checkTier(Type.BLITZ, weapon)) dropItem(event, returnSeedItem(Type.BLITZ), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Blizz) && checkTier(Type.BLIZZ, weapon)) dropItem(event, returnSeedItem(Type.BLIZZ), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Chicken) && checkTier(Type.CHICKEN, weapon)) dropItem(event, returnSeedItem(Type.CHICKEN), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Cow) && checkTier(Type.COW, weapon)) dropItem(event, returnSeedItem(Type.COW), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Creeper) && checkTier(Type.CREEPER, weapon)) dropItem(event, returnSeedItem(Type.CREEPER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Enderman) && checkTier(Type.ENDERMAN, weapon)) dropItem(event, returnSeedItem(Type.ENDERMAN), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Ghast) && checkTier(Type.GHAST, weapon)) dropItem(event, returnSeedItem(Type.GHAST), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Guardian) && checkTier(Type.GUARDIAN, weapon)) dropItem(event, returnSeedItem(Type.GUARDIAN), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Pig) && checkTier(Type.PIG, weapon)) dropItem(event, returnSeedItem(Type.PIG), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Rabbit) && checkTier(Type.RABBIT, weapon)) dropItem(event, returnSeedItem(Type.RABBIT), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Sheep) && checkTier(Type.SHEEP, weapon)) dropItem(event, returnSeedItem(Type.SHEEP), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Skeleton) && checkTier(Type.SKELETON, weapon)) dropItem(event, returnSeedItem(Type.SKELETON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Spider) && checkTier(Type.SPIDER, weapon)) dropItem(event, returnSeedItem(Type.SPIDER), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.WitherSkeleton) && checkTier(Type.WITHER_SKELETON, weapon)) dropItem(event, returnSeedItem(Type.WITHER_SKELETON), weapon, player);
					else if(verifyEntity(event.getEntityLiving(), EntitiesList.Zombie) && checkTier(Type.ZOMBIE, weapon)) dropItem(event, returnSeedItem(Type.ZOMBIE), weapon, player);
					else if(ModCheck.MYSTICAL_AGRADDITIONS) {
						if(checkTier(6, weapon) || ModConfig.EXTRACTOR_ANY_TIER) {
							if(verifyEntity(event.getEntityLiving(), EntitiesList.Netherstar)) dropItem(event, new ItemStack(Item.getByNameOrId("mysticalagradditions:nether_star_seeds")), weapon, player);
							else if(verifyEntity(event.getEntityLiving(), EntitiesList.Awakened)) dropItem(event, new ItemStack(Item.getByNameOrId("mysticalagradditions:awakened_draconium_seeds")), weapon, player);
							else if(verifyEntity(event.getEntityLiving(), EntitiesList.DragonEgg)) dropItem(event, new ItemStack(Item.getByNameOrId("mysticalagradditions:dragon_egg_seeds")), weapon, player);
							else if(verifyEntity(event.getEntityLiving(), EntitiesList.Neutronium)) dropItem(event, new ItemStack(Item.getByNameOrId("mysticalagradditions:neutronium_seeds")), weapon, player);
						}
					}
				}
			}
    	}
    }
    
    public boolean verifyEntity(EntityLivingBase entity, List<ResourceLocation> resourceList) {
		if(!(resourceList == null || resourceList.isEmpty())) {
	    	for(ResourceLocation r : resourceList) {
	    		if(EntityList.getKey(entity).equals(r)) {
	    			return true;
	    		}
	    	}
		}
    	return false;
    }
    
    public void dropItem(LivingDropsEvent event, ItemStack drop, ItemStack extractor, EntityLivingBase player) {
    	EntityItem entityItem = new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, drop);
    	event.getDrops().add(entityItem);
    	extractor.damageItem(1, player);
    }
    
	public ItemStack returnSeedItem(CropType.Type seed) {
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

}