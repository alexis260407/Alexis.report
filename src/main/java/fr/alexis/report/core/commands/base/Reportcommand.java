package fr.alexis.report.core.commands.base;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import fr.alexis.report.core.menus.ReportMenu;

import static fr.alexis.report.api.database.PlayerListener.hasPlayerJoinedBefore;

//Moi même
public class Reportcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player player = (Player) sender;
        //Inutilisé String playerName = args[0];

        if(args.length != 1){
            //Montre
            player.sendMessage(ChatColor.RED + "/invsee <Player>");
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
            player.sendMessage(ChatColor.RED + "Tu cherches de l'attention c: ? (inspiré skylymc)");
            return false;
        }
            //Va permettre d'ouvrir le menu
        new ReportMenu(player,target);
        return true;
    }
}