package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;


@DataType("Furnace")
public class TileFurnace extends TileContainer{

    short burn,cook;

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
