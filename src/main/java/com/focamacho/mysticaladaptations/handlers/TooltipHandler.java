package com.focamacho.mysticaladaptations.handlers;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.lib.ModTooltips;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.util.Utils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TooltipHandler {

    //Replace Tier 6 tooltips with a colored one
    @SubscribeEvent
    public void tooltipEvent(ItemTooltipEvent event){
        if(event.getItemStack().getItem().getItemCategory() == MysticalAdaptations.creativeTab || event.getItemStack().getItem().getItemCategory() == MysticalAgriculture.CREATIVE_TAB) {
            int index = -1;
            for(Component text : event.getToolTip()){
                if(text.equals(ModTooltips.getTooltipForTier(6))){
                    index = event.getToolTip().indexOf(text);
                }
            }
            if(index != -1){
                event.getToolTip().set(index, Component.literal(ChatFormatting.GRAY + Component.translatable("tooltip.mysticalagriculture.tier").getString() + Utils.getColorFromTier(6) + "6"));
            }
        }
    }
}
