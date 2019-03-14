package com.huminecraft.huminerespawn.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.huminecraft.huminerespawn.commands.CommandDeathroom;
import com.huminecraft.huminerespawn.objects.Countdown;

public class DeathListener implements Listener {

    private static Location deathLocation;

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
	Player player = e.getEntity();
	this.setDeathLocation(player);
	if (player instanceof Player && CommandDeathroom.isENABLED()) /** && player.getKiller() != null)**/ {
	    player.teleport(CommandDeathroom.getDeathroomLocation());
	    Countdown.setPlayer(player);
	    Countdown.start();
	} else {
	    return;
	}
    }

    private void setDeathLocation(Player player) {
	deathLocation = player.getLocation();
    }

    public static Location getDeathLocation() {
	return deathLocation;
    }
}
