package com.focamacho.mysticaladaptations.augment;

import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class HungerlessAugment extends Augment {

    public HungerlessAugment(ResourceLocation id) {
        super(id, 6, EnumSet.of(AugmentType.CHESTPLATE), 15654992, 2825844);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        player.getFoodData().setFoodLevel(20);
    }
}
