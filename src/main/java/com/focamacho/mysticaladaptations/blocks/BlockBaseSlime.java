package com.focamacho.mysticaladaptations.blocks;

import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.init.ModBlocks;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.IHasModel;

import net.minecraft.block.BlockSlime;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBaseSlime extends BlockSlime implements IHasModel {

	public BlockBaseSlime(String name, boolean register) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabMysticalAdaptations);
		setSoundType(SoundType.SLIME);
		
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
