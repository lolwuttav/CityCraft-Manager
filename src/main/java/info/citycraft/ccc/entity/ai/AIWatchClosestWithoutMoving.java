package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.Entity;
import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.PathfinderGoalInteract;

public class AIWatchClosestWithoutMoving extends PathfinderGoalInteract {
    private final CCEntity ridable;

    public AIWatchClosestWithoutMoving(CCEntity ridable, Class<? extends Entity> targetClass, float maxDistance, float chance) {
        super((EntityInsentient) ridable, targetClass, maxDistance, chance);
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
