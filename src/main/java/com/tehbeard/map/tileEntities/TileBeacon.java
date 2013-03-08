package com.tehbeard.map.tileEntities;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.ItemPotionEffect;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Control")
public class TileBeacon extends TileNameable{

	private int levels;
	private int primary;
	private int secondary;
	
	
	public int getLevels() {
		return levels;
	}




	public int getPrimary() {
		return primary;
	}




	public int getSecondary() {
		return secondary;
	}




	public TileBeacon(CompoundTag tag) {
		super(tag);
		levels = tag.getInt("Levels");
		primary = tag.getInt("Primary");
		secondary = tag.getInt("Secondary");
		
	}
	

}
