package me.raindropz.mc.hmclobby.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.raindropz.mc.hmclobby.HMCLobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinEvent implements Listener {
    private final HMCLobby plugin;
    public FirstJoinEvent(HMCLobby plugin) { this.plugin = plugin; }
    @EventHandler
    public void MOTDManager(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (p.hasPlayedBefore()) {
            String joinMOTD = plugin.getConfig().getString("join-motd");
            joinMOTD = PlaceholderAPI.setPlaceholders(event.getPlayer(), joinMOTD);
            p.sendMessage(joinMOTD);
        } else {
            String firstJoinMOTD = plugin.getConfig().getString("first-join-motd");
            firstJoinMOTD = PlaceholderAPI.setPlaceholders(event.getPlayer(), firstJoinMOTD);
            p.sendMessage(firstJoinMOTD);
        }
    }
}