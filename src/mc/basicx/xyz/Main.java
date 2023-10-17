package mc.basicx.xyz;

import org.bukkit.plugin.java.JavaPlugin;

import commands.Ban;
import commands.Day;
import commands.Gamemode;
import commands.Help;
import commands.Night;
import commands.Unban;
import commands.Weather;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§aBasicX 1.0 has loaded in!");
		getCommand("day").setExecutor(new Day()); //kész ha minden igaz
		getCommand("night").setExecutor(new Night()); //kész ha minden igaz
		getCommand("help").setExecutor(new Help()); //nincs kész
		getCommand("gmc").setExecutor(new Gamemode()); //kész
		getCommand("gms").setExecutor(new Gamemode()); //kész
		getCommand("gma").setExecutor(new Gamemode()); //kész
		getCommand("gmsp").setExecutor(new Gamemode()); //kész
		getCommand("gm").setExecutor(new Gamemode()); //kész
		getCommand("ban").setExecutor(new Ban()); //kész
		getCommand("unban").setExecutor(new Unban()); //kész
		getCommand("rain").setExecutor(new Weather()); //kész
		getCommand("wclear").setExecutor(new Weather()); //kész
		getCommand("thunder").setExecutor(new Weather()); //kész
	}

}