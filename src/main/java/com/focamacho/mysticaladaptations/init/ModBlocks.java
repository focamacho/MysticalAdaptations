package com.focamacho.mysticaladaptations.init;

import java.util.ArrayList;
import java.util.List;

import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.blocks.BlockBase;
import com.focamacho.mysticaladaptations.blocks.BlockBaseSlime;
import com.focamacho.mysticaladaptations.config.ModConfig;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block NETHERSTAR_BLOCK = new BlockBase("netherstar_block", Material.IRON, SoundType.METAL, 5, 30, ModConfig.NETHERSTAR_BLOCK);
	public static final Block SILICON_BLOCK = new BlockBaseSlime("silicon_block", ModConfig.SILICON_BLOCK);
	public static final Block HOP_GRAPHITE_BLOCK = new BlockBase("hop_graphite_block", Material.ROCK, SoundType.STONE, 1.5f, 30, ModConfig.HOP_GRAPHITE_BLOCK);
	
}
