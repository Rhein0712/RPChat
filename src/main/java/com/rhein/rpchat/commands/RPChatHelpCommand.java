package com.rhein.rpchat.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RPChatHelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(ChatColor.GOLD + "----- RPChat Help -----");
        sender.sendMessage(ChatColor.GREEN + "/rp" + ChatColor.GRAY + " - Toggle RP chat mode, which sends messages IRP (within a 20-block radius)");
        sender.sendMessage(ChatColor.GREEN + "/ooc" + ChatColor.GRAY + " - Switch to global OOC chat");
        sender.sendMessage(ChatColor.GREEN + "/whisper <msg>" + ChatColor.GRAY + " - Whisper to nearby players (within a 5-block radius)");
        sender.sendMessage(ChatColor.GREEN + "/yell <msg>" + ChatColor.GRAY + " - Yell to farther players IRP (within a 50-block radius)");
        sender.sendMessage(ChatColor.GREEN + "/looc <msg>" + ChatColor.GRAY + " - Local OOC message (within a 20-block radius)");
        sender.sendMessage(ChatColor.GREEN + "/me <emote>" + ChatColor.GRAY + " - Send an emote/action (within a 20-block radius)");
        sender.sendMessage(ChatColor.GREEN + "/staff" + ChatColor.GRAY + " - Toggle staff chat mode (requires access)");
        sender.sendMessage(ChatColor.GREEN + "/staffadd <player>" + ChatColor.GRAY + " - Give staff access " + ChatColor.RED + "(OP only)");
        sender.sendMessage(ChatColor.GREEN + "/staffremove <player>" + ChatColor.GRAY + " - Remove staff access " + ChatColor.RED + "(OP only)");
        sender.sendMessage(ChatColor.GREEN + "/stafflist" + ChatColor.GRAY + " - View staff access list " + ChatColor.RED + "(OP only)");
        sender.sendMessage(ChatColor.GREEN + "/rpchathelp" + ChatColor.GRAY + " - Show this help message");

        return true;
    }
}