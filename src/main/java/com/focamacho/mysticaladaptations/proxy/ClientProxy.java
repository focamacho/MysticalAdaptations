package com.focamacho.mysticaladaptations.proxy;

import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModEntities;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.focamacho.mysticaladaptations.util.compat.tconstruct.CompatTConstruct;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	public void registerEntityRenderer() {
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_TOOLS) ModEntities.initModels();
	}
	
	public void initTConstructModels() {
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModCheck.TCONSTRUCT && ModConfig.TINKERS_INSANIUM) CompatTConstruct.initFluidModels();
	}

}
