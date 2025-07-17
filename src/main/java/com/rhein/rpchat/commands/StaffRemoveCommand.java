public class StaffRemoveCommand implements CommandExecutor {

    private final ChatModeManager manager;

    public StaffRemoveCommand(ChatModeManager manager) {
        this.manager = manager;
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
        manager.exitStaff(target.getUniqueId());
        sender.sendMessage(ChatColor.GREEN + "Removed " + target.getName() + " from staff chat.");
        return true;
    }
}