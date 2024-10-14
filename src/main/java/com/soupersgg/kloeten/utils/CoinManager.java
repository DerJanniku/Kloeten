package com.soupersgg.kloeten.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class CoinManager {
    private final JavaPlugin plugin;
    private final FileConfiguration config;

    public CoinManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public int getCoins(Player player) {
        UUID uuid = player.getUniqueId();
        return config.getInt("coins." + uuid.toString(), 0);
    }

    public void addCoins(Player player, int amount) {
        UUID uuid = player.getUniqueId();
        int coins = getCoins(player) + amount;
        config.set("coins." + uuid.toString(), coins);
        plugin.saveConfig();
    }

    public void removeCoins(Player player, int amount) {
        UUID uuid = player.getUniqueId();
        int coins = getCoins(player) - amount;
        config.set("coins." + uuid.toString(), Math.max(coins, 0));
        plugin.saveConfig();
    }
}