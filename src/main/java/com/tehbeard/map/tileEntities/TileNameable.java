package com.tehbeard.map.tileEntities;

import com.tehbeard.mojang.nbt.CompoundTag;

public class TileNameable extends TileEntity{

	private String customName = null;
	
	public TileNameable(CompoundTag tag) {
		super(tag);
		if(tag.contains("CustomName"))
		{
			customName = tag.getString("CustomName");
		}
	}

	public String getCustomName() {
		return customName;
	}



}
