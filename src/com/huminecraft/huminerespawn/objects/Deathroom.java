package com.huminecraft.huminerespawn.objects;

import org.bukkit.Location;

public class Deathroom {
    
    private Location roomLocation;
    private int timer = 30;
    private boolean ENABLED = true;
    private static Deathroom deathroom;
//    private String worldLocation = roomLocation.getWorld().getName();
//    private double xLocation = roomLocation.getX();
//    private double yLocation = roomLocation.getY();
//    private double zLocation = roomLocation.getZ();
    
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
}
