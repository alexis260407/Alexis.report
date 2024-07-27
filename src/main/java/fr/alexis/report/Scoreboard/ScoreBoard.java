package fr.alexis.report.Scoreboard;


import com.avaje.ebean.validation.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class ScoreBoard {
    @EventHandler
    public void onPlayerJoinBoard(@NotNull PlayerJoinEvent event) {
        //permet de créer un scoreboard en event pour le player.
        createBoard(event.getPlayer());
    }

    public void createBoard(@NotNull Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        assert manager != null;
        Scoreboard board = manager.getNewScoreboard();
        //permet de créer les lignes ?
        Objective o = board.registerNewObjective("scores", "dummy", ChatColor.GREEN + "§1Test");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        player.setScoreboard(board);
    }
    public void addLineToSb(Player p) {
        Scoreboard board = p.getScoreboard();
        Team myData = board.registerNewTeam("myData");
        myData.setPrefix(ChatColor.RED + "Mon incroyable data ?");
        Objective.getScore(ChatColor.BLUE + "").setScore(14);
    }
    public void update(Player p) { //Permet d'actualiser le scoreboard
        Scoreboard board = p.getScoreboard();
        board.getTeam("myData").setPrefix(ChatColor.RED + "Mon incroyable data (2) ?");
    }
}
