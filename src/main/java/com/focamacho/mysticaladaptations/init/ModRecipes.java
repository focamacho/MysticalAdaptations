package com.focamacho.mysticaladaptations.init;

import java.util.ArrayList;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.crafting.TinkeringTableManager;
import com.blakebr0.mysticalagriculture.items.armor.ArmorType;
import com.blakebr0.mysticalagriculture.items.tools.ToolType;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.google.common.collect.Lists;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.ForgeRegistry;

public class ModRecipes {
	
	public static final ItemStack insanium_nugget = new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium"), 1, 3);
	public static final ItemStack insanium_ingot = new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium"), 1, 2);
	public static final ItemStack insanium_block = new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium"), 1, 1);
	
	public static void addShapedRecipe(ItemStack output, Object... input){
		RecipeHelper.addShapedRecipe(output, input);
	}
	
	public static void addUpgradeRecipe(ItemStack output, ItemStack input, int type){
		TinkeringTableManager.getInstance().addUpgradeRecipe(output, type,
				"ACE", 
				"PEP", 
				"EPE",
				'A', new ItemStack(output.getItem(), 1, OreDictionary.WILDCARD_VALUE),
				'C', input,
				'E', new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium")),
				'P', com.blakebr0.mysticalagriculture.items.ModItems.itemCrafting.itemProsperityShard);
	}
	
	public static void addShapelessRecipe(ItemStack output, Object... input){
		RecipeHelper.addShapelessRecipe(output, input);
	}
	
	public static void initRecipes() {
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_ARMOR) {
			addShapedRecipe(new ItemStack(ModItems.INSANIUM_HELMET), "ICI", "I I", "   ", 'I', insanium_ingot, 'C', ModItems.GEAR_ARMOR);
			addShapedRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), "I I", "ICI", "III", 'I', insanium_ingot, 'C', ModItems.GEAR_ARMOR);
			addShapedRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), "ICI", "I I", "I I", 'I', insanium_ingot, 'C', ModItems.GEAR_ARMOR);
			addShapedRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), "I I", "I C", "   ", 'I', insanium_ingot, 'C', ModItems.GEAR_ARMOR);
			
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmNightvision, ArmorType.NIGHT_VISION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmAbsorption, ArmorType.ABSORPTION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmWither, ArmorType.WITHER_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmAntivenom, ArmorType.ANTIVENOM.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmFire, ArmorType.FIRE_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmResistance, ArmorType.RESISTANCE.getIndex());

			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmStrength, ArmorType.STRENGTH.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmAbsorption, ArmorType.ABSORPTION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmWither, ArmorType.WITHER_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmAntivenom, ArmorType.ANTIVENOM.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmFire, ArmorType.FIRE_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmResistance, ArmorType.RESISTANCE.getIndex());
			
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmSpeed, ArmorType.SPEED.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmAbsorption, ArmorType.ABSORPTION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmWither, ArmorType.WITHER_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmAntivenom, ArmorType.ANTIVENOM.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmFire, ArmorType.FIRE_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmResistance, ArmorType.RESISTANCE.getIndex());
			
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmJump, ArmorType.JUMP.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmAbsorption, ArmorType.ABSORPTION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmWither, ArmorType.WITHER_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmAntivenom, ArmorType.ANTIVENOM.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmFire, ArmorType.FIRE_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmResistance, ArmorType.RESISTANCE.getIndex());
			
			addShapelessRecipe(new ItemStack(ModItems.GEAR_ARMOR), new ItemStack(ModItems.INSANIUM_HELMET, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR_ARMOR), new ItemStack(ModItems.INSANIUM_CHESTPLATE, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR_ARMOR), new ItemStack(ModItems.INSANIUM_LEGGINGS, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR_ARMOR), new ItemStack(ModItems.INSANIUM_BOOTS, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
		}
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_TOOLS) {
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SWORD), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmStrength, ToolType.STRENGTH.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SWORD), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmStrength2, ToolType.STRENGTH_2.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SWORD), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmAttackAOE, ToolType.ATTACK_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_PICKAXE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmMinersVision, ToolType.MINERS_VISION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_PICKAXE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmMiningAOE, ToolType.MINING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SHOVEL), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmMiningAOE, ToolType.MINING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_AXE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmMiningAOE, ToolType.MINING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HOE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmTillingAOE, ToolType.TILLING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SHEARS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmRainbow, ToolType.RAINBOW.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SHEARS), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmShearingAOE, ToolType.SHEARING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOW), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmQuickDraw, ToolType.QUICK_DRAW.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOW), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmTripleShot, ToolType.TRIPLE_SHOT.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SICKLE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmReapingAOE, ToolType.REAPING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SCYTHE), com.blakebr0.mysticalagriculture.items.ModItems.itemCharm.itemCharmScythingAOE, ToolType.SCYTHING_AOE.getIndex());
	    
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_SWORD, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_PICKAXE, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_SHOVEL, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_AXE, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_HOE, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_SHEARS, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_BOW, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_SICKLE, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_SCYTHE, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_FISHING_ROD, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			
			if(com.blakebr0.mysticalagriculture.config.ModConfig.confWateringCans) addShapelessRecipe(new ItemStack(ModItems.INSANIUM_FERTILIZATION_CORE), ModItems.WATERING_CAN_INSANIUM, new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			
			if(ModConfig.ENABLE_SEED_EXTRACTORS) {
				addShapelessRecipe(new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemGear, 1, 0), new ItemStack(ModItems.INFERIUM_SEED_EXTRACTOR, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
				addShapelessRecipe(new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemGear, 1, 1), new ItemStack(ModItems.PRUDENTIUM_SEED_EXTRACTOR, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
				addShapelessRecipe(new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemGear, 1, 2), new ItemStack(ModItems.INTERMEDIUM_SEED_EXTRACTOR, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
				addShapelessRecipe(new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemGear, 1, 3), new ItemStack(ModItems.SUPERIUM_SEED_EXTRACTOR, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
				addShapelessRecipe(new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemGear, 1, 4), new ItemStack(ModItems.SUPREMIUM_SEED_EXTRACTOR, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
				if(ModCheck.MYSTICAL_AGRADDITIONS) {
					addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_SEED_EXTRACTOR, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
				}
			}
		}
		
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_FURNACE && ModConfig.ULTIMATE_FURNACE_RECIPE && com.blakebr0.mysticalagriculture.config.ModConfig.confUltimateFurnace && com.blakebr0.mysticalagriculture.config.ModConfig.confEssenceFurnaces) {
			ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
		    ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValues());
			
		    for(IRecipe recipe : recipes) {
		    	if(recipe.getRegistryName().toString().equalsIgnoreCase("mysticalagriculture:core/ultimate_furnace") && recipe.getRecipeOutput().getItem().equals(new ItemStack(com.blakebr0.mysticalagriculture.blocks.ModBlocks.blockUltimateFurnace).getItem())) {
		    		recipeRegistry.remove(recipe.getRegistryName());
		    		RecipeHelper.addShapedRecipe(recipe.getRegistryName(), new ItemStack(com.blakebr0.mysticalagriculture.blocks.ModBlocks.blockUltimateFurnace), "WSW", "IFI", "WIW", 'W', new ItemStack(Items.SKULL, 1, 1), 'S', Items.NETHER_STAR, 'I', new ItemStack(Item.getByNameOrId("mysticalagradditions:storage"), 1), 'F', new ItemStack(ModBlocks.INSANIUM_FURNACE_BLOCK));
		    	}
		    }
		}
		
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_REPROCESSOR && ModConfig.ULTIMATE_REPROCESSOR_RECIPE && com.blakebr0.mysticalagriculture.config.ModConfig.confUltimateReprocessor && com.blakebr0.mysticalagriculture.config.ModConfig.confSeedReprocessor) {
			ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
		    ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValues());
			
		    for(IRecipe recipe : recipes) {
		    	if(recipe.getRegistryName().toString().equalsIgnoreCase("mysticalagriculture:ultimate_reprocessor") && recipe.getRecipeOutput().getItem().equals(new ItemStack(com.blakebr0.mysticalagriculture.blocks.ModBlocks.ULTIMATE_REPROCESSOR).getItem())) {
		    		recipeRegistry.remove(recipe.getRegistryName());
		    		RecipeHelper.addShapedRecipe(recipe.getRegistryName(), new ItemStack(com.blakebr0.mysticalagriculture.blocks.ModBlocks.ULTIMATE_REPROCESSOR), "WSW", "IFI", "WIW", 'W', new ItemStack(Items.SKULL, 1, 1), 'S', Items.NETHER_STAR, 'I', new ItemStack(Item.getByNameOrId("mysticalagradditions:storage"), 1), 'F', new ItemStack(ModBlocks.INSANIUM_REPROCESSOR_BLOCK));
		    	}
		    }
		}
		
		
	}
	
}
