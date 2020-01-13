package com.focamacho.mysticaladaptations.util.compat.tconstruct;

import com.focamacho.mysticaladaptations.Main;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlockMolten extends BlockFluidClassic {

	public BlockMolten(Fluid fluid) {
		super(fluid, Material.LAVA);
		this.setCreativeTab(Main.tabMysticalAdaptations);
	}

	@Override
	public String getUnlocalizedName() {
		Fluid fluid = FluidRegistry.getFluid(fluidName);
		if (fluid != null) {
			return fluid.getUnlocalizedName();
		}
		
		return super.getUnlocalizedName();
	}
}
