package commands;

import java.util.Arrays;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ban implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("ban")) {
			Player player = (Player) sender;
            if(player.hasPermission("basicx.admin")){
            	if(args.length >= 2) {
            		String targetPlayerName = args[0];
                    String reason = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                    
                    BanList banList = Bukkit.getBanList(BanList.Type.NAME);
                    if (banList.isBanned(targetPlayerName)) {
                        player.sendMessage(targetPlayerName + " §7is already banned.");
                    } else {
                        banList.addBan(targetPlayerName, reason, null, sender.getName());
                        Player target = Bukkit.getPlayerExact(targetPlayerName);
                        if (target != null) {
                            target.kickPlayer("§cYou have been banned from the server: " + reason);
                        }
                        player.sendMessage(targetPlayerName + " §7is successfully banned for " + reason + " §7reason.");
                    }
                    return true;
                } else {
                    player.sendMessage("§1Usage: §9/ban §7<player> <reason>");
                }
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
		}
		return false;
}
}