package com.tehbeard.map.tileEntities;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.Item;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@DataType("Furnace")
public class TileFurnace extends TileEntity{

	Item[] items = new Item[3];
    short burn,cook;

	public TileFurnace(CompoundTag tag) {
		super(tag);

		items = MapUtils.makeInventory(3,(ListTag<CompoundTag>) tag.getList("Items"));
		
		burn = tag.getShort("BurnTime");
		cook = tag.getShort("CookTime");
	}

	
	

	public Item[] getItems() {
        return items;
    }




    public short getBurn() {
        return burn;
    }




    public short getCook() {
        return cook;
    }




    @Override
	public String toString() {
		return "TileFurance [items=" + Arrays.toString(items) + "]";
	}
	


}
