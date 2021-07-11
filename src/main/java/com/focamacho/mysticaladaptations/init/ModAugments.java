package com.focamacho.mysticaladaptations.init;

import com.blakebr0.mysticalagriculture.api.registry.IAugmentRegistry;
import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.augment.*;
import com.focamacho.mysticaladaptations.augment.DaywalkerAugment;
import com.focamacho.mysticaladaptations.augment.HungerlessAugment;
import com.focamacho.mysticaladaptations.augment.ThirstlessAugment;
import com.focamacho.mysticaladaptations.augment.WoodcutterAugment;
import com.focamacho.mysticaladaptations.util.Utils;

public class ModAugments {

    public static Augment HUNGERLESS = new HungerlessAugment(Utils.getRegistryName("hungerless"));
    public static Augment WOODCUTTER = new WoodcutterAugment(Utils.getRegistryName("woodcutter"));
    public static Augment MINING_AOE_V = new MiningAOEAugment(Utils.getRegistryName("mining_aoe_v"), 6, 5);
    public static Augment STRENGTH_IV = new StrengthAugment(Utils.getRegistryName("strength_iv"), 6, 5);
    public static Augment ABSORPTION_VI = new AbsorptionAugment(Utils.getRegistryName("absorption_vi"), 6, 5);
    public static Augment HEALTH_BOOST_VI = new HealthBoostAugment(Utils.getRegistryName("health_boost_vi"), 6, 6);
    public static Augment ATTACK_AOE_IV = new AttackAOEAugment(Utils.getRegistryName("attack_aoe_iv"), 6, 4);
    public static Augment TILLING_AOE_V = new TillingAOEAugment(Utils.getRegistryName("tilling_aoe_v"), 6, 5);

    public static Augment DAYWALKER = new DaywalkerAugment(Utils.getRegistryName("daywalker"));
    public static Augment THIRSTLESS = new ThirstlessAugment(Utils.getRegistryName("thirstless"));

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
            registry.register(DAYWALKER);
            registry.register(THIRSTLESS);
        }
    }

}