package com.focamacho.mysticaladaptations.util.compat.mysticalagradditions;

import com.blakebr0.mysticalagradditions.lib.CropType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MysticalAgradditionsReferences {

    public static final ItemStack insaniumEssence = new ItemStack(com.blakebr0.mysticalagradditions.items.ModItems.itemInsanium, 1, 0);
    public static final ItemStack insaniumIngot = new ItemStack(com.blakebr0.mysticalagradditions.items.ModItems.itemInsanium, 1, 2);
    public static final ItemStack insaniumBlock = new ItemStack(com.blakebr0.mysticalagradditions.blocks.ModBlocks.blockStorage, 1, 0);

    public static final boolean netherStar = CropType.Type.NETHER_STAR.isEnabled();
    public static final boolean awakenedDraconium = CropType.Type.AWAKENED_DRACONIUM.isEnabled();
    public static final boolean dragonEgg = CropType.Type.DRAGON_EGG.isEnabled();
    public static final boolean neutronium = CropType.Type.NEUTRONIUM.isEnabled();

    public static final Item netherStarSeed = CropType.Type.NETHER_STAR.getSeed();
    public static final Item awakenedDraconiumSeed = CropType.Type.AWAKENED_DRACONIUM.getSeed();
    public static final Item dragonEggSeed = CropType.Type.DRAGON_EGG.getSeed();
    public static final Item neutroniumSeed = CropType.Type.NEUTRONIUM.getSeed();

}
