package fr.alexis.report;

import fr.alexis.report.Scoreboard.ScoreBoard;
import fr.alexis.report.commands.*;
import fr.alexis.report.events.Evenement;
import fr.alexis.report.listeners.ButtonListener;
import fr.alexis.report.commands.SetButtonCommand;
import fr.alexis.report.listeners.PlayerListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import fr.alexis.report.listeners.MenuListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        //Report Command + Listener
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getCommand("report").setExecutor(new Reportcommand());
        //Bouton Command + Listener
        getServer().getPluginManager().registerEvents(new ButtonListener(this), this);
        getCommand("setbutton").setExecutor(new SetButtonCommand(this));
        //PlayerListener
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new Evenement(), this);

        System.out.println("Plugin Allumé");
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin Désactivé");
    }

}

