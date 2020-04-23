package com.dicksuckers.meinkraftplugin.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.World;

import java.lang.reflect.Array;

public class Rainbow implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location playerLocation = player.getLocation();
            Location targetLocation = new Location(player.getWorld(), playerLocation.getX(), playerLocation.getY() + 5.0, playerLocation.getZ());
            if (args.length > 2 )
            {
                int height = Integer.parseInt(args[0]);
                int huy = Integer.parseInt(args[1]);
                int form = Integer.parseInt(args[2]);
                drawRainbow(targetLocation, height, huy, form);
            }
            else{
                drawRainbow(targetLocation, 60,128,64);
            }
        }
        return true;
    }

    private void drawRainbow(Location fromLocation, int height, int length, int form) {

        Material[] colors = {Material.RED_WOOL, Material.ORANGE_WOOL, Material.YELLOW_WOOL, Material.GREEN_WOOL,Material.BLUE_WOOL,Material.MAGENTA_WOOL  };
        for (int x = 0; x < length; x = x +1){
            for (int i = 0; i < colors.length; i++) {
                int y = (int) Math.round (Math.sin(( x/(float)length )* Math.PI)* height + i);
                Location targetLocation = new Location(fromLocation.getWorld(), fromLocation.getX()+ x - form, fromLocation.getY()+y , fromLocation.getZ());
                targetLocation.getBlock().setType(colors[colors.length - i - 1]);
            }

        }
/*colors = [14, 1, 4, 5, 3, 11, 10]

mc = minecraft.Minecraft.create()
height = 60

mc.setBlocks(-64,0,0,64,height + len(colors),0,0)
for x in range(0, 128):
        for colourindex in range(0, len(colors)):
                y = sin((x / 128.0) * pi) * height + colourindex
                mc.setBlock(x - 64, y, 0, block.WOOL.id, colors[len(colors) - 1 - colourindex])*/
        
    }

}
