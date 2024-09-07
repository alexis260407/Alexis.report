package fr.alexis.report.bungee.commands.base;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import static org.bukkit.Bukkit.getServer;

//Alexis et ChatGPT
public class helpcommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§cA ce que je vois, tu sais pas écrire /help...");
            sender.sendMessage("§cSi tu as envie, je peux t'aider ;-;'");
            return true;
        }
        Player player = ((Player) sender).getPlayer();
        if (args.length == 0 || args[0].equalsIgnoreCase("1")) {
            sendHelpPage1(player);
        } else if (args[0].equalsIgnoreCase("2")) {
            sendHelpPage2(player);
        }
       /*  else if (args[0].equalsIgnoreCase("3")) {
            //sendHelpPage3(player);
        }*/
        else {
            player.sendMessage("§cA ce que je vois, tu sais pas écrire /help...");
            player.sendMessage("§cSi tu as envie, je peux t'aider ;-;'");
        }

        return true;
    }
    private void sendHelpPage1(Player player) {
            player.sendMessage("§c§l---------------------------------------");
            player.sendMessage("");
            player.sendMessage("§c§lSi vous voulez de l'aide, il y a le :");
            player.sendMessage("§b/report : §fPour avertir un joueur à un modérateur (non dev) ");
            player.sendMessage("§b/oldreport : §fl'ancien report tha (ou sah ?) 2022");
            player.sendMessage("");
            player.sendMessage("§c§l---------------------------------------");
            player.sendMessage("§c§lHelp §r§f1§7/§r§f2");
        }
    private void sendHelpPage2(Player player) {
        player.sendMessage("§c§l---------------------------------------");
        player.sendMessage("");
        player.sendMessage("§c§lLes personnes qui m'ont aidé:");
        player.sendMessage("");
        player.sendMessage("§bElikill58 : §fCoté code optimisation");
        player.sendMessage("§bKhorosenai & Zatrax_ : §fMon aidé a ajouter");
        player.sendMessage("le spigot de minecraft en tant artifacts");
        player.sendMessage("");
        player.sendMessage("§c§l---------------------------------------");;
        player.sendMessage("§c§lHelp §r§f2§7/§r§f2");
        TextComponent message = new TextComponent("§f Suite (a dev car = dinguerie après)");
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help 3"));
        message.setColor(net.md_5.bungee.api.ChatColor.GOLD);

        // Envoie le message cliquable au joueur
        player.spigot().sendMessage(message);
    }
        /* private void sendHelpPage3(Player player) {
            BukkitScheduler scheduler = getServer().getScheduler();

            // Commande non fonctionnel
            scheduler.scheduleSyncDelayedTask((Plugin) this, () -> player.sendMessage("God dammit "), 20L); // 20L ticks = 1 seconde
            scheduler.scheduleSyncDelayedTask((Plugin) this, () -> player.sendMessage("QUESQUE C'EST "), 4* 20L); // // 4* = seconde = quand on est à la 4ème seconde.
            player.sendMessage("Message a dev");
    }
    */
}