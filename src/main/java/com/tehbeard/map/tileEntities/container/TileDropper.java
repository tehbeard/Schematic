package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;


@DataType("Dropper")
public class TileDropper extends TileContainer{


    public TileDropper(CompoundTag tag) {
		super(tag,9);

	}

    @Override
	public String toString() {
		return "TileDropper [items=" + Arrays.toString(getItems()) + "]";
	}
	


}
