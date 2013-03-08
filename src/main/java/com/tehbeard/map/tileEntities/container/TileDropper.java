package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.Item;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.tileEntities.TileEntity;
import com.tehbeard.map.tileEntities.TileNameable;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@DataType("Dropper")
public class TileDropper extends TileContainer{


	@SuppressWarnings("unchecked")
    public TileDropper(CompoundTag tag) {
		super(tag,9);

	}

    @Override
	public String toString() {
		return "TileTrap [items=" + Arrays.toString(getItems()) + "]";
	}
	


}