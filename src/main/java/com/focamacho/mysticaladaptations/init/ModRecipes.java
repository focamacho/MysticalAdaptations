package com.focamacho.mysticaladaptations.init;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.crafting.TinkeringTableManager;
import com.blakebr0.mysticalagriculture.items.ItemCharm;
import com.blakebr0.mysticalagriculture.items.ItemCrafting;
import com.blakebr0.mysticalagriculture.items.armor.ArmorType;
import com.blakebr0.mysticalagriculture.items.tools.ToolType;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.util.ModCheck;
import com.google.common.collect.Lists;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.ForgeRegistry;

import java.util.List;

public class ModRecipes {

	public static final ItemStack insaniumEssence = new ItemStack(com.blakebr0.mysticalagradditions.items.ModItems.itemInsanium, 1, 0);
	public static final ItemStack insaniumIngot = new ItemStack(com.blakebr0.mysticalagradditions.items.ModItems.itemInsanium, 1, 2);
	public static final ItemStack insaniumBlock = new ItemStack(com.blakebr0.mysticalagradditions.blocks.ModBlocks.blockStorage, 1, 0);
	
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
				'E', insaniumEssence,
				'P', ItemCrafting.itemProsperityShard);
	}
	
	public static void addShapelessRecipe(ItemStack output, Object... input){
		RecipeHelper.addShapelessRecipe(output, input);
	}
	
	public static void initRecipes() {
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_ARMOR) {
			addShapedRecipe(new ItemStack(ModItems.INSANIUM_HELMET), "ICI", "I I", "   ", 'I', insaniumIngot, 'C', ModItems.GEAR_ARMOR);
			addShapedRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), "I I", "ICI", "III", 'I', insaniumIngot, 'C', ModItems.GEAR_ARMOR);
			addShapedRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), "ICI", "I I", "I I", 'I', insaniumIngot, 'C', ModItems.GEAR_ARMOR);
			addShapedRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), "I I", "I C", "   ", 'I', insaniumIngot, 'C', ModItems.GEAR_ARMOR);
			
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), ItemCharm.itemCharmNightvision, ArmorType.NIGHT_VISION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), ItemCharm.itemCharmAbsorption, ArmorType.ABSORPTION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), ItemCharm.itemCharmWither, ArmorType.WITHER_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), ItemCharm.itemCharmAntivenom, ArmorType.ANTIVENOM.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), ItemCharm.itemCharmFire, ArmorType.FIRE_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HELMET), ItemCharm.itemCharmResistance, ArmorType.RESISTANCE.getIndex());

			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), ItemCharm.itemCharmStrength, ArmorType.STRENGTH.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), ItemCharm.itemCharmAbsorption, ArmorType.ABSORPTION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), ItemCharm.itemCharmWither, ArmorType.WITHER_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), ItemCharm.itemCharmAntivenom, ArmorType.ANTIVENOM.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), ItemCharm.itemCharmFire, ArmorType.FIRE_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_CHESTPLATE), ItemCharm.itemCharmResistance, ArmorType.RESISTANCE.getIndex());
			
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), ItemCharm.itemCharmSpeed, ArmorType.SPEED.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), ItemCharm.itemCharmAbsorption, ArmorType.ABSORPTION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), ItemCharm.itemCharmWither, ArmorType.WITHER_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), ItemCharm.itemCharmAntivenom, ArmorType.ANTIVENOM.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), ItemCharm.itemCharmFire, ArmorType.FIRE_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_LEGGINGS), ItemCharm.itemCharmResistance, ArmorType.RESISTANCE.getIndex());
			
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), ItemCharm.itemCharmJump, ArmorType.JUMP.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), ItemCharm.itemCharmAbsorption, ArmorType.ABSORPTION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), ItemCharm.itemCharmWither, ArmorType.WITHER_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), ItemCharm.itemCharmAntivenom, ArmorType.ANTIVENOM.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), ItemCharm.itemCharmFire, ArmorType.FIRE_RESISTANCE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOOTS), ItemCharm.itemCharmResistance, ArmorType.RESISTANCE.getIndex());
			
			addShapelessRecipe(new ItemStack(ModItems.GEAR_ARMOR), new ItemStack(ModItems.INSANIUM_HELMET, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR_ARMOR), new ItemStack(ModItems.INSANIUM_CHESTPLATE, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR_ARMOR), new ItemStack(ModItems.INSANIUM_LEGGINGS, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			addShapelessRecipe(new ItemStack(ModItems.GEAR_ARMOR), new ItemStack(ModItems.INSANIUM_BOOTS, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
		}
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_TOOLS) {
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SWORD), ItemCharm.itemCharmStrength, ToolType.STRENGTH.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SWORD), ItemCharm.itemCharmStrength2, ToolType.STRENGTH_2.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SWORD), ItemCharm.itemCharmAttackAOE, ToolType.ATTACK_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_PICKAXE), ItemCharm.itemCharmMinersVision, ToolType.MINERS_VISION.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_PICKAXE), ItemCharm.itemCharmMiningAOE, ToolType.MINING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SHOVEL), ItemCharm.itemCharmMiningAOE, ToolType.MINING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_AXE), ItemCharm.itemCharmMiningAOE, ToolType.MINING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_HOE), ItemCharm.itemCharmTillingAOE, ToolType.TILLING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SHEARS), ItemCharm.itemCharmRainbow, ToolType.RAINBOW.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SHEARS), ItemCharm.itemCharmShearingAOE, ToolType.SHEARING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOW), ItemCharm.itemCharmQuickDraw, ToolType.QUICK_DRAW.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_BOW), ItemCharm.itemCharmTripleShot, ToolType.TRIPLE_SHOT.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SICKLE), ItemCharm.itemCharmReapingAOE, ToolType.REAPING_AOE.getIndex());
			addUpgradeRecipe(new ItemStack(ModItems.INSANIUM_SCYTHE), ItemCharm.itemCharmScythingAOE, ToolType.SCYTHING_AOE.getIndex());
	    
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

				addShapelessRecipe(new ItemStack(ModItems.GEAR), new ItemStack(ModItems.INSANIUM_SEED_EXTRACTOR, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(com.blakebr0.mysticalagriculture.items.ModItems.itemCoreRemover, 1, OreDictionary.WILDCARD_VALUE));
			}
		}

		ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
		List<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());

		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_FURNACE && ModConfig.ULTIMATE_FURNACE_RECIPE && com.blakebr0.mysticalagriculture.config.ModConfig.confUltimateFurnace && com.blakebr0.mysticalagriculture.config.ModConfig.confEssenceFurnaces) {
		    for(IRecipe recipe : recipes) {
		    	if(recipe.getRegistryName() != null && recipe.getRegistryName().toString().equalsIgnoreCase("mysticalagriculture:core/ultimate_furnace") && recipe.getRecipeOutput().getItem().equals(new ItemStack(com.blakebr0.mysticalagriculture.blocks.ModBlocks.blockUltimateFurnace).getItem())) {
		    		recipeRegistry.remove(recipe.getRegistryName());
		    		RecipeHelper.addShapedRecipe(recipe.getRegistryName(), new ItemStack(com.blakebr0.mysticalagriculture.blocks.ModBlocks.blockUltimateFurnace), "WSW", "IFI", "WIW", 'W', new ItemStack(Items.SKULL, 1, 1), 'S', Items.NETHER_STAR, 'I', insaniumBlock, 'F', new ItemStack(ModBlocks.INSANIUM_FURNACE_BLOCK));
		    	}
		    }
		}
		
		if(ModCheck.MYSTICAL_AGRADDITIONS && ModConfig.INSANIUM_REPROCESSOR && ModConfig.ULTIMATE_REPROCESSOR_RECIPE && com.blakebr0.mysticalagriculture.config.ModConfig.confUltimateReprocessor && com.blakebr0.mysticalagriculture.config.ModConfig.confSeedReprocessor) {
		    for(IRecipe recipe : recipes) {
		    	if(recipe.getRegistryName() != null && recipe.getRegistryName().toString().equalsIgnoreCase("mysticalagriculture:ultimate_reprocessor") && recipe.getRecipeOutput().getItem().equals(new ItemStack(com.blakebr0.mysticalagriculture.blocks.ModBlocks.ULTIMATE_REPROCESSOR).getItem())) {
		    		recipeRegistry.remove(recipe.getRegistryName());
		    		RecipeHelper.addShapedRecipe(recipe.getRegistryName(), new ItemStack(com.blakebr0.mysticalagriculture.blocks.ModBlocks.ULTIMATE_REPROCESSOR), "WSW", "IFI", "WIW", 'W', new ItemStack(Items.SKULL, 1, 1), 'S', Items.NETHER_STAR, 'I', insaniumBlock, 'F', new ItemStack(ModBlocks.INSANIUM_REPROCESSOR_BLOCK));
		    	}
		    }
		}
		
		
	}
	
}
