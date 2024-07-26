package fr.alexis.report.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoard {
    public static void SetScoreBoard(Player player){
        //aucune idée a quoi sert ?
        ScoreboardManager manager = Bukkit.getScoreboardManager();

        org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
        //objective = l'objectif ?
        Objective obj = board.registerNewObjective("test", "dummy");
        //tout en haut
        obj.setDisplayName("§cBienvenue !");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score1 = obj.getScore("Test");
        score1.setScore(0);

        Score score2 =obj.getScore("Test d'un grand");
        score2.setScore(1);

        player.setScoreboard(board);

    }
}
