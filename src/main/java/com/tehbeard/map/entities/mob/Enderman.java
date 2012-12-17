package com.tehbeard.map.entities.mob;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.Item;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Enderman")
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
