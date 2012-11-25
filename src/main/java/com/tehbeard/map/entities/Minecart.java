package com.tehbeard.map.entities;

import me.tehbeard.utils.map.misc.Item;
import me.tehbeard.utils.map.misc.MapUtils;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

@DataType("Minecraft")
public class Minecart extends Entity{

    private int type;
    private Item[] items = new Item[27];
    
    
    public Minecart(CompoundTag tag) {
        super(tag);
        type = tag.getInt("Type");
        if(tag.contains("Items")){
            items = MapUtils.makeInventory(27,(ListTag<CompoundTag>)tag.getList("Items"));
        }
        
    }
    
    public Item[] getItems() {
        return items;
    }

    public int getType() {
        return type;
    }
    

}
