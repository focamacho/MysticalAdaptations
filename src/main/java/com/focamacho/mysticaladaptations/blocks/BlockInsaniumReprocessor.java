package com.focamacho.mysticaladaptations.blocks;

import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.mysticalagriculture.blocks.reprocessor.BlockEssenceReprocessor;
import com.blakebr0.mysticalagriculture.tileentity.reprocessor.TileEssenceReprocessor;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.tileentity.TileInsaniumReprocessor;
import net.minecraft.block.SoundType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInsaniumReprocessor extends BlockEssenceReprocessor {
	
	private TileInsaniumReprocessor tileForInfo = new TileInsaniumReprocessor();

	public BlockInsaniumReprocessor(String name) {
		super(name);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAdaptations.tabMysticalAdaptations);
		this.setSoundType(SoundType.METAL);
		this.setHardness(8.0F);
		this.setResistance(12.0F);
		this.setHarvestLevel("pickaxe", 1);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileInsaniumReprocessor();
	}

	@Override
	public String getTooltipColor() {
		return Colors.DARK_PURPLE;
	}
	
	@Override
	public TileEssenceReprocessor getTileForInfo() {
		return this.tileForInfo;
	}

}