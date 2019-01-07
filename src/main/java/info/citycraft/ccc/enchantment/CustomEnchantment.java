package info.citycraft.ccc.enchantment;

import info.citycraft.ccc.CityCraftCommander;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class CustomEnchantment extends Enchantment implements Listener {

    CityCraftCommander plugin;


    public CustomEnchantment(NamespacedKey id) {
        super(id);
    }

    public CustomEnchantment getEnchantment()
    {
        return this;
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();

            ItemStack mainhand = player.getInventory().getItemInMainHand();



            if (hasEnchant(mainhand, getKey())) {
                player.getWorld().createExplosion(event.getEntity().getLocation(), 2, false);
            }
        }
    }

    public static boolean hasEnchant(ItemStack item, NamespacedKey name) {
        for (Enchantment ench : item.getEnchantments().keySet()) {
            if (ench.getKey().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack arg0) {
        return true;
    }

    @Override
    public boolean conflictsWith(Enchantment arg0) {
        return false;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public String getName() {
        return "Explosive Touch";
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }
}
