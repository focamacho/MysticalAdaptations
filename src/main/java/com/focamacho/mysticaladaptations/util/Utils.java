package com.focamacho.mysticaladaptations.util;

import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

public class Utils {

	public static final boolean isVampirismLoaded = ModList.get().isLoaded("vampirism");

	public static ChatFormatting getColorFromTier(int tier) {
		switch(tier) {
			case 1:
				return CropTier.ONE.getTextColor();
			case 2:
				return CropTier.TWO.getTextColor();
			case 3:
				return CropTier.THREE.getTextColor();
			case 4:
				return CropTier.FOUR.getTextColor();
			case 5:
				return CropTier.FIVE.getTextColor();
			case 6:
				return ChatFormatting.DARK_PURPLE;
		}
		return ChatFormatting.GRAY;
	}

	public static ResourceLocation getRegistryName(String itemName){
		return new ResourceLocation(Reference.MOD_ID, itemName);
	}

}
