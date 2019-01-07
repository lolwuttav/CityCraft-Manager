package info.citycraft.ccc.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerTeleportListener implements Listener {

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event)
    {
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 2000, 5, false, true, true));
    }

}
