package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalRandomStrollLand;

public class AIWanderAvoidWater extends PathfinderGoalRandomStrollLand {
    private final CCEntity ridable;

    public AIWanderAvoidWater(CCEntity ridable, double var2) {
        this(ridable, var2, 0.001F);
    }

    public AIWanderAvoidWater(CCEntity ridable, double speed, float probability) {
        super((EntityCreature) ridable, speed, probability);
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
