package com.soupersgg.kloeten.gui;

import com.soupersgg.kloeten.Kloeten;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FriendsMenu implements Listener {
    private final Kloeten kloeten;
    private final List<UUID> friends;

    public FriendsMenu(Kloeten kloeten) {
        this.kloeten = kloeten;

        // Initialize an empty list to store friends
        friends = new ArrayList<>();

        // Register this class as an event listener
        Bukkit.getPluginManager().registerEvents(this, kloeten);

        // Initialize a configuration file to store friends data
        File friendsFile = new File(kloeten.getDataFolder(), "friends.yml");
        if (!friendsFile.exists()) {
            try {
                friendsFile.createNewFile();
            } catch (IOException e) {
                kloeten.getLogger().severe("Failed to create friends.yml file: " + e.getMessage());
            }
        }

        // Load friends data from the configuration file
        FileConfiguration friendsConfig = YamlConfiguration.loadConfiguration(friendsFile);
        for (String uuid : friendsConfig.getKeys(false)) {
            friends.add(UUID.fromString(uuid));
        }
    }

    public void openFriendsMenu(Player player) {
        Inventory friendsMenu = Bukkit.createInventory(player, 27, "Friends Menu");

        ItemStack friendsItem = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta friendsMeta = friendsItem.getItemMeta();
        friendsMeta.setDisplayName("Manage Friends");
        friendsItem.setItemMeta(friendsMeta);
        friendsMenu.setItem(11, friendsItem);

        ItemStack partyItem = new ItemStack(Material.CAKE);
        ItemMeta partyMeta = partyItem.getItemMeta();
        partyMeta.setDisplayName("Manage Parties");
        partyItem.setItemMeta(partyMeta);
        friendsMenu.setItem(13, partyItem);

        ItemStack clanItem = new ItemStack(Material.MAGENTA_BANNER);
        ItemMeta clanMeta = clanItem.getItemMeta();
        clanMeta.setDisplayName("Manage Clans");
        clanItem.setItemMeta(clanMeta);
        friendsMenu.setItem(15, clanItem);

        player.openInventory(friendsMenu);
    }

    @org.bukkit.event.EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Friends Menu")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.hasItemMeta()) {
                String itemName = clickedItem.getItemMeta().getDisplayName();

                switch (itemName) {
                    case "Manage Friends":
                        player.performCommand("friend");
                        break;
                    case "Manage Parties":
                        player.performCommand("party");
                        break;
                    case "Manage Clans":
                        player.performCommand("clan");
                        break;
                }
            }
        }
    }
}