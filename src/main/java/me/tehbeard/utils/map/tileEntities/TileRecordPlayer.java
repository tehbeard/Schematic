package me.tehbeard.utils.map.tileEntities;


import com.tehbeard.mojang.nbt.CompoundTag;

@TileEntityType(id="RecordPlayer")
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

	



}
