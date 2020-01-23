package com.focamacho.mysticaladaptations.items.insanium;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.blakebr0.cucumber.helper.NBTHelper;
import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.items.armor.ArmorType;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InsaniumArmor extends ItemArmor implements IHasModel {
	
	public InsaniumArmor(String name, ArmorMaterial material, int index, EntityEquipmentSlot slot){
		super(material, index, slot);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabMysticalAdaptations);
	    this.setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced){
		int damage = stack.getMaxDamage() - stack.getItemDamage();
		tooltip.add(Tooltips.DURABILITY + Colors.DARK_PURPLE + damage);
		if(ModConfig.INSANIUM_ARMOR_HUNGERLESS){ tooltip.add(Tooltips.SET_BONUS + Colors.DARK_PURPLE + I18n.translateToLocal("tooltip.mysticaladaptations.hungerless")); }
		else if(ModConfig.INSANIUM_ARMOR_SATURATION){ tooltip.add(Tooltips.SET_BONUS + Colors.DARK_PURPLE + Utils.localize(MobEffects.SATURATION.getName())); }
		else if(ModConfig.INSANIUM_ARMOR_FLIGHT){ tooltip.add(Tooltips.SET_BONUS + Colors.DARK_PURPLE + Tooltips.FLIGHT); }
		NBTTagCompound tag = NBTHelper.getTagCompound(stack);
		if(tag.hasKey(ArmorType.ARMOR_TYPE)){
			tooltip.add(Tooltips.CHARM_SLOT + Colors.DARK_PURPLE + ArmorType.byIndex(tag.getInteger(ArmorType.ARMOR_TYPE)).getLocalizedName());
		} else {
			tooltip.add(Tooltips.CHARM_SLOT + Colors.DARK_PURPLE + Tooltips.EMPTY);
		}
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){	
		if(com.blakebr0.mysticalagriculture.config.ModConfig.confSetBonuses && isFullSet(player)){
			if(player.isInWater()){
				player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 5, 0, true, false));
			}
		}
		
		if(ModConfig.INSANIUM_ARMOR_SATURATION && isFullSet(player)) {
			player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 5, 0, true, false));
		}
		
		if(ModConfig.INSANIUM_ARMOR_HUNGERLESS && isFullSet(player)) {
			if(player.getFoodStats().needFood()) player.getFoodStats().setFoodLevel(20);
		}
		
		NBTTagCompound tag = NBTHelper.getTagCompound(stack);
		if(tag.hasKey(ArmorType.ARMOR_TYPE)){
			ArmorType type = ArmorType.byIndex(tag.getInteger(ArmorType.ARMOR_TYPE));
			if(type != null){
				type.getSpecialAbility(world, player);
			}
		}
	}
	
	@Override
	public int getItemEnchantability(){
		return 0;
	}
	
	public static boolean isFullSet(EntityPlayer player){		
		ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
		ItemStack feet = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
		
		return !head.isEmpty() && head.getItem() instanceof InsaniumArmor && !chest.isEmpty() && chest.getItem() instanceof InsaniumArmor && !legs.isEmpty() && legs.getItem() instanceof InsaniumArmor && !feet.isEmpty() && feet.getItem() instanceof InsaniumArmor;
	}
	    
    public static class AbilityHandler {
    	
    	public static List<String> playersWithSet = new ArrayList<String>();
    	public static List<String> playersWithSpeed = new ArrayList<String>();

    	public static String playerKey(EntityPlayer player) {
    		return player.getGameProfile().getName() + ":" + player.getEntityWorld().isRemote;
    	}
    	
    	public boolean hasSpeed(EntityPlayer player){
    		ItemStack stack = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
    		if(stack.getItem() == ModItems.INSANIUM_LEGGINGS){
            	NBTTagCompound tag = NBTHelper.getTagCompound(stack);
            	if(tag.hasKey(ArmorType.ARMOR_TYPE)){
            		if(tag.getInteger(ArmorType.ARMOR_TYPE) == ArmorType.SPEED.getIndex()){
            			return true;
            		}
            	}
    		}
    		return false;
    	}
    	    	
    	@SubscribeEvent
    	public void updatePlayerAbilityStatus(LivingUpdateEvent event) {
    		if(event.getEntityLiving() instanceof EntityPlayer) {
    			EntityPlayer player = (EntityPlayer)event.getEntityLiving();
    			String key = playerKey(player);

    			Boolean hasSet = InsaniumArmor.isFullSet(player);
    			if(playersWithSet.contains(key)){
    				if(hasSet){
    					if(ModConfig.INSANIUM_ARMOR_FLIGHT){
    						player.capabilities.allowFlying = true;
    					}
    					if(com.blakebr0.mysticalagriculture.config.ModConfig.confSetBonuses){
        					player.stepHeight = 1.0625F;
    						boolean flying = player.capabilities.isFlying;
    						if(flying){ 
    							boolean sneaking = player.isSneaking();
    							
    							float speed = 0.08f 
    								* (flying ? 0.6f : 1.0f)
    								* (sneaking ? 0.1f : 1.0f); 
    							
    							if (player.moveForward > 0f) {
    								player.moveRelative(0f, 0f, 1f, speed);
    							} else if (player.moveForward < 0f) {
    								player.moveRelative(0f, 0f, 1f, -speed * 0.3f);
    							}
    							
    							if (player.moveStrafing != 0f) {
    								player.moveRelative(1f, 0f, 0f, speed * 0.5f * Math.signum(player.moveStrafing));
    							}
    						}
						}
    				} else {
    					player.stepHeight = 0.6F;
    					if(!player.capabilities.isCreativeMode && !player.isSpectator()){
    						player.capabilities.allowFlying = false;
        					player.capabilities.isFlying = false;
    					}
    					playersWithSet.remove(key);
    				}
    			} else if(hasSet) {
    				playersWithSet.add(key);
    			}
    			boolean hasSpeed = hasSpeed(player);
    			if(playersWithSpeed.contains(key)){
    				if(hasSpeed){
						boolean flying = player.capabilities.isFlying;
						boolean swimming = player.isInsideOfMaterial(Material.WATER) || player.isInWater();
						if(player.onGround || flying || swimming) {
							boolean sneaking = player.isSneaking();
							boolean sprinting = player.isSprinting();
							
							float speed = 0.1f 
								* (flying ? 0.6f : 1.0f)
								* (sneaking ? 0.1f : 1.0f)
								* (!sprinting ? 0.6F : 1.2F);
							
							if (player.moveForward > 0f) {
								player.moveRelative(0f, 0f, 1f, speed);
							} else if (player.moveForward < 0f) {
								player.moveRelative(0f, 0f, 1f, -speed * 0.3f);
							}
							
							if (player.moveStrafing != 0f) {
								player.moveRelative(1f, 0f, 0f, speed * 0.5f * Math.signum(player.moveStrafing));
							}
						}
    				} else {
    					playersWithSpeed.remove(key);
    				}
    			} else if(hasSpeed){
    				playersWithSpeed.add(key);
    			}
    		}
    	}
    }
    
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}