package fr.alexis.report;

import fr.alexis.report.bungee.MainBungee;
import fr.alexis.report.core.Scoreboard.scoreboard;
import fr.alexis.report.core.commands.*;
import fr.alexis.report.core.events.Evenement;
import fr.alexis.report.core.listeners.ButtonListener;
import fr.alexis.report.core.commands.SetButtonCommand;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import fr.alexis.report.core.listeners.MenuListener;

public final class Main extends JavaPlugin {

	private static Main instance;
	public static Main getInstance() {
		return instance;
	}
	
    @Override
    public void onEnable() {
    	instance = this;

    	PluginManager pm = getServer().getPluginManager();
        //Report Command + Listener
    	pm.registerEvents(new MenuListener(), this);
        getCommand("report").setExecutor(new Reportcommand());
        //Bouton Command + Listener
        pm.registerEvents(new ButtonListener(this), this);
        getCommand("setbutton").setExecutor(new SetButtonCommand(this));
        //PlayerListener
        //getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        pm.registerEvents(new Evenement(), this);
        pm.registerEvents(new scoreboard(), this);
        //Oldreport
        getCommand("oldreport").setExecutor(new oldreportcommand());
        //bungee


        MainBungee.getInstance().onEnable();

        getLogger().info("Plugin Allumé");
    }

    @Override
    public void onDisable() {
    	getLogger().info("Plugin Désactivé");
    }
}

