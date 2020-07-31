package com.focamacho.mysticaladaptations.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ConfigMysticalAdaptations {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final General GENERAL = new General(BUILDER);
    public static final ForgeConfigSpec spec = BUILDER.build();

    //Config Values
    //Seed Extractor
    /*public static ConfigValue<Boolean> ENABLE_EXTRACTORS;

    //Extractor Durability
    public static ConfigValue<Integer> INFERIUM_DURABILITY;
    public static ConfigValue<Integer> PRUDENTIUM_DURABILITY;
    public static ConfigValue<Integer> TERTIUM_DURABILITY;
    public static ConfigValue<Integer> IMPERIUM_DURABILITY;
    public static ConfigValue<Integer> SUPREMIUM_DURABILITY;
    public static ConfigValue<Integer> INSANIUM_DURABILITY;

    //Extractor Recipes
    public static ConfigValue<String> AIR;
    public static ConfigValue<String> EARTH;
    public static ConfigValue<String> WATER;
    public static ConfigValue<String> FIRE;

    public static ConfigValue<String> INFERIUM;
    public static ConfigValue<String> STONE;
    public static ConfigValue<String> DIRT;
    public static ConfigValue<String> WOOD;
    public static ConfigValue<String> ICE;

    public static ConfigValue<String> NATURE;
    public static ConfigValue<String> DYE;
    public static ConfigValue<String> NETHER;
    public static ConfigValue<String> COAL;
    public static ConfigValue<String> CORAL;
    public static ConfigValue<String> PIG;
    public static ConfigValue<String> CHICKEN;
    public static ConfigValue<String> COW;
    public static ConfigValue<String> SHEEP;
    public static ConfigValue<String> SQUID;
    public static ConfigValue<String> FISH;
    public static ConfigValue<String> SLIME;
    public static ConfigValue<String> TURTLE;

    public static ConfigValue<String> IRON;
    public static ConfigValue<String> NETHER_QUARTZ;
    public static ConfigValue<String> GLOWSTONE;
    public static ConfigValue<String> REDSTONE;
    public static ConfigValue<String> OBSIDIAN;
    public static ConfigValue<String> PRISMARINE;
    public static ConfigValue<String> ZOMBIE;
    public static ConfigValue<String> SKELETON;
    public static ConfigValue<String> CREEPER;
    public static ConfigValue<String> SPIDER;
    public static ConfigValue<String> RABBIT;

    public static ConfigValue<String> GOLD;
    public static ConfigValue<String> LAPIS_LAZULI;
    public static ConfigValue<String> END;
    public static ConfigValue<String> EXPERIENCE;
    public static ConfigValue<String> BLAZE;
    public static ConfigValue<String> GHAST;
    public static ConfigValue<String> ENDERMAN;

    public static ConfigValue<String> DIAMOND;
    public static ConfigValue<String> EMERALD;
    public static ConfigValue<String> WITHER_SKELETON;

    //Mystical Agradditions
    public static ConfigValue<Boolean> INSANIUM_ARMOR;
    public static ConfigValue<Boolean> INSANIUM_TOOLS;*/
    public static ConfigValue<Boolean> ENCHANTABLE_INSANIUM_ARMOR;
    public static ConfigValue<Boolean> ENCHANTABLE_INSANIUM_TOOLS;
    public static ConfigValue<Integer> INSANIUM_ARMOR_AUGMENTS;
    public static ConfigValue<Integer> INSANIUM_TOOLS_AUGMENTS;

    //Vampirism Compat
    public static ConfigValue<Boolean> THIRSTLESS_AUGMENT;
    public static ConfigValue<Boolean> DAYWALKER_AUGMENT;

    //Additional Mechanics
    /*public static ConfigValue<Boolean> ENCHANTABLE_EXTRACTOR;
    public static ConfigValue<Boolean> EXPERIENCE_SEEDS_DROP;
    public static ConfigValue<Integer> EXPERIENCE_SEEDS_DROP_CHANCE;
    public static ConfigValue<Boolean> EXPERIENCE_SEEDS_DROP_DURABILITY;
    public static ConfigValue<Boolean> EXTRACTOR_ANY_TIER;
    public static ConfigValue<Boolean> EXTRACTOR_LOWER_TIER;
    public static ConfigValue<Boolean> JEI_COMPAT;
    public static ConfigValue<Boolean> MOB_SEED_DROP;*/

    public static class General {
        public General(final ForgeConfigSpec.Builder builder) {
            /*builder.push("Seed Extractor");

            builder.comment("Enable/Disable Principal Mechanics");
            builder.push("Main");
            ENABLE_EXTRACTORS = builder.comment("Enable Seed Extractors").define("enable_extractors", false);
            builder.pop();

            builder.comment("Seed Extractor Durability");
            builder.push("Durability");
            INFERIUM_DURABILITY = builder.comment("Inferium Seed Extractor Durability").defineInRange("inferium_extractor_durability", 15, 1, 2147483647);
            PRUDENTIUM_DURABILITY = builder.comment("Prudentium Seed Extractor Durability").defineInRange("prudentium_extractor_durability", 15, 1, 2147483647);
            TERTIUM_DURABILITY = builder.comment("Tertium Seed Extractor Durability").defineInRange("tertium_extractor_durability", 15, 1, 2147483647);
            IMPERIUM_DURABILITY = builder.comment("Imperium Seed Extractor Durability").defineInRange("imperium_extractor_durability", 15, 1, 2147483647);
            SUPREMIUM_DURABILITY = builder.comment("Supremium Seed Extractor Durability").defineInRange("supremium_durability", 15, 1, 2147483647);
            INSANIUM_DURABILITY = builder.comment("Insanium Seed Extractor Durability. (Only if Mystical Agradditions is loaded)").defineInRange("inferium_durability", 15, 1, 2147483647);
            builder.pop();

            builder.comment("Set which block or entity drops a seed when right-clicked/killed using a Seed Extractor");
            builder.push("Recipes");
            AIR = builder.define("air", "minecraft:grass;minecraft:water;tag:minecraft:wool;entity:minecraft:chicken");
            EARTH = builder.define("earth", "");
            WATER = builder.define("water", "");
            FIRE = builder.define("fire", "");

            INFERIUM = builder.define("inferium", "");
            STONE = builder.define("stone", "");
            DIRT = builder.define("dirt", "");
            WOOD = builder.define("wood", "");
            ICE = builder.define("ice", "");

            NATURE = builder.define("nature", "");
            DYE = builder.define("dye", "");
            NETHER = builder.define("nether", "");
            COAL = builder.define("coal", "");
            CORAL = builder.define("coral", "");
            PIG = builder.define("pig", "");
            CHICKEN = builder.define("chicken", "");
            COW = builder.define("cow", "");
            SHEEP = builder.define("sheep", "");
            SQUID = builder.define("squid", "");
            FISH = builder.define("fish", "");
            SLIME = builder.define("slime", "");
            TURTLE = builder.define("turtle", "");

            IRON = builder.define("iron", "");
            NETHER_QUARTZ = builder.define("nether_quartz", "");
            GLOWSTONE = builder.define("glowstone", "");
            REDSTONE = builder.define("redstone", "");
            OBSIDIAN = builder.define("obsidian", "");
            PRISMARINE = builder.define("prismarine", "");
            ZOMBIE = builder.define("zombie", "");
            SKELETON = builder.define("skeleton", "");
            CREEPER = builder.define("creeper", "");
            SPIDER = builder.define("spider", "");
            RABBIT = builder.define("rabbit", "");

            GOLD = builder.define("gold", "");
            LAPIS_LAZULI = builder.define("lapis_lazuli", "");
            END = builder.define("end", "");
            EXPERIENCE = builder.define("experience", "");
            BLAZE = builder.define("blaze", "");
            GHAST = builder.define("ghast", "");
            ENDERMAN = builder.define("enderman", "");

            DIAMOND = builder.define("diamond", "");
            EMERALD = builder.define("emerald", "");
            WITHER_SKELETON = builder.define("wither_skeleton", "");
            builder.pop();

            builder.pop();*/

            builder.push("Mystical Agradditions");
            //INSANIUM_ARMOR = builder.comment("Enable the Insanium Armor").define("insanium_armor", true);
            //INSANIUM_TOOLS = builder.comment("Enable Insanium Tools").define("insanium_tools", true);
            ENCHANTABLE_INSANIUM_ARMOR = builder.comment("Set whether Insanium Armor can be enchanted using a enchantment table").define("enchantable_insanium_armor", false);
            ENCHANTABLE_INSANIUM_TOOLS = builder.comment("Set whether Insanium Tools can be enchanted using a enchantment table").define("enchantable_insanium_tools", false);
            INSANIUM_ARMOR_AUGMENTS = builder.comment("Set how many augments can be placed on the insanium armor").defineInRange("insanium_armor_augments", 2, 1, 2);
            INSANIUM_TOOLS_AUGMENTS = builder.comment("Set how many augments can be placed on the insanium tools").defineInRange("insanium_tools_augments", 2, 1, 2);
            builder.pop();

            builder.push("Vampirism Compat");
            THIRSTLESS_AUGMENT = builder.comment("Enable the Thirstless Augment").define("thirstless_augment", true);
            DAYWALKER_AUGMENT = builder.comment("Enable the Daywalker Augment").define("daywalker_augment", true);
            builder.pop();

            /*builder.push("Additional Mechanics");
            ENCHANTABLE_EXTRACTOR = builder.comment("Set whether Seed Extractors can be enchanted using books").define("enchantable_extractor", false);
            EXPERIENCE_SEEDS_DROP = builder.comment("If true, mobs will have a configurable chance of dropping a Experience Seeds when killed using a Seed Extractor.").define("experience_seeds_drop", true);
            EXPERIENCE_SEEDS_DROP_CHANCE = builder.comment("Set Experience Seeds drop chance").defineInRange("experience_seeds_drop_chance", 10, 1, 100);
            EXPERIENCE_SEEDS_DROP_DURABILITY = builder.comment("Consume 1 from the Seed Extractor Durability when a Experience Seed is dropped").define("experience_seeds_drop_durability", false);
            EXTRACTOR_ANY_TIER = builder.comment("Seed extractors can collect any seed, regardless of the tier").define("extractor_any_tier", false);
            EXTRACTOR_LOWER_TIER = builder.comment("Seed Extractor of larger tiers can pick lower tier seeds").define("extractor_lower_tier", true);
            JEI_COMPAT = builder.comment("Enable/Disable JEI Seed Extractor Compat").define("jei_extractor_compat", true);
            MOB_SEED_DROP = builder.comment("Kill a mob using a Seed Extractor to get its seed").define("mob_seed_drop", true);
            builder.pop();*/
        }
    }
}
