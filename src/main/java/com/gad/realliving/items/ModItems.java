
package com.gad.realliving.items;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import net.minecraft.item.Item;

import com.gad.realliving.RealLiving;
import com.gad.realliving.common.CommonProxy;

public class ModItems{
	private ModItems(){}

	private static final Map<String, Item> items = new HashMap<>();
	static{
		items.put("test_stick", new TestStick());
	}

	public static Item getItem(String name){
		return items.get(name);
	}

	public static Iterator<Map.Entry<String, Item>> getIterator(){
		Iterator<Map.Entry<String, Item>> iterator = items.entrySet().iterator();
		return iterator;
	}
}