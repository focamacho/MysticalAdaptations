package com.focamacho.mysticaladaptations.lib;

import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.items.SeedExtractor;
import com.focamacho.mysticaladaptations.util.ModCheck;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class BlockCheck {

	public static ItemStack getSeedFromBlock(ItemStack extractor, ItemStack blockItem, Block block) {
		for(SeedExtractorRecipe recipe : SeedExtractorRecipes.allRecipes) {
			if(checkRecipe(recipe, extractor, blockItem, block)) {
				if(recipe.getType() != null && recipe.getType().isEnabled()) return recipe.getSeed();
				else {
					if(ModCheck.MYSTICAL_AGRADDITIONS && recipe.getSeed() != null && recipe.getSeed().getItem() != Items.AIR) {
						return recipe.getSeed();
					}
				}
			}
		}
		return null;
	}
	
	public static boolean checkTier(int tier, ItemStack extractor) {
		if(!(extractor.getItem() instanceof SeedExtractor)) return false;
		if(!ModConfig.EXTRACTOR_ANY_TIER) {
			if(ModConfig.EXTRACTOR_LOWER_TIER) {
				return ((SeedExtractor) extractor.getItem()).getExtractorTier() >= tier;
			} else {
				return ((SeedExtractor) extractor.getItem()).getExtractorTier() == tier;
			}
		} else return true;
	}
	
	public static boolean checkRecipe(SeedExtractorRecipe recipe, ItemStack extractor, ItemStack blockItem, Block block) {
		return checkBlock(blockItem, block, recipe.getItemsList(), recipe.getBlocksList()) && checkTier(recipe.getTier(), extractor);
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