package com.focamacho.mysticaladaptations.handlers;

import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagradditions.init.ModItems;
import com.blakebr0.mysticalagriculture.api.tinkering.ITinkerable;
import com.blakebr0.mysticalagriculture.config.ModConfigs;
import com.focamacho.mysticaladaptations.config.ConfigHolder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;

public class MobDropsHandler {

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntityLiving();
        World world = entity.getCommandSenderWorld();
        Collection<ItemEntity> drops = event.getDrops();
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) attacker;
            Item item = player.getMainHandItem().getItem();

            if (item instanceof ITinkerable) {
                ITinkerable tinkerable = (ITinkerable) item;

                if(tinkerable.getTinkerableTier() != 6) return;

                boolean witherDropsEssence = ModConfigs.WITHER_DROPS_ESSENCE.get();
                if (witherDropsEssence && entity instanceof WitherEntity) {
                    ItemStack stack = getEssenceAmount(ConfigHolder.witherInsanium, 1, 3);

                    if (!stack.isEmpty()) {
                        drops.add(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), stack));
                    }
                }

                boolean dragonDropsEssence = ModConfigs.DRAGON_DROPS_ESSENCE.get();
                if (dragonDropsEssence && entity instanceof EnderDragonEntity) {
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