package com.tehbeard.map.entities;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.items.Item;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("ItemFrame")
public class ItemFrame extends Entity{

    private int tx,ty,tz;
    private byte direction;
    private Item item;
    private float dropChance;
    private byte rotation;
    public ItemFrame(CompoundTag tag) {
        super(tag);
        tx = tag.getInt("TileX");
        ty = tag.getInt("TileY");
        tz = tag.getInt("TileZ");
        direction = tag.getByte("Direction");
        item = new Item(tag.getCompound("Item"));
        dropChance = tag.getFloat("ItemDropChance");
        rotation = tag.getByte("ItemRotation");
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
    public Item getItem() {
        return item;
    }
    public float getDropChance() {
        return dropChance;
    }
    public byte getRotation() {
        return rotation;
    }

}
