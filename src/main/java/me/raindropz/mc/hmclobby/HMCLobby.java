package me.raindropz.mc.hmclobby;

import me.raindropz.mc.hmclobby.listeners.FirstJoinEvent;
import me.raindropz.mc.hmclobby.listeners.WheatBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HMCLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new WheatBreakEvent(this), this);
        getServer().getPluginManager().registerEvents(new FirstJoinEvent(this), this);
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("HMCLobby version: " + getConfig().getString("version") + "by Raindropz is now enabled.");
        Bukkit.getConsoleSender().sendMessage("This plugin should not be ran on anything other than a lobby server! It will likely break many game mechanics!");

    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("HMCLobby version: " + getConfig().getString("version") + " by Raindropz is now disabled.");
    }
}
