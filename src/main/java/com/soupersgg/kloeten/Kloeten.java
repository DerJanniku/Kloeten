package com.soupersgg.kloeten;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.soupersgg.kloeten.gui.MainMenu;
import com.soupersgg.kloeten.gui.FriendsMenu;
import com.soupersgg.kloeten.gui.CosmeticsMenu;
import com.soupersgg.kloeten.utils.LobbyScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import com.soupersgg.kloeten.utils.TabListManager;
import com.soupersgg.kloeten.commands.ClanCommand;
import com.soupersgg.kloeten.commands.FriendCommand;
import com.soupersgg.kloeten.commands.LobbyCommand;
import com.soupersgg.kloeten.commands.LobbyMinigamesCommand;
import com.soupersgg.kloeten.commands.LobbySpawnCommand;
import com.soupersgg.kloeten.commands.PartyCommand;
import com.soupersgg.kloeten.commands.ReportCommand;

public class Kloeten extends JavaPlugin implements Listener {
    private LobbyScoreboard lobbyScoreboard;
    private TabListManager tabListManager;



    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled!");

        // Register commands
        PluginCommand lobbyCommand = getCommand("lobby");
        if (lobbyCommand != null) {
            getLogger().info("Lobby command found!");
            lobbyCommand.setExecutor(new LobbyCommand());
            getLogger().info("Lobby command registered!");
        } else {
            getLogger().severe("Lobby command not found!");
        }

        PluginCommand lobbySpawnCommand = getCommand("lobby_spawn");
        if (lobbySpawnCommand != null) {
            getLogger().info("Lobby spawn command found!");
            lobbySpawnCommand.setExecutor(new LobbySpawnCommand());
            getLogger().info("Lobby spawn command registered!");
        } else {
            getLogger().severe("Lobby spawn command not found!");
        }

        PluginCommand lobbyMinigamesCommand = getCommand("lobby_minigames");
        if (lobbyMinigamesCommand != null) {
            getLogger().info("Lobby minigames command found!");
            lobbyMinigamesCommand.setExecutor(new LobbyMinigamesCommand());
            getLogger().info("Lobby minigames command registered!");
        } else {
            getLogger().severe("Lobby minigames command not found!");
        }

        PluginCommand reportCommand = getCommand("report");
        if (reportCommand != null) {
            getLogger().info("Report command found!");
            reportCommand.setExecutor(new ReportCommand());
            getLogger().info("Report command registered!");
        } else {
            getLogger().severe("Report command not found!");
        }

        PluginCommand friendCommand = getCommand("friend");
        if (friendCommand != null) {
            getLogger().info("Friend command found!");
            friendCommand.setExecutor(new FriendCommand());
            getLogger().info("Friend command registered!");
        } else {
            getLogger().severe("Friend command not found!");
        }

        PluginCommand partyCommand = getCommand("party");
        if (partyCommand != null) {
            getLogger().info("Party command found!");
            partyCommand.setExecutor(new PartyCommand());
            getLogger().info("Party command registered!");
        } else {
            getLogger().severe("Party command not found!");
        }

        PluginCommand clanCommand = getCommand("clan");
        if (clanCommand != null) {
            getLogger().info("Clan command found!");
            clanCommand.setExecutor(new ClanCommand());
            getLogger().info("Clan command registered!");
        } else {
            getLogger().severe("Clan command not found!");
        }
    }
}