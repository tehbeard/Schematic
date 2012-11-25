package me.tehbeard.utils.map.entities;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.DoubleTag;
import com.mojang.nbt.FloatTag;
import com.mojang.nbt.ListTag;

/**
 * Base entity NBT storage
 * @author James
 *
 */
public abstract class Entity {
    
    private String id;
    private double x,y,z,dx,dy,dz;
    private float yaw,pitch;
    
    private boolean invulnerable;
    
    @SuppressWarnings("unchecked")
    public Entity(CompoundTag tag) {
        id = tag.getString("id");
        x = ((ListTag<DoubleTag>) tag.getList("Pos")).get(0).data;
        y = ((ListTag<DoubleTag>) tag.getList("Pos")).get(1).data;
        z = ((ListTag<DoubleTag>) tag.getList("Pos")).get(2).data;
        dx = ((ListTag<DoubleTag>) tag.getList("Motion")).get(0).data;
        dy = ((ListTag<DoubleTag>) tag.getList("Motion")).get(1).data;
        dz = ((ListTag<DoubleTag>) tag.getList("Motion")).get(2).data;
        yaw = ((ListTag<FloatTag>) tag.getList("Rotation")).get(0).data; 
        pitch = ((ListTag<FloatTag>) tag.getList("Rotation")).get(1).data;
        
        invulnerable = tag.getBoolean("Invulnerable");
    }

    
    public String getId() {
        return id;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getDz() {
        return dz;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public boolean isInvulnerable() {
        return invulnerable;
    }
   
    
    
}
