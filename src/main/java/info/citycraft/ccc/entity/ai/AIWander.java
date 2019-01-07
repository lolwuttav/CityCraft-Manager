package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalRandomStroll;

public class AIWander extends PathfinderGoalRandomStroll {
    private final CCEntity ridable;

    public AIWander(CCEntity ridable, double speed) {
        this(ridable, speed, 120);
    }

    public AIWander(CCEntity ridable, double speed, int chance) {
        super((EntityCreature) ridable, speed, chance);
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
