package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.Item;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.tileEntities.TileEntity;
import com.tehbeard.map.tileEntities.TileNameable;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@DataType("Furnace")
public class TileFurnace extends TileContainer{

    short burn,cook;

	@SuppressWarnings("unchecked")
    public TileFurnace(CompoundTag tag) {
		super(tag,3);

		
		burn = tag.getShort("BurnTime");
		cook = tag.getShort("CookTime");
	}

	
	
    public short getBurn() {
        return burn;
    }




    public short getCook() {
        return cook;
    }




    @Override
	public String toString() {
		return "TileFurance [items=" + Arrays.toString(getItems()) + "]";
	}
	


}
