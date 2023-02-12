package com.focamacho.mysticaladaptations.util;

import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

public class Utils {

	public static final boolean isVampirismLoaded = ModList.get().isLoaded("vampirism");

	public static ChatFormatting getColorFromTier(int tier) {
		return switch (tier) {
			case 1 -> CropTier.ONE.getTextColor();
			case 2 -> CropTier.TWO.getTextColor();
			case 3 -> CropTier.THREE.getTextColor();
			case 4 -> CropTier.FOUR.getTextColor();
			case 5 -> CropTier.FIVE.getTextColor();
			case 6 -> ChatFormatting.DARK_PURPLE;
			default -> ChatFormatting.GRAY;
		};
	}

	public static ResourceLocation getRegistryName(String itemName){
		return new ResourceLocation(Reference.MOD_ID, itemName);
	}

}
