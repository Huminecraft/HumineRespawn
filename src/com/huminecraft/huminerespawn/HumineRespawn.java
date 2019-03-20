package com.huminecraft.huminerespawn;

//import java.io.File;
//import java.io.IOException;
import java.util.logging.Level;

//import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.huminecraft.huminerespawn.commands.CommandDeathroom;
import com.huminecraft.huminerespawn.listeners.DeathListener;
import com.huminecraft.huminerespawn.listeners.RespawnListener;

public class HumineRespawn extends JavaPlugin {

    // private File customConfigFile;
    private FileConfiguration customConfig;
    public static HumineRespawn instance;
    private final String VERSION = "1.0.0";

    public static HumineRespawn getInstance() {
	return instance;
    }

    public void onEnable() {
	consoleLog(Level.INFO, "Humine Respawn " + VERSION + " by SDA loaded.");
	getCommand("deathroom").setExecutor(new CommandDeathroom());
	getServer().getPluginManager().registerEvents(new DeathListener(), this);
	getServer().getPluginManager().registerEvents(new RespawnListener(), this);

	// createCustomConfig();

    }

    public void onDisable() {
	consoleLog(Level.INFO, "Humine Respawn unloaded");
    }

    public FileConfiguration getCustomConfig() {
	return this.customConfig;
    }

    /**
     * private void createCustomConfig() { customConfigFile = new
     * File(getDataFolder(), "room.yml"); if (!customConfigFile.exists()) {
     * customConfigFile.getParentFile().mkdirs(); saveResource("room.yml", false); }
     * 
     * customConfig= new YamlConfiguration(); try {
     * customConfig.load(customConfigFile); } catch (IOException |
     * InvalidConfigurationException e) { e.printStackTrace(); } }
     **/

    public void consoleLog(Level level, String message) {
	this.getServer().getLogger().log(level, message);
    }

}
