package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;


@DataType("Trap")
public class TileTrap extends TileContainer{


    public TileTrap(CompoundTag tag) {
		super(tag,9);

	}

    @Override
	public String toString() {
		return "TileTrap [items=" + Arrays.toString(getItems()) + "]";
	}
	


}
