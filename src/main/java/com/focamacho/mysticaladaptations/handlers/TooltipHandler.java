package com.focamacho.mysticaladaptations.handlers;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.lib.ModTooltips;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.Utils;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class TooltipHandler {

    //Replace Tier 6 tooltips with a colored one
    @SubscribeEvent
    public void tooltipEvent(ItemTooltipEvent event){
        if(event.getItemStack().getItem().getGroup() == MysticalAdaptations.creativeTab || event.getItemStack().getItem().getGroup() == MysticalAgriculture.ITEM_GROUP) {
            int index = -1;
            for(ITextComponent text : event.getToolTip()){
                if(text.equals(ModTooltips.getTooltipForTier(6))){
                    index = event.getToolTip().indexOf(text);
                }
            }
            if(index != -1){
                event.getToolTip().set(index, new StringTextComponent(TextFormatting.GRAY + new TranslationTextComponent("tooltip.mysticalagriculture.tier").getString() + Utils.getColorFromTier(6) + "6"));
            }
        }
    }
}
