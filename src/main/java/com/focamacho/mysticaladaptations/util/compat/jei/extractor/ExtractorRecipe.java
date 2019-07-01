package com.focamacho.mysticaladaptations.util.compat.jei.extractor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagriculture.lib.CropType.Type;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.UniversalBucket;

public class ExtractorRecipe extends BlankRecipeWrapper {

	private List<ItemStack> inputs = new ArrayList<ItemStack>();
	private ItemStack tool;
	private ItemStack output;
	
	public ExtractorRecipe(Type seed, ItemStack item) {
		output = new ItemStack(seed.getSeed());
		inputs.add(item);
		if(!ModConfig.EXTRACTOR_ANY_TIER) {
			switch(seed.getTier()) {
				case 1:
					tool = new ItemStack(ModItems.INFERIUM_SEED_EXTRACTOR);
					break;
				case 2:
					tool = new ItemStack(ModItems.PRUDENTIUM_SEED_EXTRACTOR);
					break;
				case 3:
					tool = new ItemStack(ModItems.INTERMEDIUM_SEED_EXTRACTOR);
					break;
				case 4:
					tool = new ItemStack(ModItems.SUPERIUM_SEED_EXTRACTOR);
					break;
				case 5:
					tool = new ItemStack(ModItems.SUPREMIUM_SEED_EXTRACTOR);
					break;	
				case 6:
					tool = new ItemStack(ModItems.INSANIUM_SEED_EXTRACTOR);
					break;
			}
		} else {
			tool = new ItemStack(ModItems.INFERIUM_SEED_EXTRACTOR);
		}
		
		inputs.add(tool);
	}
	
	public ExtractorRecipe(ItemStack seed, ItemStack item) {
		output = seed;
		inputs.add(item);
		if(ModConfig.EXTRACTOR_ANY_TIER) {
			tool = new ItemStack(ModItems.INFERIUM_SEED_EXTRACTOR);
		} else {
			tool = new ItemStack(ModItems.INSANIUM_SEED_EXTRACTOR);
		}
		
		inputs.add(tool);
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputs(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
	}

}