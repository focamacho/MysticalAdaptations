package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.block.InsaniumFurnaceBlock;
import com.focamacho.mysticaladaptations.block.InsaniumReprocessorBlock;
import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    static final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

    public static RegistryObject<Block> INSANIUM_FURNACE = blocks.register("insanium_furnace", InsaniumFurnaceBlock::new);
    public static RegistryObject<Block> INSANIUM_REPROCESSOR = blocks.register("insanium_reprocessor", InsaniumReprocessorBlock::new);

    static {
        ModItems.items.register("insanium_furnace", () -> new BlockItem(INSANIUM_FURNACE.get(), new Item.Properties()));
        ModItems.items.register("insanium_reprocessor", () -> new BlockItem(INSANIUM_REPROCESSOR.get(), new Item.Properties()));
    }

}
