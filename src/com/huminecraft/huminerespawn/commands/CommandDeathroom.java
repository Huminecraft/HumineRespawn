package com.huminecraft.huminerespawn.commands;


import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.huminecraft.huminerespawn.objects.Deathroom;

public class CommandDeathroom implements CommandExecutor {
            
    public static Deathroom deathroom = new Deathroom();
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (sender instanceof Player) {
	    Player p = (Player) sender;
	    if (p.hasPermission("huminerespawn.admin")) {
		if (args[0].equalsIgnoreCase("set")) {
		    Location location = p.getLocation();
		    deathroom.setRoomLocation(location);
		    p.sendMessage("La localisation de la Deathroom a bien été actualisée");
		    System.out.println("La localisation de la deathroom a été mise à jour : " + "X = "
			    + location.getBlockX() + "Y = " + location.getBlockY() + "Z = " + location.getBlockZ());
		}
		
		if (args[0].equalsIgnoreCase("tp")) {
		    p.teleport(deathroom.getRoomLocation());
		    p.sendMessage("Téléporté à la deathroom");
		}

		else if (args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("disable")) {
		    if ((deathroom.isENABLED() && args[0].equalsIgnoreCase("enabled"))
			    || (!deathroom.isENABLED() && args[0] == "disabled")) {
			p.sendMessage("La deathroom est déjà " + args[0]);
		    } else if (args[0].equalsIgnoreCase("enabled")) {
			deathroom.setENABLED(true);
		    } else if (args[0].equalsIgnoreCase("disabled")) {
			deathroom.setENABLED(false);
		    }
		} else if (args[0].equalsIgnoreCase("time") && !args[1].equalsIgnoreCase("")) {
		    try {
			deathroom.setTimer(Integer.parseInt(args[1]));
		    } catch (NumberFormatException e) {
			p.sendMessage(args[1] + " n'est pas un nombre valide");
		    }
		}

		else if (args[0].equalsIgnoreCase("")) {
		    p.sendMessage("Utilisez /deathroom help pour en savoir plus.");
		} else {
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
	return deathroom.getRoomLocation();
    }
    public static int getDeathroomTimer() {
	return deathroom.getTimer();
    }



}
