package me.tehbeard.utils.map.entities.mob;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("Creeper")
public class Creeper extends MobEntity {

    private boolean powered;
    private byte radius = 3;
    
    public boolean isPowered() {
        return powered;
    }

    public byte getRadius() {
        return radius;
    }

    public Creeper(CompoundTag tag) {
        super(tag);
        powered = (tag.getByte("Powered") == 1);
        radius = tag.getByte("ExplosionRadius");
    }

}
