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

public class MainMenu implements Listener {
    private final JavaPlugin plugin;

    public MainMenu(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void openMainMenu(Player player) {
        Inventory mainMenu = Bukkit.createInventory(null, 27, "Main Menu");

        ItemStack spawnItem = new ItemStack(Material.COMPASS);
        ItemMeta spawnMeta = spawnItem.getItemMeta();
        spawnMeta.setDisplayName("Teleport to Spawn");
        spawnItem.setItemMeta(spawnMeta);
        mainMenu.setItem(11, spawnItem);

        ItemStack minigamesItem = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta minigamesMeta = minigamesItem.getItemMeta();
        minigamesMeta.setDisplayName("Teleport to Minigames");
        minigamesItem.setItemMeta(minigamesMeta);
        mainMenu.setItem(15, minigamesItem);

        player.openInventory(mainMenu);
    }

    @org.bukkit.event.EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Main Menu")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.hasItemMeta()) {
                String itemName = clickedItem.getItemMeta().getDisplayName();

                if (itemName.equals("Teleport to Spawn")) {
                    player.performCommand("lobby spawn");
                } else if (itemName.equals("Teleport to Minigames")) {
                    player.performCommand("lobby minigames");
                }
            }
        }
    }
}
