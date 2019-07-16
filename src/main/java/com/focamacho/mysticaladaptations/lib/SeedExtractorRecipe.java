package com.focamacho.mysticaladaptations.lib;

import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

public class SeedExtractorRecipe {

	private List<ItemStack> itemList;
	private List<Block> blockList;
	private List<ResourceLocation> entityList;
	private ItemStack seed;
	private Integer tier;
	private Type type;
	
	public SeedExtractorRecipe(String[] config, Type seed) {
		this.itemList = getItemsFromConfig(config);
		this.blockList = getBlocksFromConfig(config);
		this.entityList = getEntitiesFromConfig(config);
		this.seed = new ItemStack(seed.getSeed());
		this.tier = seed.getTier();
		this.type = seed;
	}
	
	public SeedExtractorRecipe(String[] config, ItemStack seed, int tier) {
		this.itemList = getItemsFromConfig(config);
		this.blockList = getBlocksFromConfig(config);
		this.entityList = getEntitiesFromConfig(config);
		this.seed = seed;
		this.tier = tier;
	}
	
	private static List<ItemStack> getItemsFromConfig(String[] config) {
		List<ItemStack> allItems = new ArrayList<ItemStack>();
		for(String item : config) {
			if(item.startsWith("ore:")) {
				String[] split = item.split(":");
				allItems.addAll(getItemListFromOredict(split[1]));
			} else if(item.startsWith("entity")) {
				//nothing
			} else {
				String[] split = item.split(":");
				if(split.length > 2) {
					ItemStack itemA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]), 1, Integer.parseInt(split[2]));
					if(!(itemA.getItem() == Items.AIR)) {
						allItems.add(itemA);
					}
				} else if(split.length == 2){
					ItemStack itemA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]));
					if(!(itemA.getItem() == Items.AIR)) {
						allItems.add(itemA);
					}
				}
			}
		}
		return allItems;
	}
	
	private static List<ItemStack> getItemListFromOredict(String ore) {
		List<ItemStack> oreItems = OreDictionary.getOres(ore);
		return oreItems;
	}
	
	
	private static List<Block> getBlocksFromConfig(String[] config) {
		List<Block> allBlocks = new ArrayList<Block>();
		for(String block : config) {
			if(block.startsWith("ore:")) {
				//nothing
			} else if(block.startsWith("entity")) {
				//nothing
			} else {
				String[] split = block.split(":");
				if(split.length > 2) {
					ItemStack blockA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]), 1, Integer.parseInt(split[2]));
					if(blockA.getItem() == Items.AIR) {
						Block blockB = Block.getBlockFromName(split[0] + ":" + split[1]);
						if(blockB != null) {
							allBlocks.add(blockB);
						}
					}
				} else if(split.length == 2){
					ItemStack blockA = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]));
					if(blockA.getItem() == Items.AIR) {
						Block blockB = Block.getBlockFromName(split[0] + ":" + split[1]);
						if(blockB != null) {
							allBlocks.add(blockB);
						}
					}
				}
			}
		}
		return allBlocks;
	}
	
	private static List<ResourceLocation> getEntitiesFromConfig(String[] config) {
		List<EntityEntry> entityRegistry = ForgeRegistries.ENTITIES.getValues();
		List<ResourceLocation> allEntities = new ArrayList<ResourceLocation>();
		for(String entity : config) {
			if(entity.startsWith("entity")) {
				String[] split = entity.split(":");
				for(EntityEntry entityE : entityRegistry) {
					ResourceLocation entityR = new ResourceLocation(split[1] + ":" + split[2]);
					if(entityE.getRegistryName().equals(entityR)) allEntities.add(entityR);
				}
			}
		}
		return allEntities;
	}
	
	public List<ItemStack> getItemsList() {
		return this.itemList;
	}

	public List<Block> getBlocksList() {
		return this.blockList;
	}
	
	public List<ResourceLocation> getEntitiesList() {
		return this.entityList;
	}
	
	public ItemStack getSeed() {
		return this.seed;
	}
	
	public Integer getTier() {
		return this.tier;
	}
	
	public Type getType() {
		return this.type;
	}
	
}
