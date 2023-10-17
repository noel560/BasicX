package commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("rain")) {
			Player p = (Player) sender;
            if(p.hasPermission("basicx.admin")){
            	p.sendMessage("§3Set the weather: §brain§3.");
            	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            	p.getWorld().setStorm(true);
            	p.getWorld().setThundering(false);
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
            }
		if(label.equalsIgnoreCase("thunder")) {
			Player p = (Player) sender;
            if(p.hasPermission("basicx.admin")){
            	p.sendMessage("§3Set the weather: §brain & thunder§3.");
            	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            	p.getWorld().setStorm(true);
            	p.getWorld().setThundering(true);
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
            }
		if(label.equalsIgnoreCase("wclear")) {
			Player p = (Player) sender;
            if(p.hasPermission("basicx.admin")){
            	p.sendMessage("§3Set the weather: §bclear§3.");
            	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            	p.getWorld().setStorm(false);
            	p.getWorld().setThundering(false);
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
            }
		return false;
		
	}

}
