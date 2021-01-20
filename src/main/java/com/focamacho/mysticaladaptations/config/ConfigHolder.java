package com.focamacho.mysticaladaptations.config;

import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigHolder {

    //Mystical Agradditions
    public static boolean enchantableInsaniumArmor;
    public static boolean enchantableInsaniumTools;
    public static int insaniumArmorAugments;
    public static int insaniumToolsAugments;

    //Vampirism Compat
    public static boolean thirstlessAugment;
    public static boolean daywalkerAugment;

    //Mob Drops
    public static boolean witherInsanium;
    public static boolean dragonInsanium;

    public static void updateConfigs(){
        enchantableInsaniumArmor = ConfigMysticalAdaptations.enchantableInsaniumArmor.get();
        enchantableInsaniumTools = ConfigMysticalAdaptations.enchantableInsaniumTools.get();
        insaniumArmorAugments = ConfigMysticalAdaptations.insaniumArmorAugments.get();
        insaniumToolsAugments = ConfigMysticalAdaptations.insaniumToolsAugments.get();

        thirstlessAugment = ConfigMysticalAdaptations.thirstlessAugment.get();
        daywalkerAugment = ConfigMysticalAdaptations.daywalkerAugment.get();

        witherInsanium = ConfigMysticalAdaptations.witherInsanium.get();
        dragonInsanium = ConfigMysticalAdaptations.dragonInsanium.get();
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
        final ModConfig config = event.getConfig();

        if (config.getSpec() == ConfigMysticalAdaptations.spec) {
            updateConfigs();
        }
    }

}
