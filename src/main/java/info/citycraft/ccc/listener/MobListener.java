package info.citycraft.ccc.listener;

import info.citycraft.ccc.CityCraftCommander;
import net.minecraft.server.v1_13_R2.EntityPlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.Random;

public class MobListener implements Listener {

    private Random random;

    @EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event)
    {
        //Blaze thorns damage
        if(event.getEntityType().equals(EntityType.BLAZE))
        {
            if(event.getDamager() instanceof Player)
            {
                Player player = (Player) event.getDamager();
                damagePlayerWithThorns(player, 1);
            }
        }
        //Multiply player critical hit damage
        if(event.getEntity() instanceof LivingEntity)
        {
            if(event.getDamager() instanceof Player) {

                Player player = (Player) event.getDamager();

                if (isCritical(player))
                {
                    if (!event.getEntityType().equals(EntityType.PLAYER)) event.setDamage(event.getDamage() * 1.25);
                }
            }
        }
    }



    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event){

        random = new Random();


        event.getEntity().setMetadata("hpModified", new FixedMetadataValue(CityCraftCommander.getPlugin(CityCraftCommander.class), false));

            LivingEntity entity = (event.getEntity());

            if(!entity.getType().equals(EntityType.WOLF) && !(entity instanceof Boss))
            {
                entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue((entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue() * 1.5));
                //entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue((entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue() * (random.nextInt(3 - 1 + 1) + 1)));
                entity.setHealth(entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            }

            //Set creeper powered on spawn
        if(entity.getType().equals(EntityType.CREEPER) && random.nextInt(40) == 0)
        {
            Creeper creeper = (Creeper) event.getEntity();
            creeper.setPowered(true);
            entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue((entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue() * 1.5));
        }
    }

    @EventHandler
    public void creeperPoweredEvent(CreeperPowerEvent event)
    {
        event.getEntity().setExplosionRadius(event.getEntity().getExplosionRadius() + 1);
    }

  /*  @EventHandler
    public void onEntityTarget(EntityTargetEvent event)
    {
        double[] multiplier = {1, 1, 1, 1};
        double finalMultiplier = 0;
        boolean modified = false;

        Entity entity = event.getEntity();
        EntityType type = entity.getType();

        if(!type.equals(EntityType.WOLF) && entity instanceof LivingEntity && !type.equals(EntityType.PLAYER)) {
        for (MetadataValue s : entity.getMetadata("hpModified")) modified = s.asBoolean();

        //Reset multiplier
        for(int i = 0; i < multiplier.length; i++) multiplier[i] = 1;

        if(!modified) {
            if (event.getEntity() != null) {

                LivingEntity livingEntity = (LivingEntity) event.getEntity();
                double maxHealth = livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
                double knockbackResistance = livingEntity.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).getBaseValue();

                entity.setMetadata("hpModified", new FixedMetadataValue(CityCraftCommander.getPlugin(CityCraftCommander.class), true));

                if (event.getTarget() != null) {
                    if (event.getTarget().getType().equals(EntityType.PLAYER)) {

                        Player player = (Player) event.getTarget();
                        PlayerInventory inventory = player.getInventory();
                        ItemStack[] armor = inventory.getArmorContents();

                       // for (ItemStack i : armor) {
                        for (int i = 0; i < armor.length - 1; i++) {
                                String[] armorType = armor[i].getType().toString().split("_");
                                switch (armorType[0]) {
                                    case "LEATHER":
                                        multiplier[i] *= 1.1;
                                        break;
                                    case "CHAINMAIL":
                                        multiplier[i] *= 1.3;
                                        break;
                                    case "IRON":
                                        multiplier[i] *= 1.5;
                                        break;
                                    case "DIAMOND":
                                        multiplier[i] *= 2;
                                        break;
                                    default:
                                        multiplier[i] *= 1;
                                        break;
                                }

                            for (int counter = 1; counter < multiplier.length; counter++) {
                                if (multiplier[counter] > finalMultiplier) {
                                    finalMultiplier = multiplier[counter];
                                }
                            }
                        }

                        setMaxHealth(livingEntity,maxHealth * finalMultiplier);
                        setKnockbackResistance(livingEntity,knockbackResistance * finalMultiplier);
                        livingEntity.setHealth(livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
            }
            }
            }
        }*/

        public void damagePlayerWithThorns(Player player, int level){

            EntityPlayer nmsPlayer = ((CraftPlayer) player).getHandle() ;
            player.damage(thornsDamage(level, nmsPlayer.getRandom()));
    }

    //TODO: MOVE TO UTIL CLASS

    public void setMaxHealth(LivingEntity entity, double i)
    {
        entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(i);
    }

    public void setKnockbackResistance(LivingEntity entity, double i)
    {
        entity.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(i);
    }

    public void setArmorLevel(LivingEntity entity, double i)
    {
        entity.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(i);
    }

    public void setArmorToughness(LivingEntity entity, double i)
    {
        entity.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(i);
    }

    public static int thornsDamage(int i, Random random)
    {
        return i > 10 ? i - 10 : 1 + random.nextInt(4);
    }

    public boolean isCritical(Player p)
    {
        return (p.getVelocity().getY() + 0.0784000015258789) <= 0;
    }
}
