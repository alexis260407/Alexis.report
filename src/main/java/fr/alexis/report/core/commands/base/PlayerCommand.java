package fr.alexis.report.core.commands.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static fr.alexis.report.api.database.PlayerListener.hasPlayerJoinedBefore;

public class PlayerCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length != 1) {
            sender.sendMessage("§cUsage: /test <player>");
            return false;
        }

        String playerName = args[0];

        if (hasPlayerJoinedBefore(playerName)) {
            sender.sendMessage("§aLe joueur " + playerName + " a déjà rejoint le serveur.");
        } else {
            sender.sendMessage("§cLe joueur " + playerName + " n'existe pas ou n'a jamais rejoint le serveur.");
        }

        return true;
    }
}
