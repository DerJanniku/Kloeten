package com.soupersgg.kloeten.gui;

import com.soupersgg.kloeten.Kloeten;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class FriendsMenu implements Listener {
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

    public FriendsMenu(Kloeten kloeten) {
        this.kloeten = kloeten;

        // Perform any other initialization or setup required by the FriendsMenu class
        // For example, you could initialize a list of friends or set up event listeners

        // Example initialization code:
        friends = new ArrayList<>();
        Bukkit.getPluginManager().registerEvents(this, this);
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