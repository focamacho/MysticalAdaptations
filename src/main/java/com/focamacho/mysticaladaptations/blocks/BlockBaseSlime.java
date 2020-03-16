package com.focamacho.mysticaladaptations.blocks;

import com.focamacho.mysticaladaptations.MysticalAdaptations;

import net.minecraft.block.BlockSlime;
import net.minecraft.block.SoundType;

public class BlockBaseSlime extends BlockSlime {

	public BlockBaseSlime(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAdaptations.tabMysticalAdaptations);
		this.setSoundType(SoundType.SLIME);
	}

}
