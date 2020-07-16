package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.tileentity.InsaniumFurnaceTileEntity;
import com.focamacho.mysticaladaptations.tileentity.InsaniumReprocessorTileEntity;
import com.focamacho.mysticaladaptations.util.Utils;
import net.minecraft.tileentity.TileEntityType;

import java.util.ArrayList;
import java.util.List;

public class ModTileEntities {

    public static List<TileEntityType<?>> allTileEntities = new ArrayList<TileEntityType<?>>();

    public static TileEntityType<?> INSANIUM_FURNACE = TileEntityType.Builder.create(InsaniumFurnaceTileEntity::new, ModBlocks.INSANIUM_FURNACE).build(null);
    public static TileEntityType<?> INSANIUM_REPROCESSOR = TileEntityType.Builder.create(InsaniumReprocessorTileEntity::new, ModBlocks.INSANIUM_REPROCESSOR).build(null);

    public static void initTileEntities(){
        INSANIUM_FURNACE.setRegistryName(Utils.getRegistryName("insanium_furnace_tile"));
        INSANIUM_REPROCESSOR.setRegistryName(Utils.getRegistryName("insanium_reprocessor_tile"));

        allTileEntities.add(INSANIUM_FURNACE);
        allTileEntities.add(INSANIUM_REPROCESSOR);
    }
}
