package com.rhein.rpchat.commands;

import java.util.UUID;
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

        if (manager.isInStaff(uuid)) {
            manager.disableStaff(uuid);
            player.sendMessage(ChatColor.GRAY + "Staff Chat disabled.");
        } else {
            manager.enableStaff(uuid);
            manager.disableRP(uuid); // exit RP if active
            player.sendMessage(ChatColor.GREEN + "Staff Chat enabled.");
        }

        return true;
    }
}