package me.raindropz.mc.hmclobby.listeners;

import me.raindropz.mc.hmclobby.HMCLobby;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class wheatBreakEvent implements Listener {

    private final HMCLobby plugin;
    public wheatBreakEvent(HMCLobby plugin) { this.plugin = plugin; }
    @EventHandler
    public void wheatBreakEvent(BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.WHEAT){
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
        }
    }
}
