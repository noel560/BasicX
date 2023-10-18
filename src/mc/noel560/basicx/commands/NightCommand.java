package mc.noel560.basicx.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("basicx.admin")) {
            sender.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this!");
            return false;
        }
        Player player = (Player) sender;
        player.sendMessage(ChatColor.DARK_AQUA + "§3Game time is switched to: " + ChatColor.AQUA + "night" + ChatColor.DARK_AQUA + ".");
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        player.getWorld().setTime(18000);
        return false;
    }
}
