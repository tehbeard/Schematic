package me.tehbeard.utils.map.entities.mob;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("WitherBoss")
public class WitherBoss extends MobEntity {

    private int invul;
    public WitherBoss(CompoundTag tag) {
        super(tag);
        invul= tag.getInt("Invul");
    }
    
    public int getInvul(){
        return invul;
    }

}
