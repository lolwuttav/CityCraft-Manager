package info.citycraft.ccc.utils;

import info.citycraft.ccc.CityCraftCommander;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

public class PlayerGlide {

    CityCraftCommander ccc;
    Player p;
    IntUtils intUtils;

    public void launchPlayer(Player player, Vector v)
    {
        p = player;
        p.setVelocity(v);
        p.setMetadata("CommandGliding", new FixedMetadataValue(CityCraftCommander.getPlugin(CityCraftCommander.class), true));
        p.setMetadata("IgnoreFallDamage", new FixedMetadataValue(CityCraftCommander.getPlugin(CityCraftCommander.class), true));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CityCraftCommander.getPlugin(CityCraftCommander.class), () -> p.setGliding(true), 20);

    }

}
