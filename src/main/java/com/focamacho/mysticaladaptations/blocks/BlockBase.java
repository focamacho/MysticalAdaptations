package com.focamacho.mysticaladaptations.blocks;

import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.init.ModBlocks;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	
	public BlockBase(String name, Material material, SoundType sound, float hardness, float resistance, boolean register) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabMysticalAdaptations);
		setSoundType(sound);
		setHardness(hardness);
		setResistance(resistance);
		
		if(register){
			ModBlocks.BLOCKS.add(this);
			ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		}
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
