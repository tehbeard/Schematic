package com.tehbeard.map.tileEntities.container;

import java.util.Arrays;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Cauldron")
public class TileCauldron extends TileContainer{

	
	private short brew;

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
