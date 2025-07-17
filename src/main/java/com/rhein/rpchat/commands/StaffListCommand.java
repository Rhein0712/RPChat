package com.rhein.rpchat.commands;

import com.rhein.rpchat.ChatModeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.*;

import java.util.UUID;
import java.util.Set;

public class StaffListCommand implements CommandExecutor {

    private final ChatModeManager manager;

    public StaffListCommand(ChatModeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "Only operators can use this command.");
            return true;
        }

        Set<UUID> staffUUIDs = manager.getStaffAccessUUIDs();

        if (staffUUIDs.isEmpty()) {
            sender.sendMessage(ChatColor.YELLOW + "No players have staff chat access.");
            return true;
        }

        sender.sendMessage(ChatColor.GOLD + "Staff Chat Access List:");
        for (UUID uuid : staffUUIDs) {
            OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
            String name = player.getName() != null ? player.getName() : uuid.toString();
            sender.sendMessage(ChatColor.GRAY + "- " + name);
        }

        return true;
    }
}