package com.huminecraft.huminerespawn.commands;

//import java.io.IOException;

//import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//import com.huminecraft.huminerespawn.HumineRespawn;

public class CommandDeathroom implements CommandExecutor {

    private static boolean ENABLED = true;
//    private static String world = HumineRespawn.getInstance().getConfig().getString("world");
//    private static double x = HumineRespawn.getInstance().getConfig().getDouble("x");
//    private static double y = HumineRespawn.getInstance().getConfig().getDouble("y");
//    private static double z = HumineRespawn.getInstance().getConfig().getDouble("z");
//    private static Location roomLocation = new Location(Bukkit.getWorld(world), x, y, z);
    private static Location roomLocation;
    private static int timer = 30;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (sender instanceof Player) {
	    Player p = (Player) sender;
	    if (p.hasPermission("HumineRespawn.admin")) {
		if (args[0].equalsIgnoreCase("set")) {
		    Location location = p.getLocation();
		    this.setLocation(location);
		    /**
		     * String world = loc.getWorld().getName(); double x = loc.getX(); double y =
		     * loc.getY(); double z = loc.getZ();
		     * HumineRespawn.getInstance().getCustomConfig().set("world", world);
		     * HumineRespawn.getInstance().getCustomConfig().set("x", x);
		     * HumineRespawn.getInstance().getCustomConfig().set("y", y);
		     * HumineRespawn.getInstance().getCustomConfig().set("z", z); try {
		     * HumineRespawn.getInstance().getCustomConfig().save("spawn.yml"); } catch
		     * (IOException e) { e.printStackTrace(); }
		     **/
		    p.sendMessage("La localisation de la Deathroom a bien été actualisée");
		    System.out.println("La localisation de la deathroom a été mise à jour : " + "X = "
			    + location.getBlockX() + "Y = " + location.getBlockY() + "Z = " + location.getBlockZ());
		}

		/*
		 * else if (args[0].equalsIgnoreCase("enable") ||
		 * args[0].equalsIgnoreCase("disable")) { if ((CommandDeathroom.isENABLED() &&
		 * args[0].equalsIgnoreCase("enabled")) || (!CommandDeathroom.isENABLED() &&
		 * args[0] == "disabled")) { p.sendMessage("La deathroom est déjà " + args[0]);
		 * } else if (args[0].equalsIgnoreCase("enabled")) { this.setEnabled(true); }
		 * else if (args[0].equalsIgnoreCase("disabled")) { this.setEnabled(false); } }
		 */

		/*
		 * else if (args[0].equalsIgnoreCase("time") && !args[1].equalsIgnoreCase("")) {
		 * try { timer = Integer.parseInt(args[1]); } catch (NumberFormatException e) {
		 * p.sendMessage(args[1] + " n'est pas un nombre valide"); } }
		 */

		else {
		    p.sendMessage("Commande inconnue, utilisez /deathroom help pour en savoir plus.");
		}

	    }

	    else {
		p.sendMessage("Vous n'avez pas la permission pour utiliser cette commande.");
	    }
	}
	return true;
    }

    public static Location getDeathroomLocation() {
	return roomLocation;
    }

    public void setLocation(Location location) {
	CommandDeathroom.roomLocation = location;
    }

    public static boolean isENABLED() {
	return ENABLED;
    }

    public void setEnabled(boolean enabled) {
	CommandDeathroom.ENABLED = enabled;
    }

    public static int getTimer() {
	return timer;
    }

}
