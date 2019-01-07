package info.citycraft.ccc.listener;

import info.citycraft.ccc.CityCraftCommander;
import info.citycraft.ccc.utils.Config;
import info.citycraft.ccc.utils.IntUtils;
import info.citycraft.ccc.utils.PlayerGlide;
import info.citycraft.ccc.playerstats.Weight;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class SignListener implements Listener {

    IntUtils intUtils;
    int launchHeight;
    Material material;
    Player player;
    PlayerGlide pg = new PlayerGlide();
    Config config;
    Weight weight = new Weight();
    CityCraftCommander ccc = CityCraftCommander.getPlugin(CityCraftCommander.class);

    @EventHandler
    public void onSignChange(SignChangeEvent event)
    {
         if(event.getPlayer() != null ) {

             player = (Player) event.getPlayer();

             if (player.isOp()) {
                 if (event.getLine(1).equals("[Launch]")) {
                     if (intUtils.isInt(event.getLine(2))) launchHeight = Integer.parseInt(event.getLine(2));

                     config = new Config(ccc, "signs.yml");

                     for(int i = 0; i < 10000; i++)
                     {
                        if(config.isSet("signs.sign" + i))
                        {}else {
                            config.set("signs.sign" + i + ".x", event.getBlock().getLocation().getX());
                            config.set("signs.sign" + i + ".y", event.getBlock().getLocation().getY());
                            config.set("signs.sign" + i + ".z", event.getBlock().getLocation().getZ());
                            config.save();
                            break;
                        }
                     }
                     //TODO: ADD LINE FOR NUMBER OF ROCKETS TO GIVE PLAYER, AND GIVE THEM TO THE PLAYER
                     //TODO: ADD DELAY, POLISH, AND CANCEL LAUNCH IF PLAYER ENTERS COMMAND, OR MOVES EXCESSIVELY
                 }
             }
         }
    }


    @EventHandler
    public void onSignInteract(PlayerInteractEvent event)
    {

        if(event.getPlayer() != null) player = event.getPlayer();

        if(event.getClickedBlock() != null)
        {
            material = event.getClickedBlock().getType();
        }

    if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
    {
        if (material.equals(Material.WALL_SIGN) || material.equals(Material.LEGACY_WALL_SIGN)) {
            Sign sign = (Sign) event.getClickedBlock().getState();
            config = new Config(ccc, "signs.yml");

            for(int i = 0; i < 10000; i++) {

                if(!config.isSet("signs.sign" + i)) {
                    event.getPlayer().sendMessage(ChatColor.RED + "UNREGISTERED SIGN");
                    break;
                }
                if(config.getInt("signs.sign" + i + ".x") == event.getClickedBlock().getLocation().getX()) {
                    if (config.getInt("signs.sign" + i + ".y") == event.getClickedBlock().getLocation().getY()) {
                        if (config.getInt("signs.sign" + i + ".z") == event.getClickedBlock().getLocation().getZ()) {
                            pg.launchPlayer(player, new Vector(0, Integer.parseInt(sign.getLine(2)), 0));
                            break;
                        }
                    }
                }
            }
            config.save();

            }
        }
    }
    }


