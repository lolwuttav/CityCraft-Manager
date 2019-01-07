package info.citycraft.ccc.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class EnderChestListener implements Listener {

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event)
    {
        Player player = (Player) event.getPlayer();

        if(event.getOffHandItem().getData().getItemType() == Material.LEGACY_ENDER_CHEST)
        {
            event.setCancelled(true);
            player.openInventory(player.getEnderChest());
            player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, SoundCategory.BLOCKS, 2,1);
        }

    }

}
