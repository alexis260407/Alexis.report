package fr.alexis.report.bungee.commands.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

//on est bien d'accord que ce code est absolument
//dégeu non ?
//signé par Alexis (oui je me clash à moi-même)
public class inutilecommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§c/inutile help");
            return true;
        }
        Player player = ((Player) sender).getPlayer();
        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            Heal(player);
        } else if (args[0].equalsIgnoreCase("heal")) {
            sendHelpPage(player);
        }
       else if (args[0].equalsIgnoreCase("3")) {
            sendHelpPage3(player);
        }
        else if (args[0].equalsIgnoreCase("")) {
            //sendHelpPage3(player);
        }
        else {
            player.sendMessage("§cA ce que je vois, tu sais pas écrire /help...");
            player.sendMessage("§cSi tu as envie, je peux t'aider ;-;'");

        }

        return true;
    }
    private void Heal(Player player) {
        player.setHealth(100);
        player.sendMessage("§cVous avez été heal !");
    }
    private void sendHelpPage(Player player) {
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
    }
        /* A dev
        private void sendHelpPage3(Player event) {
            Player p = event.getPlayer();

            int upper = 5;

            Random random = new Random();

            p.sendMessage("Random Number: " + random.nextInt(5+(upper)));
    } */
}