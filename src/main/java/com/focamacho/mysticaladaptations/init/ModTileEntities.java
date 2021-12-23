package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.tiles.InsaniumFurnaceTileEntity;
import com.focamacho.mysticaladaptations.tiles.InsaniumReprocessorTileEntity;
import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModTileEntities {

    static final DeferredRegister<BlockEntityType<?>> tileEntities = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Reference.MOD_ID);

    public static RegistryObject<BlockEntityType<InsaniumFurnaceTileEntity>> INSANIUM_FURNACE = tileEntities.register("insanium_furnace_tile", () -> BlockEntityType.Builder.of(InsaniumFurnaceTileEntity::new, ModBlocks.INSANIUM_FURNACE.get()).build(null));
    public static RegistryObject<BlockEntityType<InsaniumReprocessorTileEntity>> INSANIUM_REPROCESSOR = tileEntities.register("insanium_reprocessor_tile", () -> BlockEntityType.Builder.of(InsaniumReprocessorTileEntity::new, ModBlocks.INSANIUM_REPROCESSOR.get()).build(null));

}
