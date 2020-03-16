package com.focamacho.mysticaladaptations.items;

import java.util.List;

import javax.annotation.Nullable;

import com.focamacho.mysticaladaptations.MysticalAdaptations;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item {

	private String itemTooltip;
	
	public ItemBase(String name, @Nullable String tooltip) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAdaptations.tabMysticalAdaptations);
		this.itemTooltip = tooltip;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced){
		if(itemTooltip != null) tooltip.add(itemTooltip);
	}
	
}
