package com.focamacho.mysticaladaptations.init;

import com.blakebr0.mysticalagriculture.api.registry.IAugmentRegistry;
import com.blakebr0.mysticalagriculture.api.tinkering.IAugment;
import com.blakebr0.mysticalagriculture.augment.*;
import com.focamacho.mysticaladaptations.augment.DaywalkerAugment;
import com.focamacho.mysticaladaptations.augment.HungerlessAugment;
import com.focamacho.mysticaladaptations.augment.ThirstlessAugment;
import com.focamacho.mysticaladaptations.augment.WoodcutterAugment;
import com.focamacho.mysticaladaptations.util.Utils;

public class ModAugments {

    public static IAugment HUNGERLESS = new HungerlessAugment(Utils.getRegistryName("hungerless"));
    public static IAugment WOODCUTTER = new WoodcutterAugment(Utils.getRegistryName("woodcutter"));
    public static IAugment MINING_AOE_V = new MiningAOEAugment(Utils.getRegistryName("mining_aoe_v"), 6, 5);
    public static IAugment STRENGTH_IV = new StrengthAugment(Utils.getRegistryName("strength_iv"), 6, 5);
    public static IAugment ABSORPTION_VI = new AbsorptionAugment(Utils.getRegistryName("absorption_vi"), 6, 5);
    public static IAugment HEALTH_BOOST_VI = new HealthBoostAugment(Utils.getRegistryName("health_boost_vi"), 6, 6);
    public static IAugment ATTACK_AOE_IV = new AttackAOEAugment(Utils.getRegistryName("attack_aoe_iv"), 6, 4);
    public static IAugment TILLING_AOE_V = new TillingAOEAugment(Utils.getRegistryName("tilling_aoe_v"), 6, 5);

    public static IAugment DAYWALKER;
    public static IAugment THIRSTLESS;

    public static void registerAugments(IAugmentRegistry registry) {
        registry.register(HUNGERLESS);
        registry.register(WOODCUTTER);
        registry.register(MINING_AOE_V);
        registry.register(STRENGTH_IV);
        registry.register(ABSORPTION_VI);
        registry.register(HEALTH_BOOST_VI);
        registry.register(ATTACK_AOE_IV);
        registry.register(TILLING_AOE_V);

        if(Utils.isVampirismLoaded) {
            DAYWALKER = new DaywalkerAugment(Utils.getRegistryName("daywalker"));
            THIRSTLESS = new ThirstlessAugment(Utils.getRegistryName("thirstless"));

            registry.register(DAYWALKER);
            registry.register(THIRSTLESS);
        }
    }

}