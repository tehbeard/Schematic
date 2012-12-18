package com.tehbeard.map.schematic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.tehbeard.map.entities.Entity;
import com.tehbeard.map.factory.WorkerFactory;
import com.tehbeard.map.misc.MapUtils;
import com.tehbeard.map.misc.WorldVector;
import com.tehbeard.map.tileEntities.*;
import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;
import com.tehbeard.mojang.nbt.NbtIo;

/**
 * Provides a way to access and manipulate .schematic files
 * @author James
 *
 */
public class Schematic {
    
    
    

    //SIZE
    private short width = 0;
    private short height = 0;
    private short length = 0;


    //Original location in world
    private WorldVector origin;

    //Offset vector
    private WorldVector offset;

    private byte[] blocks;
    private byte[] addBlocks;
    private byte[] blockData;
    
    private byte[] layer;

    private final List<TileEntity> tileEntities = new ArrayList<TileEntity>();

    private final List<Entity> entities = new ArrayList<Entity>();

    public Schematic(short width,short height,short length){
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public Schematic(File file) throws IOException{

        loadSchematic(file);
    }

    /**
     * loads the schematic data into memory
     * @throws IOException 
     */
    @SuppressWarnings("unchecked")
    public void loadSchematic(File file) throws IOException{
        CompoundTag tag  = NbtIo.readCompressed(new FileInputStream(file));

        if(!tag.getName().equalsIgnoreCase("schematic")){
            throw new IOException("File is not a valid schematic");
        }

        width = tag.getShort("Width");
        height = tag.getShort("Height");
        length = tag.getShort("Length");

        origin = new WorldVector(
                tag.getInt("WEOriginX"),
                tag.getInt("WEOriginY"),
                tag.getInt("WEOriginZ"),
                null
                );
        
        offset = new WorldVector(
                tag.getInt("WEOffsetX"),
                tag.getInt("WEOffsetY"),
                tag.getInt("WEOffsetZ"),
                null
                );


        int size = width*height*length;
        blocks = new byte[size];
        addBlocks = new byte[size];
        blockData = new byte[size];
        
        layer = new byte[size];

        if(tag.contains("Layers")){
            layer = tag.getByteArray("Layers");
        }
        //read in block data;
        blocks = tag.getByteArray("Blocks");
        if(tag.contains("AddBlocks")){
            addBlocks = tag.getByteArray("AddBlocks");
        }
        blockData = tag.getByteArray("Data");

        System.out.println("Schematic block data is width : " + width +
                " height: " + height +
                " length: " +length);


        //load tileEntities
        ListTag<CompoundTag> tileEntityTag = (ListTag<CompoundTag>) tag.getList("TileEntities");

        for(CompoundTag tileEntity  : tileEntityTag){

            TileEntity t = WorkerFactory.getInstance().getTileEntity(tileEntity.getString("id"), tileEntity);

            if(t!=null){
                MapUtils.printDebugCon(t.toString());
                this.tileEntities.add(t);
            }
            else
            {
                System.out.println("Could not load entity " + tileEntity.getString("id"));
            }
        }

        ListTag<CompoundTag> entityTag = (ListTag<CompoundTag>) tag.getList("Entities");

        for(CompoundTag entity  : entityTag){

            Entity e = WorkerFactory.getInstance().getEntity(entity.getString("id"), entity);

            if(e!=null){
                MapUtils.printDebugCon(e.toString());
                this.entities.add(e);
            }
            else
            {
                System.out.println("Could not load entity " + entity.getString("id"));
            }
        }
    }

    public byte getBlockId(int x,int y,int z){

        int index =  (y * width * length) + (z * width) + x;
        if(index < 0 || index >= blocks.length){
            return 0;
        }
        //((addBlocks[pos] << 8 )
        return blocks[index];
    }

    public byte getBlockData(int x,int y,int z){

        int index =  y * width *length + z * width + x;
        if(index < 0 || index >= blockData.length){
            return 0;
        }
        return blockData[index];
    }

    public final short getWidth() {
        return width;
    }

    public final short getHeight() {
        return height;
    }

    public final short getLength() {
        return length;
    }



    public final List<TileEntity> getTileEntities() {
        return tileEntities;
    }

    public final List<Entity> getEntities() {
        return entities;
    }
    
    public WorldVector getOrigin() {
        return origin;
    }

    public WorldVector getOffset() {
        return offset;
    }



    
    public String toString(){
        return "Schematic {" +
        		"[w: " + getWidth() + ", " +
        		"l: " + getLength() + ", " +
        		"h: " + getHeight() + "]\n" +
        				"origin: " + origin + "\n" +
        				"offset: " + offset + "\n" +
        				"\n}";
        		
                
    }

}
