package me.tehbeard.utils.schematic.bukkit;


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
import me.tehbeard.utils.schematic.BlockType;
import me.tehbeard.utils.schematic.Schematic;
import me.tehbeard.utils.schematic.bukkit.worldedit.BlockData;

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

    public void paste(Location location,int rotations){
        
        WorldVector l = new WorldVector(location.getX(),location.getY(),location.getZ(),location.getWorld().getName());
        addBlocks(l,0,rotations);
        addBlocks(l,1,rotations);
        addBlocks(l,2,rotations);

        World w = Bukkit.getWorld(l.getWorldName());
        for(TileEntity t:schematic.getTileEntities()){

            WorldVector relVector = new WorldVector(schematic.getOffset());
            relVector.addVector(new WorldVector(t.getX(), t.getY(),t.getZ(), null));
            getRotatedPosition(relVector, rotations);
            
            Block b = w.getBlockAt(location.clone().add(
                    relVector.getX(),
                    relVector.getY(),
                    relVector.getZ()
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



    private void addBlocks(WorldVector l,int layer,int rotations){
        World w = Bukkit.getWorld(l.getWorldName());

        WorldVector baseVector = new WorldVector(0, 0, 0, l.getWorldName());
        baseVector.addVector(l);
        for(int y = 0;y<schematic.getHeight();y++){
            for(int z = 0;z<schematic.getLength();z++){
                for(int x = 0;x<schematic.getWidth();x++){

                    if(BlockType.getOrder(schematic.getBlockId(x, y, z)) == layer){

                        WorldVector relVector = new WorldVector(schematic.getOffset());
                        relVector.addVector(new WorldVector(x, y, z, null));
                        getRotatedPosition(relVector, rotations);
                        relVector.addVector(baseVector);
                        Block b = w.getBlockAt(
                                relVector.getBlockX(), 
                                relVector.getBlockY(),
                                relVector.getBlockZ()
                                );

                        int type = schematic.getBlockId(x, y, z) & 0xFF;
                        b.setTypeId(type, false);

                        byte data = schematic.getBlockData(x, y, z);
                        for(int i =0;i<rotations;i++){
                            data = (byte) BlockData.rotate90(type, data);
                        }
                        b.setData(data,false);


                        w.getBlockAt(
                                relVector.getBlockX(), 
                                relVector.getBlockY(),
                                relVector.getBlockZ()
                                ).getState().update();

                    }

                }	
            }	
        }
    }


    public static void main(String[] args){
        for(int i =0; i > -10; i--){
            System.out.println("" + i + " : " + (i % 4)); 
        }
    }

    private void getRotatedPosition(WorldVector vector,int direction){


        int d[] = new int[4];
        d[0] = vector.getBlockZ();
        d[1] = vector.getBlockX();
        d[2] = -vector.getBlockZ();
        d[3] = -vector.getBlockX();
        vector.setX(d[(direction+1)%4]);
        vector.setZ(d[(direction)%4]);

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
