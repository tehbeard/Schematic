package com.tehbeard.map.tileEntities.container;

import com.tehbeard.map.misc.Item;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.tileEntities.TileNameable;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

public class TileContainer extends TileNameable {

	private Item[] items;

	@SuppressWarnings("unchecked")
	public TileContainer(CompoundTag tag,int size) {
		super(tag);
		items = MapUtils.makeInventory(size, (ListTag<CompoundTag>) tag.getList("Items"));
	}
	
	public Item[] getItems() {
        return items;
    }

}
