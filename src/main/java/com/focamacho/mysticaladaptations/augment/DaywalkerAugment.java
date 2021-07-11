package com.focamacho.mysticaladaptations.augment;

import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import com.focamacho.mysticaladaptations.compat.vampirism.CompatVampirism;
import com.focamacho.mysticaladaptations.util.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.EnumSet;

public class DaywalkerAugment  extends Augment {

    public DaywalkerAugment(ResourceLocation id) {
        super(id, 6, EnumSet.of(AugmentType.HELMET), 0xFFEC00, 0x111111);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        CompatVampirism.applySunscreen(player, world);
    }

}