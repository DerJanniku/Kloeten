package com.soupersgg.kloeten.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class ReportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("report")) {
            if (args.length > 0) {
                String reportedPlayerName = args[0];
                Player reportedPlayer = Bukkit.getPlayer(reportedPlayerName);

                if (reportedPlayer != null) {
                    // Handle reporting logic here
                    sender.sendMessage(ChatColor.GREEN + "Player " + reportedPlayerName + " has been reported.");
                    // You can add more detailed reporting logic, such as logging the report or notifying admins
                } else {
                    sender.sendMessage(ChatColor.RED + "Player " + reportedPlayerName + " not found.");
                }
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Usage: /report <player>");
                return false;
            }
        }
        return false;
    }
}
