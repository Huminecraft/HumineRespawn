package com.huminecraft.huminerespawn.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.huminecraft.huminerespawn.commands.CommandDeathroom;

public class RespawnListener implements Listener {
    
    public void onRespawn(PlayerRespawnEvent e) {
	Player player = e.getPlayer();
	if (player instanceof Player) /** && player.getKiller() != null)**/ {
	    if(!CommandDeathroom.getDeathroomLocation().getChunk().isLoaded()) {
		CommandDeathroom.getDeathroomLocation().getChunk().load();
	    }
	    Location respawnLocation = CommandDeathroom.getDeathroomLocation();
	    e.setRespawnLocation(respawnLocation);
	    System.out.println("Casted Respawn");
	    //Countdown.setPlayer(player);
	    //Countdown.start();
	} else {
	    return;
	}
    }

}
