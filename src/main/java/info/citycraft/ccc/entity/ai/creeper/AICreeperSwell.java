package info.citycraft.ccc.entity.ai.creeper;

import net.minecraft.server.v1_13_R2.EntityCreeper;
import net.minecraft.server.v1_13_R2.PathfinderGoalSwell;

public class AICreeperSwell extends PathfinderGoalSwell {
    public AICreeperSwell(EntityCreeper creeper) {
        super(creeper);
    }
}
