package me.raindropz.mc.hmclobby;

import me.raindropz.mc.hmclobby.listeners.wheatBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Material.WHEAT;

public final class HMCLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        FileConfiguration config = getConfig();
        getServer().getPluginManager().registerEvents(new wheatBreakEvent(this), this);
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("HMCLobby version: " + getConfig().getString("version") + "by Raindropz is now enabled.");
        Bukkit.getConsoleSender().sendMessage("This plugin should not be ran on anything other than a lobby server! It will likely break many game mechanics!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("HMCLobby version: " + getConfig().getString("version") + "by Raindropz is now disabled.");
    }
}
