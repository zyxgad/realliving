
package com.gad.realliving.items;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import com.gad.realliving.common.CommonProxy;
import com.gad.realliving.RealLiving;

// @Mod.EventBusSubscriber(modid=RealLiving.MODID)
public class ItemLoader{
	private final IForgeRegistry<Item> registry;
	public ItemLoader(final RegistryEvent.Register<Item> event){
		this.registry = event.getRegistry();
	}

	public void onLoad(){
		for(Iterator<Map.Entry<String, Item>> itemsIter = ModItems.getIterator(); itemsIter.hasNext() ;){
			Map.Entry<String, Item> entry = itemsIter.next();
			ItemLoader.register(this.registry, entry.getValue(), entry.getKey());
		}
	}

	private static void register(final IForgeRegistry<Item> registry, Item item, String name){
		registry.register(item.setRegistryName(name));
	}
}