package com.tehbeard.map.entities.mob;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Slime")
public class Slime extends MobEntity {

    private int size;
    public Slime(CompoundTag tag) {
        super(tag);
        size= tag.getInt("Size");
    }
    
    public int getSize(){
        return size;
    }

}
