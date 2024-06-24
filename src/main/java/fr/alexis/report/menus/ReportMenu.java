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

        //variable de l'item se nomme targetHead mais le player_head marche pas ;-;
        ItemStack targetHead = new ItemStack(Material.SKULL_ITEM, 1);
        ItemMeta targetHeadMeta = targetHead.getItemMeta();
        targetHeadMeta.setDisplayName(target.getName());
        targetHead.setItemMeta(targetHeadMeta);

        //Slot de l'item demandé (mettre à la position 22)
        inventory.setItem(15, targetHead);

        ItemStack AntiJeu = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta AntijeuMeta = AntiJeu.getItemMeta();
        AntijeuMeta.setDisplayName("§cAnti-Jeu");
        AntijeuMeta.setLore(Arrays.asList(ChatColor.WHITE + "sélectionner ce type de report"));
        AntiJeu.setItemMeta(AntijeuMeta);

        inventory.setItem(11, AntiJeu);

        ItemStack langage = new ItemStack(Material.PAPER, 1);
        ItemMeta langageMeta = langage.getItemMeta();
        langageMeta.setDisplayName("§cLangage");
        langageMeta.setLore(Arrays.asList(ChatColor.WHITE + "sélectionner ce type de report"));
        langage.setItemMeta(langageMeta);

        inventory.setItem(13, langage);

        player.openInventory(inventory);
    }
}