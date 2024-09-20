package fr.alexis.report.core.commands.base;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class invseecommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

            Player player = (Player) sender;

            if (args.length == 1){
                Player target2 = Bukkit.getPlayer(args[0]);
                if (target2.isOnline()){
                    player.openInventory(target2.getInventory());
                } else if(!(target2.isOnline())){
                    player.sendMessage("§cCe joueur n'est pas en ligne.(j'ai pas encore appris la db :/)");
                }
                } else {
                    player.sendMessage("§c/invsee <Player>");
                }
            return false;
        }
}