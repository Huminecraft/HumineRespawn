package com.huminecraft.huminerespawn;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import com.huminecraft.huminerespawn.commands.CommandDeathroom;
import com.huminecraft.huminerespawn.listeners.DeathListener;
import com.huminecraft.huminerespawn.listeners.RespawnListener;

public class HumineRespawn extends JavaPlugin {

    public static HumineRespawn instance;
    private final String VERSION = "1.0.0";

    public static HumineRespawn getInstance() {
	return HumineRespawn.instance;
    }

    public void onEnable() {
	consoleLog(Level.INFO, "Humine Respawn " + VERSION + " by SDA loaded.");
	getCommand("deathroom").setExecutor(new CommandDeathroom());
	getServer().getPluginManager().registerEvents(new DeathListener(), this);
	getServer().getPluginManager().registerEvents(new RespawnListener(), this);
	instance = this;
	this.saveDefaultConfig();
	CommandDeathroom.deathroom.setDefaultPosition();
	
    }

    public void onDisable() {
	this.saveConfig();
	consoleLog(Level.INFO, "Humine Respawn unloaded");
    }

    public void consoleLog(Level level, String message) {
	this.getServer().getLogger().log(level, message);
    }

}
