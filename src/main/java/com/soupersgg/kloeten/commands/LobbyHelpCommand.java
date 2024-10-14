package com.soupersgg.kloeten.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

public class LobbyHelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("lobby")) {
            if (args.length > 0 && args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(ChatColor.GREEN + "Available Commands:");
                sender.sendMessage(ChatColor.YELLOW + "/lobby help" + ChatColor.WHITE + " - Display this help message");
                sender.sendMessage(ChatColor.YELLOW + "/lobby spawn" + ChatColor.WHITE + " - Teleport to spawn");
                sender.sendMessage(ChatColor.YELLOW + "/lobby minigames" + ChatColor.WHITE + " - Teleport to minigames area");
                // Add more commands as needed
                return true;
            }
        }
        return false;
    }
}