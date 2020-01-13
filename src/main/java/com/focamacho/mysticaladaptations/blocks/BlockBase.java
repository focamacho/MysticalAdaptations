package com.focamacho.mysticaladaptations.blocks;

import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBase extends Block implements IHasModel {
	
	public BlockBase(String name, Material material, SoundType sound, float hardness, float resistance) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabMysticalAdaptations);
		this.setSoundType(sound);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}