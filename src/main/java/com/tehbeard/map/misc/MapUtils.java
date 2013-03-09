package com.tehbeard.map.misc;

import com.tehbeard.map.misc.items.Item;
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
    
    public static Item[] makeItemList(int size,ListTag<CompoundTag> items){
        Item[] itemArray = new Item[size];
        int i = 0;
        for(CompoundTag t : (ListTag<CompoundTag>) items){
            Item item = new Item(t);
            itemArray[i]=item;
            i++;
        }
        return itemArray;
    }
    
    public static void printCon(String line){
        System.out.println("[Schematic] " + line);
    }
    
    public static void printDebugCon(String line){
        System.out.println("[Schematic][DEBUG] " + line);
    }
    
    

    
}
