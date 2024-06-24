package fr.alexis.report.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        // Vérifie le titre de l'inventaire
        if(!event.getView().getTitle().equals("Menu Report")){
            return;
        }
        // Empêche de prendre des items dans le GUI
        event.setCancelled(true);

        if(event.getCurrentItem() == null){
            return;
        }

        // Récupère le joueur qui a cliqué
        Player player = (Player) event.getWhoClicked();

        // Vérifie que l'item à la position 22 existe et a un nom
        if(event.getView().getItem(15) != null && event.getView().getItem(15).hasItemMeta()) {
            ItemMeta itemMeta = event.getView().getItem(15).getItemMeta();
            if(itemMeta != null && itemMeta.hasDisplayName()) {
                Player target = Bukkit.getPlayer(itemMeta.getDisplayName());

                if (target == null){
                    player.closeInventory();
                    player.sendMessage(ChatColor.RED + "Coucou");
                    return;
                }

                // Vérifie le type de l'item cliqué et envoie un message en conséquence
                if (event.getCurrentItem().getType() == Material.IRON_SWORD) {
                    player.sendMessage(ChatColor.RED + "Test sword");
                } else if(event.getCurrentItem().getType() == Material.PAPER){
                    player.sendMessage(ChatColor.RED + "Test Paper");
                }
            }
        }
    }
}