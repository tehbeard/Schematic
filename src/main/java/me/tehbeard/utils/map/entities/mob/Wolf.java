package me.tehbeard.utils.map.entities.mob;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Wolf")
public class Wolf extends MobEntity {

    private boolean angry;
    public Wolf(CompoundTag tag) {
        super(tag);
        angry = tag.getByte("Angry")==1;
    }
    public boolean isAngry() {
        return angry;
    }
  
}
