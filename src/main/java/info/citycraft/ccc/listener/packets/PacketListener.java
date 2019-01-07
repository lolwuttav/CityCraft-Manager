package info.citycraft.ccc.listener.packets;

import info.citycraft.ccc.CityCraftCommander;
import io.netty.channel.*;
import net.minecraft.server.v1_13_R2.PacketPlayInEntityAction;
import net.minecraft.server.v1_13_R2.PacketPlayOutBed;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PacketListener implements Listener {



    Channel channel;
    Player player1;
    CityCraftCommander ccc;

    @EventHandler
    public void onjoin(PlayerJoinEvent event){
        injectPlayer(event.getPlayer());
    }

    @EventHandler
    public void onleave(PlayerQuitEvent event){
        removePlayer(event.getPlayer());
    }
    private void removePlayer(Player player) {

        player1 = player;

        channel = ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel;
        channel.eventLoop().submit(() -> {
            channel.pipeline().remove(player1.getName());
            return null;
        });
    }

    private void injectPlayer(Player player) {
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {

            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {

                if(ccc.logPacket) {
                    Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "PACKET READ: " + ChatColor.RED + packet.toString());
                }
                super.channelRead(channelHandlerContext, packet);
            }

            @Override
            public void write(ChannelHandlerContext channelHandlerContext, Object packet, ChannelPromise channelPromise) throws Exception {

                if(ccc.logPacket) {
                    Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "PACKET WRITE: " + ChatColor.GREEN + packet.toString());
                }



                if(packet instanceof PacketPlayInEntityAction){
                    PacketPlayInEntityAction packetPlayInEntityAction = (PacketPlayInEntityAction) packet;
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "PACKET DID A HAPPEN: " + ChatColor.GREEN + packetPlayInEntityAction.toString());
                }

                super.write(channelHandlerContext, packet, channelPromise);
            }


        };

        ChannelPipeline pipeline = ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline();
        pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);

    }

}
