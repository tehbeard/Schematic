package com.tehbeard.map.entities.vehicles;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("MinecartRidable")
public class MinecartRidable extends Minecart{

	public MinecartRidable(CompoundTag tag) {
		super(tag);
	}
	    
}
