package com.focamacho.mysticaladaptations.util.compat.jei.extractor;

import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipe;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ExtractorItemStacks {
	
	public static List<ItemStack> getItemStacks(SeedExtractorRecipe recipe){
		List<ItemStack> allItems = new ArrayList<>();
		List<ItemStack> itemsList = recipe.getItemsList();
		List<Block> blocksList = recipe.getBlocksList();
		List<ResourceLocation> entitiesList = recipe.getEntitiesList();
		for(ItemStack item : itemsList) {
			allItems.add(item);
		}
		for(Block block : blocksList) {
			if(Block.isEqualTo(block, Blocks.WATER)) allItems.add(new ItemStack(Items.WATER_BUCKET));
			else if(Block.isEqualTo(block, Blocks.LAVA)) allItems.add(new ItemStack(Items.LAVA_BUCKET));
			else allItems.add(new ItemStack(Item.getItemFromBlock(block)));
		}
		for(ResourceLocation entity : entitiesList) {
			allItems.add(getSpawnEgg(entity));
		}
		return allItems;
	}
	
	public static ItemStack getSpawnEgg(ResourceLocation entity){
		ItemStack egg = new ItemStack(Items.SPAWN_EGG);
        ItemMonsterPlacer.applyEntityIdToItemStack(egg, entity);
		return egg;
	}
	
}
