package me.tehbeard.utils.map.entities.mob;

import me.tehbeard.utils.map.misc.Item;

import com.tehbeard.mojang.nbt.CompoundTag;

public class Enderman extends MobEntity{

    private Item carried;
    
    public Enderman(CompoundTag tag) {
        super(tag);
        carried = new Item(tag);
    }

    public Item getCarried() {
        return carried;
    }

}
