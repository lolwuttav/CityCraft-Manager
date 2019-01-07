package info.citycraft.ccc;

import info.citycraft.ccc.command.CommandLaunch;
import info.citycraft.ccc.command.CommandCCEnchant;
import info.citycraft.ccc.entity.CustomZombie;
import info.citycraft.ccc.listener.*;
import info.citycraft.ccc.enchantment.CCEnchantment;
import info.citycraft.ccc.utils.Logger;
import info.citycraft.ccc.utils.RegistryHax;
import info.citycraft.ccc.playerstats.Weight;
import org.bukkit.plugin.java.JavaPlugin;

public class CityCraftCommander extends JavaPlugin{

    public static boolean logPacket = false;
    CCEnchantment enchantment = new CCEnchantment(this);
    private static CityCraftCommander instance;

    @Override
    public void onEnable()
    {
        this.instance = this;
        Logger.info(instance.getName());

        this.getCommand("launch").setExecutor(new CommandLaunch());
        this.getCommand("ccenchant").setExecutor(new CommandCCEnchant());


        getServer().getPluginManager().registerEvents(new EnderChestListener(), this);
        getServer().getPluginManager().registerEvents(new GlideListener(), this);
        getServer().getPluginManager().registerEvents(new SignListener(), this);
        getServer().getPluginManager().registerEvents(new SnowballListener(), this);
        getServer().getPluginManager().registerEvents(new MobListener(), this);
        getServer().getPluginManager().registerEvents(new ArrowListener(), this);
        getServer().getPluginManager().registerEvents(new LeafListener(), this);
        getServer().getPluginManager().registerEvents(new Weight(), this);

        RegistryHax.injectNewEntityTypes("test_zombie", "zombie", CustomZombie.class, CustomZombie::new);
        enchantment.loadEnchantments();
    }
    @Override
    public void onDisable() { }

    public static CityCraftCommander getInstance(){
        return instance;
    }

}
