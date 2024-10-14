package com.soupersgg.kloeten.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class FriendsMenu implements Listener {
    private final JavaPlugin plugin;

    public FriendsMenu(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void openFriendsMenu(Player player) {
        Inventory friendsMenu = Bukkit.createInventory(null, 27, "Friends Menu");

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

                if (itemName.equals("Manage Friends")) {
                    player.performCommand("friend");
                } else if (itemName.equals("Manage Parties")) {
                    player.performCommand("party");
                } else if (itemName.equals("Manage Clans")) {
                    player.performCommand("clan");
                }
            }
        }
    }
}
