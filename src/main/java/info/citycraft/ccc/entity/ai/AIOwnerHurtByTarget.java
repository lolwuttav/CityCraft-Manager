package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityTameableAnimal;
import net.minecraft.server.v1_13_R2.PathfinderGoalOwnerHurtByTarget;

public class AIOwnerHurtByTarget extends PathfinderGoalOwnerHurtByTarget {
    private final CCEntity entity;

    public AIOwnerHurtByTarget(CCEntity entity) {
        super((EntityTameableAnimal) entity);
        this.entity = entity;
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
