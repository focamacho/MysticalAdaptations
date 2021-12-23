package com.focamacho.mysticaladaptations.handlers;

import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagradditions.init.ModItems;
import com.blakebr0.mysticalagriculture.api.tinkering.ITinkerable;
import com.blakebr0.mysticalagriculture.config.ModConfigs;
import com.focamacho.mysticaladaptations.config.ConfigHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;

public class MobDropsHandler {

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntityLiving();
        Level world = entity.getCommandSenderWorld();
        Collection<ItemEntity> drops = event.getDrops();
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof Player player) {
            Item item = player.getMainHandItem().getItem();

            if (item instanceof ITinkerable tinkerable) {

                if(tinkerable.getTinkerableTier() != 6) return;

                boolean witherDropsEssence = ModConfigs.WITHER_DROPS_ESSENCE.get();
                if (witherDropsEssence && entity instanceof WitherBoss) {
                    ItemStack stack = getEssenceAmount(ConfigHolder.witherInsanium, 1, 3);

                    if (!stack.isEmpty()) {
                        drops.add(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), stack));
                    }
                }

                boolean dragonDropsEssence = ModConfigs.DRAGON_DROPS_ESSENCE.get();
                if (dragonDropsEssence && entity instanceof EnderDragon) {
                    ItemStack stack = getEssenceAmount(ConfigHolder.dragonInsanium, 2, 4);

                    if (!stack.isEmpty()) {
                        drops.add(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), stack));
                    }
                }
            }
        }
    }

    private static ItemStack getEssenceAmount(boolean insanium, int min, int max) {
        return new ItemStack(insanium ? ModItems.INSANIUM_ESSENCE.get() : com.blakebr0.mysticalagriculture.init.ModItems.SUPREMIUM_ESSENCE.get(), Utils.randInt(min, max));
    }
}