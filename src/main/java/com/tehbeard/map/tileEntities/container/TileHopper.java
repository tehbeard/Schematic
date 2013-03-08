package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;


@DataType("Hopper")
public class TileHopper extends TileContainer{


    public TileHopper(CompoundTag tag) {
		super(tag,5);

	}

    @Override
	public String toString() {
		return "TileHopper [items=" + Arrays.toString(getItems()) + "]";
	}
	


}
