package com.tehbeard.map.misc.spawner;

import com.tehbeard.map.entities.Entity;
import com.tehbeard.map.factory.WorkerFactory;
import com.tehbeard.mojang.nbt.CompoundTag;

public class SpawnPotential {
	
	private String type;
	private int weight;
	private Entity properties;
	
	public SpawnPotential(CompoundTag tag){
		type   = tag.getString("Type");
		weight = tag.getInt("Weight");
		properties = WorkerFactory.getInstance().getEntity(tag.getCompound("Properties"));
	}

	public String getType() {
		return type;
	}

	public int getWeight() {
		return weight;
	}

	public Entity getProperties() {
		return properties;
	}
	
	

}
