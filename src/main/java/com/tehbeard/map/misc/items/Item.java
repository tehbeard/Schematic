package com.tehbeard.map.misc.items;

import java.util.ArrayList;
import java.util.List;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;
import com.tehbeard.mojang.nbt.StringTag;

public class Item {

    //base data
    private byte slot;
    private short id;
    private short damage;
    private byte count;
    private List<ItemEnchantment> enchantments = new ArrayList<ItemEnchantment>();
    
    //anvil data
    private int color = 0;
    private String name = null;
    private List<String> itemLore = null;
    private int repairCost = 0;
    
    //extra data
    private CompoundTag tag;
        
    @SuppressWarnings("unchecked")
    public Item(CompoundTag itemTag){
        slot = itemTag.contains("Slot") ? itemTag.getByte("Slot") : -1;
        id = itemTag.getShort("id");
        damage = itemTag.getShort("Damage");
        count = itemTag.getByte("Count");
        if(itemTag.contains("tag")){
            
            CompoundTag tagTag = itemTag.getCompound("tag");
            this.tag = (CompoundTag) tagTag.copy();
            for(CompoundTag ench : (ListTag<CompoundTag>)tagTag.getList("ench")){
                enchantments.add(new ItemEnchantment(ench));
            }
            
            //TODO: ANVIL RELATED DATA
            repairCost = tagTag.contains("RepairCost") ? tagTag.getInt("RepairCost") : 0;
            
            //Display data
            if(tagTag.contains("display")){
                CompoundTag displayTag = tagTag.getCompound("display");
                
                //Item color
                color = displayTag.contains("color") ? displayTag.getInt("color") : 0;
                
                //item name
                name  = displayTag.contains("Name") ? displayTag.getString("Name") : null;
                
                //item lore
                if(displayTag.contains("Lore")){
                    itemLore = new ArrayList<String>();
                    for(StringTag lore : (ListTag<StringTag>)displayTag.getList("Lore")){
                        itemLore.add(lore.data);
                    }
                    
                }
            }
            
            
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

    public List<ItemEnchantment> getEnchantments() {
        return enchantments;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return itemLore;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public CompoundTag getTag() {
        return tag;
    }
    
    //BOOK RELATED DATA
    public String getBookTitle(){
        return tag.contains("title") ? tag.getString("title") : null;
    }
    
    public String getBookAuthor(){
        return tag.contains("author") ? tag.getString("author") : null;
    }
    
    @SuppressWarnings("unchecked")
    public List<String> getBookPages(){
        ArrayList<String> pages = new ArrayList<String>();
        for(StringTag page : (ListTag<StringTag>)tag.getList("pages")){
            pages.add(page.data);
        }
        return pages;
    }
    
    public String getSkullOwner(){
        return tag.contains("SkullOwner") ? tag.getString("SkullOwner") : null;
    }
    

    @Override
    public String toString() {
        return "Item [slot=" + slot + ", id=" + id + ", damage=" + damage
                + ", count=" + count + ", enchantments=" + enchantments
                + ", color=" + color + ", name=" + name + ", itemLore=" + itemLore
                + ", RepairCost=" + repairCost + "]";
    }


    
    
}
