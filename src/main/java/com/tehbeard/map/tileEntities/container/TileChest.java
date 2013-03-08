package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.Item;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.tileEntities.TileEntity;
import com.tehbeard.map.tileEntities.TileNameable;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@DataType("Chest")
public class TileChest extends TileContainer{


	@SuppressWarnings("unchecked")
    public TileChest(CompoundTag tag) {
		super(tag,27);

		
	}


    @Override
    public String toString() {
        return "TileChest [items=" + Arrays.toString(getItems()) + ", getX()="
                + getX() + ", getY()=" + getY() + ", getZ()=" + getZ() + "]";
    }
	


}
