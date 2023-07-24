package com.focamacho.mysticaladaptations.init;

import com.blakebr0.cucumber.util.FeatureFlagDisplayItemGenerator;
import com.focamacho.mysticaladaptations.MysticalAdaptations;
import com.focamacho.mysticaladaptations.config.ConfigHolder;
import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = REGISTRY.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mysticaladaptations"))
            .icon(() -> new ItemStack(ModItems.INSANIUM_SWORD.get()))
            .displayItems(FeatureFlagDisplayItemGenerator.create((parameters, output) -> {
                output.accept(new ItemStack(ModAugments.HUNGERLESS.getItem()));
                output.accept(new ItemStack(ModAugments.WOODCUTTER.getItem()));
                output.accept(new ItemStack(ModAugments.MINING_AOE_V.getItem()));
                output.accept(new ItemStack(ModAugments.STRENGTH_IV.getItem()));
                output.accept(new ItemStack(ModAugments.ABSORPTION_VI.getItem()));
                output.accept(new ItemStack(ModAugments.HEALTH_BOOST_VI.getItem()));
                output.accept(new ItemStack(ModAugments.ATTACK_AOE_IV.getItem()));
                output.accept(new ItemStack(ModAugments.TILLING_AOE_V.getItem()));

                if(ModList.get().isLoaded("vampirism")) {
                    if(ConfigHolder.thirstlessAugment) output.accept(new ItemStack(ModAugments.THIRSTLESS.getItem()));
                    if(ConfigHolder.daywalkerAugment) output.accept(new ItemStack(ModAugments.DAYWALKER.getItem()));
                }

                for (RegistryObject<Item> entry : ModItems.items.getEntries()) {
                    output.accept(entry);
                }
            }))
            .build());
}
