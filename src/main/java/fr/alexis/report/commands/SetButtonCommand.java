package fr.alexis.report.commands;

import fr.alexis.report.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class SetButtonCommand implements CommandExecutor {

    private final Main plugin;

    public SetButtonCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by a player.");
            return true;
        }

        Player player = (Player) sender;
        Block targetBlock = getTargetBlock(player, 5);

        if (targetBlock == null || targetBlock.getType() != Material.STONE_BUTTON) {
            player.sendMessage(ChatColor.RED + "You must be looking at a stone button.");
            return true;
        }

        String buttonLocation = targetBlock.getWorld().getName() + "," +
                targetBlock.getX() + "," +
                targetBlock.getY() + "," +
                targetBlock.getZ();

        FileConfiguration config = plugin.getConfig();
        config.getString("button.location");
        config.set("button.location", buttonLocation);
        config.getInt("button.location.x");

        setInConfig(config, "button.location", targetBlock.getLocation());
        setInConfig(config, "a.location", targetBlock.getLocation());
        
        plugin.saveConfig();

        player.sendMessage(ChatColor.GREEN + "Button location set!");

        return true;
    }

    private Block getTargetBlock(Player player, int range) {
        Set<Material> transparent = new HashSet<>();
        transparent.add(Material.AIR);
        return player.getTargetBlock(transparent, range);
    }
    
    public static void setInConfig(FileConfiguration config, String key, Location loc) {
    	config.set(key + ".x", loc.getX());
    	config.set(key + ".y", loc.getY());
    	config.set(key + ".z", loc.getZ());
    	
    	config.getDouble(key + ".x");
    }
}