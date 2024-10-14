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

public class CosmeticsMenu implements Listener {
    private final JavaPlugin plugin;

    public CosmeticsMenu(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void openCosmeticsMenu(Player player) {
        Inventory cosmeticsMenu = Bukkit.createInventory(null, 27, "Cosmetics Menu");

        ItemStack hatItem = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta hatMeta = hatItem.getItemMeta();
        hatMeta.setDisplayName("Select Hat");
        hatItem.setItemMeta(hatMeta);
        cosmeticsMenu.setItem(11, hatItem);

        ItemStack swordItem = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordMeta = swordItem.getItemMeta();
        swordMeta.setDisplayName("Select Sword");
        swordItem.setItemMeta(swordMeta);
        cosmeticsMenu.setItem(12, swordItem);

        ItemStack colorItem = new ItemStack(Material.REDSTONE);
        ItemMeta colorMeta = colorItem.getItemMeta();
        colorMeta.setDisplayName("Select Color Style");
        colorItem.setItemMeta(colorMeta);
        cosmeticsMenu.setItem(13, colorItem);

        ItemStack effectItem = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta effectMeta = effectItem.getItemMeta();
        effectMeta.setDisplayName("Select Visual Effect");
        effectItem.setItemMeta(effectMeta);
        cosmeticsMenu.setItem(14, effectItem);

        ItemStack shoesItem = new ItemStack(Material.GOLDEN_BOOTS);
        ItemMeta shoesMeta = shoesItem.getItemMeta();
        shoesMeta.setDisplayName("Select Shoes");
        shoesItem.setItemMeta(shoesMeta);
        cosmeticsMenu.setItem(15, shoesItem);

        ItemStack chestItem = new ItemStack(Material.CHEST);
        ItemMeta chestMeta = chestItem.getItemMeta();
        chestMeta.setDisplayName("Select Chest");
        chestItem.setItemMeta(chestMeta);
        cosmeticsMenu.setItem(16, chestItem);

        ItemStack balloonItem = new ItemStack(Material.SLIME_BALL);
        ItemMeta balloonMeta = balloonItem.getItemMeta();
        balloonMeta.setDisplayName("Select Balloon");
        balloonItem.setItemMeta(balloonMeta);
        cosmeticsMenu.setItem(17, balloonItem);

        ItemStack musicItem = new ItemStack(Material.MUSIC_DISC_CAT);
        ItemMeta musicMeta = musicItem.getItemMeta();
        musicMeta.setDisplayName("Select Music");
        musicItem.setItemMeta(musicMeta);
        cosmeticsMenu.setItem(18, musicItem);

        player.openInventory(cosmeticsMenu);
    }

    @org.bukkit.event.EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Cosmetics Menu")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.hasItemMeta()) {
                String itemName = clickedItem.getItemMeta().getDisplayName();

                // Handle item selection logic here
                player.sendMessage("You selected: " + itemName);
            }
        }
    }
}