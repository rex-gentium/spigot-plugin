package com.dicksuckers.meinkraftplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Bukkit.broadcastMessage("Attention: new dicksucker arrived to the server!");
        event.setJoinMessage("Welcome to the dicksuckers club, " + event.getPlayer().getName() + "!");
    }
}
