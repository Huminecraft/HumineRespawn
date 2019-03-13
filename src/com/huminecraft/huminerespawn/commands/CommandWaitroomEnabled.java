package com.huminecraft.huminerespawn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.huminecraft.huminerespawn.Main;

public class CommandWaitroomEnabled implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (sender instanceof Player) {
	    Player p = (Player)sender;
	    if (p.hasPermission("HumineRespawn.admin")) {
		
		Main.Enabled = false;
		
	    } else {
		p.sendMessage("Vous n'avez pas la permission pour utiliser cette commande.");
	    }
	}
	return true;
    }
    public void showHelp(Player p) {
	p.sendMessage("C'est un jeu du pendu simple, le but est de deviner le mot en proposant des lettres dans le chat en moins de 8 coups");
    }
}

    	