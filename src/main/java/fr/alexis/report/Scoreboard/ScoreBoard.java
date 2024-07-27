package fr.alexis.report.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreBoard {
	@EventHandler
	public void onPlayerJoinBoard(PlayerJoinEvent event) {
		// permet de créer un scoreboard en event pour le player.
		createBoard(event.getPlayer());
	}

	public static void createBoard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		assert manager != null;
		Scoreboard board = manager.getNewScoreboard();
		Objective o = board.registerNewObjective("scores", "dummy");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		addLineToSb(player, board, o);
		player.setScoreboard(board);
	}

	public static void addLineToSb(Player p, Scoreboard board, Objective obj) {
		Team myData = board.registerNewTeam("myData");
		myData.setPrefix(ChatColor.RED + "Mon incroyable data ?");
		obj.getScore(ChatColor.BLUE + "").setScore(14);
	}

	public static void update(Player p) { // Permet d'actualiser le scoreboard
		Scoreboard board = p.getScoreboard();
		board.getTeam("myData").setPrefix(ChatColor.RED + "Mon incroyable data (2) ?");
	}
}
