package com.focamacho.mysticaladaptations.items;

import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{

	public ItemBase(String name, boolean register) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabMysticalAdaptations);
		
		if(register) ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	
}
