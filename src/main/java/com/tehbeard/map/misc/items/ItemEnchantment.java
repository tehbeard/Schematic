package com.tehbeard.map.misc.items;

import java.util.List;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

public class ItemEnchantment {
    
    private short type;
    private short lvl;
    
    public ItemEnchantment(CompoundTag tag){
        type = tag.getShort("id");
        lvl  = tag.getShort("lvl");
    }

    public short getType() {
        return type;
    }

    public short getLvl() {
        return lvl;
    }

    @Override
    public String toString() {
        return "Enchantment [type=" + type + ", lvl=" + lvl + "]";
    }
    
    
    public static List<ItemEnchantment> getEnchantmentList(ListTag<CompoundTag> tag){
        return null;
    }
    
}
