package com.rhein.rpchat.commands;

import com.rhein.rpchat.listeners.ChatModeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class YellCommand implements CommandExecutor {
    private final ChatModeManager manager;

    public YellCommand(ChatModeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || args.length == 0) return false;
        Player player = (Player) sender;
        String msg = String.join(" ", args).toUpperCase();
        String message = ChatColor.DARK_PURPLE + "[RP] " + ChatColor.RESET + player.getDisplayName() + ChatColor.RED + " yells: " + msg;

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getWorld().equals(player.getWorld()) && p.getLocation().distance(player.getLocation()) <= 50) {
                p.sendMessage(message);
            }
        }
        return true;
    }
}