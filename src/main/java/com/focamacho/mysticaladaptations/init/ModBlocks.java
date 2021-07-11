package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.block.InsaniumFurnaceBlock;
import com.focamacho.mysticaladaptations.block.InsaniumReprocessorBlock;
import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    static final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

    public static RegistryObject<Block> INSANIUM_FURNACE = blocks.register("insanium_furnace", InsaniumFurnaceBlock::new);
    public static RegistryObject<Block> INSANIUM_REPROCESSOR = blocks.register("insanium_reprocessor", InsaniumReprocessorBlock::new);

    static {
        ModItems.items.register("insanium_furnace", () -> new BlockItem(INSANIUM_FURNACE.get(), new Item.Properties().tab(MysticalAdaptations.creativeTab)));
        ModItems.items.register("insanium_reprocessor", () -> new BlockItem(INSANIUM_REPROCESSOR.get(), new Item.Properties().tab(MysticalAdaptations.creativeTab)));
    }

}
