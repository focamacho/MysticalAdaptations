package com.focamacho.mysticaladaptations.blocks;

import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.util.IHasModel;

import net.minecraft.block.BlockSlime;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;

public class BlockBaseSlime extends BlockSlime implements IHasModel {

	public BlockBaseSlime(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabMysticalAdaptations);
		this.setSoundType(SoundType.SLIME);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
