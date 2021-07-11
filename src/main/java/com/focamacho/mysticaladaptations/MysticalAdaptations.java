package com.focamacho.mysticaladaptations;

import com.focamacho.mysticaladaptations.config.ConfigHolder;
import com.focamacho.mysticaladaptations.config.ConfigMysticalAdaptations;
import com.focamacho.mysticaladaptations.handlers.MobDropsHandler;
import com.focamacho.mysticaladaptations.handlers.TooltipHandler;
import com.focamacho.mysticaladaptations.init.*;
import com.focamacho.mysticaladaptations.tiles.InsaniumFurnaceTileEntity;
import com.focamacho.mysticaladaptations.tiles.InsaniumReprocessorTileEntity;
import com.focamacho.mysticaladaptations.util.Reference;
import com.focamacho.mysticaladaptations.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mysticaladaptations")
public class MysticalAdaptations {

    private static final Logger LOGGER = LogManager.getLogger();

    public MysticalAdaptations() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigMysticalAdaptations.spec);
        ConfigHolder.updateConfigs();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new MobDropsHandler());

        ModRegistry.register();
    }

    private void setup(final FMLCommonSetupEvent event) {
        //SeedExtractorRecipeHandler.initRecipes();
        if(Utils.isVampirismLoaded) {
            if(!ConfigHolder.thirstlessAugment) ModAugments.THIRSTLESS.setEnabled(false);
            if(!ConfigHolder.daywalkerAugment) ModAugments.DAYWALKER.setEnabled(false);
        }
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new TooltipHandler());
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
        final ModConfig config = event.getConfig();

        if (config.getSpec() == ConfigMysticalAdaptations.spec) {
            ConfigHolder.updateConfigs();
        }
    }
    
    public static final ItemGroup creativeTab = new ItemGroup(Reference.MOD_ID) {

		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.INSANIUM_SWORD.get());
		}

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            //Add Augments to Mystical Adaptations creative tab
            items.add(new ItemStack(ModAugments.HUNGERLESS.getItem()));
            items.add(new ItemStack(ModAugments.WOODCUTTER.getItem()));
            items.add(new ItemStack(ModAugments.MINING_AOE_V.getItem()));
            items.add(new ItemStack(ModAugments.STRENGTH_IV.getItem()));
            items.add(new ItemStack(ModAugments.ABSORPTION_VI.getItem()));
            items.add(new ItemStack(ModAugments.HEALTH_BOOST_VI.getItem()));
            items.add(new ItemStack(ModAugments.ATTACK_AOE_IV.getItem()));
            items.add(new ItemStack(ModAugments.TILLING_AOE_V.getItem()));
            
            if(ModList.get().isLoaded("vampirism")) {
                if(ConfigHolder.thirstlessAugment) items.add(new ItemStack(ModAugments.THIRSTLESS.getItem()));
                if(ConfigHolder.daywalkerAugment) items.add(new ItemStack(ModAugments.DAYWALKER.getItem()));
            }

            super.fillItemList(items);
        }
    };

}
