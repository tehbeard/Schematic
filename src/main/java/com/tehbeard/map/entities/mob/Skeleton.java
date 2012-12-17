package com.tehbeard.map.entities.mob;

import com.tehbeard.mojang.nbt.CompoundTag;

public class Skeleton extends MobEntity{
    
    private boolean wither;
    
    public Skeleton(CompoundTag tag) {
        super(tag);
        wither = (tag.getByte("SkeletonType") == 1);
    }

    public boolean isWither() {
        return wither;
    }
   

}
