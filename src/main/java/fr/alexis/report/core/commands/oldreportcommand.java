package fr.alexis.report.core.commands;

import fr.alexis.report.api.gui.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class oldreportcommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Seul un joueur peut exécuter cette commande.");
            return false;
        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("oldreport")) {
            if (args.length != 1) {
                player.sendMessage("§cVeuillez saisir le pseudo d'un joueur.");
                return false;
            }

            String targetName = args[0];

            if (Bukkit.getPlayer(targetName) == null) {
                player.sendMessage("§cCe joueur n'est pas connecté.");
                return false;
            }

            Player target = Bukkit.getPlayer(targetName);
            Inventory inv = Bukkit.createInventory(null, 18, "§k§cReport§k " + target.getName());

            inv.setItem(13, new ItemBuilder(Material.DIAMOND_SWORD).setName("Cheat").toItemStack());
            inv.setItem(15, new ItemBuilder(Material.DARK_OAK_DOOR).setName("Chat").toItemStack());

            player.openInventory(inv);
        }
        return true;
    }
}
