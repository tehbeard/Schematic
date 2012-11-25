package me.tehbeard.utils.map.utils;

import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.ListTag;

public class MapUtils {

    public static PotionEffect makePotionEffect(CompoundTag tag){
        return new PotionEffect(PotionEffectType.getById(tag.getByte("Id")), tag.getInt("Duration"), tag.getByte("amplifier"));     
    }

    public static ItemStack makeItemStack(CompoundTag tag){
        ItemStack is = new ItemStack(tag.getShort("id"),tag.getByte("Count"),tag.getShort("Damage"));
        if(tag.contains("tag")){
            CompoundTag tagz = tag.getCompound("tag");
            for(CompoundTag en : (ListTag<CompoundTag>)tagz.getList("ench")){
                is.addEnchantment(EnchantmentWrapper.getById(en.getShort("id")),en.getShort("lvl"));
            }
        }
        
        return is;
    }
}
