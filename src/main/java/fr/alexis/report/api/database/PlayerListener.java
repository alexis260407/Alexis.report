package fr.alexis.report.api.database;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerListener {
    public void Online (PlayerJoinEvent p){
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Team onlineCounter = board.registerNewTeam("onlineCounter");
        // Note: The ' + "" + ' is there to convert the colors into strings without manually calling ChatColor#toString
        onlineCounter.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);
    }
}
