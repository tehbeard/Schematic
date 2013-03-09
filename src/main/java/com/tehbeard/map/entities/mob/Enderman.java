package com.tehbeard.map.entities.mob;


import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.items.Item;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Enderman")
public class Enderman extends MobEntity{

    private Item carried;
    
    public Enderman(CompoundTag tag) {
        super(tag);
        //carried = new Item();TODO: WRITE ITEM DESERIALIZER FOR ENDERMAN DATA
    }

    public Item getCarried() {
        return carried;
    }

}
