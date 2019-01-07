package info.citycraft.ccc.entity.ai;

import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalMoveTowardsTarget;
import info.citycraft.ccc.entity.CCEntity;

public class AIMoveTowardsTarget extends PathfinderGoalMoveTowardsTarget {
    private final CCEntity ridable;

    public AIMoveTowardsTarget(CCEntity ridable, double speed, float targetMaxDistance) {
        super((EntityCreature) ridable, speed, targetMaxDistance);
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
