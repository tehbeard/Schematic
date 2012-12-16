package me.tehbeard.utils.schematic.worker;

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
    

}
