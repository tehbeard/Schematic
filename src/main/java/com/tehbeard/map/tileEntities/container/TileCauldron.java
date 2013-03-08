package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.Item;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.tileEntities.TileEntity;
import com.tehbeard.map.tileEntities.TileNameable;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@DataType("Cauldron")
public class TileCauldron extends TileContainer{

	
	private short brew;

    @SuppressWarnings("unchecked")
    public TileCauldron(CompoundTag tag) {
		super(tag,4);
		
		brew = tag.getShort("BrewTime");
	}

	
    public short getBrew() {
        return brew;
    }


    @Override
	public String toString() {
		return "TileFurance [items=" + Arrays.toString(getItems()) + "]";
	}
	


}
