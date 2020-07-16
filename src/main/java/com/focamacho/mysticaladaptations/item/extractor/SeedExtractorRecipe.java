package com.focamacho.mysticaladaptations.item.extractor;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class SeedExtractorRecipe {

    private List<Block> blockList;
    private List<ResourceLocation> tagList;
    private List<ResourceLocation> entityList;
    private Item seed;
    private Integer tier;

    public SeedExtractorRecipe(List<String> config, Item seed, int tier){
        this.blockList = getBlocksFromConfig(config);
        this.tagList = getTagsFromConfig(config);
        this.entityList = getEntitiesFromConfig(config);
        this.seed = seed;
        this.tier = tier;
    }

    private static List<Block> getBlocksFromConfig(List<String> config) {
        List<Block> allBlocks = new ArrayList<Block>();
        for(String block : config) {
            if(block.startsWith("tag:")) {
                //nothing
            } else if(block.startsWith("entity")) {
                //nothing
            } else {
                String[] split = block.split(":");
                if(split.length == 2) {
                    if(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(split[0], split[1])) != null) {
                        allBlocks.add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(split[0], split[1])).getBlock());
                    }
                }
            }
        }
        return allBlocks;
    }

    private static List<ResourceLocation> getTagsFromConfig(List<String> config){
        List<ResourceLocation> allTags = new ArrayList<>();
        for(String tag : config) {
            if (tag.startsWith("tag:")) {
                String[] split = tag.split(":");
                allTags.add(new ResourceLocation(split[1], split[2]));
            }
        }
        return allTags;
    }

    private static List<ResourceLocation> getEntitiesFromConfig(List<String> config) {
        List<ResourceLocation> allEntities = new ArrayList<>();
        for(String entity : config) {
            if(entity.startsWith("entity")) {
                String[] split = entity.split(":");
                for(EntityType entityType : ForgeRegistries.ENTITIES.getValues()){
                    if(entityType.getRegistryName().equals(new ResourceLocation(split[1], split[2]))) {
                        allEntities.add(entityType.getRegistryName());
                    }
                }
            }
        }
        return allEntities;
    }

    public List<Block> getBlockList() {
        return this.blockList;
    }

    public List<ResourceLocation> getTagList() {
        return this.tagList;
    }

    public List<ResourceLocation> getEntityList() {
        return this.entityList;
    }

    public Item getSeed() {
        return this.seed;
    }

    public Integer getTier() {
        return this.tier;
    }

}
