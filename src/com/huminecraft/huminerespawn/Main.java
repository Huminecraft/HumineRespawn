package com.huminecraft.huminerespawn;

import org.bukkit.plugin.java.JavaPlugin;

import com.huminecraft.huminerespawn.commands.CommandWaitroomEnabled;

public class Main extends JavaPlugin {
    
    public static boolean Enabled = true;

    final static String VERSION = "1.0";

    public void onEnable() {

	System.out.println("Humine Respawn " + VERSION + " by SDA loaded.");
	this.getCommand("waitroom enabled").setExecutor(new CommandWaitroomEnabled());

    }

    public void onDisable() {

    }

}
