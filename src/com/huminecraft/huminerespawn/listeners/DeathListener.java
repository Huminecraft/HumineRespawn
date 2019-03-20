package com.huminecraft.huminerespawn.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
//import com.huminecraft.huminerespawn.objects.Countdown;

public class DeathListener implements Listener {

    private Location deathLocation;

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
	Player player = e.getEntity();
	this.setDeathLocation(player);
    }

    private void setDeathLocation(Player player) {
	deathLocation = player.getLocation();
    }

    public Location getDeathLocation() {
	return deathLocation;
    }
}
