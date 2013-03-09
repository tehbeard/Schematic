package com.tehbeard.map.tileEntities.redstone;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.tileEntities.TileEntity;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Music")
public class TileNoteBlock extends TileEntity {

	private byte note;
	public TileNoteBlock(CompoundTag tag) {
		super(tag);
		note = tag.getByte("note");

	}


	@Override
	public String toString() {
		return "TileNoteBlock [note=" + note+ "]";
	}


    public byte getNote() {
        return note;
    }

    
    @Override
    public CompoundTag toTag() {
        CompoundTag tag = super.toTag();
        tag.putByte("note", note);
        return tag;
    }
	


}
