package com.tehbeard.map.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.tehbeard.map.entities.Entity;
import com.tehbeard.map.entities.ItemFrame;
import com.tehbeard.map.entities.Minecart;
import com.tehbeard.map.entities.Painting;
import com.tehbeard.map.factory.APIWorker.API;
import com.tehbeard.mojang.nbt.CompoundTag;

import me.tehbeard.utils.factory.ConfigurableFactory;
import me.tehbeard.utils.map.entities.mob.*;
import me.tehbeard.utils.map.tileEntities.*;
import me.tehbeard.utils.schematic.worker.SchematicPartWorker;

public class WorkerFactory {
    private FactoryObj<TileEntity> tileEntityFactory = new FactoryObj<TileEntity>();

    private FactoryObj<Entity> entityFactory = new FactoryObj<Entity>();
    
    private Map<APIWorker.API,Map<String,SchematicPartWorker>> workers = new HashMap<APIWorker.API, Map<String,SchematicPartWorker>>();
    
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
    
    public void addWorker(SchematicPartWorker worker){
        
        APIWorker api = worker.getClass().getAnnotation(APIWorker.class);
        ConsumesTypes type = worker.getClass().getAnnotation(ConsumesTypes.class);
        if(api == null || type ==null){throw new IllegalArgumentException("Invalid Annotation configuration");}
        
        Map<String, SchematicPartWorker> apiCol = workers.get(api.value());
        for(String s : type.value()){
            apiCol.put(s, worker);
        }
    }
    
    private static WorkerFactory instance;
    /**
     * INITIALISE WORKER
     */
    static{
        instance = new WorkerFactory();
        
        //Tile entities
        instance.addTileEntity(TileSign.class);
        instance.addTileEntity(TileTrap.class);
        instance.addTileEntity(TileChest.class);
        instance.addTileEntity(TileFurnace.class);
        instance.addTileEntity(TileRecordPlayer.class);
        instance.addTileEntity(TileNoteBlock.class);
        instance.addTileEntity(TileSpawner.class);
        instance.addTileEntity(TileCauldron.class);
        
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
    
    /**
     * Get the schematic worker for a entity/tileEntity
     * @param api
     * @param id
     * @return
     */
    public SchematicPartWorker getWorker(API api,String id){
        return workers.get(api).get(id);
    }


    public static WorkerFactory getInstance() {
        return instance;
    }

}
