package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityAnimal;
import net.minecraft.server.v1_13_R2.PathfinderGoalFollowParent;

public class AIFollowParent extends PathfinderGoalFollowParent {
    private final CCEntity ridable;

    public AIFollowParent(CCEntity ridable, double speed) {
        super((EntityAnimal) ridable, speed);
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
