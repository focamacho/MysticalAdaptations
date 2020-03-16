package com.focamacho.mysticaladaptations.items.insanium;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.blakebr0.cucumber.helper.NBTHelper;
import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.ToolTools;
import com.blakebr0.mysticalagriculture.items.tools.ToolType;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InsaniumAxe extends ItemAxe {

	public TextFormatting color;
	
	public InsaniumAxe(String name, ToolMaterial material, float damage, TextFormatting color){
		super(material, damage, -3.2F);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAdaptations.tabMysticalAdaptations);
		this.color = color;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced){
		int damage = stack.getMaxDamage() - stack.getItemDamage();
		if(ModConfig.INSANIUM_AXE_UP) tooltip.add(I18n.translateToLocal("tooltip.mysticaladaptations.insanium_axe_up"));
		tooltip.add(Tooltips.DURABILITY + color + (damage > -1 ? damage : Tooltips.UNLIMITED));
		NBTTagCompound tag = NBTHelper.getTagCompound(stack);
		if(tag.hasKey(ToolType.TOOL_TYPE)){
			tooltip.add(Tooltips.CHARM_SLOT + Colors.DARK_PURPLE + ToolType.byIndex(tag.getInteger(ToolType.TOOL_TYPE)).getLocalizedName());
		} else {
			tooltip.add(Tooltips.CHARM_SLOT + Colors.DARK_PURPLE + Tooltips.EMPTY);
		}
	}
	
	@Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player){
		if(stack.getItem() == ModItems.INSANIUM_AXE){
			NBTTagCompound tag = NBTHelper.getTagCompound(stack);
			if(tag.hasKey(ToolType.TOOL_TYPE)){
				if(tag.getInteger(ToolType.TOOL_TYPE) == ToolType.MINING_AOE.getIndex()){
			        boolean blocks = false;
		            RayTraceResult ray = ToolTools.getBlockWithinReach(player.getEntityWorld(), player);
		            if(ray != null){
		                int side = ray.sideHit.ordinal();
		                blocks = this.harvest(stack, 1, player.getEntityWorld(), pos, side, player);
		            }
		            return blocks;
				}
			} else if(ModConfig.INSANIUM_AXE_UP){
				for(BlockPos woodPos : getAllWood(player.getEntityWorld(), pos)) {
	        		if(woodPos != pos){
	        			IBlockState aoeState = player.getEntityWorld().getBlockState(woodPos);
	        			if(aoeState.getBlockHardness(player.getEntityWorld(), woodPos) <= player.getEntityWorld().getBlockState(pos).getBlockHardness(player.getEntityWorld(), pos) + 5.0F){
	        				if(aoeState.getBlock().isToolEffective("axe", aoeState)){
	        					canHarvest(player.getEntityWorld(), woodPos, true, stack, player);
	        				}   
	        			} else {
	        				return false;
	        			}
	        		}
	        	}
			}
		}
		return super.onBlockStartBreak(stack, pos, player);
    }

    public boolean harvest(ItemStack stack, int radius, World world, BlockPos pos, int side, EntityPlayer player){
        int xRange = radius;
        int yRange = radius;
        int zRange = 0;

        if(side == 0 || side == 1){
            zRange = radius;
            yRange = 0;
        }
        
        if(side == 4 || side == 5){
            xRange = 0;
            zRange = radius;
        }
        
        IBlockState state = world.getBlockState(pos);
        float hardness = state.getBlockHardness(world, pos);
        
        if(!canHarvest(world, pos, false, stack, player)){
        	return false;
        }
        
        if(radius > 0 && hardness >= 0.2F && state.getBlock().isToolEffective("axe", state)){
        	Iterable<BlockPos> blocks = BlockPos.getAllInBox(pos.add(-xRange, -yRange, -zRange), pos.add(xRange, yRange, zRange));
        	if(ModConfig.INSANIUM_AXE_UP) {
	        	for(BlockPos aoePos : blocks){
	        		for(BlockPos woodPos : getAllWood(world, aoePos)) {
	            		if(woodPos != pos){
	            			IBlockState aoeState = world.getBlockState(woodPos);
	            			if(aoeState.getBlockHardness(world, woodPos) <= hardness + 5.0F){
	            				if(aoeState.getBlock().isToolEffective("axe", aoeState)){
	            					canHarvest(world, woodPos, true, stack, player);
	            				}   
	            			} else {
	            				return false;
	            			}
	            		}
	            	}
	            }
        	} else {
        		for(BlockPos aoePos : blocks){
            		if(aoePos != pos){
            			IBlockState aoeState = world.getBlockState(aoePos);
            			if(aoeState.getBlockHardness(world, aoePos) <= hardness + 5.0F){
            				if(aoeState.getBlock().isToolEffective("axe", aoeState)){
            					canHarvest(world, aoePos, true, stack, player);
            				}   
            			} else {
            				return false;
            			}
            		}
                }
        	}
        }
        return true;
    }	
    
    private boolean canHarvest(World world, BlockPos pos, boolean extra, ItemStack stack, EntityPlayer player){
        IBlockState state = world.getBlockState(pos);
        float hardness = state.getBlockHardness(world, pos);
        Block block = state.getBlock();
        boolean harvest = (ForgeHooks.canHarvestBlock(block, player, world, pos) || this.canHarvestBlock(state, stack)) && (!extra || this.getDestroySpeed(stack, world.getBlockState(pos)) > 1.0F);
        if(hardness >= 0.0F && (!extra || harvest)){
            return ToolTools.breakBlocksAOE(stack, world, player, pos);
        }
        return false;
    }
    
    private List<BlockPos> getAllWood(World world, BlockPos pos) {
    	List<BlockPos> blockPosList = new ArrayList<BlockPos>();
    	BlockPos blockpos = pos.up();
    	while(world.getBlockState(blockpos).getBlock().isWood(world, blockpos)){
    		blockPosList.add(blockpos);
    		blockpos = blockpos.up();
    	}
    	return blockPosList;
    }

}