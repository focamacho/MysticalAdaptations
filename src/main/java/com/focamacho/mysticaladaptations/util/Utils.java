package com.focamacho.mysticaladaptations.util;

import com.mojang.realmsclient.gui.ChatFormatting;

public class Utils {

	public static ChatFormatting getColorFromTier(int tier) {
		switch(tier) {
			case 1:
				return ChatFormatting.YELLOW;
			case 2:
				return ChatFormatting.GREEN;
			case 3:
				return ChatFormatting.GOLD;
			case 4:
				return ChatFormatting.AQUA;
			case 5:
				return ChatFormatting.RED;
			case 6:
				return ChatFormatting.DARK_PURPLE;
		}
		return ChatFormatting.GRAY;
	}
}
