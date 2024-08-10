package fr.alexis.report.api;

import org.bukkit.plugin.java.JavaPlugin;

public class PlayerAPI extends JavaPlugin {
    public static PlayerAPI INSTANCE;

    @Override
    public void onEnable() {
    INSTANCE = this;
    }

    @Override
    public void onDisable (){

    }
}
