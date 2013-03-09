package com.tehbeard.map.entities.vehicles;


import com.tehbeard.map.entities.Entity;
import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.misc.items.Item;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

public class Minecart extends Entity{
	 int displayTile;
	 public int getDisplayTile() {
		return displayTile;
	}

	public int getDisplayData() {
		return displayData;
	}

	public byte getCustomDisplayTile() {
		return customDisplayTile;
	}

	public int getDisplayOffset() {
		return displayOffset;
	}

	int displayData;
	 byte customDisplayTile;
	 int displayOffset;

    public Minecart(CompoundTag tag) {
        super(tag);
        
        displayTile = tag.getInt("DisplayTile");
        displayData = tag.getInt("DisplayData");
        customDisplayTile = tag.getByte("CustomDisplayTile");
        displayOffset = tag.getInt("DisplayOffset");
       
    }
    
        

}
