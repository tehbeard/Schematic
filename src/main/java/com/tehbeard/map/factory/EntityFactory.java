package com.tehbeard.map.factory;

import com.tehbeard.map.entities.Entity;

import me.tehbeard.utils.factory.ConfigurableFactory;

public class EntityFactory {
private static ConfigurableFactory<Entity, DataType> entityFactory;
    
    static{
        entityFactory = new ConfigurableFactory<Entity, DataType>(DataType.class) {

            @Override
            public String getTag(DataType annotation) {
                return annotation.value();
            }
        };
        
    }
    
    public static ConfigurableFactory<Entity, DataType> getInstance(){
        
        return entityFactory;
    }
}
