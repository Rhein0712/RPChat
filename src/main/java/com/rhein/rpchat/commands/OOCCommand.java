package com.rhein.rpchat.commands;

import com.rhein.rpchat.ChatModeManager;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class OOCCommand implements CommandExecutor {
    private final ChatModeManager manager;

    public OOCCommand(ChatModeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        // Disable RP mode (thus enabling OOC mode by default)
        manager.disableRP(player.getUniqueId());
        player.sendMessage(ChatColor.GRAY + "You are now in OOC chat.");
        return true;
    }
}