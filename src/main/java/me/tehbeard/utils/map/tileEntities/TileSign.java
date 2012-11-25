package me.tehbeard.utils.map.tileEntities;

import java.util.Arrays;

import com.tehbeard.mojang.nbt.CompoundTag;

@TileEntityType(id="Sign")
public class TileSign extends TileEntity {

	private String[] lines;
	public TileSign(CompoundTag tag) {
		super(tag);
		lines = new String[4];
		lines[0] = tag.getString("Text1");
		lines[1] = tag.getString("Text2");
		lines[2] = tag.getString("Text3");
		lines[3] = tag.getString("Text4");
	}

	public String[] getLines() {
        return lines;
    }

    @Override
	public String toString() {
		return "TileSign [line=" + Arrays.toString(lines) + "]";
	}

	



}
