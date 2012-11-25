package me.tehbeard.utils.map.entities.mob;

import org.bukkit.inventory.ItemStack;

import com.tehbeard.mojang.nbt.CompoundTag;

public class Enderman extends MobEntity{

    private ItemStack carried;
    
    public Enderman(CompoundTag tag) {
        super(tag);
        carried = new ItemStack(tag.getShort("carried"),1,tag.getShort("carriedData"));
    }

    public ItemStack getCarried() {
        return carried;
    }

}
