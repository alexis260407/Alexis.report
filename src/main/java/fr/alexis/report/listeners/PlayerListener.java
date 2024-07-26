package fr.alexis.report.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Test "+ player.getName());

        event.setQuitMessage(ChatColor.YELLOW + player.getName()+" a quitté la partie");
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event){
        //rajouter le fait d'ajouter un message de kick pour everyone.

    }
}