package com.tehbeard.map.tileEntities;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("EnchantTable")
public class TileEnchantTable extends TileNameable{

	
	public TileEnchantTable(CompoundTag tag) {
		super(tag);
	}

}
