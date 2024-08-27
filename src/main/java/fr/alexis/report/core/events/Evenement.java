package fr.alexis.report.core.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class Evenement implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent event) {
        // Récupérer le joueur qui a rejoint
        Player player = event.getPlayer();

        // Envoyer un message de bienvenue au joueur
        player.sendMessage(ChatColor.YELLOW + "Guten Morgen my friends "+  player.getName());

        // Envoyer un message de bienvenue à tous les joueurs (null = rien)
        event.setJoinMessage(null);

        player.getInventory().setItem(0, new ItemStack(Material.COMPASS));

    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Test "+ player.getName());

        event.setQuitMessage(ChatColor.YELLOW + player.getName()+" a quitté la partie");
    }

 /*   @EventHandler
    public void onPlayerKick(PlayerKickEvent event){
        //rajouter le fait d'ajouter un message de kick pour everyone.

    } */
}
