package com.focamacho.mysticaladaptations.util.handlers;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.items.SeedExtractor;
import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipe;
import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipes;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.Random;

public class MobDropsHandler{

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event){
    	if(event.isRecentlyHit() && event.getSource().getTrueSource() != null && event.getSource().getTrueSource() instanceof EntityPlayer) {
    		EntityLivingBase player = ((EntityPlayer) event.getSource().getTrueSource());
			ItemStack weapon = ((EntityPlayer) event.getSource().getTrueSource()).getHeldItemMainhand();
			if(!weapon.isEmpty() && weapon.getItem() instanceof SeedExtractor) {
				if(ModConfig.MOB_SEED_DROP) {
					for(SeedExtractorRecipe recipe : SeedExtractorRecipes.allRecipes) {
						if(checkRecipe(event.getEntityLiving(), recipe, weapon)) dropItem(event, recipe.getSeed(), weapon, player);
					}
				}
				if(ModConfig.EXPERIENCE_SEEDS_DROP && Type.EXPERIENCE.isEnabled()) {
					Random random = new Random();
					if(random.nextInt(100) <= ModConfig.EXPERIENCE_SEEDS_DROP_CHANCE) {
						if(ModConfig.EXPERIENCE_SEEDS_DROP_DURABILITY) dropItem(event, new ItemStack(Type.EXPERIENCE.getSeed(), 1), weapon, player);
						else dropItem(event, new ItemStack(Type.EXPERIENCE.getSeed(), 1));
					}
				}
			}
    	}
    }
    
    public boolean checkRecipe(EntityLivingBase entity, SeedExtractorRecipe recipe, ItemStack extractor) {
		return checkEntity(entity, recipe.getEntitiesList()) && checkTier(recipe.getTier(), extractor);
	}
    
    public boolean checkEntity(EntityLivingBase entity, List<ResourceLocation> resourceList) {
		if(!(resourceList == null || resourceList.isEmpty())) {
	    	for(ResourceLocation r : resourceList) {
				ResourceLocation entityR = EntityList.getKey(entity);
	    		if(entityR != null && entityR.equals(r)) {
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
    
    public void dropItem(LivingDropsEvent event, ItemStack drop) {
    	EntityItem entityItem = new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, drop);
    	event.getDrops().add(entityItem);
    }
	
	public static boolean checkTier(int tier, ItemStack extractor) {
    	if(!(extractor.getItem() instanceof SeedExtractor)) return false;
		if(!ModConfig.EXTRACTOR_ANY_TIER) {
			if(ModConfig.EXTRACTOR_LOWER_TIER) {
				return ((SeedExtractor) extractor.getItem()).getExtractorTier() >= tier;
			} else {
				return ((SeedExtractor) extractor.getItem()).getExtractorTier() == tier;
			}
		} else return true;
	}

}