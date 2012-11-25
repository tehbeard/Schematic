package me.tehbeard.utils.map.entities.mob;

import com.tehbeard.mojang.nbt.CompoundTag;

public class Pig extends MobEntity{
    
    private boolean saddle;
    
    public Pig(CompoundTag tag) {
        super(tag);
        saddle = (tag.getByte("Saddle") == 1);
    }

    public boolean isSaddle() {
        return saddle;
    }
   

}
