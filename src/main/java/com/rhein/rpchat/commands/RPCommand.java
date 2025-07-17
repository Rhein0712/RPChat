package com.rhein.rpchat.commands;

import com.rhein.rpchat.ChatModeManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RPCommand implements CommandExecutor {
    private final ChatModeManager manager;

    public RPCommand(ChatModeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (manager.isInRP(player.getUniqueId())) {
            manager.disableRP(player.getUniqueId());
            player.sendMessage(ChatColor.GRAY + "RP mode disabled.");
        } else {
            manager.enableRP(player.getUniqueId());
            player.sendMessage(ChatColor.GREEN + "RP mode enabled.");
        }
        return true;
    }
}