package com.focamacho.mysticaladaptations.items.insanium;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.blakebr0.cucumber.helper.NBTHelper;
import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.items.tools.ToolType;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InsaniumShears extends ItemShears {

	public TextFormatting color;
	
	public InsaniumShears(String name, ToolMaterial material, TextFormatting color){
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAdaptations.tabMysticalAdaptations);
		this.setMaxDamage(material.getMaxUses());
		this.color = color;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced){
		int damage = stack.getMaxDamage() - stack.getItemDamage();
		tooltip.add(I18n.translateToLocal("tooltip.mysticaladaptations.insanium_shears"));
		tooltip.add(Tooltips.DURABILITY + color + (damage > -1 ? damage : Tooltips.UNLIMITED));
		NBTTagCompound tag = NBTHelper.getTagCompound(stack);
		if(tag.hasKey(ToolType.TOOL_TYPE)){
			tooltip.add(Tooltips.CHARM_SLOT + Colors.DARK_PURPLE + ToolType.byIndex(tag.getInteger(ToolType.TOOL_TYPE)).getLocalizedName());
		} else {
			tooltip.add(Tooltips.CHARM_SLOT + Colors.DARK_PURPLE + Tooltips.EMPTY);
		}
	}
	
    @Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity, EnumHand hand){
    	if(itemstack.getItem() == ModItems.INSANIUM_SHEARS){
        	NBTTagCompound tag = NBTHelper.getTagCompound(itemstack);
        	if(tag.hasKey(ToolType.TOOL_TYPE)){
        		if(tag.getInteger(ToolType.TOOL_TYPE) == ToolType.RAINBOW.getIndex()){
        	        if(entity.getEntityWorld().isRemote){
        	            return false;
        	        }
        	        
        	        if(entity instanceof IShearable){
        	            IShearable target = (IShearable)entity;
        	            BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
        	            if(target.isShearable(itemstack, entity.getEntityWorld(), pos)){
        	                List<ItemStack> drops = target.onSheared(itemstack, entity.getEntityWorld(), pos, EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, itemstack));

        	                Random rand = new Random();
        	                for(ItemStack stack : drops){
        	                	if(Block.getBlockFromItem(stack.getItem()) == Blocks.WOOL){
        	                		stack = new ItemStack(stack.getItem(), ModConfig.INSANIUM_SHEARS_DOUBLES ? 2 : 1, Utils.randInt(0, 15));
        	                	}
        	                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
        	                    ent.motionY += rand.nextFloat() * 0.05F;
        	                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
        	                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
        	                }
        	                itemstack.damageItem(1, entity);
        	            }
        	            return true;
        	        }
        	        return false;
        		} else if(tag.getInteger(ToolType.TOOL_TYPE) == ToolType.SHEARING_AOE.getIndex()){
        	        if(entity.getEntityWorld().isRemote){
        	            return false;
        	        }
        	        
        	        List<EntityLivingBase> entities = player.getEntityWorld().getEntitiesWithinAABB(EntityLivingBase.class, entity.getEntityBoundingBox().grow(1.5D, 0.25D, 1.5D));
        	        
        	        for(EntityLivingBase aoeEntity : entities){
        	        	shear(itemstack, player, aoeEntity, hand);
        	        }
        		} else if(ModConfig.INSANIUM_SHEARS_DOUBLES){
        			if(entity.getEntityWorld().isRemote){
        	            return false;
        	        }
        			
        			if(entity instanceof IShearable) {
        				IShearable target = (IShearable)entity;
        				BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
        				List<ItemStack> drops = target.onSheared(itemstack, entity.getEntityWorld(), pos, EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, itemstack));
        				
        				Random rand = new Random();
        				for(ItemStack stack : drops){
                        	if(ModConfig.INSANIUM_SHEARS_DOUBLES) stack.setCount(stack.getCount() * 2);
                            EntityItem ent = entity.entityDropItem(stack, 1.0F);
                            ent.motionY += rand.nextFloat() * 0.05F;
                            ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                            ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                        }
        				return true;
        			}
        			return false;
        		}
        	}
    	}
    	return super.itemInteractionForEntity(itemstack, player, entity, hand);
    }
    
    private boolean shear(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity, EnumHand hand){
        if(entity instanceof IShearable){
            IShearable target = (IShearable)entity;
            BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
            if(target.isShearable(itemstack, entity.getEntityWorld(), pos)){
                List<ItemStack> drops = target.onSheared(itemstack, entity.getEntityWorld(), pos, EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, itemstack));

                Random rand = new Random();
                for(ItemStack stack : drops){
                	stack.setCount(stack.getCount() * 2);
                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
                    ent.motionY += rand.nextFloat() * 0.05F;
                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }
                itemstack.damageItem(1, entity);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player){
        if(player.getEntityWorld().isRemote || player.capabilities.isCreativeMode){
            return false;
        }
        
        if(itemstack.getItem() != ModItems.INSANIUM_SHEARS){
        	return super.onBlockStartBreak(itemstack, pos, player);
        }
        
        NBTTagCompound tag = NBTHelper.getTagCompound(itemstack);
        if(!tag.hasKey(ToolType.TOOL_TYPE)){
        	return super.onBlockStartBreak(itemstack, pos, player);
        } else if(!(tag.getInteger(ToolType.TOOL_TYPE) == ToolType.SHEARING_AOE.getIndex())){
    		return super.onBlockStartBreak(itemstack, pos, player);
    	}
        
        Iterable<BlockPos> blocks = pos.getAllInBox(pos.add(1, 1, 1), pos.add(-1, -1, -1));      
        
        for(BlockPos aoePos : blocks){
            Block block = player.getEntityWorld().getBlockState(aoePos).getBlock();
            if(block instanceof IShearable){
                IShearable target = (IShearable)block;
                if(target.isShearable(itemstack, player.getEntityWorld(), aoePos)){
                    List<ItemStack> drops = target.onSheared(itemstack, player.getEntityWorld(), aoePos, EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, itemstack));
                    Random rand = new Random();

                    for(ItemStack stack : drops){
                        float f = 0.7F;
                        double d  = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                        double d1 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                        double d2 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                        EntityItem entityitem = new EntityItem(player.getEntityWorld(), (double)aoePos.getX() + d, (double)aoePos.getY() + d1, (double)aoePos.getZ() + d2, stack);
                        entityitem.setDefaultPickupDelay();
                        player.getEntityWorld().spawnEntity(entityitem);
                        player.getEntityWorld().destroyBlock(aoePos, false);
                    }

                    itemstack.damageItem(1, player);
                    player.addStat(StatList.getBlockStats(block));
                }
            }
        }
        return false;
    }

}