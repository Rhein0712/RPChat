package com.rhein.rpchat.commands;

import com.rhein.rpchat.ChatModeManager;
import com.rhein.rpchat.RPChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class StaffRemoveCommand implements CommandExecutor {

    private final ChatModeManager manager;
    private final RPChat plugin;

    public StaffRemoveCommand(ChatModeManager manager, RPChat plugin) {
        this.manager = manager;
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "Only operators can use this.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /staffremove <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        manager.removeStaffAccess(target.getUniqueId());
        manager.disableStaff(target.getUniqueId());
        plugin.saveStaffAccess(); // save to file
        sender.sendMessage(ChatColor.GREEN + "Removed " + target.getName() + " from staff chat.");
        return true;
    }
}