package fr.alexis.report.bungee;

import fr.alexis.report.Main;
import fr.alexis.report.bungee.commands.admin.flycommand;
import fr.alexis.report.bungee.commands.base.commandmsg;
import fr.alexis.report.bungee.commands.base.helpcommand;

import fr.alexis.report.bungee.commands.base.inutilecommand;
import org.bukkit.plugin.PluginManager;

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
        Main.getInstance().getCommand("inutile").setExecutor(new inutilecommand());
        Main.getInstance().getCommand("msg").setExecutor(new commandmsg());

        getLogger().info("Plugin bungee ON");
    }

    public void onDisable() {
        getLogger().info("Plugin bungee OFF");
    }

}