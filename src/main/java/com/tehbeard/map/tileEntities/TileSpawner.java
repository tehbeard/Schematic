package com.tehbeard.map.tileEntities;

import java.util.List;

import com.tehbeard.map.entities.Entity;
import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.spawner.SpawnPotential;
import com.tehbeard.map.misc.spawner.SpawnerData;
import com.tehbeard.mojang.nbt.CompoundTag;

@DataType("MobSpawner")
public class TileSpawner extends TileEntity {

    private SpawnerData spawnerData;
    
    public TileSpawner(CompoundTag tag) {
        super(tag);
        spawnerData = new SpawnerData(tag);
    }


    @Override
    public String toString() {
        return "TileMobSpawner [TODO]";
    }


    public List<SpawnPotential> getSpawnPotentials() { return  spawnerData.getSpawnPotentials(); } 

    @Deprecated
    public String getEntityId() { return  spawnerData.getEntityId(); } 

    @Deprecated
    public Entity getSpawnData() { return  spawnerData.getSpawnData(); } 

    public short getSpawnCount() { return  spawnerData.getSpawnCount(); } 

    public short getSpawnRange() { return  spawnerData.getSpawnRange(); } 

    public short getDelay() { return  spawnerData.getDelay(); } 

    public short getMinSpawnDelay() { return  spawnerData.getMinSpawnDelay(); } 

    public short getMaxSpawnDelay() { return  spawnerData.getMaxSpawnDelay(); } 

    public short getMaxNearbyEntities() { return  spawnerData.getMaxNearbyEntities(); } 

    public short getRequiredPlayerRange() { return  spawnerData.getRequiredPlayerRange(); } 

}
