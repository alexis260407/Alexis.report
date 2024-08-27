package fr.alexis.report.bungee;

import fr.alexis.report.Main;
import fr.alexis.report.bungee.commands.flycommand;
import fr.alexis.report.bungee.commands.helpcommand;

import org.bukkit.plugin.PluginBase;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public class MainBungee {


    private static MainBungee instance;
    public static MainBungee getInstance() {
        if (instance == null) {
            instance = new MainBungee();
        }
        return instance;
    }
  public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        Main.getInstance().getCommand("help").setExecutor(new helpcommand());
      Main.getInstance().getCommand("fly").setExecutor(new flycommand());

        getLogger().info("Plugin bungee ON");
    }

    public void onDisable() {
        getLogger().info("Plugin bungee OFF");
    }

}