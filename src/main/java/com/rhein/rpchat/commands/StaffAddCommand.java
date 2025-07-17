package com.rhein.rpchat.commands;

import com.rhein.rpchat.ChatModeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class StaffAddCommand implements CommandExecutor {

    private final ChatModeManager manager;

    public StaffAddCommand(ChatModeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "Only operators can use this.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /staffadd <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        manager.addStaffAccess(target.getUniqueId());
        sender.sendMessage(ChatColor.GREEN + "Added " + target.getName() + " to staff chat.");
        return true;
    }
}