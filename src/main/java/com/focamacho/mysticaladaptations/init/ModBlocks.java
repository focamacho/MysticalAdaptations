package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.blocks.BlockBase;
import com.focamacho.mysticaladaptations.blocks.BlockBaseSlime;
import com.focamacho.mysticaladaptations.blocks.BlockInsaniumFurnace;
import com.focamacho.mysticaladaptations.blocks.BlockInsaniumReprocessor;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.util.ModCheck;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<>();
	
	public static Block SILICON_BLOCK;
	public static Block HOP_GRAPHITE_BLOCK;
	public static Block NETHERSTAR_BLOCK;
	
	public static Block INSANIUM_FURNACE_BLOCK;
	public static Block INSANIUM_FURNACE_BLOCK_ACTIVE;
	
	public static Block INSANIUM_REPROCESSOR_BLOCK;
	
	public static void init() {
		if(ModConfig.SILICON_BLOCK) {
			SILICON_BLOCK = new BlockBaseSlime("silicon_block");
			BLOCKS.add(SILICON_BLOCK);
			ModItems.ITEMS.add(new ItemBlock(SILICON_BLOCK).setRegistryName(SILICON_BLOCK.getRegistryName()));
		}
		
		if(ModConfig.HOP_GRAPHITE_BLOCK) {
			HOP_GRAPHITE_BLOCK = new BlockBase("hop_graphite_block", Material.ROCK, SoundType.STONE, 1.5f, 30);
			BLOCKS.add(HOP_GRAPHITE_BLOCK);
			ModItems.ITEMS.add(new ItemBlock(HOP_GRAPHITE_BLOCK).setRegistryName(HOP_GRAPHITE_BLOCK.getRegistryName()));
		}
		
		if(ModConfig.NETHERSTARS_BLOCK) {
			NETHERSTAR_BLOCK = new BlockBase("netherstar_block", Material.IRON, SoundType.METAL, 5, 30);
			BLOCKS.add(NETHERSTAR_BLOCK);
			ModItems.ITEMS.add(new ItemBlock(NETHERSTAR_BLOCK).setRegistryName(NETHERSTAR_BLOCK.getRegistryName()));
		}
		
		if(ModCheck.MYSTICAL_AGRADDITIONS) {
			if(com.blakebr0.mysticalagriculture.config.ModConfig.confEssenceFurnaces) {
				if(ModConfig.INSANIUM_FURNACE) {
					INSANIUM_FURNACE_BLOCK = new BlockInsaniumFurnace(false, "insanium_furnace");
					INSANIUM_FURNACE_BLOCK_ACTIVE = new BlockInsaniumFurnace(true, "insanium_furnace_active");			
				
					BLOCKS.add(INSANIUM_FURNACE_BLOCK);
					BLOCKS.add(INSANIUM_FURNACE_BLOCK_ACTIVE);
					ModItems.ITEMS.add(new ItemBlock(INSANIUM_FURNACE_BLOCK).setRegistryName(INSANIUM_FURNACE_BLOCK.getRegistryName()));
				}
			}
			
			if(com.blakebr0.mysticalagriculture.config.ModConfig.confSeedReprocessor) {
				if(ModConfig.INSANIUM_REPROCESSOR) {
					INSANIUM_REPROCESSOR_BLOCK = new BlockInsaniumReprocessor("insanium_reprocessor");
				
					BLOCKS.add(INSANIUM_REPROCESSOR_BLOCK);
					ModItems.ITEMS.add(new ItemBlock(INSANIUM_REPROCESSOR_BLOCK).setRegistryName(INSANIUM_REPROCESSOR_BLOCK.getRegistryName()));
				}
			}
		}
	}
	
}
