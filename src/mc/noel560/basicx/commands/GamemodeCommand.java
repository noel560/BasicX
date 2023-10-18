package mc.noel560.basicx.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("basicx.admin")) {
            sender.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this!");
            return false;
        }
        Player player = (Player) sender;

        if (label.equalsIgnoreCase("gmc")) {
            this.changeGamemode(player, GameMode.CREATIVE);
            return false;
        } else if (label.equalsIgnoreCase("gms")) {
            this.changeGamemode(player, GameMode.SURVIVAL);
            return false;
        } else if (label.equalsIgnoreCase("gma")) {
            this.changeGamemode(player, GameMode.ADVENTURE);
            return false;
        } else if (label.equalsIgnoreCase("gmsp")) {
            this.changeGamemode(player, GameMode.SPECTATOR);
            return false;
        } else if (label.equalsIgnoreCase("gm") && args.length == 1) {
            switch (args[0]) {
                case "0", "survival", "s":
                    this.changeGamemode(player, GameMode.SURVIVAL);
                    break;
                case "1", "creative", "c":
                    this.changeGamemode(player, GameMode.CREATIVE);
                    break;
                case "2", "adventure", "a":
                    this.changeGamemode(player, GameMode.ADVENTURE);
                    break;
                case "3", "spectator", "sp":
                    this.changeGamemode(player, GameMode.SPECTATOR);
                    break;
                case null, default:
                    this.changeGamemode(player, null);
                    break;
            }
            return false;
        } else {
            this.changeGamemode(player, null);
            return false;
        }
    }

    private void changeGamemode(Player player, GameMode gameMode) {
        if (gameMode == null) {
            player.sendMessage("§l§b------------------§r\n§1Gamemodes: \n§9/gm §7[0/s/survival]\n§9/gm §7[1/c/creative]\n§9/gm §7[2/a/adventure]\n§9/gm §7[3/sp/spectator]\n§l§b------------------");
            return;
        }
        player.sendMessage(ChatColor.DARK_AQUA + player.getDisplayName() + " game mode switched to this: " + ChatColor.AQUA + gameMode.name().toLowerCase() + ChatColor.DARK_AQUA + ".");
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        player.setGameMode(gameMode);
    }

}
