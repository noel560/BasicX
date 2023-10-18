package mc.noel560.basicx.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnbanCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("basicx.admin")) {
            sender.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this!");
            return false;
        }
        if (args.length == 1) {
            String targetPlayerName = args[0];
            BanList banList = Bukkit.getBanList(BanList.Type.NAME);

            if (banList.isBanned(targetPlayerName)) {
                banList.pardon(targetPlayerName);
                sender.sendMessage(ChatColor.GRAY + targetPlayerName + " is unbanned.");
                return false;
            }
            sender.sendMessage(ChatColor.GRAY + targetPlayerName + " is not banned.");
            return false;
        }
        sender.sendMessage(ChatColor.DARK_BLUE + "Usage: " + ChatColor.BLUE + "/unban " + ChatColor.GRAY + "<player>");
        return false;
    }
}
