package com.focamacho.mysticaladaptations.util.handlers;

import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.items.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TooltipsHandler {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void itemTooltipEvent(ItemTooltipEvent event) {
		if(ItemStack.areItemStacksEqual(event.getItemStack(), new ItemStack(ModItems.itemCharm, 1, 19))) {
			if(Utils.isShiftKeyDown()) {
				event.getToolTip().add(I18n.translateToLocal("tooltips.mysticaladaptations.sickle_aoe_charm"));
			}
		}
		if(ItemStack.areItemStacksEqual(event.getItemStack(), new ItemStack(ModItems.itemCharm, 1, 20))) {
			if(Utils.isShiftKeyDown()) {
				event.getToolTip().add(I18n.translateToLocal("tooltips.mysticaladaptations.scythe_aoe_charm"));
			}
		}
	}
}
