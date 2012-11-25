package me.tehbeard.utils.map.entities.mob;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("PigZombie")
public class PigZombie extends MobEntity{
    
    private short anger;
    
    public PigZombie(CompoundTag tag) {
        super(tag);
        anger = tag.getShort("Anger");
    }

    public short getAnger() {
        return anger;
    }
   

}
