package com.focamacho.mysticaladaptations.lib;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.config.RecipesConfig;

import cofh.thermalfoundation.entity.projectile.EntityBlitzBolt;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SeedExtractorRecipes {

	public static final SeedExtractorRecipe water_seeds = new SeedExtractorRecipe(RecipesConfig.water_seeds, Type.WATER);
	public static final SeedExtractorRecipe wood_seeds = new SeedExtractorRecipe(RecipesConfig.wood_seeds, Type.WOOD);
	public static final SeedExtractorRecipe copper_seeds = new SeedExtractorRecipe(RecipesConfig.copper_seeds, Type.COPPER);
	public static final SeedExtractorRecipe tin_seeds = new SeedExtractorRecipe(RecipesConfig.tin_seeds, Type.TIN);
	public static final SeedExtractorRecipe platinum_seeds = new SeedExtractorRecipe(RecipesConfig.platinum_seeds, Type.PLATINUM);
	public static final SeedExtractorRecipe aluminum_brass_seeds = new SeedExtractorRecipe(RecipesConfig.aluminum_brass_seeds, Type.ALUMINUM_BRASS);
	public static final SeedExtractorRecipe aluminum_seeds = new SeedExtractorRecipe(RecipesConfig.aluminum_seeds, Type.ALUMINUM);
	public static final SeedExtractorRecipe alumite_seeds = new SeedExtractorRecipe(RecipesConfig.alumite_seeds, Type.ALUMITE);
	public static final SeedExtractorRecipe ardite_seeds = new SeedExtractorRecipe(RecipesConfig.ardite_seeds, Type.ARDITE);
	public static final SeedExtractorRecipe black_quartz_seeds = new SeedExtractorRecipe(RecipesConfig.black_quartz_seeds, Type.BLACK_QUARTZ);
	public static final SeedExtractorRecipe boron_seeds = new SeedExtractorRecipe(RecipesConfig.boron_seeds, Type.BORON);
	public static final SeedExtractorRecipe brass_seeds = new SeedExtractorRecipe(RecipesConfig.brass_seeds, Type.BRASS);
	public static final SeedExtractorRecipe bronze_seeds = new SeedExtractorRecipe(RecipesConfig.bronze_seeds, Type.BRONZE);
	public static final SeedExtractorRecipe chrome_seeds = new SeedExtractorRecipe(RecipesConfig.chrome_seeds, Type.CHROME);
	public static final SeedExtractorRecipe coal_seeds = new SeedExtractorRecipe(RecipesConfig.coal_seeds, Type.COAL);
	public static final SeedExtractorRecipe cobalt_seeds = new SeedExtractorRecipe(RecipesConfig.cobalt_seeds, Type.COBALT);
	public static final SeedExtractorRecipe conductive_iron_seeds = new SeedExtractorRecipe(RecipesConfig.conductive_iron_seeds, Type.CONDUCTIVE_IRON);
	public static final SeedExtractorRecipe constantan_seeds = new SeedExtractorRecipe(RecipesConfig.constantan_seeds, Type.CONSTANTAN);
	public static final SeedExtractorRecipe dark_steel_seeds = new SeedExtractorRecipe(RecipesConfig.dark_steel_seeds, Type.DARK_STEEL);
	public static final SeedExtractorRecipe diamond_seeds = new SeedExtractorRecipe(RecipesConfig.diamond_seeds, Type.DIAMOND);
	public static final SeedExtractorRecipe draconium_seeds = new SeedExtractorRecipe(RecipesConfig.draconium_seeds, Type.DRACONIUM);
	public static final SeedExtractorRecipe dirt_seeds = new SeedExtractorRecipe(RecipesConfig.dirt_seeds, Type.DIRT);
	public static final SeedExtractorRecipe electrical_steel_seeds = new SeedExtractorRecipe(RecipesConfig.electrical_steel_seeds, Type.ELECTRICAL_STEEL);
	public static final SeedExtractorRecipe electrum_seeds = new SeedExtractorRecipe(RecipesConfig.electrum_seeds, Type.ELECTRUM);
	public static final SeedExtractorRecipe emerald_seeds = new SeedExtractorRecipe(RecipesConfig.emerald_seeds, Type.EMERALD);
	public static final SeedExtractorRecipe end_steel_seeds = new SeedExtractorRecipe(RecipesConfig.end_steel_seeds, Type.END_STEEL);
	public static final SeedExtractorRecipe enderium_seeds = new SeedExtractorRecipe(RecipesConfig.enderium_seeds, Type.ENDERIUM);
	public static final SeedExtractorRecipe energetic_alloy_seeds = new SeedExtractorRecipe(RecipesConfig.energetic_alloy_seeds, Type.ENERGETIC_ALLOY);
	public static final SeedExtractorRecipe glowstone_ingot_seeds = new SeedExtractorRecipe(RecipesConfig.glowstone_ingot_seeds, Type.GLOWSTONE_INGOT);
	public static final SeedExtractorRecipe glowstone_seeds = new SeedExtractorRecipe(RecipesConfig.glowstone_seeds, Type.GLOWSTONE);
	public static final SeedExtractorRecipe gold_seeds = new SeedExtractorRecipe(RecipesConfig.gold_seeds, Type.GOLD);
	public static final SeedExtractorRecipe grains_of_infinity_seeds = new SeedExtractorRecipe(RecipesConfig.grains_of_infinity_seeds, Type.GRAINS_OF_INFINITY);
	public static final SeedExtractorRecipe invar_seeds = new SeedExtractorRecipe(RecipesConfig.invar_seeds, Type.INVAR);
	public static final SeedExtractorRecipe iridium_seeds = new SeedExtractorRecipe(RecipesConfig.iridium_seeds, Type.IRIDIUM);
	public static final SeedExtractorRecipe iron_seeds = new SeedExtractorRecipe(RecipesConfig.iron_seeds, Type.IRON);
	public static final SeedExtractorRecipe knightslime_seeds = new SeedExtractorRecipe(RecipesConfig.knightslime_seeds, Type.KNIGHTSLIME);
	public static final SeedExtractorRecipe lapis_lazuli_seeds = new SeedExtractorRecipe(RecipesConfig.lapis_lazuli_seeds, Type.LAPIS_LAZULI);
	public static final SeedExtractorRecipe lead_seeds = new SeedExtractorRecipe(RecipesConfig.lead_seeds, Type.LEAD);
	public static final SeedExtractorRecipe limestone_seeds = new SeedExtractorRecipe(RecipesConfig.limestone_seeds, Type.LIMESTONE);
	public static final SeedExtractorRecipe lithium_seeds = new SeedExtractorRecipe(RecipesConfig.lithium_seeds, Type.LITHIUM);
	public static final SeedExtractorRecipe lumium_seeds = new SeedExtractorRecipe(RecipesConfig.lumium_seeds, Type.LUMIUM);
	public static final SeedExtractorRecipe magnesium_seeds = new SeedExtractorRecipe(RecipesConfig.magnesium_seeds, Type.MAGNESIUM);
	public static final SeedExtractorRecipe manyullyn_seeds = new SeedExtractorRecipe(RecipesConfig.manyullyn_seeds, Type.MANYULLYN);
	public static final SeedExtractorRecipe marble_seeds = new SeedExtractorRecipe(RecipesConfig.marble_seeds, Type.MARBLE);
	public static final SeedExtractorRecipe mithril_seeds = new SeedExtractorRecipe(RecipesConfig.mithril_seeds, Type.MITHRIL);
	public static final SeedExtractorRecipe nether_quartz_seeds = new SeedExtractorRecipe(RecipesConfig.nether_quartz_seeds, Type.NETHER_QUARTZ);
	public static final SeedExtractorRecipe nickel_seeds = new SeedExtractorRecipe(RecipesConfig.nickel_seeds, Type.NICKEL);
	public static final SeedExtractorRecipe obsidian_seeds = new SeedExtractorRecipe(RecipesConfig.obsidian_seeds, Type.OBSIDIAN);
	public static final SeedExtractorRecipe osmium_seeds = new SeedExtractorRecipe(RecipesConfig.osmium_seeds, Type.OSMIUM);
	public static final SeedExtractorRecipe peridot_seeds = new SeedExtractorRecipe(RecipesConfig.peridot_seeds, Type.PERIDOT);
	public static final SeedExtractorRecipe pulsating_iron_seeds = new SeedExtractorRecipe(RecipesConfig.pulsating_iron_seeds, Type.PULSATING_IRON);
	public static final SeedExtractorRecipe redstone_alloy_seeds = new SeedExtractorRecipe(RecipesConfig.redstone_alloy_seeds, Type.REDSTONE_ALLOY);
	public static final SeedExtractorRecipe redstone_seeds = new SeedExtractorRecipe(RecipesConfig.redstone_seeds, Type.REDSTONE);
	public static final SeedExtractorRecipe refined_obsidian_seeds = new SeedExtractorRecipe(RecipesConfig.refined_obsidian_seeds, Type.REFINED_OBSIDIAN);
	public static final SeedExtractorRecipe ruby_seeds = new SeedExtractorRecipe(RecipesConfig.ruby_seeds, Type.RUBY);
	public static final SeedExtractorRecipe sapphire_seeds = new SeedExtractorRecipe(RecipesConfig.sapphire_seeds, Type.SAPPHIRE);
	public static final SeedExtractorRecipe signalum_seeds = new SeedExtractorRecipe(RecipesConfig.signalum_seeds, Type.SIGNALUM);
	public static final SeedExtractorRecipe silver_seeds = new SeedExtractorRecipe(RecipesConfig.silver_seeds, Type.SILVER);
	public static final SeedExtractorRecipe slate_seeds = new SeedExtractorRecipe(RecipesConfig.slate_seeds, Type.SLATE);
	public static final SeedExtractorRecipe slime_seeds = new SeedExtractorRecipe(RecipesConfig.slime_seeds, Type.SLIME);
	public static final SeedExtractorRecipe soularium_seeds = new SeedExtractorRecipe(RecipesConfig.soularium_seeds, Type.SOULARIUM);
	public static final SeedExtractorRecipe steel_seeds = new SeedExtractorRecipe(RecipesConfig.steel_seeds, Type.STEEL);
	public static final SeedExtractorRecipe thorium_seeds = new SeedExtractorRecipe(RecipesConfig.thorium_seeds, Type.THORIUM);
	public static final SeedExtractorRecipe titanium_seeds = new SeedExtractorRecipe(RecipesConfig.titanium_seeds, Type.TITANIUM);
	public static final SeedExtractorRecipe tungsten_seeds = new SeedExtractorRecipe(RecipesConfig.tungsten_seeds, Type.TUNGSTEN);
	public static final SeedExtractorRecipe uranium_seeds = new SeedExtractorRecipe(RecipesConfig.uranium_seeds, Type.URANIUM);
	public static final SeedExtractorRecipe vibrant_alloy_seeds = new SeedExtractorRecipe(RecipesConfig.vibrant_alloy_seeds, Type.VIBRANT_ALLOY);
	public static final SeedExtractorRecipe zinc_seeds = new SeedExtractorRecipe(RecipesConfig.zinc_seeds, Type.ZINC);
	public static final SeedExtractorRecipe abyssalnite_seeds = new SeedExtractorRecipe(RecipesConfig.abyssalnite_seeds, Type.ABYSSALNITE);
	public static final SeedExtractorRecipe adamantine_seeds = new SeedExtractorRecipe(RecipesConfig.adamantine_seeds, Type.ADAMANTINE);
	public static final SeedExtractorRecipe apatite_seeds = new SeedExtractorRecipe(RecipesConfig.apatite_seeds, Type.APATITE);
	public static final SeedExtractorRecipe aquarium_seeds = new SeedExtractorRecipe(RecipesConfig.aquarium_seeds, Type.AQUARIUM);
	public static final SeedExtractorRecipe basalt_seeds = new SeedExtractorRecipe(RecipesConfig.basalt_seeds, Type.BASALT);
	public static final SeedExtractorRecipe cold_iron_seeds = new SeedExtractorRecipe(RecipesConfig.cold_iron_seeds, Type.COLD_IRON);
	public static final SeedExtractorRecipe compressed_iron_seeds = new SeedExtractorRecipe(RecipesConfig.compressed_iron_seeds, Type.COMPRESSED_IRON);
	public static final SeedExtractorRecipe coralium_seeds = new SeedExtractorRecipe(RecipesConfig.coralium_seeds, Type.CORALIUM);
	public static final SeedExtractorRecipe dawnstone_seeds = new SeedExtractorRecipe(RecipesConfig.dawnstone_seeds, Type.DAWNSTONE);
	public static final SeedExtractorRecipe desh_seeds = new SeedExtractorRecipe(RecipesConfig.desh_seeds, Type.DESH);
	public static final SeedExtractorRecipe dreadium_seeds = new SeedExtractorRecipe(RecipesConfig.dreadium_seeds, Type.DREADIUM);
	public static final SeedExtractorRecipe end_seeds = new SeedExtractorRecipe(RecipesConfig.end_seeds, Type.END);
	public static final SeedExtractorRecipe fiery_ingot_seeds = new SeedExtractorRecipe(RecipesConfig.fiery_ingot_seeds, Type.FIERY_INGOT);
	public static final SeedExtractorRecipe fluxed_electrum_seeds = new SeedExtractorRecipe(RecipesConfig.fluxed_electrum_seeds, Type.FLUXED_ELECTRUM);
	public static final SeedExtractorRecipe jade_seeds = new SeedExtractorRecipe(RecipesConfig.jade_seeds, Type.JADE);
	public static final SeedExtractorRecipe knightmetal_seeds = new SeedExtractorRecipe(RecipesConfig.knightmetal_seeds, Type.KNIGHTMETAL);
	public static final SeedExtractorRecipe nether_seeds = new SeedExtractorRecipe(RecipesConfig.nether_seeds, Type.NETHER);
	public static final SeedExtractorRecipe octine_seeds = new SeedExtractorRecipe(RecipesConfig.octine_seeds, Type.OCTINE);
	public static final SeedExtractorRecipe slimy_bone_seeds = new SeedExtractorRecipe(RecipesConfig.slimy_bone_seeds, Type.SLIMY_BONE);
	public static final SeedExtractorRecipe star_steel_seeds = new SeedExtractorRecipe(RecipesConfig.star_steel_seeds, Type.STAR_STEEL);
	public static final SeedExtractorRecipe steeleaf_seeds = new SeedExtractorRecipe(RecipesConfig.steeleaf_seeds, Type.STEELEAF);
	public static final SeedExtractorRecipe syrmorite_seeds = new SeedExtractorRecipe(RecipesConfig.syrmorite_seeds, Type.SYRMORITE);
	public static final SeedExtractorRecipe thaumium_seeds = new SeedExtractorRecipe(RecipesConfig.thaumium_seeds, Type.THAUMIUM);
	public static final SeedExtractorRecipe tritanium_seeds = new SeedExtractorRecipe(RecipesConfig.tritanium_seeds, Type.TRITANIUM);
	public static final SeedExtractorRecipe valonite_seeds = new SeedExtractorRecipe(RecipesConfig.valonite_seeds, Type.VALONITE);
	public static final SeedExtractorRecipe void_metal_seeds = new SeedExtractorRecipe(RecipesConfig.void_metal_seeds, Type.VOID_METAL);
	public static final SeedExtractorRecipe ice_seeds = new SeedExtractorRecipe(RecipesConfig.ice_seeds, Type.ICE);
	public static final SeedExtractorRecipe amber_seeds = new SeedExtractorRecipe(RecipesConfig.amber_seeds, Type.AMBER);
	public static final SeedExtractorRecipe certus_quartz_seeds = new SeedExtractorRecipe(RecipesConfig.certus_quartz_seeds, Type.CERTUS_QUARTZ);
	public static final SeedExtractorRecipe dark_gem_seeds = new SeedExtractorRecipe(RecipesConfig.dark_gem_seeds, Type.DARK_GEM);
	public static final SeedExtractorRecipe elementium_seeds = new SeedExtractorRecipe(RecipesConfig.elementium_seeds, Type.ELEMENTIUM);
	public static final SeedExtractorRecipe ender_amethyst_seeds = new SeedExtractorRecipe(RecipesConfig.ender_amethyst_seeds, Type.ENDER_AMETHYST);
	public static final SeedExtractorRecipe ender_biotite_seeds = new SeedExtractorRecipe(RecipesConfig.ender_biotite_seeds, Type.ENDER_BIOTITE);
	public static final SeedExtractorRecipe fluix_seeds = new SeedExtractorRecipe(RecipesConfig.fluix_seeds, Type.FLUIX);
	public static final SeedExtractorRecipe ironwood_seeds = new SeedExtractorRecipe(RecipesConfig.ironwood_seeds, Type.IRONWOOD);
	public static final SeedExtractorRecipe malachite_seeds = new SeedExtractorRecipe(RecipesConfig.malachite_seeds, Type.MALACHITE);
	public static final SeedExtractorRecipe manasteel_seeds = new SeedExtractorRecipe(RecipesConfig.manasteel_seeds, Type.MANASTEEL);
	public static final SeedExtractorRecipe menril_seeds = new SeedExtractorRecipe(RecipesConfig.menril_seeds, Type.MENRIL);
	public static final SeedExtractorRecipe meteoric_iron_seeds = new SeedExtractorRecipe(RecipesConfig.meteoric_iron_seeds, Type.METEORIC_IRON);
	public static final SeedExtractorRecipe quartz_enriched_iron_seeds = new SeedExtractorRecipe(RecipesConfig.quartz_enriched_iron_seeds, Type.QUARTZ_ENRICHED_IRON);
	public static final SeedExtractorRecipe rock_crystal_seeds = new SeedExtractorRecipe(RecipesConfig.rock_crystal_seeds, Type.ROCK_CRYSTAL);
	public static final SeedExtractorRecipe sky_stone_seeds = new SeedExtractorRecipe(RecipesConfig.sky_stone_seeds, Type.SKY_STONE);
	public static final SeedExtractorRecipe tanzanite_seeds = new SeedExtractorRecipe(RecipesConfig.tanzanite_seeds, Type.TANZANITE);
	public static final SeedExtractorRecipe terrasteel_seeds = new SeedExtractorRecipe(RecipesConfig.terrasteel_seeds, Type.TERRASTEEL);
	public static final SeedExtractorRecipe topaz_seeds = new SeedExtractorRecipe(RecipesConfig.topaz_seeds, Type.TOPAZ);
	public static final SeedExtractorRecipe blue_topaz_seeds = new SeedExtractorRecipe(RecipesConfig.blue_topaz_seeds, Type.BLUE_TOPAZ);
	public static final SeedExtractorRecipe chimerite_seeds = new SeedExtractorRecipe(RecipesConfig.chimerite_seeds, Type.CHIMERITE);
	public static final SeedExtractorRecipe graphite_seeds = new SeedExtractorRecipe(RecipesConfig.graphite_seeds, Type.GRAPHITE);
	public static final SeedExtractorRecipe moonstone_seeds = new SeedExtractorRecipe(RecipesConfig.moonstone_seeds, Type.MOONSTONE);
	public static final SeedExtractorRecipe sunstone_seeds = new SeedExtractorRecipe(RecipesConfig.sunstone_seeds, Type.SUNSTONE);
	public static final SeedExtractorRecipe vinteum_seeds = new SeedExtractorRecipe(RecipesConfig.vinteum_seeds, Type.VINTEUM);
	public static final SeedExtractorRecipe yellorium_seeds = new SeedExtractorRecipe(RecipesConfig.yellorium_seeds, Type.YELLORIUM);
	public static final SeedExtractorRecipe mystical_flower_seeds = new SeedExtractorRecipe(RecipesConfig.mystical_flower_seeds, Type.MYSTICAL_FLOWER);
	public static final SeedExtractorRecipe nature_seeds = new SeedExtractorRecipe(RecipesConfig.nature_seeds, Type.NATURE);
	public static final SeedExtractorRecipe stone_seeds = new SeedExtractorRecipe(RecipesConfig.stone_seeds, Type.STONE);
	public static final SeedExtractorRecipe fire_seeds = new SeedExtractorRecipe(RecipesConfig.fire_seeds, Type.FIRE);
	public static final SeedExtractorRecipe aquamarine_seeds = new SeedExtractorRecipe(RecipesConfig.aquamarine_seeds, Type.AQUAMARINE);
	public static final SeedExtractorRecipe dilithium_seeds = new SeedExtractorRecipe(RecipesConfig.dilithium_seeds, Type.DILITHIUM);
	public static final SeedExtractorRecipe iridium_ore_seeds = new SeedExtractorRecipe(RecipesConfig.iridium_ore_seeds, Type.IRIDIUM_ORE);
	public static final SeedExtractorRecipe rubber_seeds = new SeedExtractorRecipe(RecipesConfig.rubber_seeds, Type.RUBBER);
	public static final SeedExtractorRecipe starmetal_seeds = new SeedExtractorRecipe(RecipesConfig.starmetal_seeds, Type.STARMETAL);
	public static final SeedExtractorRecipe uranium_238_seeds = new SeedExtractorRecipe(RecipesConfig.uranium_238_seeds, Type.URANIUM_238);
	public static final SeedExtractorRecipe quicksilver_seeds = new SeedExtractorRecipe(RecipesConfig.quicksilver_seeds, Type.QUICKSILVER);
	public static final SeedExtractorRecipe dye_seeds = new SeedExtractorRecipe(RecipesConfig.dye_seeds, Type.DYE);
	public static final SeedExtractorRecipe nether_star_seeds = new SeedExtractorRecipe(RecipesConfig.nether_star_seeds, new ItemStack(Item.getByNameOrId("mysticalagradditions:nether_star_seeds")), 6);
	public static final SeedExtractorRecipe awakened_draconium_seeds = new SeedExtractorRecipe(RecipesConfig.awakened_draconium_seeds, new ItemStack(Item.getByNameOrId("mysticalagradditions:awakened_draconium_seeds")), 6);
	public static final SeedExtractorRecipe dragon_egg_seeds = new SeedExtractorRecipe(RecipesConfig.dragon_egg_seeds, new ItemStack(Item.getByNameOrId("mysticalagradditions:dragon_egg_seeds")), 6);
	public static final SeedExtractorRecipe neutronium_seeds = new SeedExtractorRecipe(RecipesConfig.neutronium_seeds, new ItemStack(Item.getByNameOrId("mysticalagradditions:neutronium_seeds")), 6);
	public static final SeedExtractorRecipe silicon_seeds = new SeedExtractorRecipe(RecipesConfig.silicon_seeds, Type.SILICON);
	public static final SeedExtractorRecipe basalz_seeds = new SeedExtractorRecipe(RecipesConfig.basalz_seeds, Type.BASALZ);
	public static final SeedExtractorRecipe blaze_seeds = new SeedExtractorRecipe(RecipesConfig.blaze_seeds, Type.BLAZE);
	public static final SeedExtractorRecipe blitz_seeds = new SeedExtractorRecipe(RecipesConfig.blitz_seeds, Type.BLITZ);
	public static final SeedExtractorRecipe blizz_seeds = new SeedExtractorRecipe(RecipesConfig.blizz_seeds, Type.BLIZZ);
	public static final SeedExtractorRecipe chicken_seeds = new SeedExtractorRecipe(RecipesConfig.chicken_seeds, Type.CHICKEN);
	public static final SeedExtractorRecipe cow_seeds = new SeedExtractorRecipe(RecipesConfig.cow_seeds, Type.COW);
	public static final SeedExtractorRecipe creeper_seeds = new SeedExtractorRecipe(RecipesConfig.creeper_seeds, Type.CREEPER);
	public static final SeedExtractorRecipe enderman_seeds = new SeedExtractorRecipe(RecipesConfig.enderman_seeds, Type.ENDERMAN);
	public static final SeedExtractorRecipe ghast_seeds = new SeedExtractorRecipe(RecipesConfig.ghast_seeds, Type.GHAST);
	public static final SeedExtractorRecipe guardian_seeds= new SeedExtractorRecipe(RecipesConfig.guardian_seeds, Type.GUARDIAN);
	public static final SeedExtractorRecipe pig_seeds = new SeedExtractorRecipe(RecipesConfig.pig_seeds, Type.PIG);
	public static final SeedExtractorRecipe rabbit_seeds = new SeedExtractorRecipe(RecipesConfig.rabbit_seeds, Type.RABBIT);
	public static final SeedExtractorRecipe sheep_seeds = new SeedExtractorRecipe(RecipesConfig.sheep_seeds, Type.SHEEP);
	public static final SeedExtractorRecipe skeleton_seeds = new SeedExtractorRecipe(RecipesConfig.skeleton_seeds, Type.SKELETON);
	public static final SeedExtractorRecipe spider_seeds = new SeedExtractorRecipe(RecipesConfig.spider_seeds, Type.SPIDER);
	public static final SeedExtractorRecipe wither_skeleton_seeds = new SeedExtractorRecipe(RecipesConfig.wither_skeleton_seeds, Type.WITHER_SKELETON);
	public static final SeedExtractorRecipe zombie_seeds = new SeedExtractorRecipe(RecipesConfig.zombie_seeds, Type.ZOMBIE);
	public static final List<SeedExtractorRecipe> allRecipes = new ArrayList<SeedExtractorRecipe>(Arrays.asList((water_seeds),
			(wood_seeds),
			(copper_seeds),
			(tin_seeds),
			(platinum_seeds),
			(aluminum_brass_seeds),
			(aluminum_seeds),
			(alumite_seeds),
			(ardite_seeds),
			(black_quartz_seeds),
			(boron_seeds),
			(brass_seeds),
			(bronze_seeds),
			(chrome_seeds),
			(coal_seeds),
			(cobalt_seeds),
			(conductive_iron_seeds),
			(constantan_seeds),
			(dark_steel_seeds),
			(diamond_seeds),
			(draconium_seeds),
			(dirt_seeds),
			(electrical_steel_seeds),
			(electrum_seeds),
			(emerald_seeds),
			(end_steel_seeds),
			(enderium_seeds),
			(energetic_alloy_seeds),
			(glowstone_ingot_seeds),
			(glowstone_seeds),
			(gold_seeds),
			(grains_of_infinity_seeds),
			(invar_seeds),
			(iridium_seeds),
			(iron_seeds),
			(knightslime_seeds),
			(lapis_lazuli_seeds),
			(lead_seeds),
			(limestone_seeds),
			(lithium_seeds),
			(lumium_seeds),
			(magnesium_seeds),
			(manyullyn_seeds),
			(marble_seeds),
			(mithril_seeds),
			(nether_quartz_seeds),
			(nickel_seeds),
			(obsidian_seeds),
			(osmium_seeds),
			(peridot_seeds),
			(pulsating_iron_seeds),
			(redstone_alloy_seeds),
			(redstone_seeds),
			(refined_obsidian_seeds),
			(ruby_seeds),
			(sapphire_seeds),
			(signalum_seeds),
			(silver_seeds),
			(slate_seeds),
			(slime_seeds),
			(soularium_seeds),
			(steel_seeds),
			(thorium_seeds),
			(titanium_seeds),
			(tungsten_seeds),
			(uranium_seeds),
			(vibrant_alloy_seeds),
			(zinc_seeds),
			(abyssalnite_seeds),
			(adamantine_seeds),
			(apatite_seeds),
			(aquarium_seeds),
			(basalt_seeds),
			(cold_iron_seeds),
			(compressed_iron_seeds),
			(coralium_seeds),
			(dawnstone_seeds),
			(desh_seeds),
			(dreadium_seeds),
			(end_seeds),
			(fiery_ingot_seeds),
			(fluxed_electrum_seeds),
			(jade_seeds),
			(knightmetal_seeds),
			(nether_seeds),
			(octine_seeds),
			(slimy_bone_seeds),
			(star_steel_seeds),
			(steeleaf_seeds),
			(syrmorite_seeds),
			(thaumium_seeds),
			(tritanium_seeds),
			(valonite_seeds),
			(void_metal_seeds),
			(ice_seeds),
			(amber_seeds),
			(certus_quartz_seeds),
			(dark_gem_seeds),
			(elementium_seeds),
			(ender_amethyst_seeds),
			(ender_biotite_seeds),
			(fluix_seeds),
			(ironwood_seeds),
			(malachite_seeds),
			(manasteel_seeds),
			(menril_seeds),
			(meteoric_iron_seeds),
			(quartz_enriched_iron_seeds),
			(rock_crystal_seeds),
			(sky_stone_seeds),
			(tanzanite_seeds),
			(terrasteel_seeds),
			(topaz_seeds),
			(blue_topaz_seeds),
			(chimerite_seeds),
			(graphite_seeds),
			(moonstone_seeds),
			(sunstone_seeds),
			(vinteum_seeds),
			(yellorium_seeds),
			(mystical_flower_seeds),
			(nature_seeds),
			(stone_seeds),
			(fire_seeds),
			(aquamarine_seeds),
			(dilithium_seeds),
			(iridium_ore_seeds),
			(rubber_seeds),
			(starmetal_seeds),
			(uranium_238_seeds),
			(quicksilver_seeds),
			(dye_seeds),
			(nether_star_seeds),
			(awakened_draconium_seeds),
			(dragon_egg_seeds),
			(neutronium_seeds),
			(silicon_seeds),
			(basalz_seeds),
			(blaze_seeds),
			(blitz_seeds),
			(blizz_seeds),
			(chicken_seeds),
			(cow_seeds),
			(creeper_seeds),
			(enderman_seeds),
			(ghast_seeds),
			(guardian_seeds),
			(pig_seeds),
			(rabbit_seeds),
			(sheep_seeds),
			(skeleton_seeds),
			(spider_seeds),
			(wither_skeleton_seeds),
			(zombie_seeds)));
}
