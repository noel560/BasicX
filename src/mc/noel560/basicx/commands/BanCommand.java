package mc.noel560.basicx.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class BanCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("basicx.admin")) {
            sender.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this!");
            return false;
        }

        if (args.length >= 2) {
            String targetPlayerName = args[0];
            String reason = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

            BanList banList = Bukkit.getBanList(BanList.Type.NAME);
            if (banList.isBanned(targetPlayerName)) {
                sender.sendMessage(ChatColor.GRAY + targetPlayerName + " is already banned.");
                return false;
            }
            banList.addBan(targetPlayerName, reason, null, sender.getName());
            Player target = Bukkit.getPlayerExact(targetPlayerName);

            sender.sendMessage(ChatColor.GRAY + targetPlayerName + " is successfully banned for ''" + reason + "'' reason.");

            if (target != null) {
                target.kickPlayer(ChatColor.RED + "You have been banned from the server: " + reason);
                return false;
            }
            return false;
        }
        sender.sendMessage(ChatColor.DARK_BLUE + "Usage: " + ChatColor.BLUE + "/ban" + ChatColor.GRAY + " <player> <reason>");
        return false;
    }
}