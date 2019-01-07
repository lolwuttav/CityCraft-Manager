package info.citycraft.ccc.listener;

import net.minecraft.server.v1_13_R2.EntityPlayer;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.LeavesDecayEvent;

import java.util.Random;

public class LeafListener implements Listener {

    Random random;

    @EventHandler
    public void leafBlockBreak(BlockBreakEvent event)
    {
        if(event.getBlock().getBiome().equals(Biome.SWAMP) || event.getBlock().getBiome().equals(Biome.SWAMP_HILLS) || event.getBlock().getBiome().equals(Biome.RIVER) && event.getBlock().getType().toString().contains("LEAVES"))
        {
            World world = event.getBlock().getWorld();
            random = new Random();

            if(random.nextInt(200) == 0)
            {
                world.spawnEntity(event.getBlock().getLocation(), EntityType.SILVERFISH);
            }
        }
    }

    @EventHandler
    public void leafDecayEvent(LeavesDecayEvent event)
    {
        if(event.getBlock().getBiome().equals(Biome.SWAMP) || event.getBlock().getBiome().equals(Biome.SWAMP_HILLS) || event.getBlock().getBiome().equals(Biome.RIVER)) {

            World world = event.getBlock().getWorld();
            random = new Random();

            if (random.nextInt(200) == 0) {
                world.spawnEntity(event.getBlock().getLocation(), EntityType.SILVERFISH);
            }
        }
    }
}
