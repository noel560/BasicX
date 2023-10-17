package commands;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("gmc")) {
			Player p = (Player) sender;
            if(p.hasPermission("basicx.admin")){
            	p.sendMessage(p.getDisplayName() + "§3 game mode switched to this: §bcreative§3.");
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                p.setGameMode(GameMode.CREATIVE);
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
		}
		if(label.equalsIgnoreCase("gms")) {
			Player p = (Player) sender;
            if(p.hasPermission("basicx.admin")){
            	p.sendMessage(p.getDisplayName() + "§3 game mode switched to this: §bsurvival§3.");
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                p.setGameMode(GameMode.SURVIVAL);
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
		}
		if(label.equalsIgnoreCase("gma")) {
			Player p = (Player) sender;
            if(p.hasPermission("basicx.admin")){
            	p.sendMessage(p.getDisplayName() + "§3 game mode switched to this: §badventure§3.");
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                p.setGameMode(GameMode.ADVENTURE);
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
		}
		if(label.equalsIgnoreCase("gmsp")) {
			Player p = (Player) sender;
            if(p.hasPermission("basicx.admin")){
            	p.sendMessage(p.getDisplayName() + "§3 game mode switched to this: §bspectator§3.");
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                p.setGameMode(GameMode.SPECTATOR);
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
		}
		if(label.equalsIgnoreCase("gm")){
            Player p = (Player) sender;
            if(p.hasPermission("basicx.admin")){
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")){

                        p.sendMessage(p.getDisplayName() + "§3 game mode switched to this: §bsurvival§3.");
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.setGameMode(GameMode.SURVIVAL);
                    }else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")){

                        p.sendMessage(p.getDisplayName() + "§3 game mode switched to this: §bcreative§3.");
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.setGameMode(GameMode.CREATIVE);
                    }else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")){

                        p.sendMessage(p.getDisplayName() + "§3 game mode switched to this: §badventure§3.");
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.setGameMode(GameMode.ADVENTURE);
                    }else if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp")) {

                        p.sendMessage(p.getDisplayName() + "§3 game mode switched to this: §bspectator§3.");
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.setGameMode(GameMode.SPECTATOR);
                    }
                }else {
                    p.sendMessage("§l§b------------------§r\n§1Gamemodes: \n§9/gm §7[0/s/survival]\n§9/gm §7[1/c/creative]\n§9/gm §7[2/a/adventure]\n§9/gm §7[3/sp/spectator]\n§l§b------------------");
                }
            }else {
            	sender.sendMessage("§4You don't have permission to use this!");
            }
        }
		return false;
	}

}
