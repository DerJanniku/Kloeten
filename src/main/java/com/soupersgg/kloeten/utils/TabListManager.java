package com.soupersgg.kloeten.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TabListManager {
    private final JavaPlugin plugin;

    public TabListManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void updateTabList(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Team team = scoreboard.registerNewTeam("tablist");
        team.addEntry(player.getName());
        team.setPrefix("ยง6[VIP] ยงr");
        player.setScoreboard(scoreboard);
    }
}
