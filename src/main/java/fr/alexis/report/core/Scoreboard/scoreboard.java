package fr.alexis.report.core.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

//Elikill58 (merci) et moi
public class scoreboard implements Listener {
	int online; //créer un online beau

	@EventHandler
	public void onPlayerJoinBoard(PlayerJoinEvent event) {
		// permet de créer un scoreboard en event pour le player.
		createBoard(event.getPlayer());
	}

	public static void createBoard(Player player) {
		//permet de créer le Scoreboard
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		assert manager != null;
		Scoreboard board = manager.getNewScoreboard();
		Objective o = board.registerNewObjective("Test num 1", "dummy");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		addLineToSb(player, board, o);
		player.setScoreboard(board);
	}

	public static void addLineToSb(Player p, Scoreboard board, Objective obj) {
		Team myData = board.registerNewTeam("myData");
		Team online = board.registerNewTeam("online");
		online.addEntry("t");
		if (Bukkit.getOnlinePlayers().size() == 0) {
			online.setPrefix(ChatColor.DARK_RED + "0" + ChatColor.RED + "/" + Bukkit.getMaxPlayers());
		} else {
			online.setPrefix("§fJoueurs " + ChatColor.GREEN + Bukkit.getOnlinePlayers().size());
		}
		//obj.getScore + .setScore permet d'ajouter une ligne au scoreboard avec le chiffre attribué
		obj.getScore("§cServeur.fr").setScore(1);
		obj.getScore("   ").setScore(2);
		obj.getScore("En jeu" + ChatColor.RED).setScore(3);
		obj.getScore("Joueur " + ChatColor.GREEN + Bukkit.getOnlinePlayers().size() + "§7/§f" + Bukkit.getMaxPlayers() ).setScore(4);
		obj.getScore("AFK").setScore(5);
		obj.getScore("  ").setScore(6);
		obj.getScore("➜ Pièce :").setScore(7);
		obj.getScore("➜ Grade").setScore(8);
		obj.getScore("➜ Pseudo:").setScore(9);
		obj.getScore("§c").setScore(10);
	}

	public static void update(Player p) { // Permet d'actualiser le scoreboard (actuellement pas encore utilisé)
		Scoreboard board = p.getScoreboard();
		board.getTeam("myData").setPrefix(ChatColor.RED + "Test 2");
	}
}
