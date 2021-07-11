package com.focamacho.mysticaladaptations.init;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModRegistry {

    public static void register() {
        ModItems.items.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.blocks.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModContainers.containers.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModTileEntities.tileEntities.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
