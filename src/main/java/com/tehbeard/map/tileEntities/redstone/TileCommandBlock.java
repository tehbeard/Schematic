package com.tehbeard.map.tileEntities.redstone;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.tileEntities.TileNameable;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Control")
public class TileCommandBlock extends TileNameable{

	private String command;
	private int successCount;
	
	public String getCommand() {
		return command;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public TileCommandBlock(CompoundTag tag) {
		super(tag);
		command = tag.getString("Command");
		successCount = tag.getInt("SuccessCount");
	}

}
