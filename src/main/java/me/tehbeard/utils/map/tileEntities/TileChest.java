package me.tehbeard.utils.map.tileEntities;

import java.util.Arrays;

import me.tehbeard.utils.map.misc.Item;
import me.tehbeard.utils.map.misc.MapUtils;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@TileEntityType(id="Chest")
public class TileChest extends TileEntity{

	Item[] items = new Item[9*3];

	public TileChest(CompoundTag tag) {
		super(tag);

		items = MapUtils.makeInventory(27,(ListTag<CompoundTag>) tag.getList("Items"));
	}

	public Item[] getItems() {
        return items;
    }

    @Override
	public String toString() {
		return "TileChest [items=" + Arrays.toString(items) + "]";
	}
	


}
