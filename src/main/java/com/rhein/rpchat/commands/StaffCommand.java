package com.rhein.rpchat.commands;

import com.rhein.rpchat.ChatModeManager;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class StaffCommand implements CommandExecutor {

    private final ChatModeManager manager;

    public StaffCommand(ChatModeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();

        if (!manager.hasStaffAccess(uuid)) {
            player.sendMessage(ChatColor.RED + "You do not have access to Staff Chat.");
            return true;
        }

        manager.enterStaff(uuid);
        manager.exitRP(uuid);
        player.sendMessage(ChatColor.GREEN + "Entered Staff Chat.");
        return true;
    }
}