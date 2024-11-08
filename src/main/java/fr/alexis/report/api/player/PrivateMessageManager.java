package fr.alexis.report.api.player;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PrivateMessageManager {
    private static HashMap<Player, Player> lastMessageMap = new HashMap<>();

    // Initialise la gestion
    public static void init() {
        lastMessageMap = new HashMap<>();
    }

    // Définit le dernier joueur à qui un message a été envoyé
    public static void setLastMessagedPlayer(Player sender, Player target2) {
        lastMessageMap.put(sender, target2);
    }

    // Récupère le dernier joueur à qui un message a été envoyé
    public static Player getLastMessagedPlayer(Player player) {
        return lastMessageMap.get(player);
    }
}