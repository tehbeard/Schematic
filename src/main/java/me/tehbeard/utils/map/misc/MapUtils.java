package me.tehbeard.utils.map.misc;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

public class MapUtils {

    public static Item[] makeInventory(int size,ListTag<CompoundTag> items){
        Item[] ii = new Item[size];
        for(CompoundTag t : (ListTag<CompoundTag>) items){
            Item i = new Item(t);
            ii[i.getSlot()]=i;
        }
        return ii;
    }
}
