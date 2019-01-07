package info.citycraft.ccc.command;

import info.citycraft.ccc.CityCraftCommander;
import info.citycraft.ccc.enchantment.CCEnchantment;
import info.citycraft.ccc.enchantment.CustomEnchantment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandCCEnchant implements CommandExecutor {

    private CCEnchantment enchant = new CCEnchantment(CityCraftCommander.getInstance());


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        int level;

        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            if(args.length == 2)
            {
                try{
                    level = Integer.parseInt(args[1]);
                }catch (NumberFormatException e) {
                    return false;
                }

                for(CustomEnchantment c : enchant.getEnchantments())
                {
                    if(c.getKey().getKey().equals(args[0]))
                    {
                        enchant.applyCustomEnchantment(player.getInventory().getItemInMainHand(), c.getEnchantment(), level);
                        return true;
                    }
                }
            }else return false;
        } else return false;



    return true;
    }
}
