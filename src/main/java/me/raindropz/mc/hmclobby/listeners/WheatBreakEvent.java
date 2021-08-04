package me.raindropz.mc.hmclobby.listeners;

import me.raindropz.mc.hmclobby.HMCLobby;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class WheatBreakEvent implements Listener {
    private final HMCLobby plugin;
    public WheatBreakEvent(HMCLobby plugin) { this.plugin = plugin; }
    @EventHandler
    public void wheatBreakEvent(BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.WHEAT && plugin.getConfig().getBoolean("disable-wheat-drops")){
            event.setDropItems(false);
            if(plugin.getConfig().getBoolean("play-wheat-break-sound")){
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.3f, 1.0f);
            }
        }
    }
}
