package com.tehbeard.map.tileEntities;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Skull")
public class TileSkull extends TileEntity {

	private String owner;
	private byte   type;
	private byte   rot;
	public TileSkull(CompoundTag tag) {
		super(tag);
		owner = tag.getString("ExtraType");
		type = tag.getByte("SkullType");
		rot  = tag.getByte("Rot");
	}
	public String getOwner() {
		return owner;
	}
	public byte getType() {
		return type;
	}
	public byte getRot() {
		return rot;
	}

	

	



}
