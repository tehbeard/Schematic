package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Chest")
public class TileChest extends TileContainer{


    public TileChest(CompoundTag tag) {
		super(tag,27);

		
	}


    @Override
    public String toString() {
        return "TileChest [items=" + Arrays.toString(getItems()) + ", getX()="
                + getX() + ", getY()=" + getY() + ", getZ()=" + getZ() + "]";
    }
	


}
