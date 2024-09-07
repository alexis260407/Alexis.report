package fr.alexis.report.core.events;

import fr.alexis.report.api.gui.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Evenement implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event) {
        // Récupérer le joueur qui a rejoint
        Player player = event.getPlayer();
        event.getHandlers();

        // Envoyer un message de bienvenue au joueur
        event.setJoinMessage("§eGuten Morgen my friends "+  player.getName());

        player.getInventory().setItem(0, new ItemBuilder(Material.COMPASS).setName("§cNavigation").toItemStack());
        player.getInventory().setItem(1, new ItemBuilder(Material.SKULL_ITEM).setName("§2Profil").toItemStack());
        player.getInventory().setItem(2, new ItemBuilder(Material.CHEST).setName("§aCosmétiques").toItemStack());
        player.getInventory().setItem(4, new ItemBuilder(Material.FEATHER).setName("§eSpam Jump").toItemStack());
        player.getInventory().setItem(8, new ItemBuilder(Material.REDSTONE_COMPARATOR).setName("§cParamètre").toItemStack());
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Test "+ player.getName());

        event.setQuitMessage(player.getName()+"§e a quitté la partie");
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Le joueur "+ player.getName() + " a été kick");

        event.setReason(player.getName() +"§e vous avez été kick pour raison :");

    }
}
