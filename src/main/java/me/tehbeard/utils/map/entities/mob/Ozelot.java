package me.tehbeard.utils.map.entities.mob;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Ozelot")
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
