package com.focamacho.mysticaladaptations.util.compat.tconstruct;

import com.blakebr0.mysticalagradditions.tinkers.TraitProsperous;
import com.focamacho.mysticaladaptations.init.ModRecipes;
import com.focamacho.mysticaladaptations.lib.FluidRender;
import com.focamacho.mysticaladaptations.util.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerTraits;

public class CompatTConstruct {

	public static Material insanium;
	public static FluidMolten moltenInsanium;

	public static void init() {
		insanium = new Material(Reference.MOD_ID + ".insanium", 0x7100B2);
		insanium.addItem(new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium"), 1, 2), 1, Material.VALUE_Ingot);
		insanium.setRepresentativeItem(new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium"), 1, 2));
		TinkerRegistry.addMaterialStats(insanium, new HeadMaterialStats(11040, 27.7F, 18.23F, HarvestLevels.COBALT),
				new HandleMaterialStats(1.52F, 250), new ExtraMaterialStats(370),
				new BowMaterialStats(1.60F, 2.18F, 6.24F));
		moltenInsanium = new FluidMolten("insanium", 0x5600C4);
		FluidRegistry.registerFluid(moltenInsanium);
		ForgeRegistries.BLOCKS.register(new BlockMolten(moltenInsanium).setRegistryName("molten_" + moltenInsanium.getName()));
		FluidRegistry.addBucketForFluid(moltenInsanium);
		insanium.setFluid(moltenInsanium);
		insanium.setCastable(true);

		TinkerRegistry.integrate(insanium, moltenInsanium).preInit();
		
		insanium.addTrait(TraitProsperous.getTrait());
		insanium.addTrait(TraitProsperous.getTrait(), MaterialTypes.HEAD);
		insanium.addTrait(TinkerTraits.duritos, MaterialTypes.HEAD);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initFluidModels() {
		FluidRender.mapFluidState(moltenInsanium);
	}
	
	public static void initRecipes() {
		TinkerRegistry.registerMelting(new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium"), 1, 3), moltenInsanium, 16);
		TinkerRegistry.registerMelting(new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium"), 1, 2), moltenInsanium, 144);
		TinkerRegistry.registerMelting(new ItemStack(Item.getByNameOrId("mysticalagradditions:storage"), 1, 1), moltenInsanium, 1296);
		
		if (TConstruct.pulseManager.isPulseLoaded(TinkerSmeltery.PulseId)) {
			TinkerRegistry.registerTableCasting(new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium"), 1, 3), TinkerSmeltery.castNugget, moltenInsanium, 16);
			TinkerRegistry.registerTableCasting(new ItemStack(Item.getByNameOrId("mysticalagradditions:insanium"), 1, 2), TinkerSmeltery.castIngot, moltenInsanium, 144);
			TinkerRegistry.registerBasinCasting(new ItemStack(Item.getByNameOrId("mysticalagradditions:storage"), 1, 1), ItemStack.EMPTY, moltenInsanium, 1296);
		}
	}
}
