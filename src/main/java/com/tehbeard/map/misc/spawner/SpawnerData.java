package com.tehbeard.map.misc.spawner;

import java.util.ArrayList;
import java.util.List;

import com.tehbeard.map.entities.Entity;
import com.tehbeard.mojang.nbt.CompoundTag;

public class SpawnerData {
	
	private List<SpawnPotential> spawnPotentials = new ArrayList<SpawnPotential>();
	
	@Deprecated
	private String entityId;
	@Deprecated
	private Entity spawnData;
	
	private short spawnCount;
	private short spawnRange;
	private short delay;
	private short minSpawnDelay;
	private short maxSpawnDelay;

	private short maxNearbyEntities;
	private short requiredPlayerRange;
	
	public SpawnerData(CompoundTag tag){
		
		
	}
}
