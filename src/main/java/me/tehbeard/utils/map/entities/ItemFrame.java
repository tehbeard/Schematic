package me.tehbeard.utils.map.entities;

import me.tehbeard.utils.map.utils.MapUtils;

import org.bukkit.inventory.ItemStack;

import com.mojang.nbt.CompoundTag;

public class ItemFrame extends Entity{

    private int tx,ty,tz;
    private byte direction;
    private ItemStack item;
    private float dropChance;
    private byte rotation;
    public ItemFrame(CompoundTag tag) {
        super(tag);
        tx = tag.getInt("TileX");
        ty = tag.getInt("TileY");
        tz = tag.getInt("TileZ");
        direction = tag.getByte("Direction");
        item = MapUtils.makeItemStack(tag.getCompound("Item"));
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
    public ItemStack getItem() {
        return item;
    }
    public float getDropChance() {
        return dropChance;
    }
    public byte getRotation() {
        return rotation;
    }

}
