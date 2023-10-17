package commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Night implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("night")) {
			Player p = (Player) sender;
            if(p.hasPermission("basicx.admin")){
            	p.sendMessage("§3Game time is switched to: §bnight§3.");
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                p.getWorld().setTime(18000);
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
		}
		return false;
		
	}

}
