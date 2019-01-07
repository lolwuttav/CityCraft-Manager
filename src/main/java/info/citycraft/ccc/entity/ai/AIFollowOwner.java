package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityTameableAnimal;
import net.minecraft.server.v1_13_R2.PathfinderGoalFollowOwner;

public class AIFollowOwner extends PathfinderGoalFollowOwner {
    private final CCEntity ridable;

    public AIFollowOwner(CCEntity ridable, double speed, float minDistance, float maxDistance) {
        super((EntityTameableAnimal) ridable, speed, minDistance, maxDistance);
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
