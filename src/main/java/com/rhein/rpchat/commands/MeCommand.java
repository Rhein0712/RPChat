package com.rhein.rpchat.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class MeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /me <action>");
            return true;
        }

        String action = String.join(" ", args);
        String message = ChatColor.LIGHT_PURPLE + "* " + player.getDisplayName() + " " + action;

        player.getWorld().getPlayers().stream()
                .filter(p -> p.getLocation().distance(player.getLocation()) <= 20)
                .forEach(p -> p.sendMessage(message));

        return true;
    }
}