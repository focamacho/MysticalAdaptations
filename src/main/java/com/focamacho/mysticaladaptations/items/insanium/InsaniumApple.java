package com.focamacho.mysticaladaptations.items.insanium;

import java.util.List;

import javax.annotation.Nullable;

import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.focamacho.mysticaladaptations.MysticalAdaptations;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InsaniumApple extends ItemFood {
	
	public InsaniumApple(String name){
        super(25, 1.1F, false);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAdaptations.tabMysticalAdaptations);
		this.setAlwaysEdible();
	}
	
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
        if(!world.isRemote) {
        	int duration = 0;
            PotionEffect potion;
            int buffLength = ModConfig.confAppleBuffDuration * 20;
            
            potion = player.getActivePotionEffect(MobEffects.ABSORPTION);
            if(potion != null){
            	duration = potion.getDuration();
            }
        	player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, duration + 60 * buffLength, 1));
        	
            potion = player.getActivePotionEffect(MobEffects.SPEED);
            if(potion != null){
            	duration = potion.getDuration();
            }
        	player.addPotionEffect(new PotionEffect(MobEffects.SPEED, duration + 60 * buffLength, 1));

            potion = player.getActivePotionEffect(MobEffects.RESISTANCE);
            if(potion != null){
            	duration = potion.getDuration();
            }
        	player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, duration + 60 * buffLength, 1));

            potion = player.getActivePotionEffect(MobEffects.REGENERATION);
            if(potion != null){
            	duration = potion.getDuration();
            }
        	player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, duration + 60 * buffLength, 1));          	
            
            potion = player.getActivePotionEffect(MobEffects.STRENGTH);
            if(potion != null){
            	duration = potion.getDuration();
            }
        	player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, duration + 60 * buffLength, 1));
        
        	potion = player.getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
        	if(potion != null) {
        		duration = potion.getDuration();
        	}
        	player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, duration + 60 * buffLength, 1));
        }
    }
    
    @Override
    public boolean hasEffect(ItemStack stack){
    	return true;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced){
		int duration = ModConfig.confAppleBuffDuration;
		if(Utils.isShiftKeyDown()){
			tooltip.add(Tooltips.GIVES_BUFFS);
			tooltip.add("- " + Tooltips.ABSORPTION + Colors.GRAY + " (" + duration + ":00)");
			tooltip.add("- " + Tooltips.SPEED + Colors.GRAY + " (" + duration + ":00)");
			tooltip.add("- " + Tooltips.RESISTANCE + Colors.GRAY + " (" + duration + ":00)");
			tooltip.add("- " + Tooltips.REGENERATION + Colors.GRAY + " (" + duration + ":00)");
			tooltip.add("- " + Tooltips.STRENGTH + Colors.GRAY + " (" + duration + ":00)");
			tooltip.add("- " + Colors.DARK_PURPLE + Utils.localize(MobEffects.FIRE_RESISTANCE.getName()) + " II"+ Colors.GRAY + " (" + duration + ":00)");
		} else {
			tooltip.add(Tooltips.HOLD_SHIFT_FOR_INFO);
		}
	}
}
