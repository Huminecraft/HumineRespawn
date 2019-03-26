package com.huminecraft.huminerespawn.objects;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.aypi.utils.Timer;
import com.aypi.utils.inter.TimerFinishListener;
import com.huminecraft.huminerespawn.HumineRespawn;
import com.huminecraft.huminerespawn.commands.CommandDeathroom;

public class Countdown {

    private Player p;
    public static Countdown instance;
    
    public Countdown() {
    }

    public void setPlayer(Player p) {
	this.p = p;
    }

    public Player getPlayer() {
	return p;
    }

    public void start() {
	Timer countdown = new Timer(HumineRespawn.getInstance(), CommandDeathroom.getDeathroomTimer(),
		new TimerFinishListener() {
		    @Override
		    public void execute() {
			getPlayer().teleport(getPlayer().getBedSpawnLocation());
		    }
		}, true);
	countdown.start();
	new BukkitRunnable()
        {
            int countdown = CommandDeathroom.getDeathroomTimer();
            public void run()
            {
                p.setLevel(countdown);
                if (countdown == 0) {
            		this.cancel();
                }
                countdown--;
            }


        }.runTaskTimer(HumineRespawn.getInstance(), 20, 20);
    }

}