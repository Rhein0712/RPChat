package com.rhein.rpchat.listeners;

import com.rhein.rpchat.ChatModeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffListener implements Listener {

    private final ChatModeManager manager;

    public StaffListener(ChatModeManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (manager.isInStaff(player.getUniqueId())) {
            event.setCancelled(true);
            String formatted = ChatColor.GREEN + "[Staff] " + ChatColor.WHITE + player.getDisplayName() + ": " + event.getMessage();

            for (Player p : Bukkit.getOnlinePlayers()) {
                if (manager.hasStaffAccess(p.getUniqueId())) {
                    p.sendMessage(formatted);
                }
            }
        }
    }
}