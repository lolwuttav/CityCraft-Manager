package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.PathfinderGoalFloat;

public class AISwim extends PathfinderGoalFloat {
    public AISwim(CCEntity ridable) {
        super((EntityInsentient) ridable);
    }
}
