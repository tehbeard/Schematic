package me.tehbeard.utils.map.entities.mob;


import com.tehbeard.map.entities.Entity;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.FloatTag;
import com.tehbeard.mojang.nbt.ListTag;

import me.tehbeard.utils.map.misc.Item;
import me.tehbeard.utils.map.misc.PotionEffect;
import me.tehbeard.utils.map.misc.MapUtils;


public abstract class MobEntity extends Entity {
    
    private short health;
    private short attackTime;
    private short hurtTime;
    private short deathTime;
    private PotionEffect[] activeEffects;
    private Item[] equipment;
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
            activeEffects[i] = new PotionEffect(potionTag);
            i++;
        }
        
        equipment = MapUtils.makeInventory(5, (ListTag<CompoundTag>) tag.getList("Items"));
        
        dropChance = new float[5];
        i = 0;
        for(FloatTag chanceTag : (ListTag<FloatTag>)tag.getList("DropChances")){
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

    public Item[] getEquipment() {
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
