package fr.alexis.report.core.commands.base;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class invseecommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

            Player player = (Player) sender;

            if(args.length != 1){
                //Montre
                player.sendMessage(ChatColor.RED + "/report <Player>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);

            if(player == null){
                //si le joueur est hors ligne, alors = null (défault de minecraft)
                player.sendMessage(ChatColor.RED + "Le Joueur n'est pas connecté.");
                return false;
            }

            player.openInventory(target.getInventory());
            return true;

    }
}