package com.tehbeard.map.entities;

import me.tehbeard.utils.map.misc.Item;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

public class Minecart extends Entity{

    private int type;
    private Item[] items = new Item[27];
    
    
    public Minecart(CompoundTag tag) {
        super(tag);
        type = tag.getInt("Type");
        if(tag.contains("Items")){
            for(CompoundTag t : (ListTag<CompoundTag>)tag.getList("Items")){
                Item i = new Item(t);
                items[i.getSlot()] = i;
            }
        }
    }
    
    public Item[] getItems() {
        return items;
    }

    public int getType() {
        return type;
    }
    

}
