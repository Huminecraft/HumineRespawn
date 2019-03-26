package com.huminecraft.huminerespawn.commands;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.huminecraft.huminerespawn.HumineRespawn;
import com.huminecraft.huminerespawn.objects.Deathroom;

public class CommandDeathroom implements CommandExecutor {

    public static Deathroom deathroom = new Deathroom();
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (sender instanceof Player) {
	    Player p = (Player) sender;
	    if (p.hasPermission("huminerespawn.admin")) {
		if (args.length == 0) {
		    p.sendMessage("Utilisez /deathroom help pour en savoir plus.");
		} else if (args[0].equalsIgnoreCase("set")) {
		    Location location = p.getLocation();
		    deathroom.setRoomLocation(location);
		    deathroom.savePosition();
		    p.sendMessage(ChatColor.GREEN + "La localisation de la Deathroom a bien été actualisée");
		    HumineRespawn.getInstance().getServer().getLogger().log(Level.INFO,
			    "La localisation de la deathroom a ete mise a jour : " + "X = " + location.getBlockX()
				    + "Y = " + location.getBlockY() + "Z = " + location.getBlockZ());
		} else if (args[0].equalsIgnoreCase("tp")) {
		    p.teleport(deathroom.getRoomLocation());
		    p.sendMessage(ChatColor.GREEN + "Téléporté à la deathroom");
		} else if (args[0].equalsIgnoreCase("enabled")) {
			deathroom.setENABLED(true);
		} else if (args[0].equalsIgnoreCase("disabled")) {
			deathroom.setENABLED(false);
		} else if (args[0].equalsIgnoreCase("timer") && !args[1].equalsIgnoreCase("")) {
		    try {
			deathroom.setTimer(Integer.parseInt(args[1]));
		    } catch (NumberFormatException e) {
			p.sendMessage(args[1] + " n'est pas un nombre valide");
		    }
		} else if (args[0].equalsIgnoreCase("help")) {
		    p.sendMessage(ChatColor.GREEN + "Voici les différentes commandes et leur usage : ");
		    p.sendMessage(ChatColor.GREEN + "/deathroom help : Affiche l'aide.");
		    p.sendMessage(ChatColor.GREEN + "/deathroom set : Met à jour la position de la deathroom.");
		    p.sendMessage(ChatColor.GREEN + "/deathroom tp : Téléporte le joueur à l'emplacement de la deahtroom");
		    p.sendMessage(ChatColor.GREEN + "/deathroom timer [nombre] : Modifie la durée du timer.");
		    p.sendMessage(ChatColor.GREEN + "/deathroom enable/disable : Active ou désactive la deathroom.");
		    p.sendMessage(ChatColor.GREEN + "/deathroom status : Permet de savoir l'état de la deathroom.");
		} else if (args[0].equalsIgnoreCase("status")) {
		    if (deathroom.isENABLED()) {
			p.sendMessage(ChatColor.GREEN + "La deathroom est activée");
		    } else {
			p.sendMessage(ChatColor.GREEN + "La deathroom est désactivée");
		    }
		} else {
		    p.sendMessage("Commande inconnue, utilisez /deathroom help pour en savoir plus.");
		} 
		
	    } else {
		p.sendMessage("Vous n'avez pas la permission pour utiliser cette commande.");
	    }
	}
	return true;
    }

    public static Location getDeathroomLocation() {
	return deathroom.getRoomLocation();
    }

    public static int getDeathroomTimer() {
	return deathroom.getTimer();
    }

}
