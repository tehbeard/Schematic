package com.tehbeard.map.entities.vehicles;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.misc.items.Item;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

@DataType("MinecartHopper")
public class MinecartHopper extends Minecart{

	private Item[] items;
	public Item[] getItems() {
		return items;
	}
	@SuppressWarnings("unchecked")
	public MinecartHopper(CompoundTag tag) {
		super(tag);
		items = MapUtils.makeInventory(5, (ListTag<CompoundTag>) tag.getList("Items"));
		
	}

}
