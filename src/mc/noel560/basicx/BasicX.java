package mc.noel560.basicx;

import mc.noel560.basicx.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicX extends JavaPlugin {

    public void onEnable() {
        getServer().getConsoleSender().sendMessage("§aBasicX 1.0 has loaded in!");

        //-- World commands --//
        getCommand("day").setExecutor(new DayCommand()); //kész ha minden igaz
        getCommand("night").setExecutor(new NightCommand()); //kész ha minden igaz
        getCommand("rain").setExecutor(new WeatherCommand()); //kész
        getCommand("wclear").setExecutor(new WeatherCommand()); //kész
        getCommand("thunder").setExecutor(new WeatherCommand()); //kész

        //-- Player commands --//
        getCommand("gmc").setExecutor(new GamemodeCommand()); //kész
        getCommand("gms").setExecutor(new GamemodeCommand()); //kész
        getCommand("gma").setExecutor(new GamemodeCommand()); //kész
        getCommand("gmsp").setExecutor(new GamemodeCommand()); //kész
        getCommand("gm").setExecutor(new GamemodeCommand()); //kész

        //-- Punishment commands --//
        getCommand("ban").setExecutor(new BanCommand()); //kész
        getCommand("unban").setExecutor(new UnbanCommand()); //kész

        //-- Basic commands --//
        getCommand("help").setExecutor(new HelpCommand()); //nincs kész
    }
}
