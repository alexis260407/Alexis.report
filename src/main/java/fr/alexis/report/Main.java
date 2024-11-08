package fr.alexis.report;

import fr.alexis.report.bungee.MainBungee;
import fr.alexis.report.core.Core;
import fr.alexis.report.core.Scoreboard.scoreboard;
import fr.alexis.report.core.commands.base.*;
import fr.alexis.report.core.events.Evenement;
import fr.alexis.report.core.listeners.ButtonListener;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import fr.alexis.report.core.listeners.MenuListener;

public final class Main extends JavaPlugin {

    private Core core;
	private static Main instance;
	public static Main getInstance() {
		return instance;
	}
   // private Core core;

    @Override
    public void onEnable() {
    	instance = this;
        core = new Core(this);
        PluginManager pm = getServer().getPluginManager();
        MainBungee.getInstance().onEnable();
        pm.registerEvents(new MenuListener(), this);
        pm.registerEvents(new Evenement(), this);
        pm.registerEvents(new scoreboard(), this);
        pm.registerEvents(new ButtonListener(this), this);
        //getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        getLogger().info("Plugin Allumé");
    }

    @Override
    public void onDisable() {
    	getLogger().info("Plugin Désactivé");
    }
}

