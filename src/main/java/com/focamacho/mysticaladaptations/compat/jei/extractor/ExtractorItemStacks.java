/*package com.focamacho.mysticaladaptations.compat.jei.extractor;

import com.focamacho.mysticaladaptations.lib.SeedExtractorRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ExtractorItemStacks {

	public static List<ItemStack> getItemStacks(SeedExtractorRecipe recipe){
		List<ItemStack> allItems = new ArrayList<ItemStack>();
		List<Block> blocksList = recipe.getBlockList();
		List<ResourceLocation> entitiesList = recipe.getEntityList();
		for(Block block : blocksList) {
			if(block.equals(Blocks.WATER)) allItems.add(new ItemStack(Items.WATER_BUCKET));
			else if(block.equals(Blocks.LAVA)) allItems.add(new ItemStack(Items.LAVA_BUCKET));
			else allItems.add(new ItemStack(block.asItem()));
		}
		for(ResourceLocation entity : entitiesList) {
			allItems.add(getSpawnEgg(entity));
		}
		return allItems;
	}
	
	public static ItemStack getSpawnEgg(ResourceLocation entity){
		ItemStack egg = new ItemStack(SpawnEggItem.getEgg(ForgeRegistries.ENTITIES.getValue(entity)));
		return egg;
	}
	
}
*/