package me.tehbeard.utils.map.tileEntities;

import java.util.Arrays;

import me.tehbeard.utils.map.misc.Item;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@TileEntityType(id="Trap")
public class TileTrap extends TileEntity{

	Item[] items = new Item[9];

	public TileTrap(CompoundTag tag) {
		super(tag);

		for(CompoundTag t : (ListTag<CompoundTag>) tag.getList("Items")){
            Item i = new Item(t);
            items[i.getSlot()]=i;
        }
	}
	
	public Item[] getItems() {
        return items;
    }

    @Override
	public String toString() {
		return "TileTrap [items=" + Arrays.toString(items) + "]";
	}
	


}
