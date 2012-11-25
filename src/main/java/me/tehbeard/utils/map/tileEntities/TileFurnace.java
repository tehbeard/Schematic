package me.tehbeard.utils.map.tileEntities;

import java.util.Arrays;

import me.tehbeard.utils.map.misc.Item;
import me.tehbeard.utils.map.misc.MapUtils;

import com.tehbeard.mojang.nbt.CompoundTag;
import com.tehbeard.mojang.nbt.ListTag;


@TileEntityType(id="Furnace")
public class TileFurnace extends TileEntity{

	Item[] items = new Item[3];
    short burn,cook;

	public TileFurnace(CompoundTag tag) {
		super(tag);

		items = MapUtils.makeInventory(3,(ListTag<CompoundTag>) tag.getList("Items"));
		
		burn = tag.getShort("BurnTime");
		cook = tag.getShort("CookTime");
	}

	
	

	public Item[] getItems() {
        return items;
    }




    public short getBurn() {
        return burn;
    }




    public short getCook() {
        return cook;
    }




    @Override
	public String toString() {
		return "TileFurance [items=" + Arrays.toString(items) + "]";
	}
	


}
