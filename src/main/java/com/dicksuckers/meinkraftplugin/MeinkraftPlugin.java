package com.dicksuckers.meinkraftplugin;

import com.dicksuckers.meinkraftplugin.commands.Kit;
import com.dicksuckers.meinkraftplugin.commands.Rainbow;
import com.dicksuckers.meinkraftplugin.listeners.MyListener;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class MeinkraftPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        PluginCommand kitCommand = this.getCommand("kit");
        if (kitCommand != null) {
            kitCommand.setExecutor(new Kit());
            getLogger().info("kit command registered");
        }
        PluginCommand rainbowCommand = this.getCommand("rainbow");
        if (rainbowCommand != null) {
            rainbowCommand.setExecutor(new Rainbow());
            getLogger().info("rainbow command registered");
        }
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        getLogger().info("event listener registered");
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}
