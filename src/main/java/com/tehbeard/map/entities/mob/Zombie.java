package com.tehbeard.map.entities.mob;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Zombie")
public class Zombie extends MobEntity {

    private boolean baby;
    private boolean villager;
    private int conversionTime;
    
    public Zombie(CompoundTag tag) {
        super(tag);
        baby = tag.getByte("isBaby")==1;
        villager = tag.getByte("isVillager")==1;
        conversionTime = tag.getInt("ConversionTime");
    }

    public boolean isBaby() {
        return baby;
    }

    public boolean isVillager() {
        return villager;
    }

    public int getConversionTime() {
        return conversionTime;
    }

  
}
