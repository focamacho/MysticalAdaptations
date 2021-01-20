package com.focamacho.mysticaladaptations.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ConfigMysticalAdaptations {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final General GENERAL = new General(BUILDER);
    public static final ForgeConfigSpec spec = BUILDER.build();

    //Mystical Agradditions
    public static ConfigValue<Boolean> enchantableInsaniumArmor;
    public static ConfigValue<Boolean> enchantableInsaniumTools;
    public static ConfigValue<Integer> insaniumArmorAugments;
    public static ConfigValue<Integer> insaniumToolsAugments;

    //Vampirism Compat
    public static ConfigValue<Boolean> thirstlessAugment;
    public static ConfigValue<Boolean> daywalkerAugment;

    //Mob Drops
    public static ConfigValue<Boolean> witherInsanium;
    public static ConfigValue<Boolean> dragonInsanium;

    public static class General {
        public General(final ForgeConfigSpec.Builder builder) {
            builder.push("Mystical Agradditions");
            enchantableInsaniumArmor = builder.comment("Set whether Insanium Armor can be enchanted using a enchantment table").define("enchantable_insanium_armor", false);
            enchantableInsaniumTools = builder.comment("Set whether Insanium Tools can be enchanted using a enchantment table").define("enchantable_insanium_tools", false);
            insaniumArmorAugments = builder.comment("Set how many augments can be placed on the insanium armor").defineInRange("insanium_armor_augments", 2, 1, 2);
            insaniumToolsAugments = builder.comment("Set how many augments can be placed on the insanium tools").defineInRange("insanium_tools_augments", 2, 1, 2);
            builder.pop();

            builder.push("Vampirism Compat");
            thirstlessAugment = builder.comment("Enable the Thirstless Augment").define("thirstless_augment", true);
            daywalkerAugment = builder.comment("Enable the Daywalker Augment").define("daywalker_augment", true);
            builder.pop();

            builder.push("Mob Drops");
            witherInsanium = builder.comment("Wither drops insanium essence when killed with an Insanium weapon.").define("wither_insanium", true);
            dragonInsanium = builder.comment("Ender Dragon drops insanium essence when killed with an Insanium weapon.").define("dragon_insanium", true);
            builder.pop();
        }
    }

}
