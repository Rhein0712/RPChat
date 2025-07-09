package com.rhein.rpchat.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class RPListener implements Listener {

    private final ChatModeManager manager;

    public RPListener(ChatModeManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player sender = event.getPlayer();

        if (!manager.isInRP(sender.getUniqueId())) return;

        event.setCancelled(true);
        String message = ChatColor.DARK_PURPLE + "[RP] " + ChatColor.YELLOW + sender.getDisplayName() + ": " + event.getMessage();

        for (Player p : sender.getWorld().getPlayers()) {
            if (p.getLocation().distance(sender.getLocation()) <= 15) {
                p.sendMessage(message);
            }
        }
    }
}