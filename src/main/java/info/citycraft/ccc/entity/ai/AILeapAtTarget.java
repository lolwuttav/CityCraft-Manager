package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.PathfinderGoalLeapAtTarget;

public class AILeapAtTarget extends PathfinderGoalLeapAtTarget {
    private final CCEntity ridable;

    public AILeapAtTarget(CCEntity ridable, float motion) {
        super((EntityInsentient) ridable, motion);
        this.ridable = ridable;
    }

    // shouldExecute
    @Override
    public boolean a() {

        return super.a();
    }

    // shouldContinueExecuting
    @Override
    public boolean b() {

        return super.b();
    }
}
