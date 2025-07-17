package com.rhein.rpchat.listeners;

import com.rhein.rpchat.ChatModeManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OOCListener implements Listener {

    private final ChatModeManager manager;

    public OOCListener(ChatModeManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player sender = event.getPlayer();

        if (manager.isInRP(sender.getUniqueId())) return; // RP chat handles those

        event.setFormat(ChatColor.GRAY + "[OOC] " + ChatColor.WHITE + sender.getDisplayName() + ": " + event.getMessage());
    }
}