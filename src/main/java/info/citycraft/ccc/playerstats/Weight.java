package info.citycraft.ccc.playerstats;

import info.citycraft.ccc.CityCraftCommander;
import info.citycraft.ccc.utils.Config;
import net.minecraft.server.v1_13_R2.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class Weight implements Listener {

    CityCraftCommander ccc = CityCraftCommander.getPlugin(CityCraftCommander.class);
    private int maxWeight = 2700;
    private double multiplier = 1.4;
    private Random random;

    Collection<PotionEffect> potionEffects;



    @EventHandler
    public void playerLogin(PlayerLoginEvent event)
    {}


    @EventHandler
    public void playerPickupItem(EntityPickupItemEvent event)
    {
        if(event.getEntityType() == EntityType.PLAYER)
        {
         Player player = (Player) event.getEntity();

         calculateWeight(player, event.getItem().getItemStack().getAmount());
        }
    }

    @EventHandler
    public void playerDropItem(PlayerDropItemEvent event)
    {
        calculateWeight(event.getPlayer(), 0);
    }

    @EventHandler
    public void playerMove(PlayerMoveEvent event)
    {
        random = new Random();

        if(random.nextInt(5) == 0) {
            Player player = event.getPlayer();
            Config config = new Config(ccc, "player.yml");
            int weight = config.getInt(player.getUniqueId().toString() + ".playerstats");
            if (weight > maxWeight) {
                playerOverweight(player);
            }
        }

    }

    @EventHandler
    public void playerInventoryChange(InventoryClickEvent event)
    {
        calculateWeight((Player) event.getWhoClicked(), 0);
    }


    //Calculate playerstats

    private int getItemWeight(ItemStack item)
    {
        return (int)((double) item.getAmount() * multiplier);
    }

    private void playerOverweight(Player player)
    {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1), true);
        player.spawnParticle(Particle.CLOUD, player.getLocation().getX(), player.getLocation().getY() + 0.1, player.getLocation().getZ(), 0);
    }

    private void calculateWeight(Player p, int extra)
    {

        EntityPlayer player = ((CraftPlayer) p).getHandle();
        Inventory playerInventory = p.getInventory();
        int weight = extra;

        for(ItemStack i : playerInventory)
        {
            if (i != null && i.getType() != Material.AIR) {
                weight += getItemWeight(i);
            }
        }

        Config config = new Config(ccc, "player.yml");
        config.set(player.getUniqueID().toString() + ".playerstats", weight);
        p.sendMessage(weight + "/" + maxWeight);
        config.save();
    }

    @Deprecated
    public void oneTimeUse(){
        ArrayList<String> list = new ArrayList<>();
        Config config = new Config(ccc, "items.yml");
        for (Material material : Material.values()) {
            list.add(material.name());
            config.set(material.name(),0);
            Bukkit.getServer().broadcastMessage(material.name());
        }
        config.save();
    }

}
