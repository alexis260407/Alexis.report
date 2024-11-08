package fr.alexis.report.core;


import fr.alexis.report.bungee.MainBungee;
import fr.alexis.report.core.Scoreboard.scoreboard;
import fr.alexis.report.core.commands.base.*;
import fr.alexis.report.core.events.Evenement;
import fr.alexis.report.core.listeners.ButtonListener;
import fr.alexis.report.core.listeners.MenuListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Core{
    private final JavaPlugin plugin;

    public Core(JavaPlugin plugin) {
        this.plugin = plugin;

    }

    public void registerCommands() {
        //Report Command + test
        plugin.getCommand("test").setExecutor(new PlayerCommand());
        plugin.getCommand("report").setExecutor(new Reportcommand());
        //Bouton Command + Listener
        //PlayerListener
        plugin.getCommand("invsee").setExecutor(new invseecommand());
        //Oldreport
        plugin.getCommand("oldreport").setExecutor(new oldreportcommand());
    }
}
