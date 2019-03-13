package com.huminecraft.huminerespawn.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    public static Location deathLocation;
    public static Player player;
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
	player = e.getEntity();
	deathLocation = player.getLocation();
    }
}
