package com.soupersgg.kloeten.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class PartyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("party")) {
            if (args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Usage: /party <create|disband|list> [player]");
                return true;
            }

            String subCommand = args[0].toLowerCase();
            switch (subCommand) {
                case "create":
                    if (args.length < 2) {
                        sender.sendMessage(ChatColor.RED + "Usage: /party create <player>");
                        return true;
                    }
                    String playerToInvite = args[1];
                    // Create party logic here
                    sender.sendMessage(ChatColor.GREEN + "Created a party and invited " + playerToInvite + ".");
                    break;
                case "disband":
                    // Disband party logic here
                    sender.sendMessage(ChatColor.GREEN + "Disbanded the party.");
                    break;
                case "list":
                    // List party members logic here
                    sender.sendMessage(ChatColor.GREEN + "Listing party members...");
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Unknown subcommand. Usage: /party <create|disband|list> [player]");
                    break;
            }
            return true;
        }
        return false;
    }
}