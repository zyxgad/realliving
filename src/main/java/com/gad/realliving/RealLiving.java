
package com.gad.realliving;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.gad.realliving.common.CommonProxy;
import com.gad.realliving.client.ClientProxy;
import com.gad.realliving.items.ItemLoader;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(RealLiving.MODID)
public class RealLiving{
	public static final String MODID = "realliving";

	// @Instance(RealLiving.MODID)
	// public static RealLiving instance;

	public static CommonProxy commonProxy = new CommonProxy();
	public static ClientProxy clientProxy = new ClientProxy();

	public RealLiving(){
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
	}

	private void setup(final FMLCommonSetupEvent event){
		commonProxy.setup(event);
	}

	private void doClientStuff(final FMLClientSetupEvent event){
		clientProxy.setup(event);
	}

	private void enqueueIMC(final InterModEnqueueEvent event){
		// some example code to dispatch IMC to another mod
		// InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
	}

	private void processIMC(final InterModProcessEvent event){
		// some example code to receive and process InterModComms from other mods
		// LOGGER.info("Got IMC {}", event.getIMCStream().
		// 		map(m->m.getMessageSupplier().get()).
		// 		collect(Collectors.toList()));
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(final FMLServerStartingEvent event) {
		// do something when the server starts
		System.out.println("server starting");
	}

	// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
			new ItemLoader(itemRegistryEvent).onLoad();
		}
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			//
		}
	}
}
