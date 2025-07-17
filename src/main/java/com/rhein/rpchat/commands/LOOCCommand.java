package com.rhein.rpchat.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class LOOCCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /looc <message>");
            return true;
        }

        String msg = String.join(" ", args);
        for (Player p : player.getWorld().getPlayers()) {
            if (p.getLocation().distance(player.getLocation()) <= 20) {
                p.sendMessage(ChatColor.GRAY + "[LOOC] " + player.getDisplayName() + ": " + msg);
            }
        }
        return true;
    }
}