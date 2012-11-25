package com.tehbeard.map.factory;

import me.tehbeard.utils.factory.ConfigurableFactory;
import me.tehbeard.utils.map.tileEntities.TileCauldron;
import me.tehbeard.utils.map.tileEntities.TileChest;
import me.tehbeard.utils.map.tileEntities.TileEntity;
import me.tehbeard.utils.map.tileEntities.TileFurnace;
import me.tehbeard.utils.map.tileEntities.TileNoteBlock;
import me.tehbeard.utils.map.tileEntities.TileRecordPlayer;
import me.tehbeard.utils.map.tileEntities.TileSign;
import me.tehbeard.utils.map.tileEntities.TileSpawner;
import me.tehbeard.utils.map.tileEntities.TileTrap;

public class TileEntityFactory {

	private static ConfigurableFactory<TileEntity, DataType> tileEntityFactory;
	
	static{
		tileEntityFactory = new ConfigurableFactory<TileEntity, DataType>(DataType.class) {

			@Override
			public String getTag(DataType annotation) {
				return annotation.value();
			}
		};
		tileEntityFactory.addProduct(TileSign.class);
		tileEntityFactory.addProduct(TileTrap.class);
		tileEntityFactory.addProduct(TileChest.class);
		tileEntityFactory.addProduct(TileFurnace.class);
		tileEntityFactory.addProduct(TileRecordPlayer.class);
		tileEntityFactory.addProduct(TileNoteBlock.class);
		tileEntityFactory.addProduct(TileSpawner.class);
		tileEntityFactory.addProduct(TileCauldron.class);
	}
	
	public static ConfigurableFactory<TileEntity, DataType> getInstance(){
		
		return tileEntityFactory;
	}
}
