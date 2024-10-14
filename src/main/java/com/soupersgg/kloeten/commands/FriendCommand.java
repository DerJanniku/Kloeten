package com.soupersgg.kloeten.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import com.soupersgg.kloeten.Kloeten;

import org.jetbrains.annotations.NotNull;

public class FriendCommand implements CommandExecutor {

    public FriendCommand() {
        Kloeten plugin = Kloeten.getPlugin(Kloeten.class);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("friend")) {
            if (args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Usage: /friend <add|remove|list> [player]");
                return true;
            }

            String subCommand = args[0].toLowerCase();
            switch (subCommand) {
                case "add":
                    if (args.length < 2) {
                        sender.sendMessage(ChatColor.RED + "Usage: /friend add <player>");
                        return true;
                    }
                    String playerToAdd = args[1];
                    // Add friend logic here
                    sender.sendMessage(ChatColor.GREEN + "Added " + playerToAdd + " as a friend.");
                    break;
                case "remove":
                    if (args.length < 2) {
                        sender.sendMessage(ChatColor.RED + "Usage: /friend remove <player>");
                        return true;
                    }
                    String playerToRemove = args[1];
                    // Remove friend logic here
                    sender.sendMessage(ChatColor.GREEN + "Removed " + playerToRemove + " from friends.");
                    break;
                case "list":
                    // List friends logic here
                    sender.sendMessage(ChatColor.GREEN + "Listing friends...");
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Unknown subcommand. Usage: /friend <add|remove|list> [player]");
                    break;
            }
            return true;
        }
        return false;
    }
}