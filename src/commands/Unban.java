package commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Unban implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("basicx.admin")){
		if (args.length == 1) {
            String targetPlayerName = args[0];
            BanList banList = Bukkit.getBanList(BanList.Type.NAME);

            if (banList.isBanned(targetPlayerName)) {
                banList.pardon(targetPlayerName); // Kitiltás feloldása
                sender.sendMessage(targetPlayerName + " §7is unbanned.");
            } else {
                sender.sendMessage(targetPlayerName + " §7is not banned.");
            }
            return true;
        } else {
            sender.sendMessage("§1Usage: §9/unban §7<player>");
        }
		}else {
        	sender.sendMessage("§4You don't have permission to use this!");
        }
		return false;
		
	}

}
