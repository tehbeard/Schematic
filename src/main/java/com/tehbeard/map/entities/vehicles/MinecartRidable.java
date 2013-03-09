package com.tehbeard.map.entities.vehicles;


import com.tehbeard.map.entities.Entity;
import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.misc.items.Item;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

@DataType("MinecartRideable")
public class MinecartRidable extends Entity{

    private int type;
    private Item[] items = new Item[27];
    
    
    @SuppressWarnings("unchecked")
    public MinecartRidable(CompoundTag tag) {
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
