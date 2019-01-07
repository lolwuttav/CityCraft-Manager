package info.citycraft.ccc.enchantment;

import info.citycraft.ccc.CityCraftCommander;
import info.citycraft.ccc.utils.Logger;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class CCEnchantment {

    private CityCraftCommander plugin;


    public static List<CustomEnchantment> enchantments = new ArrayList<>();

    public CustomEnchantment ench;

    public CCEnchantment(CityCraftCommander plugin) {
        this.plugin = plugin;
        ench = new CustomEnchantment(new NamespacedKey(plugin, "explosive"));
    }

    public List<CustomEnchantment> getEnchantments() {
        return enchantments;
    }

    public void applyCustomEnchantment(ItemStack item, CustomEnchantment enchantment, int level) {
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + enchantment.getName() + " " + integerToRomanNumeral(level));
        meta.setLore(lore);
        item.setItemMeta(meta);
        item.addUnsafeEnchantment(enchantment, level);
    }

    public void loadEnchantments() {

        enchantments.add(ench);

        plugin.getServer().getPluginManager().registerEvents(ench, plugin);

        try {
            try {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                plugin.getLogger().log(Level.INFO, f.toString());
                f.setAccessible(true);
                f.set(null, true);
                plugin.getLogger().log(Level.INFO, f.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                for (Enchantment e : enchantments) {
                    Enchantment.registerEnchantment(e);
                    Logger.info("Enchantment registered: " + ChatColor.YELLOW + e.getKey().getKey());
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String integerToRomanNumeral(int input) {
        return String.valueOf(new char[input]).replace('\0', 'I')
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }
}
