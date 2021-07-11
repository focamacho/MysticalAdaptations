package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.tiles.InsaniumFurnaceTileEntity;
import com.focamacho.mysticaladaptations.tiles.InsaniumReprocessorTileEntity;
import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    static final DeferredRegister<TileEntityType<?>> tileEntities = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Reference.MOD_ID);

    public static RegistryObject<TileEntityType<InsaniumFurnaceTileEntity>> INSANIUM_FURNACE = tileEntities.register("insanium_furnace_tile", () -> TileEntityType.Builder.of(InsaniumFurnaceTileEntity::new, ModBlocks.INSANIUM_FURNACE.get()).build(null));
    public static RegistryObject<TileEntityType<InsaniumReprocessorTileEntity>> INSANIUM_REPROCESSOR = tileEntities.register("insanium_reprocessor_tile", () -> TileEntityType.Builder.of(InsaniumReprocessorTileEntity::new, ModBlocks.INSANIUM_REPROCESSOR.get()).build(null));

}
