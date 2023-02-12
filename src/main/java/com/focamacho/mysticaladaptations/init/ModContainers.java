package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.container.InsaniumReprocessorContainer;
import com.focamacho.mysticaladaptations.container.InsaniumReprocessorScreen;
import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainers {

    static final DeferredRegister<MenuType<?>> containers = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Reference.MOD_ID);
    public static RegistryObject<MenuType<InsaniumReprocessorContainer>> INSANIUM_REPROCESSOR = containers.register("insanium_reprocessor", () -> IForgeMenuType.create(InsaniumReprocessorContainer::create));

    @OnlyIn(Dist.CLIENT)
    public static void registerScreens() {
        MenuScreens.register(INSANIUM_REPROCESSOR.get(), InsaniumReprocessorScreen::new);
    }

}