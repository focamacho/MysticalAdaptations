package com.focamacho.mysticaladaptations.item.extractor;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class SeedExtractorRecipeHandler {

    public static List<SeedExtractorRecipe> allRecipes = new ArrayList<SeedExtractorRecipe>();

    public static void initRecipes(){
        allRecipes.clear();
    }

    public static Item getSeedFromBlock(SeedExtractorItem extractor, Item blockItem, Block block) {
        for(SeedExtractorRecipe recipe : allRecipes) {
            for(ResourceLocation tag : recipe.getTagList()) {
                if(blockItem.getTags().contains(tag)) return extractor.getTier() >= recipe.getTier() ? recipe.getSeed() : null;
                if(block.getTags().contains(tag)) return extractor.getTier() >= recipe.getTier() ? recipe.getSeed() : null;
            }
            for(Block blockR : recipe.getBlockList()){
                if(blockR.equals(block)){
                    return extractor.getTier() >= recipe.getTier() ? recipe.getSeed() : null;
                }
            }
        }
        return null;
    }

    @SubscribeEvent
    public void onLivingDropsEvent(LivingDropsEvent event) {
        if(event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            if(player.getHeldItemMainhand().getItem() instanceof SeedExtractorItem) {
                Item seed = getItemFromEntity(ForgeRegistries.ENTITIES.getKey(event.getEntity().getType()), (SeedExtractorItem) player.getHeldItemMainhand().getItem());
                if(seed != null) {
                    Entity entity = event.getEntity();
                    event.getDrops().add(new ItemEntity(entity.world, entity.getPosX(), entity.getPosY(), entity.getPosZ(), new ItemStack(seed)));
                }
            }
        }
    }

    public static Item getItemFromEntity(ResourceLocation entity, SeedExtractorItem extractor) {
        for(SeedExtractorRecipe recipe : allRecipes) {
            for(ResourceLocation entityName : recipe.getEntityList()) {
                if(entityName.equals(entity)) return extractor.getTier() >= recipe.getTier() ? recipe.getSeed() : null;
            }
        }
        return null;
    }

}