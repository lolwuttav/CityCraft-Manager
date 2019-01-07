package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalFleeSun;

public class AIFleeSun extends PathfinderGoalFleeSun {
    private final CCEntity ridable;

    public AIFleeSun(CCEntity ridable, double speed) {
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
