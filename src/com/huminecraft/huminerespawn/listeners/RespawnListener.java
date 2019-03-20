package com.huminecraft.huminerespawn.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.huminecraft.huminerespawn.commands.CommandDeathroom;
import com.huminecraft.huminerespawn.objects.Countdown;

public class RespawnListener implements Listener {
    
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
	Player player = e.getPlayer();
	if (player instanceof Player) /** && player.getKiller() != null)**/ {
	    e.setRespawnLocation(CommandDeathroom.deathroom.getDeathroom().getRoomLocation());
	    System.out.println("Casted Respawn");
	    Countdown.setPlayer(player);
	    Countdown.start();
	} else {
	    return;
	}
    }

}
