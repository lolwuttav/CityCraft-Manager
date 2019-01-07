package info.citycraft.ccc.entity.ai;

import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalMoveTowardsRestriction;
import info.citycraft.ccc.entity.CCEntity;

public class AIMoveTowardsRestriction extends PathfinderGoalMoveTowardsRestriction {
    private final CCEntity ridable;

    public AIMoveTowardsRestriction(CCEntity ridable, double speed) {
        super((EntityCreature) ridable, speed);
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
