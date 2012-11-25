package me.tehbeard.utils.map.tileEntities;

import java.util.Arrays;

import me.tehbeard.utils.map.misc.Item;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@TileEntityType(id="Cauldron")
public class TileCauldron extends TileEntity{

	private Item[] items = new Item[4];
	private short brew;

    public TileCauldron(CompoundTag tag) {
		super(tag);

		
		for(CompoundTag t : (ListTag<CompoundTag>) tag.getList("Items")){
		    Item i = new Item(t);
			items[i.getSlot()]=i;
		}
		brew = tag.getShort("BrewTime");
	}

	
	public Item[] getItems() {
        return items;
    }


    public short getBrew() {
        return brew;
    }


    @Override
	public String toString() {
		return "TileFurance [items=" + Arrays.toString(items) + "]";
	}
	


}
