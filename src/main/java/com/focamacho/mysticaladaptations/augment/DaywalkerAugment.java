package com.focamacho.mysticaladaptations.augment;

import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import de.teamlapen.vampirism.core.ModEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.EnumSet;

public class DaywalkerAugment  extends Augment {

    public DaywalkerAugment(ResourceLocation id) {
        super(id, 6, EnumSet.of(AugmentType.HELMET), 0xFFEC00, 0x111111);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        EffectInstance effect = new EffectInstance(ModEffects.sunscreen, 20, 5, false, false);
        if(world.isRemote) effect.setPotionDurationMax(true);
        player.addPotionEffect(effect);
    }

}