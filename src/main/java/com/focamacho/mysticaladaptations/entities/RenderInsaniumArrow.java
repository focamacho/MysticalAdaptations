package com.focamacho.mysticaladaptations.entities;

import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderInsaniumArrow extends RenderArrow<EntityInsaniumArrow> {
	
	public RenderInsaniumArrow(RenderManager renderManager){
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityInsaniumArrow entity){
		return new ResourceLocation(Reference.MOD_ID, "textures/entity/projectiles/insanium_arrow.png");
	}	
}