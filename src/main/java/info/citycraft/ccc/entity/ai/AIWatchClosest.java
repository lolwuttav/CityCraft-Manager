package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.Entity;
import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.PathfinderGoalLookAtPlayer;

public class AIWatchClosest extends PathfinderGoalLookAtPlayer {
    private final CCEntity ridable;

    public AIWatchClosest(CCEntity ridable, Class<? extends Entity> targetClass, float maxDistance) {
        this(ridable, targetClass, maxDistance, 0.02F);
    }

    public AIWatchClosest(CCEntity ridable, Class<? extends Entity> targetClass, float maxDistance, float chance) {
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
