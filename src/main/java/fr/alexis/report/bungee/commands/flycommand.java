package fr.alexis.report.bungee.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class flycommand implements CommandExecutor {

    private ArrayList<Player> list_of_flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if(list_of_flying_players.contains(player)){
                list_of_flying_players.remove(player);
                player.setAllowFlight(false);
                player.sendMessage("§cVous n'êtes plus en fly");
            } else if (!list_of_flying_players.contains(player)) {
                list_of_flying_players.add(player);
                player.setAllowFlight(true);
                player.sendMessage("§cVous êtes en fly !");
            }
        }
        return true;
    }
}
