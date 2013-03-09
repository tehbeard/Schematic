package com.tehbeard.map.entities.vehicles;

import com.tehbeard.map.factory.DataType;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.misc.items.Item;
import com.tehbeard.map.misc.spawner.SpawnerData;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;

@DataType("MinecartSpawner")
public class MinecartSpawner extends Minecart{

	private SpawnerData spawnerData;
	
	@SuppressWarnings("unchecked")
	public MinecartSpawner(CompoundTag tag) {
		super(tag);
		spawnerData = new SpawnerData(tag);
		
	}

	public SpawnerData getSpawnerData() {
		return spawnerData;
	}

}
