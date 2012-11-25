package me.tehbeard.utils.map.entities.mob;

import com.mojang.nbt.CompoundTag;

public class Ozelot extends MobEntity{

    private int type;
    
    public Ozelot(CompoundTag tag) {
        
        super(tag);
        type = tag.getInt("CatType");
    }

    public int getType() {
        return type;
    }

}
