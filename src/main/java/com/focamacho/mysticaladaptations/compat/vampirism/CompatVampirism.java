package com.focamacho.mysticaladaptations.compat.vampirism;

import de.teamlapen.vampirism.core.ModEffects;
//import de.teamlapen.vampirism.player.vampire.VampirePlayer;
import de.teamlapen.vampirism.entity.player.vampire.VampirePlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CompatVampirism {

    public static void fillThirst(Player player, Level world) {
        if(!world.isClientSide) {
            VampirePlayer vampire = VampirePlayer.get(player);
            vampire.drinkBlood(vampire.getBloodStats().getMaxBlood(), 0, false);
        }
    }

    public static void applySunscreen(Player player, Level world) {
        MobEffectInstance effect = new MobEffectInstance(ModEffects.SUNSCREEN.get(), 20, 5, false, false);
        if(world.isClientSide) effect.setNoCounter(true);
        player.addEffect(effect);
    }

}
