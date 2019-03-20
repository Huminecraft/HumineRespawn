package com.huminecraft.huminerespawn.objects;

import org.bukkit.entity.Player;

import com.aypi.utils.Timer;
import com.aypi.utils.inter.TimerFinishListener;
import com.huminecraft.huminerespawn.HumineRespawn;
import com.huminecraft.huminerespawn.commands.CommandDeathroom;

public class Countdown {

    private static Player p;

    public static void setPlayer(Player p) {
	Countdown.p = p;
    }

    public static Player getPlayer() {
	return p;
    }

    public static void start() {
	Timer countdown = new Timer(HumineRespawn.getInstance(), CommandDeathroom.deathroom.getDeathroom().getTimer(),
		new TimerFinishListener() {

		    @Override
		    public void execute() {
			Countdown.getPlayer();
		    }
		}, true);
	countdown.start();
    }

}
