package com.tehbeard.map.tileEntities;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.Item;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@DataType("Trap")
public class TileTrap extends TileEntity{

	Item[] items = new Item[9];

	public TileTrap(CompoundTag tag) {
		super(tag);

		items = MapUtils.makeInventory(9,(ListTag<CompoundTag>) tag.getList("Items"));
	}
	
	public Item[] getItems() {
        return items;
    }

    @Override
	public String toString() {
		return "TileTrap [items=" + Arrays.toString(items) + "]";
	}
	


}
