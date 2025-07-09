package com.rhein.rpchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        String action = String.join(" ", args);
        String message = ChatColor.LIGHT_PURPLE + "* " + player.getName() + " " + action;

        // Broadcast to all players for now (we'll do local chat next)
        Bukkit.getServer().broadcastMessage(message);

        return true;
    }
}