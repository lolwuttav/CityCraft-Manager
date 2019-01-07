package info.citycraft.ccc.listener;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SnowballListener implements Listener {

    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event)
    {
        if(event.getEntity() instanceof Snowball)
        {
            if(event.getHitEntity() instanceof Player){
                Player player = (Player) event.getHitEntity();
                player.setSprinting(false);
            }
        }
    }
}
