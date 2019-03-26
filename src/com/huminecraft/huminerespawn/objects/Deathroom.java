package com.huminecraft.huminerespawn.objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import com.huminecraft.huminerespawn.HumineRespawn;

public class Deathroom {

    private Location roomLocation;
    private int timer = 30;
    private boolean ENABLED = true;
    private static Deathroom deathroom;
    String world;
    double x;
    double y;
    double z;
    

    public Deathroom() {
    }

    public boolean isENABLED() {
	return ENABLED;
    }

    public void setENABLED(boolean enabled) {
	ENABLED = enabled;
    }

    public int getTimer() {
	return timer;
    }

    public void setTimer(int timer) {
	this.timer = timer;
    }

    public Location getRoomLocation() {
	return roomLocation;
    }

    public void setRoomLocation(Location roomLocation) {
	this.roomLocation = roomLocation;
    }

    public Deathroom getDeathroom() {
	return deathroom;
    }

    public void setDeathroom(Deathroom deathroom) {
	Deathroom.deathroom = deathroom;
    }

    public void savePosition() {
	HumineRespawn.getInstance().getConfig().set("worldLocation", roomLocation.getWorld().getName());
	HumineRespawn.getInstance().getConfig().set("xLocation", roomLocation.getX());
	HumineRespawn.getInstance().getConfig().set("yLocation", roomLocation.getY());
	HumineRespawn.getInstance().getConfig().set("zLocation", roomLocation.getZ());
    }
    public void setDefaultPosition() {
	String worldName = HumineRespawn.getInstance().getConfig().getString("worldLocation");
	x = HumineRespawn.getInstance().getConfig().getDouble("xLocation");
	y = HumineRespawn.getInstance().getConfig().getDouble("yLocation");
	z = HumineRespawn.getInstance().getConfig().getDouble("zLocation");
	World world = Bukkit.getServer().getWorld(worldName);
	this.roomLocation = new Location(world, x, y, z);
    }
}
