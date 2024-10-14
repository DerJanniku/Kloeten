package com.soupersgg.kloeten.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class LobbyScoreboard {
    private final JavaPlugin plugin;

    public LobbyScoreboard(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void createScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective objective = board.registerNewObjective("lobby", "dummy", ChatColor.GOLD + "GOMMEHD.NET");
        objective.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);

        Score rank = objective.getScore(ChatColor.YELLOW + "Rang");
        rank.setScore(6);

        Score playerName = objective.getScore(ChatColor.WHITE + player.getName());
        playerName.setScore(5);

        Score coins = objective.getScore(ChatColor.YELLOW + "Coins");
        coins.setScore(4);

        Score coinsValue = objective.getScore(ChatColor.WHITE + "29.371");
        coinsValue.setScore(3);

        Score gold = objective.getScore(ChatColor.YELLOW + "Gold");
        gold.setScore(2);

        Score goldValue = objective.getScore(ChatColor.WHITE + "0");
        goldValue.setScore(1);

        Score clan = objective.getScore(ChatColor.YELLOW + "Clan");
        clan.setScore(0);

        Score clanValue = objective.getScore(ChatColor.WHITE + "Kein Clan");
        clanValue.setScore(-1);

        Score friends = objective.getScore(ChatColor.YELLOW + "Freunde");
        friends.setScore(-2);

        Score friendsValue = objective.getScore(ChatColor.WHITE + "1/5");
        friendsValue.setScore(-3);

        player.setScoreboard(board);
    }

    public void removePlayerFromScoreboard(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }
}