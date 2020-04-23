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
        if (to == null) {
            return; // no destination
        }
        if (areEqualBlockPositions(from, to)) {
            return; // coordinates did not change
        }
        String playerName = event.getPlayer().getName();
        String message = String.format("Player %s moved to %s",
                playerName, locationToString(to));
        Bukkit.broadcastMessage(message);
    }

    private boolean areEqualBlockPositions(Location left, Location right) {
        return left.getBlockX() == right.getBlockX()
                && left.getBlockY() == right.getBlockY()
                && left.getBlockZ() == right.getBlockZ();
    }

    private String locationToString(Location location) {
        return String.format("(%d, %d, %d)",
                location.getBlockX(),
                location.getBlockY(),
                location.getBlockZ());
    }

}
