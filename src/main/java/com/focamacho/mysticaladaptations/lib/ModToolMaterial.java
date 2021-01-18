package com.focamacho.mysticaladaptations.lib;

import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {

	 public static final ToolMaterial INSANIUM = EnumHelper.addToolMaterial("INSANIUM", 6, -1, 32.0F, 24.0F, 0);
	 public static final ArmorMaterial INSANIUM_ARMOR = EnumHelper.addArmorMaterial("INSANIUMARMOR", Reference.MOD_ID + ":" + "insanium_armor", 400, new int[]{5, 9, 10, 6}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.75F);
			 
}
