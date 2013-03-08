package com.tehbeard.map.factory;


import com.tehbeard.map.entities.Entity;
import com.tehbeard.map.entities.ItemFrame;
import com.tehbeard.map.entities.Minecart;
import com.tehbeard.map.entities.Painting;
import com.tehbeard.map.entities.mob.*;
import com.tehbeard.map.tileEntities.*;
import com.tehbeard.map.tileEntities.container.TileCauldron;
import com.tehbeard.map.tileEntities.container.TileChest;
import com.tehbeard.map.tileEntities.container.TileDropper;
import com.tehbeard.map.tileEntities.container.TileFurnace;
import com.tehbeard.map.tileEntities.container.TileHopper;
import com.tehbeard.map.tileEntities.container.TileTrap;
import com.tehbeard.mojang.nbt.CompoundTag;

import me.tehbeard.utils.factory.ConfigurableFactory;

public class WorkerFactory {
    private FactoryObj<TileEntity> tileEntityFactory = new FactoryObj<TileEntity>();

    private FactoryObj<Entity> entityFactory = new FactoryObj<Entity>();
    
    
    private class FactoryObj<T> extends ConfigurableFactory<T, DataType> {

        public FactoryObj() {
            super(DataType.class);
        }

        @Override
        public String getTag(DataType type) {
            return type.value();
        }
        
        public T make(String tag,CompoundTag data){
            try {
                return products.get(tag).getDeclaredConstructor(CompoundTag.class).newInstance(data);
            }catch(NullPointerException exception){
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
    
    
    /**
     * Add a tile entity data handler
     * @param tileEntity
     */
    public void addTileEntity(Class<? extends TileEntity> tileEntity){
        tileEntityFactory.addProduct(tileEntity);
    }
    
    /**
     * Add an entity data handler
     * @param entity
     */
    public void addEntity(Class<? extends Entity> entity){
        entityFactory.addProduct(entity);
    }
    
    
    
    private static WorkerFactory instance;
    /**
     * INITIALISE WORKER
     */
    static{
        instance = new WorkerFactory();
        
        //Tile entities
        instance.addTileEntity(TileSkull.class);
        instance.addTileEntity(TileSign.class);
        instance.addTileEntity(TileTrap.class);
        instance.addTileEntity(TileChest.class);
        instance.addTileEntity(TileFurnace.class);
        instance.addTileEntity(TileRecordPlayer.class);
        instance.addTileEntity(TileNoteBlock.class);
        instance.addTileEntity(TileSpawner.class);
        instance.addTileEntity(TileCauldron.class);
        instance.addTileEntity(TileBeacon.class);
        instance.addTileEntity(TileHopper.class);
        instance.addTileEntity(TileDropper.class);
        instance.addTileEntity(TileDLDetector.class);
        instance.addTileEntity(TileCommandBlock.class);
        instance.addTileEntity(TileEnchantTable.class);
        
        
        //mob entities
        instance.addEntity(Creeper.class);
        instance.addEntity(Enderman.class);
        instance.addEntity(LavaSlime.class);
        instance.addEntity(Ozelot.class);
        instance.addEntity(Pig.class);
        instance.addEntity(PigZombie.class);
        instance.addEntity(Skeleton.class);
        instance.addEntity(Slime.class);
        instance.addEntity(WitherBoss.class);
        instance.addEntity(Wolf.class);
        instance.addEntity(Zombie.class);
        
        //other entities
        instance.addEntity(Minecart.class);
        instance.addEntity(ItemFrame.class);
        instance.addEntity(Painting.class);
        
        
    }
    
    /**
     * Create a TileEntity data object
     * @param id
     * @param data
     * @return
     */
    public TileEntity getTileEntity(String id,CompoundTag data){
        return tileEntityFactory.make(id, data);
    }
    
    /**
     * Create a Entity data object
     * @param id
     * @param data
     * @return
     */
    public Entity getEntity(String id,CompoundTag data){
        return entityFactory.make(id, data);
    }
    

    public static WorkerFactory getInstance() {
        return instance;
    }

}
