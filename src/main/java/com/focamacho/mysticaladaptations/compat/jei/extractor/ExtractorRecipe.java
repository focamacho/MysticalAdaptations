/*package com.focamacho.mysticaladaptations.compat.jei.extractor;

import com.focamacho.mysticaladaptations.init.ModItems;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ExtractorRecipe {

	private static List<ItemStack> inputs = new ArrayList<ItemStack>();
	private ItemStack tool;
	private static ItemStack output;
	
	public ExtractorRecipe(ItemStack item, ItemStack seed, int tier) {
		output = seed;
		inputs.add(item);
		if(true/*!ModConfig.EXTRACTOR_ANY_TIER) {
			switch(tier) {
				case 1:
					tool = new ItemStack(ModItems.INFERIUM_EXTRACTOR);
					break;
				case 2:
					tool = new ItemStack(ModItems.PRUDENTIUM_EXTRACTOR);
					break;
				case 3:
					tool = new ItemStack(ModItems.TERTIUM_EXTRACTOR);
					break;
				case 4:
					tool = new ItemStack(ModItems.IMPERIUM_EXTRACTOR);
					break;
				case 5:
					tool = new ItemStack(ModItems.SUPREMIUM_EXTRACTOR);
					break;	
				case 6:
					tool = new ItemStack(ModItems.INSANIUM_EXTRACTOR);
					break;
			}
		} else {
			tool = new ItemStack(ModItems.INFERIUM_EXTRACTOR);
		}
		
		inputs.add(tool);
	}

	public List<ItemStack> getInputs(){
		return inputs;
	}

	public ItemStack getOutput() {
		return output;
	}

}*/