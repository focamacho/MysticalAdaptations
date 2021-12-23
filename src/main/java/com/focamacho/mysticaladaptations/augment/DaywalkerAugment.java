package com.focamacho.mysticaladaptations.augment;

import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import com.focamacho.mysticaladaptations.compat.vampirism.CompatVampirism;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class DaywalkerAugment  extends Augment {

    public DaywalkerAugment(ResourceLocation id) {
        super(id, 6, EnumSet.of(AugmentType.HELMET), 0xFFEC00, 0x111111);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        CompatVampirism.applySunscreen(player, world);
    }

}