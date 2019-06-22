package com.focamacho.mysticaladaptations.util.handlers;

import java.util.Random;

import javax.annotation.Nullable;

import com.blakebr0.mysticalagriculture.lib.CropType;
import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.blakebr0.mysticalagriculture.util.ModChecker;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.items.SeedExtractor;

import cofh.thermalfoundation.entity.monster.EntityBasalz;
import cofh.thermalfoundation.entity.monster.EntityBlitz;
import cofh.thermalfoundation.entity.monster.EntityBlizz;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
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
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
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
					if(event.getEntityLiving() instanceof EntityZombie && verifyTier(Type.ZOMBIE, weapon)) {
						dropItem(event, returnSeedItem(Type.ZOMBIE), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityBlaze && verifyTier(Type.BLAZE, weapon)) {
						dropItem(event, returnSeedItem(Type.BLAZE), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityChicken && verifyTier(Type.CHICKEN, weapon)) {
						dropItem(event, returnSeedItem(Type.CHICKEN), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityCow && verifyTier(Type.COW, weapon)) {
						dropItem(event, returnSeedItem(Type.COW), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityCreeper && verifyTier(Type.CREEPER, weapon)) {
						dropItem(event, returnSeedItem(Type.CREEPER), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityEnderman && verifyTier(Type.ENDERMAN, weapon)) {
						dropItem(event, returnSeedItem(Type.ENDERMAN), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityGhast && verifyTier(Type.GHAST, weapon)) {
						dropItem(event, returnSeedItem(Type.GHAST), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityPig && verifyTier(Type.PIG, weapon)) {
						dropItem(event, returnSeedItem(Type.PIG), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityRabbit && verifyTier(Type.RABBIT, weapon)) {
						dropItem(event, returnSeedItem(Type.RABBIT), weapon, player);
					} else if(event.getEntityLiving() instanceof EntitySheep && verifyTier(Type.SHEEP, weapon)) {
						dropItem(event, returnSeedItem(Type.SHEEP), weapon, player);
					} else if(event.getEntityLiving() instanceof EntitySkeleton && verifyTier(Type.SKELETON, weapon)) {
						dropItem(event, returnSeedItem(Type.SKELETON), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityWitherSkeleton && verifyTier(Type.WITHER_SKELETON, weapon)) {
						dropItem(event, returnSeedItem(Type.WITHER_SKELETON), weapon, player);
					} else if(event.getEntityLiving() instanceof EntitySpider && verifyTier(Type.SPIDER, weapon)) {
						dropItem(event, returnSeedItem(Type.SPIDER), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityWitherSkeleton && verifyTier(Type.WITHER_SKELETON, weapon)) {
						dropItem(event, returnSeedItem(Type.WITHER_SKELETON), weapon, player);
					} else if(event.getEntityLiving() instanceof EntityGuardian && verifyTier(Type.GUARDIAN, weapon)) {
						dropItem(event, returnSeedItem(Type.GUARDIAN), weapon, player);
					} else if(ModChecker.THERMAL_FOUNDATION) {
						if(event.getEntityLiving() instanceof EntityBasalz && verifyTier(Type.BASALZ, weapon)) {
							dropItem(event, returnSeedItem(Type.BASALZ), weapon, player);
						} else if(event.getEntityLiving() instanceof EntityBlitz && verifyTier(Type.BLITZ, weapon)) {
							dropItem(event, returnSeedItem(Type.BLITZ), weapon, player);
						} else if(event.getEntityLiving() instanceof EntityBlizz && verifyTier(Type.BLIZZ, weapon)) {
							dropItem(event, returnSeedItem(Type.BLIZZ), weapon, player);
						}
					}
				}
			}
    	}
    }
    
    public void dropItem(LivingDropsEvent event, ItemStack drop, ItemStack extractor, EntityLivingBase player) {
    	EntityItem entityItem = new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, drop);
    	event.getDrops().add(entityItem);
    	extractor.damageItem(1, player);
    }
    
	public ItemStack returnSeedItem(CropType.Type seed) {
		return new ItemStack(seed.getSeed());
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

}