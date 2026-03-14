package com.vanish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class VanishManager {
    private JavaPlugin plugin;
    private Set<Player> vanishedPlayers = new HashSet<>();

    public VanishManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void toggleVanish(Player player) {
        if (vanishedPlayers.contains(player)) {
            unvanish(player);
        } else {
            vanish(player);
        }
    }

    public void vanish(Player player) {
        if (vanishedPlayers.contains(player)) {
            player.sendMessage("§eYou are already vanished!");
            return;
        }

        vanishedPlayers.add(player);

        // Hide player from all other players
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.equals(player)) {
                onlinePlayer.hidePlayer(plugin, player);
            }
        }

        // Send fake quit message
        Bukkit.broadcastMessage("§e" + player.getName() + " left the game");

        // Allow flight (spectator-like mode)
        player.setAllowFlight(true);
        player.setFlying(true);

        // Send confirmation message
        player.sendMessage("§a✓ You are now vanished!");
    }

    public void unvanish(Player player) {
        if (!vanishedPlayers.contains(player)) {
            player.sendMessage("§eYou are not vanished!");
            return;
        }

        vanishedPlayers.remove(player);

        // Show player to all other players
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.equals(player)) {
                onlinePlayer.showPlayer(plugin, player);
            }
        }

        // Send fake join message
        Bukkit.broadcastMessage("§e" + player.getName() + " joined the game");

        // Disable flight (restore original state)
        player.setAllowFlight(false);
        player.setFlying(false);

        // Send confirmation message
        player.sendMessage("§c✗ You are no longer vanished!");
    }

    public boolean isVanished(Player player) {
        return vanishedPlayers.contains(player);
    }

    public Set<Player> getVanishedPlayers() {
        return new HashSet<>(vanishedPlayers);
    }
}
