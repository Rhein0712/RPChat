package com.rhein.rpchat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WhisperCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /whisper <player> <message>");
            return true;
        }

        Player target = sender.getServer().getPlayerExact(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        Player player = (Player) sender;
        String message = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length));

        String formatted = ChatColor.GRAY + "[Whisper] " + player.getName() + ": " + message;

        player.sendMessage(formatted);
        target.sendMessage(formatted);

        return true;
    }
}