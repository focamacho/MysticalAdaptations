package com.focamacho.mysticaladaptations.blocks;

import com.focamacho.mysticaladaptations.MysticalAdaptations;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
	
	public BlockBase(String name, Material material, SoundType sound, float hardness, float resistance) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAdaptations.tabMysticalAdaptations);
		this.setSoundType(sound);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}

}