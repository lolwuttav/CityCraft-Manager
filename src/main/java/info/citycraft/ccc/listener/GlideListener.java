package info.citycraft.ccc.listener;

import info.citycraft.ccc.CityCraftCommander;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

public class GlideListener implements Listener {

    @EventHandler
    public void onPlayerToggleGlide(EntityToggleGlideEvent event)
    {
        if(event.getEntity() instanceof Player)
        {
            Player player = (Player) event.getEntity();
            for (MetadataValue s : player.getMetadata("CommandGliding"))
            {
                if(s.asBoolean()){
                    if(player.isOnGround())
                    {
                        player.setMetadata("CommandGliding", new FixedMetadataValue(CityCraftCommander.getPlugin(CityCraftCommander.class), false));
                        //TODO: TAKE ROCKETS FROM PLAYER
                        return;
                    }
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerFallDamage(EntityDamageEvent event)
    {
        if(event.getEntity() instanceof Player)
        {
            Player player = (Player) event.getEntity();
            for (MetadataValue s : player.getMetadata("IgnoreFallDamage"))
            {
                if(s.asBoolean() && (event.getCause().equals(EntityDamageEvent.DamageCause.FALL) || event.getCause().equals(EntityDamageEvent.DamageCause.FLY_INTO_WALL)))
                {
                    event.setCancelled(true);
                    player.setMetadata("IgnoreFallDamage", new FixedMetadataValue(CityCraftCommander.getPlugin(CityCraftCommander.class), false));
                }
            }
        }
    }
}
