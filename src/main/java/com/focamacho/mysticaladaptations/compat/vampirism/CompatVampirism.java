package com.focamacho.mysticaladaptations.compat.vampirism;

import de.teamlapen.vampirism.core.ModEffects;
import de.teamlapen.vampirism.entity.player.vampire.VampirePlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;

public class CompatVampirism {

    public static void fillThirst(Player player, Level world) {
        if(!world.isClientSide) {
            LazyOptional<VampirePlayer> optVampire = VampirePlayer.getOpt(player);
            optVampire.ifPresent(vampire -> vampire.drinkBlood(vampire.getBloodStats().getMaxBlood(), 0, false));
        }
    }

    public static void applySunscreen(Player player, Level world) {
        MobEffectInstance effect = new MobEffectInstance(ModEffects.SUNSCREEN.get(), 20, 5, false, false);
        player.addEffect(effect);
    }

}
