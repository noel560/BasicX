package mc.noel560.basicx.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("basicx.admin")) {
            sender.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this!");
            return false;
        }
        Player player = (Player) sender;

        if (label.equalsIgnoreCase("rain")) {
            this.changeWeather(player, true, false, "brain");
            return false;
        } else if (label.equalsIgnoreCase("thunder")) {
            this.changeWeather(player, true, true, "brain & thunder");
            return false;
        } else if (label.equalsIgnoreCase("wclear")) {
            this.changeWeather(player, false, false, "clear");
            return false;
        }
        return false;
    }

    private void changeWeather(Player player, boolean storm, boolean thunder, String messageValue) {
        player.sendMessage(ChatColor.DARK_AQUA + "Set the weather: " + ChatColor.AQUA + messageValue + ChatColor.DARK_AQUA + ".");
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        player.getWorld().setStorm(storm);
        player.getWorld().setThundering(thunder);
    }
}
