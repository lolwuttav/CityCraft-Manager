package info.citycraft.ccc.entity;

import net.minecraft.server.v1_13_R2.EnumHand;
import net.minecraft.server.v1_13_R2.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;

import java.util.Random;

public interface CCEntity {
    /**
     * Get the RidableType of this entity
     *
     * @return RidableType
     */
    Random random = new Random();
    CCEntity getType();

    default Random getRandom()
    {
        return random;
    }

    default World getWorld()
    {
     return this.getWorld();
    }

    /**
     * Reload the mob's attributes
     */
    void reloadAttributes();


    /**
     * This method is called when the spacebar is pressed by the current rider
     * <p>
     * This is used internally for triggering spacebar events other than jumping. It is advised to not use this method
     *
     * @return True if spacebar was handled
     */
    default boolean onSpacebar() {
        return false;
    }

    /**
     * This method is called when the current rider clicks on an entity
     * <p>
     * This is used internally for triggering click events on the creature. It is advised to not use this method
     *
     * @param entity The Entity clicked on
     * @param hand   Hand used to click
     * @return True if click was handled
     */
    default boolean onClick(Entity entity, EnumHand hand) {
        return false;
    }

    /**
     * This method is called when the current rider clicks on a block
     * <p>
     * This is used internally for triggering click events on the creature. It is advised to not use this method
     *
     * @param block     The Block clicked on
     * @param blockFace Face of black clicked
     * @param hand      Hand used to click
     * @return True if click was handled
     */
    default boolean onClick(Block block, BlockFace blockFace, EnumHand hand) {
        return false;
    }

    /**
     * This method is called when the current rider clicks in the air
     * <p>
     * This is used internally for triggering click events on the creature. It is advised to not use this method
     *
     * @param hand Hand used to click
     * @return True if click was handled
     */
    default boolean onClick(EnumHand hand) {
        return false;
    }

    default boolean onClick() {
        return false;
    }
}
