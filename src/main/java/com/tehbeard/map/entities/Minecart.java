package com.tehbeard.map.entities;

import me.tehbeard.utils.map.utils.MapUtils;

import org.bukkit.inventory.ItemStack;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

public class Minecart extends Entity{

    private int type;
    private ItemStack[] items;
    
    
    public Minecart(CompoundTag tag) {
        super(tag);
        type = tag.getInt("Type");
        if(tag.contains("Items")){
            items = new ItemStack[tag.getList("Items").size()];
            int i = 0;
            for(CompoundTag t : (ListTag<CompoundTag>)tag.getList("Items")){
                items[i] = MapUtils.makeItemStack(t);
                i++;
            }
        }
    }
    
    public ItemStack[] getItems() {
        return items;
    }

    public int getType() {
        return type;
    }
    

}
