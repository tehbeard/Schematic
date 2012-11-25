package me.tehbeard.utils.map.entities.mob;

import com.tehbeard.mojang.nbt.CompoundTag;

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
