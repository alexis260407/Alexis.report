package fr.alexis.report.listeners;


import fr.alexis.report.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class ButtonListener implements Listener {

    private final Main plugin;

    public ButtonListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;

        Block clickedBlock = event.getClickedBlock();
        Material blockType = clickedBlock.getType();

        FileConfiguration config = plugin.getConfig();
        String buttonLocation = config.getString("button.location");

        if (buttonLocation == null) return;

        String[] locParts = buttonLocation.split(",");
        if (locParts.length != 4) return;

        String worldName = locParts[0];
        int x = Integer.parseInt(locParts[1]);
        int y = Integer.parseInt(locParts[2]);
        int z = Integer.parseInt(locParts[3]);

        if (!clickedBlock.getWorld().getName().equals(worldName)) return;
        if (clickedBlock.getX() != x || clickedBlock.getY() != y || clickedBlock.getZ() != z) return;

        if (blockType != Material.STONE_BUTTON) return;

        Player player = event.getPlayer();
        Vector playerLocation = player.getLocation().toVector();

        double nearestDistance = Double.MAX_VALUE;
        LivingEntity nearestEntity = null;

        for (Entity entity : player.getWorld().getEntities()) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                if (livingEntity.getCustomName() != null) {
                    double distance = livingEntity.getLocation().toVector().distance(playerLocation);
                    if (distance < nearestDistance) {
                        nearestDistance = distance;
                        nearestEntity = livingEntity;
                    }
                }
            }
        }

        if (nearestEntity != null) {
            String customName = nearestEntity.getCustomName();
            try {
                int value = Integer.parseInt(ChatColor.stripColor(customName));
                value++;
                nearestEntity.setCustomName(ChatColor.GREEN + String.valueOf(value));
                player.sendMessage(ChatColor.YELLOW + "Le bouton a été appuyé " + value);
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Chiffre invalide. ");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Pas d'entité a l'horizon avec nametag");
        }
    }
}