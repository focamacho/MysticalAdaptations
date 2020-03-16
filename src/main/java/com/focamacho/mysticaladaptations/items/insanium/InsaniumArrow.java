package com.focamacho.mysticaladaptations.items.insanium;
import java.util.List;

import javax.annotation.Nullable;

import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.entities.EntityInsaniumArrow;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InsaniumArrow extends ItemArrow {
	
	public InsaniumArrow(String name){
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAdaptations.tabMysticalAdaptations);
	}
	
	@Override
	public EntityArrow createArrow(World world, ItemStack stack, EntityLivingBase shooter) {
		return new EntityInsaniumArrow(world, shooter);
	}
	
	@Override
	public boolean isInfinite(ItemStack stack, ItemStack bow, EntityPlayer player) {
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
		if(Utils.isShiftKeyDown()){
			tooltip.add(Tooltips.DAMAGE + Colors.DARK_PURPLE + "+6.0");
			tooltip.add(Tooltips.GIVES_DEBUFFS);
			tooltip.add(" - " + Tooltips.BLINDNESS);
			tooltip.add(" - " + Tooltips.SLOWNESS);
			tooltip.add(" - " + Tooltips.POISON);
			tooltip.add(" - " + Tooltips.WEAKNESS);
			tooltip.add(" - " + Tooltips.WITHER);
			tooltip.add(" - " + Colors.DARK_PURPLE + Utils.localize(MobEffects.LEVITATION.getName()));
		} else {
			tooltip.add(Tooltips.HOLD_SHIFT_FOR_INFO);
		}
	}
	
}