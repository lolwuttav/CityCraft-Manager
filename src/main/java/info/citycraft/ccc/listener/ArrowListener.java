package info.citycraft.ccc.listener;

import info.citycraft.ccc.CityCraftCommander;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class ArrowListener implements Listener {

    CityCraftCommander plugin;

    @EventHandler
    public void playerShoot(EntityShootBowEvent event)
    {



        //arrow.setCritical(false);
        //arrow.setGlowing(true);
        //arrow.setVelocity(arrow.getVelocity().multiply(4));

    }

}
