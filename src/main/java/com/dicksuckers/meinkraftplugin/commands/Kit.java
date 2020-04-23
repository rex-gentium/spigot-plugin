package com.dicksuckers.meinkraftplugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kit implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            giveItemsToPlayer(player);
        }
        return true;
    }

    private void giveItemsToPlayer(Player player) {
        ItemStack[] items = createExampleItems();
        player.getInventory().addItem(items);
    }

    private ItemStack[] createExampleItems() {
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack bricks = new ItemStack(Material.BRICK, 20);
        return new ItemStack[] { diamond, bricks };
    }

}
