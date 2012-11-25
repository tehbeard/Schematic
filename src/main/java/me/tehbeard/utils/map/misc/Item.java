package me.tehbeard.utils.map.misc;

import java.util.ArrayList;
import java.util.List;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

public class Item {

    //base data
    private short id;
    private short damage;
    private byte count;
    private List<Enchantment> enchantments = new ArrayList<Enchantment>();
    
    //anvil data
    private int color;
    private String name;
    private List<String> lore;
    private int RepairCost;
    
    //extra data
    private CompoundTag tag;
        
    public Item(CompoundTag tag){
        id = tag.getShort("id");
        damage = tag.getShort("Damage");
        count = tag.getByte("Count");
        if(tag.contains("tag")){
            
            CompoundTag t= tag.getCompound("tag");
            this.tag = (CompoundTag) t.copy();
            for(CompoundTag ench : (ListTag<CompoundTag>)t.getList("ench")){
                enchantments.add(new Enchantment(ench));
            }
            
            
        }
    }
    
}
