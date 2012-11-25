package me.tehbeard.utils.map.tileEntities;

import java.util.Arrays;

import me.tehbeard.utils.map.misc.Item;
import me.tehbeard.utils.map.misc.MapUtils;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@TileEntityType(id="Trap")
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
