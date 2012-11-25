package me.tehbeard.utils.map.misc;

import com.tehbeard.mojang.nbt.CompoundTag;

public class Enchantment {
    
    private short type;
    private short lvl;
    
    public Enchantment(CompoundTag tag){
        type = tag.getShort("id");
        lvl  = tag.getShort("lvl");
    }

    public short getType() {
        return type;
    }

    public short getLvl() {
        return lvl;
    }
    

}
