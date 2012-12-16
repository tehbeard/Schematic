package me.tehbeard.utils.schematic;


import me.tehbeard.utils.map.misc.Enchantment;
import me.tehbeard.utils.map.misc.Item;
import me.tehbeard.utils.map.misc.WorldVector;
import me.tehbeard.utils.map.tileEntities.TileCauldron;
import me.tehbeard.utils.map.tileEntities.TileChest;
import me.tehbeard.utils.map.tileEntities.TileEntity;
import me.tehbeard.utils.map.tileEntities.TileFurnace;
import me.tehbeard.utils.map.tileEntities.TileNoteBlock;
import me.tehbeard.utils.map.tileEntities.TileRecordPlayer;
import me.tehbeard.utils.map.tileEntities.TileSign;
import me.tehbeard.utils.map.tileEntities.TileSpawner;
import me.tehbeard.utils.map.tileEntities.TileTrap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Furnace;
import org.bukkit.block.Jukebox;
import org.bukkit.block.NoteBlock;
import org.bukkit.block.Sign;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BukkitSchematicLoader {

    private Schematic schematic;

    public BukkitSchematicLoader(Schematic schematic){
        this.schematic = schematic;
    }

    public void paste(Location location){

        WorldVector l = new WorldVector(location.getX(),location.getY(),location.getZ(),location.getWorld().getName());
        addBlocks(l,0);
        addBlocks(l,1);
        addBlocks(l,2);

        World w = Bukkit.getWorld(l.getWorldName());
        for(TileEntity t:schematic.getTileEntities()){

            Block b = w.getBlockAt(location.clone().add(
                    schematic.getOffset().getX(),
                    schematic.getOffset().getY(),
                    schematic.getOffset().getZ()
                    ).add(
                            t.getX(),
                            t.getY(), 
                            t.getZ()
                            )
                    );

            if(t instanceof TileChest){
                placeChest(b,(TileChest) t);
            }

            if(t instanceof TileTrap){
                placeDispenser(b,(TileTrap)t);
            }
            if(t instanceof TileSign){
                placeSign(b,(TileSign)t);
            }
            
            if(t instanceof TileNoteBlock){
                placeNoteBlock(b,(TileNoteBlock)t);
            }
            if(t instanceof TileFurnace){
                placeFurnace(b,(TileFurnace)t);
            }
            if(t instanceof TileCauldron){
                placeBrewStand(b,(TileCauldron)t);
            }
            if(t instanceof TileRecordPlayer){
                placeJukebox(b,(TileRecordPlayer)t);
            }
            if(t instanceof TileSpawner){
                placeSpawner(b, (TileSpawner) t);
            }
        }
    }

    

    private void addBlocks(WorldVector l,int layer){
        World w = Bukkit.getWorld(l.getWorldName());
        for(int y = 0;y<schematic.getHeight();y++){
            for(int z = 0;z<schematic.getLength();z++){
                for(int x = 0;x<schematic.getWidth();x++){

                    if(BlockType.getOrder(schematic.getBlockId(x, y, z)) == layer){
                        WorldVector wv = new WorldVector(0, 0, 0, l.getWorldName());
                        wv.addVector(l);
                        wv.addVector(schematic.getOffset());

                        Block b = w.getBlockAt(
                                wv.getBlockX() + x, 
                                wv.getBlockY() + y,
                                wv.getBlockZ() + z
                                );
                        
                        b.setTypeId(schematic.getBlockId(x, y, z) & 0xFF, false);
                        b.setData(schematic.getBlockData(x, y, z),false);


                        w.getBlockAt(
                                wv.getBlockX() + x, 
                                wv.getBlockY() + y,
                                wv.getBlockZ() + z
                                ).getState().update();
                        
                    }

                }	
            }	
        }
    }



    private static void placeChest(Block b,TileChest chest){
        Chest c = (Chest)b.getState();
        Inventory i = c.getBlockInventory();
        doInventory(i, chest.getItems());
        c.update(true);
    }

    private static void placeDispenser(Block b, TileTrap trap) {
        Dispenser c = (Dispenser)b.getState();
        Inventory i = c.getInventory();
        doInventory(i, trap.getItems());
        c.update(true);

    }
    
    private static void placeSign(Block b, TileSign t) {
        Sign s = (Sign) b.getState();
        int i =0;
        for(String l : t.getLines()){
            s.setLine(i,l);
            i++;
        }
        s.update(true);
        
    }
    
    private static void placeNoteBlock(Block b, TileNoteBlock t) {
        NoteBlock s = (NoteBlock) b.getState();
        s.setRawNote(t.getNote());
        s.update(true);
        
    }
    
    private static void placeFurnace(Block b, TileFurnace t) {
        Furnace f = (Furnace) b.getState();

        f.setBurnTime(t.getBurn());
        f.setCookTime(t.getCook());
        doInventory(f.getInventory(), t.getItems());
        f.update(true);
    }
    
    private static void placeBrewStand(Block b, TileCauldron t) {
        BrewingStand bs = (BrewingStand)b.getState();
        bs.setBrewingTime(t.getBrew());
        
        
        doInventory(bs.getInventory(), t.getItems());
        
        bs.update(true);
    }
    
    private static void placeJukebox(Block b, TileRecordPlayer t) {
        Jukebox jb = (Jukebox)b.getState();
        jb.setRawData(t.getRecord());
        jb.update(true);
        
    }

    private static void placeSpawner(Block b,TileSpawner t){
        CreatureSpawner spawner = (CreatureSpawner) b.getState();
        spawner.setCreatureTypeByName(t.getId());
    }
    
    
    private static ItemStack makeItemStack(Item item){
        ItemStack is = new ItemStack(item.getId(),item.getCount(),item.getDamage());
        for(Enchantment e : item.getEnchantments()){
            is.addUnsafeEnchantment(org.bukkit.enchantments.Enchantment.getById(e.getType()), e.getLvl());
        }
        return is;
        
    }
    
    private static void doInventory(Inventory inv, Item[] items){
        for(Item item : items){
            if(item == null){continue;}
            
            inv.setItem(item.getSlot(),makeItemStack(item));
        }
    }
}
