package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.entities.EntityInsaniumArrow;
import com.focamacho.mysticaladaptations.entities.RenderInsaniumArrow;
import com.focamacho.mysticaladaptations.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {

	public static void init(){
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "insanium_arrow"), EntityInsaniumArrow.class, "insanium_arrow", 0, Main.instance, 64, 1, true);
	}

	public static void initModels(){
		RenderingRegistry.registerEntityRenderingHandler(EntityInsaniumArrow.class, RenderInsaniumArrow::new);
	}
	
}
