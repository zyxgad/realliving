
package com.gad.realliving.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Manure extends Item{
	public Manure(){
		super(new Properties()
			.group(ItemGroup.MATERIALS)
			.maxStackSize(64)
		);
	}
}
