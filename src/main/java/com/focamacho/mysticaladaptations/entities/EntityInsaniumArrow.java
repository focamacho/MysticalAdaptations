package com.focamacho.mysticaladaptations.entities;

import javax.annotation.Nonnull;

import com.blakebr0.cucumber.util.Utils;
import com.focamacho.mysticaladaptations.init.ModItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityInsaniumArrow extends EntityArrow {

    public EntityInsaniumArrow(World world){
        super(world);
    }

    public EntityInsaniumArrow(World world, EntityLivingBase shooter){
        super(world, shooter);
    }

    public EntityInsaniumArrow(World world, double x, double y, double z){
        super(world, x, y, z);
    }

    @Override
    public void setDamage(double damage){
        super.setDamage(8.0D);
    }

    @Override
    @Nonnull
    public ItemStack getArrowStack(){
        return new ItemStack(ModItems.INSANIUM_ARROW);
    }

    @Override
    public void arrowHit(EntityLivingBase living){
        super.arrowHit(living);
        living.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, Utils.randInt(100, 300), 0));
        living.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, Utils.randInt(100, 300), 0));
        living.addPotionEffect(new PotionEffect(MobEffects.POISON, Utils.randInt(100, 300), 0));
        living.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, Utils.randInt(100, 300), 0));
        living.addPotionEffect(new PotionEffect(MobEffects.WITHER, Utils.randInt(100, 300), 0));
        living.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, Utils.randInt(100, 300), 0));
    }
}