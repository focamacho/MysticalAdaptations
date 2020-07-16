package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.block.InsaniumFurnaceBlock;
import com.focamacho.mysticaladaptations.block.InsaniumReprocessorBlock;
import com.focamacho.mysticaladaptations.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static List<Block> allBlocks = new ArrayList<Block>();

    public static Block INSANIUM_FURNACE = new InsaniumFurnaceBlock();
    public static Block INSANIUM_REPROCESSOR = new InsaniumReprocessorBlock();

    public static void initBlocks() {
        INSANIUM_FURNACE.setRegistryName(Utils.getRegistryName("insanium_furnace"));
        INSANIUM_REPROCESSOR.setRegistryName(Utils.getRegistryName("insanium_reprocessor"));

        allBlocks.add(INSANIUM_FURNACE);
        allBlocks.add(INSANIUM_REPROCESSOR);

        ModItems.allItems.add(new BlockItem(INSANIUM_FURNACE, new Item.Properties().group(MysticalAdaptations.creativeTab)).setRegistryName(Utils.getRegistryName("insanium_furnace")));
        ModItems.allItems.add(new BlockItem(INSANIUM_REPROCESSOR, new Item.Properties().group(MysticalAdaptations.creativeTab)).setRegistryName(Utils.getRegistryName("insanium_reprocessor")));
    }
}
