package me.tehbeard.utils.map.entities.mob;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.FloatTag;
import com.mojang.nbt.ListTag;

import me.tehbeard.utils.map.entities.Entity;
import me.tehbeard.utils.map.utils.MapUtils;

public abstract class MobEntity extends Entity {
    
    private short health;
    private short attackTime;
    private short hurtTime;
    private short deathTime;
    private PotionEffect[] activeEffects;
    private ItemStack[] equipment;
    private float[] dropChance;
    private boolean canPickUpLoot;
    private boolean persistenceRequired;
    
    public MobEntity(CompoundTag tag){
        super(tag);
        
        health = tag.getShort("Health");
        attackTime = tag.getShort("AttackTime");
        hurtTime = tag.getShort("HurtTime");
        deathTime = tag.getShort("DeathTime");
        
        activeEffects = new PotionEffect[tag.getList("ActiveEffects").size()];
        int i = 0;
        for(CompoundTag potionTag : (ListTag<CompoundTag>)tag.getList("ActiveEffects")){
            activeEffects[i] = MapUtils.makePotionEffect(potionTag);
            i++;
        }
        
        equipment = new ItemStack[5];
        i = 0;
        for(CompoundTag itemTag : (ListTag<CompoundTag>)tag.getList("Equipment")){
            equipment[i] = MapUtils.makeItemStack(itemTag);
            i++;
        }
        dropChance = new float[5];
        i = 0;
        for(FloatTag chanceTag : (ListTag<FloatTag>)tag.getList("Equipment")){
            dropChance[i] = chanceTag.data;
            i++;
        }
        
        canPickUpLoot = tag.getBoolean("CanPickUpLoot");
        persistenceRequired = tag.getBoolean("PersistenceRequired");
    }

    public short getHealth() {
        return health;
    }

    public short getAttackTime() {
        return attackTime;
    }

    public short getHurtTime() {
        return hurtTime;
    }

    public short getDeathTime() {
        return deathTime;
    }

    public PotionEffect[] getActiveEffects() {
        return activeEffects;
    }

    public ItemStack[] getEquipment() {
        return equipment;
    }

    public float[] getDropChance() {
        return dropChance;
    }

    public boolean isCanPickupLoot() {
        return canPickUpLoot;
    }

    public boolean isPersistenceRequired() {
        return persistenceRequired;
    }
    
    
}
