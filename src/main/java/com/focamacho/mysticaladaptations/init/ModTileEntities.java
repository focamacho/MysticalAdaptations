package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.tileentity.TileInsaniumFurnace;
import com.focamacho.mysticaladaptations.tileentity.TileInsaniumReprocessor;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.focamacho.mysticaladaptations.util.Reference;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void init() {
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_FURNACE) {
			if(com.blakebr0.mysticalagriculture.config.ModConfig.confEssenceFurnaces) {
				GameRegistry.registerTileEntity(TileInsaniumFurnace.class, Reference.MOD_ID + ".tile_insanium_furnace");
			}
		}
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_REPROCESSOR) {
			if(com.blakebr0.mysticalagriculture.config.ModConfig.confSeedReprocessor) {
				GameRegistry.registerTileEntity(TileInsaniumReprocessor.class, Reference.MOD_ID + ".tile_insanium_reprocessor");
			}
		}	
	}
}
