package com.focamacho.mysticaladaptations.config;

import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigHolder {


    /*public static boolean COMPAT_JEI = true;

    //Extractor Recipes
    public static List<String> AIR;
    public static List<String> EARTH;
    public static List<String> WATER;
    public static List<String> FIRE;

    public static List<String> INFERIUM;
    public static List<String> STONE;
    public static List<String> DIRT;
    public static List<String> WOOD;
    public static List<String> ICE;

    public static List<String> NATURE;
    public static List<String> DYE;
    public static List<String> NETHER;
    public static List<String> COAL;
    public static List<String> CORAL;
    public static List<String> PIG;
    public static List<String> CHICKEN;
    public static List<String> COW;
    public static List<String> SHEEP;
    public static List<String> SQUID;
    public static List<String> FISH;
    public static List<String> SLIME;
    public static List<String> TURTLE;

    public static List<String> IRON;
    public static List<String> NETHER_QUARTZ;
    public static List<String> GLOWSTONE;
    public static List<String> REDSTONE;
    public static List<String> OBSIDIAN;
    public static List<String> PRISMARINE;
    public static List<String> ZOMBIE;
    public static List<String> SKELETON;
    public static List<String> CREEPER;
    public static List<String> SPIDER;
    public static List<String> RABBIT;

    public static List<String> GOLD;
    public static List<String> LAPIS_LAZULI;
    public static List<String> END;
    public static List<String> EXPERIENCE;
    public static List<String> BLAZE;
    public static List<String> GHAST;
    public static List<String> ENDERMAN;

    public static List<String> DIAMOND;
    public static List<String> EMERALD;
    public static List<String> WITHER_SKELETON;

    public static boolean INSANIUM_ARMOR;
    public static boolean INSANIUM_TOOLS;*/
    public static boolean ENCHANTABLE_INSANIUM_ARMOR;
    public static boolean ENCHANTABLE_INSANIUM_TOOLS;
    public static int INSANIUM_ARMOR_AUGMENTS;
    public static int INSANIUM_TOOLS_AUGMENTS;

    public static boolean THIRSTLESS_AUGMENT;
    public static boolean DAYWALKER_AUGMENT;

    public static void updateConfigs(){
        /*AIR = Arrays.asList(ConfigMysticalAdaptations.AIR.get().split(";"));
        EARTH = Arrays.asList(ConfigMysticalAdaptations.EARTH.get().split(";"));
        WATER = Arrays.asList(ConfigMysticalAdaptations.WATER.get().split(";"));
        FIRE = Arrays.asList(ConfigMysticalAdaptations.FIRE.get().split(";"));

        INFERIUM = Arrays.asList(ConfigMysticalAdaptations.INFERIUM.get().split(";"));
        STONE = Arrays.asList(ConfigMysticalAdaptations.STONE.get().split(";"));
        DIRT = Arrays.asList(ConfigMysticalAdaptations.DIRT.get().split(";"));
        WOOD = Arrays.asList(ConfigMysticalAdaptations.WOOD.get().split(";"));
        ICE = Arrays.asList(ConfigMysticalAdaptations.ICE.get().split(";"));

        NATURE = Arrays.asList(ConfigMysticalAdaptations.NATURE.get().split(";"));
        DYE = Arrays.asList(ConfigMysticalAdaptations.DYE.get().split(";"));
        NETHER = Arrays.asList(ConfigMysticalAdaptations.NETHER.get().split(";"));
        COAL = Arrays.asList(ConfigMysticalAdaptations.COAL.get().split(";"));
        CORAL = Arrays.asList(ConfigMysticalAdaptations.CORAL.get().split(";"));
        PIG = Arrays.asList(ConfigMysticalAdaptations.PIG.get().split(";"));
        CHICKEN = Arrays.asList(ConfigMysticalAdaptations.CHICKEN.get().split(";"));
        COW = Arrays.asList(ConfigMysticalAdaptations.COW.get().split(";"));
        SHEEP = Arrays.asList(ConfigMysticalAdaptations.SHEEP.get().split(";"));
        SQUID = Arrays.asList(ConfigMysticalAdaptations.SQUID.get().split(";"));
        FISH = Arrays.asList(ConfigMysticalAdaptations.FISH.get().split(";"));
        SLIME = Arrays.asList(ConfigMysticalAdaptations.SLIME.get().split(";"));
        TURTLE = Arrays.asList(ConfigMysticalAdaptations.TURTLE.get().split(";"));

        IRON = Arrays.asList(ConfigMysticalAdaptations.IRON.get().split(";"));
        NETHER_QUARTZ = Arrays.asList(ConfigMysticalAdaptations.NETHER_QUARTZ.get().split(";"));
        GLOWSTONE = Arrays.asList(ConfigMysticalAdaptations.GLOWSTONE.get().split(";"));
        REDSTONE = Arrays.asList(ConfigMysticalAdaptations.REDSTONE.get().split(";"));
        OBSIDIAN = Arrays.asList(ConfigMysticalAdaptations.OBSIDIAN.get().split(";"));
        PRISMARINE = Arrays.asList(ConfigMysticalAdaptations.PRISMARINE.get().split(";"));
        ZOMBIE = Arrays.asList(ConfigMysticalAdaptations.ZOMBIE.get().split(";"));
        SKELETON = Arrays.asList(ConfigMysticalAdaptations.SKELETON.get().split(";"));
        CREEPER = Arrays.asList(ConfigMysticalAdaptations.CREEPER.get().split(";"));
        SPIDER = Arrays.asList(ConfigMysticalAdaptations.SPIDER.get().split(";"));
        RABBIT = Arrays.asList(ConfigMysticalAdaptations.RABBIT.get().split(";"));

        GOLD = Arrays.asList(ConfigMysticalAdaptations.GOLD.get().split(";"));
        LAPIS_LAZULI = Arrays.asList(ConfigMysticalAdaptations.LAPIS_LAZULI.get().split(";"));
        END = Arrays.asList(ConfigMysticalAdaptations.END.get().split(";"));
        EXPERIENCE = Arrays.asList(ConfigMysticalAdaptations.EXPERIENCE.get().split(";"));
        BLAZE = Arrays.asList(ConfigMysticalAdaptations.BLAZE.get().split(";"));
        GHAST = Arrays.asList(ConfigMysticalAdaptations.GHAST.get().split(";"));
        ENDERMAN = Arrays.asList(ConfigMysticalAdaptations.ENDERMAN.get().split(";"));

        DIAMOND = Arrays.asList(ConfigMysticalAdaptations.DIAMOND.get().split(";"));
        EMERALD = Arrays.asList(ConfigMysticalAdaptations.EMERALD.get().split(";"));
        WITHER_SKELETON = Arrays.asList(ConfigMysticalAdaptations.WITHER_SKELETON.get().split(";"));

        INSANIUM_ARMOR = ConfigMysticalAdaptations.INSANIUM_ARMOR.get();
        INSANIUM_TOOLS = ConfigMysticalAdaptations.INSANIUM_TOOLS.get();*/
        ENCHANTABLE_INSANIUM_ARMOR = ConfigMysticalAdaptations.ENCHANTABLE_INSANIUM_ARMOR.get();
        ENCHANTABLE_INSANIUM_TOOLS = ConfigMysticalAdaptations.ENCHANTABLE_INSANIUM_TOOLS.get();
        INSANIUM_ARMOR_AUGMENTS = ConfigMysticalAdaptations.INSANIUM_ARMOR_AUGMENTS.get();
        INSANIUM_TOOLS_AUGMENTS = ConfigMysticalAdaptations.INSANIUM_TOOLS_AUGMENTS.get();

        THIRSTLESS_AUGMENT = ConfigMysticalAdaptations.THIRSTLESS_AUGMENT.get();
        DAYWALKER_AUGMENT = ConfigMysticalAdaptations.DAYWALKER_AUGMENT.get();
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
        final ModConfig config = event.getConfig();

        if (config.getSpec() == ConfigMysticalAdaptations.spec) {
            updateConfigs();
        }
    }

}
