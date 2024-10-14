package com.soupersgg.kloeten;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.soupersgg.kloeten.commands.LobbyHelpCommand;
import com.soupersgg.kloeten.commands.LobbySpawnCommand;
import com.soupersgg.kloeten.commands.LobbyMinigamesCommand;
import com.soupersgg.kloeten.commands.ReportCommand;
import com.soupersgg.kloeten.commands.FriendCommand;
import com.soupersgg.kloeten.commands.PartyCommand;
import com.soupersgg.kloeten.commands.ClanCommand;
import com.soupersgg.kloeten.gui.MainMenu;
import com.soupersgg.kloeten.gui.FriendsMenu;
import com.soupersgg.kloeten.gui.CosmeticsMenu;
import com.soupersgg.kloeten.utils.LobbyScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import com.soupersgg.kloeten.utils.TabListManager;

import java.util.Objects;

public class Kloeten extends JavaPlugin implements Listener {
    private LobbyScoreboard lobbyScoreboard;
    private TabListManager tabListManager;

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled!");

        // Register commands
        Objects.requireNonNull(this.getCommand("lobby")).setExecutor(new LobbyHelpCommand());
        Objects.requireNonNull(this.getCommand("lobby spawn")).setExecutor(new LobbySpawnCommand());
        Objects.requireNonNull(this.getCommand("lobby minigames")).setExecutor(new LobbyMinigamesCommand());
        Objects.requireNonNull(this.getCommand("report")).setExecutor(new ReportCommand());
        Objects.requireNonNull(this.getCommand("friend")).setExecutor(new FriendCommand());
        Objects.requireNonNull(this.getCommand("party")).setExecutor(new PartyCommand());
        Objects.requireNonNull(this.getCommand("clan")).setExecutor(new ClanCommand());

        // Register event listeners
        Bukkit.getPluginManager().registerEvents(new MainMenu(this), this);
        Bukkit.getPluginManager().registerEvents(new FriendsMenu(this), this);
        Bukkit.getPluginManager().registerEvents(new CosmeticsMenu(this), this);
        Bukkit.getPluginManager().registerEvents(this, this);

        // Initialize TabListManager
        tabListManager = new TabListManager(this);
        for (Player player : Bukkit.getOnlinePlayers()) {
            tabListManager.updateTabList(player);
        }

        // Initialize LobbyScoreboard
        lobbyScoreboard = new LobbyScoreboard(this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Update player's tab list
        tabListManager.updateTabList(event.getPlayer());

        // Update player's scoreboard
        lobbyScoreboard.createScoreboard(event.getPlayer());
    }
}

