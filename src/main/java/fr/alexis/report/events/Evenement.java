package fr.alexis.report.events;

import fr.alexis.report.Scoreboard.ScoreBoard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Evenement implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent event) {        // Récupérer le joueur qui a rejoint
        Player player = event.getPlayer();

        // Envoyer un message de bienvenue au joueur
        player.sendMessage(ChatColor.YELLOW + "Guten Morgen my friends "+  player.getName() + ". (Bienvenue mdrrr)");

        // Envoyer un message de bienvenue à tous les joueurs (null = rien)
        event.setJoinMessage(null);

        ScoreBoard.SetScoreBoard(player);

    }
}
