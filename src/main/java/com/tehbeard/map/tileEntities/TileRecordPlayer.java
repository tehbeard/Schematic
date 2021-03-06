package com.tehbeard.map.tileEntities;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("RecordPlayer")
public class TileRecordPlayer extends TileEntity {

	private byte record;
	public TileRecordPlayer(CompoundTag tag) {
		super(tag);
		record = tag.getByte("Record");

	}


	@Override
	public String toString() {
		return "TileSign [record=" + record+ "]";
	}


    public byte getRecord() {
        return record;
    }

    @Override
    public CompoundTag toTag() {
        CompoundTag tag = super.toTag();
        tag.putByte("Record", record);
        return tag;
    }



}
