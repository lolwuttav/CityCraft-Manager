package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalRandomSwim;

public class AIWanderSwim extends PathfinderGoalRandomSwim {
    private final CCEntity ridable;

    public AIWanderSwim(CCEntity ridable, double speed) {
        this(ridable, speed, 120);
    }

    public AIWanderSwim(CCEntity ridable, double speed, int chance) {
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
