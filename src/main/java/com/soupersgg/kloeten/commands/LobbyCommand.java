package com.soupersgg.kloeten.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;

public class LobbyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Get the spawn location from the server
            Location spawnLocation = Bukkit.getWorlds().get(0).getSpawnLocation();

            // Teleport the player to the spawn location
            player.teleport(spawnLocation);

            // Send a message to the player
            player.sendMessage("You have been teleported to the lobby!");
        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }

        return true;
    }
}