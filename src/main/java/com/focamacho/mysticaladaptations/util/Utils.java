package com.focamacho.mysticaladaptations.util;

import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class Utils {

	public static TextFormatting getColorFromTier(int tier) {
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
				return TextFormatting.DARK_PURPLE;
		}
		return TextFormatting.GRAY;
	}

	public static ResourceLocation getRegistryName(String itemName){
		return new ResourceLocation(Reference.MOD_ID, itemName);
	}
}
