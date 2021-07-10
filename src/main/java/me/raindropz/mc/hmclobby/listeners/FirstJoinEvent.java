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

    public void onWheatBreak(PlayerJoinEvent event) {

        Player p = event.getPlayer();
        String firstJoinMOTD = plugin.getConfig().getString("first-join-motd");
        firstJoinMOTD = PlaceholderAPI.setPlaceholders(event.getPlayer(), firstJoinMOTD);

        String joinMOTD = plugin.getConfig().getString("join-motd");
        joinMOTD = PlaceholderAPI.setPlaceholders(event.getPlayer(), joinMOTD);

        if(!p.hasPlayedBefore()) {
            p.sendMessage(firstJoinMOTD);
        }
        if(p.hasPlayedBefore()) {
            p.sendMessage(joinMOTD);
        }
    }
}