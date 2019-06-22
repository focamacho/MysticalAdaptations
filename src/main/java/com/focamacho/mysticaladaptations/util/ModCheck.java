package com.focamacho.mysticaladaptations.util;

import net.minecraftforge.fml.common.Loader;

public class ModCheck {

	public static final boolean MYSTICAL_AGRADDITIONS = Loader.isModLoaded("mysticalagradditions");
	public static final boolean AVARITIA = Loader.isModLoaded("avaritia") || Loader.isModLoaded("Avaritia");
	
}
