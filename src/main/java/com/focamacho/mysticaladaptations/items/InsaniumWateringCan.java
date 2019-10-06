package com.focamacho.mysticaladaptations.items;

import java.util.List;
import java.util.Random;

import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.IHasModel;
import com.focamacho.mysticaladaptations.util.ModCheck;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * Code from BlakeBr0's Mystical Agriculture.
 * https://github.com/BlakeBr0/MysticalAgriculture/
*/

public class InsaniumWateringCan extends Item implements IHasModel {
		
	private boolean water = false;
	private long ticks;
	
	public InsaniumWateringCan(String name) {
		this.setCreativeTab(Main.tabMysticalAdaptations);
		this.setMaxStackSize(1);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		if(ModCheck.MYSTICAL_AGRADDITIONS && com.blakebr0.mysticalagriculture.config.ModConfig.confWateringCans && ModConfig.INSANIUM_TOOLS) ModItems.ITEMS.add(this);
	}

	@Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
    	if (selected) {
    		this.ticks++;
    		if (this.ticks % 4 == 0) {
    			this.water = true;
    		}
    	}
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.NONE;
    }
	
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	ItemStack stack = player.getHeldItem(hand);
    	
		if (!player.canPlayerEdit(pos.offset(facing), facing, stack))
			return EnumActionResult.FAIL;
		
		if (!com.blakebr0.mysticalagriculture.config.ModConfig.confFakePlayerWatering && player instanceof FakePlayer)
			return EnumActionResult.FAIL;
		
		
    	if (this.water) {
    		int range = 5;
    		
        	Iterable<BlockPos> blocks = BlockPos.getAllInBox(pos.add(-range, -range, -range), pos.add(range, range, range));
        	for (BlockPos aoePos : blocks) {
        		IBlockState aoeState = world.getBlockState(aoePos);
        		if (aoeState.getBlock() instanceof BlockFarmland) {
        			int moisture = aoeState.getValue(BlockFarmland.MOISTURE);
        			if (moisture < 7) {
        				world.setBlockState(aoePos, aoeState.withProperty(BlockFarmland.MOISTURE, 7), 2);
        			}
        		}
        	}
    		
    		Random rand = Utils.rand;
    		for (int x = -range; x <= range; x++) {
    			for (int z = -range; z <= range; z++) {
    				double d0 = pos.add(x, 0, z).getX() + rand.nextFloat();
    				double d1 = pos.add(x, 0, z).getY() + 1.0D;
    				double d2 = pos.add(x, 0, z).getZ() + rand.nextFloat();
    		      
    				IBlockState state = world.getBlockState(pos);
    				if (state.isFullCube() || state.getBlock() instanceof BlockFarmland) {
    					d1 += 0.3D;
    				}
    				
    				world.spawnParticle(EnumParticleTypes.WATER_DROP, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[5]);
    			}
    		}
    		
    	    if (!world.isRemote) {
    	    	this.water = false;
    	    	int chance = Utils.randInt(1, 100);
    	    	int bonus = 4 * stack.getMetadata();
    	        if (chance <= (40 + bonus)) {
    	        	for (BlockPos aoePos : blocks) {
    	        		Block plant = world.getBlockState(aoePos).getBlock();      		
    	        		if (plant instanceof IGrowable || plant instanceof IPlantable || plant == Blocks.MYCELIUM || plant == Blocks.CHORUS_FLOWER) {
    	        			world.scheduleBlockUpdate(aoePos, plant, 0, 1000);
    	        		}
    	        	}
    	        	
    	        	return EnumActionResult.FAIL;
    	        }
    	    }	
    	}
	    
	    return EnumActionResult.FAIL;
    }
        
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
    	tooltip.add(Tooltips.RANGE + Colors.DARK_PURPLE + "11x11");
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}