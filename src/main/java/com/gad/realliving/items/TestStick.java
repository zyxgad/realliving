
package com.gad.realliving.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.Ingredient;

public class TestStick extends SwordItem{
	private static IItemTier iItemTier = new IItemTier() {
		@Override
		public int getMaxUses() {
			return 250;
		}

		@Override
		public float getEfficiency() {
			return 1.0F;
		}

		@Override
		public float getAttackDamage() {
			return 1.0F;
		}

		@Override
		public int getHarvestLevel() {
			return 0;
		}

		@Override
		public int getEnchantability() {
			return 0;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return null;
		}
	};

	public TestStick(){
		super(iItemTier, 0, 1.5F, new Properties().group(ItemGroup.MATERIALS));
	}
}
