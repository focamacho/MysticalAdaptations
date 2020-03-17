package com.focamacho.mysticaladaptations;

import com.focamacho.mysticaladaptations.handlers.TooltipHandler;
import com.focamacho.mysticaladaptations.init.ModAugments;
import com.focamacho.mysticaladaptations.init.ModItems;
import com.focamacho.mysticaladaptations.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new TooltipHandler());
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

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

        @SubscribeEvent
        public void onTileEntitiesRegistry(RegistryEvent.Register<TileEntityType<?>> event) {

        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {

        }
        
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            ModItems.initItems();
        	IForgeRegistry<Item> registry = event.getRegistry();
        	ModItems.allItems.forEach(registry::register);
        }
    }
}
