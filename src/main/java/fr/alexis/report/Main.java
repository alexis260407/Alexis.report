package fr.alexis.report;

import fr.alexis.report.commands.*;
import fr.alexis.report.listeners.ButtonListener;
import fr.alexis.report.commands.SetButtonCommand;
import org.bukkit.plugin.java.JavaPlugin;
import fr.alexis.report.listeners.MenuListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getCommand("report").setExecutor(new Reportcommand());
        getServer().getPluginManager().registerEvents(new ButtonListener(this), this);
        getCommand("setbutton").setExecutor(new SetButtonCommand(this));
        System.out.println("Plugin Allumé");
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin Désactivé");
    }
}