package fr.alexis.report.bungee.commands.base;

import fr.alexis.report.api.player.PrivateMessageManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandmsg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;
        //Inutilisé String playerName = args[0];

        if(args.length != 2){
            //Montre
            player.sendMessage(ChatColor.RED + "/msg <Player>");
            return true;
        }

        // Note à moi : comme si c'était une variable comme dans le c++ dans le cours de Mr info
        // Player = Joueurs qui fais et Target est le nom qu'on a donné
        Player target = Bukkit.getPlayer(args[0]);

        if(target == null){
            //si le joueur est hors ligne, alors = null (défault de minecraft)
            player.sendMessage(ChatColor.RED + "Le Joueur n'est pas connecté.");
            return false;
        }

        if (target == player){
            //si le joueur veut ce report à lui-même :
            player.sendMessage(ChatColor.RED + "Tu.." +
                    "ne peux pas mp toi même...");
            return false;
        }
        Player target2 = Bukkit.getPlayer(args[0]);

        StringBuilder message = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }

        // Envoie le message privé
        String formattedMessage = "Message privé de " + target.getName() + ": " + message.toString().trim();
        target2.sendMessage(formattedMessage);
        target.sendMessage("Message privé à " + target2.getName() + ": " + message.toString().trim());

        // Enregistre le destinataire pour la commande /r
        PrivateMessageManager.setLastMessagedPlayer(target, target2);

        return true;
    }
}
