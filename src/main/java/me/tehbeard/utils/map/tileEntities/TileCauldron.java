package me.tehbeard.utils.map.tileEntities;

import java.util.Arrays;

import me.tehbeard.utils.map.misc.Item;
import me.tehbeard.utils.map.misc.MapUtils;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@TileEntityType(id="Cauldron")
public class TileCauldron extends TileEntity{

	private Item[] items = new Item[4];
	private short brew;

    public TileCauldron(CompoundTag tag) {
		super(tag);

		
		items = MapUtils.makeInventory(4,(ListTag<CompoundTag>) tag.getList("Items"));
		
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
