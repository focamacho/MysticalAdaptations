package com.focamacho.mysticaladaptations;

import com.focamacho.mysticaladaptations.config.ConfigHolder;
import com.focamacho.mysticaladaptations.config.ConfigMysticalAdaptations;
import com.focamacho.mysticaladaptations.handlers.TooltipHandler;
import com.focamacho.mysticaladaptations.init.ModAugments;
import com.focamacho.mysticaladaptations.init.ModBlocks;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.item.extractor.SeedExtractorRecipeHandler;
import com.focamacho.mysticaladaptations.tileentity.InsaniumFurnaceTileEntity;
import com.focamacho.mysticaladaptations.tileentity.InsaniumReprocessorTileEntity;
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new SeedExtractorRecipeHandler());
    }

    private void setup(final FMLCommonSetupEvent event) {
        //SeedExtractorRecipeHandler.initRecipes();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new TooltipHandler());
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
        final ModConfig config = event.getConfig();

        if (config.getSpec() == ConfigMysticalAdaptations.spec) {
            ConfigHolder.updateConfigs();
        }
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }
    
    public static final ItemGroup creativeTab = new ItemGroup(Reference.MOD_ID) {

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.INSANIUM_SWORD);
		}

        @Override
        public void fill(NonNullList<ItemStack> items) {
            //Add Augments to Mystical Adaptations creative tab
            items.add(new ItemStack(ModAugments.HUNGERLESS.getItem()));
            items.add(new ItemStack(ModAugments.WOODCUTTER.getItem()));
            items.add(new ItemStack(ModAugments.MINING_AOE_V.getItem()));
            items.add(new ItemStack(ModAugments.STRENGTH_IV.getItem()));
            items.add(new ItemStack(ModAugments.ABSORPTION_VI.getItem()));
            items.add(new ItemStack(ModAugments.HEALTH_BOOST_VI.getItem()));
            items.add(new ItemStack(ModAugments.ATTACK_AOE_IV.getItem()));
            items.add(new ItemStack(ModAugments.TILLING_AOE_V.getItem()));

            super.fill(items);
        }
    };

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        public static TileEntityType<InsaniumFurnaceTileEntity> INSANIUM_FURNACE;
        public static TileEntityType<InsaniumReprocessorTileEntity> INSANIUM_REPROCESSOR;

        @SubscribeEvent
        public static void onTileEntitiesRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            INSANIUM_FURNACE = TileEntityType.Builder.create(InsaniumFurnaceTileEntity::new, ModBlocks.INSANIUM_FURNACE).build(null);
            INSANIUM_REPROCESSOR = TileEntityType.Builder.create(InsaniumReprocessorTileEntity::new, ModBlocks.INSANIUM_REPROCESSOR).build(null);

            INSANIUM_FURNACE.setRegistryName(Utils.getRegistryName("insanium_furnace_tile"));
            INSANIUM_REPROCESSOR.setRegistryName(Utils.getRegistryName("insanium_reprocessor_tile"));

            event.getRegistry().register(INSANIUM_FURNACE);
            event.getRegistry().register(INSANIUM_REPROCESSOR);
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            ModBlocks.initBlocks();
            IForgeRegistry<Block> registry = event.getRegistry();
            ModBlocks.allBlocks.forEach(registry::register);
        }
        
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            ModItems.initItems();
        	IForgeRegistry<Item> registry = event.getRegistry();
        	ModItems.allItems.forEach(registry::register);
        }
    }

}
