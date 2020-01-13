package com.focamacho.mysticaladaptations.items;

import java.util.List;
import java.util.Random;

import com.focamacho.mysticaladaptations.Main;
import com.focamacho.mysticaladaptations.config.ModConfig;
import com.focamacho.mysticaladaptations.lib.BlockCheck;
import com.focamacho.mysticaladaptations.util.IHasModel;
import com.google.common.collect.Multimap;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SeedExtractor extends Item implements IHasModel{

	ToolMaterial toolMaterial;
	NBTTagCompound tier = new NBTTagCompound();
	
	public SeedExtractor(String name, ToolMaterial material, int durability, int tier) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setMaxDamage(durability);
		this.setCreativeTab(Main.tabMysticalAdaptations);
		this.setMaxStackSize(1);
		this.toolMaterial = material;
		this.tier.setInteger("tier", tier);
	}
	
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        ItemStack seed = null;
        
    	ItemStack itemstack = player.getHeldItem(hand);
		if(!itemstack.hasTagCompound()) itemstack.setTagCompound(new NBTTagCompound());
		if(!itemstack.getTagCompound().hasKey("tier")) itemstack.setTagCompound(this.tier);
		
        RayTraceResult raytraceresult = this.rayTrace(worldIn, player, true);
        BlockPos pos = null;

        if (raytraceresult == null) return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK) return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        else {
	        pos = raytraceresult.getBlockPos();
	        IBlockState iblockstate = worldIn.getBlockState(pos);
	        Block block = iblockstate.getBlock();
	        ItemStack blockItem = iblockstate.getBlock().getPickBlock(iblockstate, raytraceresult, worldIn, pos, player);
	       	if(player.canPlayerEdit(pos, raytraceresult.sideHit, itemstack)) {
			   seed = BlockCheck.getSeedFromBlock(itemstack, blockItem, block);
		       if(seed != null) {
		    	   if(!worldIn.isRemote) {
		    		   seedExtractorUse(worldIn, player, itemstack, seed, pos);
		    	   } else {
		    		   spawnParticles(pos, worldIn, EnumParticleTypes.BLOCK_CRACK, iblockstate);
		    	   }
		    	   worldIn.playSound(null, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
		    	   return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	        	}
		   }
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
    }
    
	public void seedExtractorUse(World worldIn, EntityPlayer player, ItemStack extractor, ItemStack seed, BlockPos pos) {
      	worldIn.setBlockToAir(pos);
      	EntityItem seedDrop = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), seed);
		player.getCooldownTracker().setCooldown(extractor.getItem(), 20);
	    worldIn.spawnEntity(seedDrop);
	    extractor.damageItem(1, player);
	}
	
	private void spawnParticles(BlockPos pos, World world, EnumParticleTypes particleType, IBlockState state) {
		Random rand = new Random();

		for (int k = 0; k < 20; ++k) {
			double xCoord = pos.getX() + (rand.nextDouble() * 0.6D) - 0.3D;
			double yCoord = pos.getY() + (rand.nextDouble() * 0.6D);
			double zCoord = pos.getZ() + (rand.nextDouble() * 0.6D) - 0.3D;
			double xSpeed = rand.nextGaussian() * 0.02D;
			double ySpeed = rand.nextGaussian() * 0.2D;
			double zSpeed = rand.nextGaussian() * 0.02D;
			world.spawnParticle(particleType, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed, Block.getStateId(state));
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flagIn) {
		switch(tier.getInteger("tier")) {
			case 1:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.YELLOW + tier.getInteger("tier"));
				break;
			case 2:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.GREEN + tier.getInteger("tier"));
				break;
			case 3:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.GOLD + tier.getInteger("tier"));
				break;
			case 4:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.AQUA + tier.getInteger("tier"));
				break;
			case 5:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.RED + tier.getInteger("tier"));
				break;
			case 6:
				list.add(ChatFormatting.GRAY + "Tier: " + ChatFormatting.DARK_PURPLE + tier.getInteger("tier"));
				break;
		}
		if(!itemstack.hasTagCompound()) itemstack.setTagCompound(new NBTTagCompound());
		if(!itemstack.getTagCompound().hasKey("tier")) itemstack.setTagCompound(this.tier);
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return ModConfig.ENCHANTABLE_EXTRACTOR;
	}
	
	@Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot){
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if(equipmentSlot == EntityEquipmentSlot.MAINHAND){
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.toolMaterial.getAttackDamage() - 1.0F, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3.4D, 0));
        }
        return multimap;
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
		
}
