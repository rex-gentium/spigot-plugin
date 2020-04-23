package com.dicksuckers.meinkraftplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class MyListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Bukkit.broadcastMessage("Attention: new dicksucker arrived to the server!");
        event.setJoinMessage("Welcome to the dicksuckers club, " + event.getPlayer().getName() + "!");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.isCancelled()) {
            return; // movement cancelled
        }
        Location from = event.getFrom();
        Location to = event.getTo();
        if (to == null || from.equals(to)) {
            return; // coordinated did not change
        }
        String playerName = event.getPlayer().getName();
        String message = String.format("Player %s moved from %s to %s",
                playerName, locationToString(from), locationToString(to));
        Bukkit.broadcastMessage(message);
    }

    private String locationToString(Location location) {
        return String.format("(%f, %f, %f)",
                location.getX(),
                location.getY(),
                location.getZ());
    }

}
