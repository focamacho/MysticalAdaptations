package com.focamacho.mysticaladaptations.augment;

import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.EnumSet;

public class HungerlessAugment extends Augment {

    public HungerlessAugment(ResourceLocation id) {
        super(id, 6, EnumSet.of(AugmentType.CHESTPLATE), 15654992, 2825844);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.getFoodData().setFoodLevel(20);
    }
}
