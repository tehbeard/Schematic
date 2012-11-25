package me.tehbeard.utils.map.entities.mob;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("LavaSlime")
public class LavaSlime extends Slime {

    public LavaSlime(CompoundTag tag) {
        super(tag);
    }

}
