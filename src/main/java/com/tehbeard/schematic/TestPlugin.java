package com.tehbeard.schematic;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.tehbeard.map.schematic.Schematic;
import com.tehbeard.map.schematic.bukkit.BukkitSchematicLoader;

public class TestPlugin extends JavaPlugin {

    
    @Override
    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        
        Schematic schematic = null;
        try {
            schematic = new Schematic(new File("plugins/WorldEdit/schematics/",args[0] + ".schematic"));
            System.out.println(schematic.toString());
            BukkitSchematicLoader loader = new BukkitSchematicLoader(schematic);
            loader.paste(((Player)sender).getLocation(), Integer.parseInt(args[1]), new byte[] {Byte.parseByte(args[2])});
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        return true;
    }
}
