package fr.alexis.report.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ReportMenu {

    public ReportMenu(Player player, Player target){
        //permet de créer un inventaire avec une variable et le nom du gui
        Inventory inventory = Bukkit.createInventory(null, 27, "Menu Report");

        //Slot de l'item demandé (mettre à la position 22)
        inventory.setItem(15, create(Material.SKULL_ITEM, target.getName()));

        inventory.setItem(11, create(Material.IRON_SWORD, "§cAnti-Jeu", ChatColor.WHITE + "Sélectionner ce type de report"));

        inventory.setItem(13, create(Material.PAPER, "§cLangage", ChatColor.WHITE + "Sélectionner ce type de report"));

        player.openInventory(inventory);
    }
    
    public static ItemStack create(Material m, String display, String... lore) {
        ItemStack langage = new ItemStack(m);
        ItemMeta langageMeta = langage.getItemMeta();
        langageMeta.setDisplayName(display);
        langageMeta.setLore(Arrays.asList(lore));
        langage.setItemMeta(langageMeta);
        return langage;
    }
}