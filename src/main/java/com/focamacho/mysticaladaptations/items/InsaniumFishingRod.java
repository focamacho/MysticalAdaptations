package com.focamacho.mysticaladaptations.items;

import java.util.List;

import javax.annotation.Nullable;

import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.IHasModel;
import com.focamacho.mysticaladaptations.util.ModCheck;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * Code from BlakeBr0's Mystical Agriculture.
 * https://github.com/BlakeBr0/MysticalAgriculture/
*/

public class InsaniumFishingRod extends ItemFishingRod implements IHasModel {
	
	public TextFormatting color;
	
	public InsaniumFishingRod(String name, ToolMaterial material, TextFormatting color){
		this.setUnlocalizedName(name);
		this.setCreativeTab(Main.tabMysticalAdaptations);
		this.setRegistryName(name);
		this.color = color;
		this.setMaxStackSize(1);
		this.setMaxDamage(material.getMaxUses());
		
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_TOOLS) ModItems.ITEMS.add(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced){
		int damage = stack.getMaxDamage() - stack.getItemDamage();
		tooltip.add(Tooltips.DURABILITY + color + (damage > -1 ? damage : Tooltips.UNLIMITED));
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
