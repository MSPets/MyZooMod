package mspets.my.zoomod;

import mspets.my.zoomod.client.render.entity.CrocodileRender;
import mspets.my.zoomod.client.render.entity.MonkeyRender;
import mspets.my.zoomod.client.render.entity.PandaRender;
import mspets.my.zoomod.client.screen.FeedingTroughScreen;
import mspets.my.zoomod.common.entity.CrocodileEntity;
import mspets.my.zoomod.common.entity.MonkeyEntity;
import mspets.my.zoomod.common.entity.PandaEntity;
import mspets.my.zoomod.common.registry.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MyZooMod.MODID)
public class MyZooMod
{
    // May not be correct
    public static final String MODID = "myzoomod";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MyZooMod() {
        GeckoLib.initialize();

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Registry handler
        BlockRegistries.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ContainerRegistries.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntityRegistries.ENTITY_TYPE.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemRegistries.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileRegistries.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::miscSetup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    // My setup
    @SuppressWarnings("deprecation")
    public void miscSetup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityRegistries.PANDA_ENTITY.get(), PandaEntity.setAttributes().create());
        });
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityRegistries.CROCODILE_ENTITY.get(), CrocodileEntity.setAttributes().create());
        });
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityRegistries.MONKEY_ENTITY.get(), MonkeyEntity.setAttributes().create());
        });
    }
    // Proxy?
    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);

        //event.enqueueWork(() ->{});

        RenderingRegistry.registerEntityRenderingHandler(EntityRegistries.PANDA_ENTITY.get(), PandaRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistries.CROCODILE_ENTITY.get(), CrocodileRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistries.MONKEY_ENTITY.get(), MonkeyRender::new);

        ScreenManager.registerFactory(ContainerRegistries.FEEDING_TROUGH_CONTAINER.get(), FeedingTroughScreen::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
