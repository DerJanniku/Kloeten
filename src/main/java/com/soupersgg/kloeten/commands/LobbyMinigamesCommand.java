package com.soupersgg.kloeten.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class LobbyMinigamesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Replace with the actual minigames location
            Location minigamesLocation = new Location(player.getWorld(), 100, 65, 100);
            player.teleport(minigamesLocation);
            player.sendMessage(ChatColor.GREEN + "You have been teleported to the minigames area.");
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return false;
        }
    }
}