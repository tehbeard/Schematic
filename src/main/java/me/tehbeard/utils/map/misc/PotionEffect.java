package me.tehbeard.utils.map.misc;

import com.tehbeard.mojang.nbt.CompoundTag;

public class PotionEffect {

    private byte id;
    private byte amplifier;
    private int  duration;
    private boolean ambient;
    
    public PotionEffect(CompoundTag tag){
        id        = tag.getByte("Id");
        amplifier = tag.getByte("Amplifier");
        duration  = tag.getInt("Duration");
        ambient   = (tag.getByte("Ambient") == 1);
    }
    
    public byte getId() {
        return id;
    }
    public byte getAmplifier() {
        return amplifier;
    }
    public int getDuration() {
        return duration;
    }
    public boolean getAmbient() {
        return ambient;
    }
}
