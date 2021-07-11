package com.focamacho.mysticaladaptations.init;

import com.focamacho.mysticaladaptations.container.InsaniumReprocessorContainer;
import com.focamacho.mysticaladaptations.container.InsaniumReprocessorScreen;
import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    static final DeferredRegister<ContainerType<?>> containers = DeferredRegister.create(ForgeRegistries.CONTAINERS, Reference.MOD_ID);
    public static RegistryObject<ContainerType<InsaniumReprocessorContainer>> INSANIUM_REPROCESSOR = containers.register("insanium_reprocessor", () -> IForgeContainerType.create(InsaniumReprocessorContainer::create));

    @OnlyIn(Dist.CLIENT)
    public static void registerScreens() {
        ScreenManager.register(INSANIUM_REPROCESSOR.get(), InsaniumReprocessorScreen::new);
    }

}