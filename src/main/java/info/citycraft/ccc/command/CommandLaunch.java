package info.citycraft.ccc.command;

import info.citycraft.ccc.utils.IntUtils;
import info.citycraft.ccc.utils.PlayerGlide;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;


public class CommandLaunch implements CommandExecutor {

    Player player;
    IntUtils intUtils;
    Vector launchSpeed = new Vector(0,0,0);
    PlayerGlide pg = new PlayerGlide();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender  instanceof Player) {

            player = (Player) sender;

            if(args.length != 0){
                if(intUtils.isInt(args[0])) {
                    launchSpeed.setY(Integer.parseInt(args[0]));
                }else{
                    return false;
                }
            }


            pg.launchPlayer(player, launchSpeed);

        }
        return true;
    }
}
