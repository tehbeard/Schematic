package me.tehbeard.utils.map.misc;

import java.util.ArrayList;
import java.util.List;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

public class Item {

    //base data
    private byte slot;
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
        
    @SuppressWarnings("unchecked")
    public Item(CompoundTag tag){
        slot = tag.contains("Slot") ? tag.getByte("Slot") : -1;
        id = tag.getShort("id");
        damage = tag.getShort("Damage");
        count = tag.getByte("Count");
        if(tag.contains("tag")){
            
            CompoundTag t= tag.getCompound("tag");
            this.tag = (CompoundTag) t.copy();
            for(CompoundTag ench : (ListTag<CompoundTag>)t.getList("ench")){
                enchantments.add(new Enchantment(ench));
            }
            //TODO: ANVIL RELATED DATA
            
        }
    }

    public byte getSlot() {
        return slot;
    }

    public short getId() {
        return id;
    }

    public short getDamage() {
        return damage;
    }

    public byte getCount() {
        return count;
    }

    public List<Enchantment> getEnchantments() {
        return enchantments;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return lore;
    }

    public int getRepairCost() {
        return RepairCost;
    }

    public CompoundTag getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "Item [slot=" + slot + ", id=" + id + ", damage=" + damage
                + ", count=" + count + ", enchantments=" + enchantments
                + ", color=" + color + ", name=" + name + ", lore=" + lore
                + ", RepairCost=" + RepairCost + "]";
    }


    
    
}
