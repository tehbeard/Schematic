package com.tehbeard.map.entities;

import com.tehbeard.mojang.nbt.CompoundTag;

public class Painting extends Entity{

    private int tx,ty,tz;
    private byte direction;
    private String motive;
    public Painting(CompoundTag tag) {
        super(tag);
        tx = tag.getInt("TileX");
        ty = tag.getInt("TileY");
        tz = tag.getInt("TileZ");
        direction = tag.getByte("Direction");
        motive = tag.getString("Motive");
    }
    public int getTx() {
        return tx;
    }
    public int getTy() {
        return ty;
    }
    public int getTz() {
        return tz;
    }
    public byte getDirection() {
        return direction;
    }
    public String getMotive() {
        return motive;
    }
   

}
