package com.tehbeard.map.misc;

import org.bukkit.Location;

public class WorldVector {
    
    private double x;
    private double y;
    private double z;
    private String worldName;
    
    
    
    /**
     * @param x
     * @param y
     * @param z
     * @param worldName
     */
    public WorldVector(double x, double y, double z, String worldName) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
        this.worldName = worldName;
    }
    
    public WorldVector(WorldVector v){
        x = v.x;
        y = v.y;
        z = v.z;
        worldName = new String(v.worldName);
       
    }
    
    public WorldVector(Location l){
        this(l.getX(),l.getY(),l.getZ(),l.getWorld().getName());
    }
    
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }
    public String getWorldName() {
        return worldName;
    }
    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    @Override
    public String toString() {
        return "WorldVector [x=" + x + ", y=" + y + ", z=" + z + ", worldName="
                + worldName + "]";
    }
    
    public WorldVector addVector(WorldVector other){
        x += other.x;
        y += other.y;
        z += other.z;
        return this;
    }
    public WorldVector subtractVector(WorldVector other){
        x -= other.x;
        y -= other.y;
        z -= other.z;
        return this;
    }

    public int getBlockX(){
        return (int) x;
    }
    
    public int getBlockY(){
        return (int) y;
    }
    
    public int getBlockZ(){
        return (int) z;
    }
    
    public void rotateVector(int direction){
        int d[] = new int[4];
        d[0] = getBlockZ();
        d[1] = getBlockX();
        d[2] = -getBlockZ();
        d[3] = -getBlockX();
        setX(d[(direction+1)%4]);
        setZ(d[(direction)%4]);
    }
}
