package com.focamacho.mysticaladaptations.items.insanium;

import java.util.List;

import javax.annotation.Nullable;

import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InsaniumFishingRod extends ItemFishingRod implements IHasModel {
	
	public TextFormatting color;
	
	public InsaniumFishingRod(String name, ToolMaterial material, TextFormatting color){
		this.setUnlocalizedName(name);
		this.setCreativeTab(Main.tabMysticalAdaptations);
		this.setRegistryName(name);
		this.color = color;
		this.setMaxStackSize(1);
		this.setMaxDamage(material.getMaxUses());
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (playerIn.fishEntity != null)
        {
            int i = playerIn.fishEntity.handleHookRetraction();
            itemstack.damageItem(i, playerIn);
            playerIn.swingArm(handIn);
            worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_BOBBER_RETRIEVE, SoundCategory.NEUTRAL, 1.0F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        }
        else
        {
            worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_BOBBER_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!worldIn.isRemote)
            {
                EntityFishHook entityfishhook = new EntityFishHook(worldIn, playerIn);
                int j = EnchantmentHelper.getFishingSpeedBonus(itemstack);

                if(ModConfig.INSANIUM_LURE) {
                	entityfishhook.setLureSpeed(5);
                } else {
                	if (j > 0)
                    {
                        entityfishhook.setLureSpeed(j);
                    }
                }

                int k = EnchantmentHelper.getFishingLuckBonus(itemstack);

                if (k > 0)
                {
                    entityfishhook.setLuck(k);
                }

                worldIn.spawnEntity(entityfishhook);
            }

            playerIn.swingArm(handIn);
            playerIn.addStat(StatList.getObjectUseStats(this));
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced){
		int damage = stack.getMaxDamage() - stack.getItemDamage();
		if(ModConfig.INSANIUM_LURE) tooltip.add(I18n.translateToLocal("tooltip.mysticaladaptations.insanium_lure"));
		tooltip.add(Tooltips.DURABILITY + color + (damage > -1 ? damage : Tooltips.UNLIMITED));
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
