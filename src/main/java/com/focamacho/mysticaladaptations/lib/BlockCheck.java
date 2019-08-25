package com.focamacho.mysticaladaptations.lib;

import java.util.List;

import com.focamacho.mysticaladaptations.config.ModConfig;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlockCheck {

	public static ItemStack getSeedFromBlock(ItemStack extractor, ItemStack blockItem, Block block) {
		for(SeedExtractorRecipe recipe : SeedExtractorRecipes.allRecipes) {
			if(checkRecipe(recipe, extractor, blockItem, block) && recipe.getType().isEnabled()) return recipe.getSeed();
		}
		return null;
	}
	
	public static boolean checkTier(int tier, ItemStack extractor) {
		if(!ModConfig.EXTRACTOR_ANY_TIER) {
			if(ModConfig.EXTRACTOR_LOWER_TIER) {
				if(extractor.getTagCompound().getInteger("tier") >= tier) return true;
				else return false;
			} else {
				if(extractor.getTagCompound().getInteger("tier") == tier) return true;
				else return false;
			}
		} else return true;
	}
	
	public static boolean checkRecipe(SeedExtractorRecipe recipe, ItemStack extractor, ItemStack blockItem, Block block) {
		if(checkBlock(blockItem, block, recipe.getItemsList(), recipe.getBlocksList()) && checkTier(recipe.getTier(), extractor)) return true;
		else return false;
	}
	
	public static boolean checkBlock(ItemStack blockItem, Block block, List<ItemStack> itemList, List<Block> blockList) {
		if(!(itemList == null || itemList.isEmpty())) {
			for(ItemStack b : itemList) {
				if(OreDictionary.itemMatches(b, blockItem, false)) {
					return true;
				}
			}
		} else if(!(blockList == null || blockList.isEmpty())) {
			for(Block b : blockList) {
				if(Block.isEqualTo(b, block)) {
					return true;
				}
			}
		}
		return false;
	}

}
