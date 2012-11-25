package me.tehbeard.utils.map.tileEntities;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("MobSpawner")
public class TileSpawner extends TileEntity {

    private String type;
    private int delay;
    public TileSpawner(CompoundTag tag) {
        super(tag);
        type = tag.getString("EntityId");
        delay = tag.getShort("Delay");
        //TODO: UPDATE THIS SHIT, WAY OUT OF DATE THANKS TO DINNERBONE
    }


    @Override
    public String toString() {
        return "TileMobSpawner [type=" + type+ "]";
    }


    public String getType() {
        return type;
    }


    

    public int getDelay() {
        return delay;
    }

}
