package com.soupersgg.kloeten.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class ClanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("clan")) {
            if (args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Usage: /clan <create|disband|list> [clanName]");
                return true;
            }

            String subCommand = args[0].toLowerCase();
            switch (subCommand) {
                case "create":
                    if (args.length < 2) {
                        sender.sendMessage(ChatColor.RED + "Usage: /clan create <clanName>");
                        return true;
                    }
                    String clanNameToCreate = args[1];
                    // Create clan logic here
                    sender.sendMessage(ChatColor.GREEN + "Created clan " + clanNameToCreate + ".");
                    break;
                case "disband":
                    if (args.length < 2) {
                        sender.sendMessage(ChatColor.RED + "Usage: /clan disband <clanName>");
                        return true;
                    }
                    String clanNameToDisband = args[1];
                    // Disband clan logic here
                    sender.sendMessage(ChatColor.GREEN + "Disbanded clan " + clanNameToDisband + ".");
                    break;
                case "list":
                    // List clans logic here
                    sender.sendMessage(ChatColor.GREEN + "Listing clans...");
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Unknown subcommand. Usage: /clan <create|disband|list> [clanName]");
                    break;
            }
            return true;
        }
        return false;
    }
}