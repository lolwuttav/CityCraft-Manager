package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalHurtByTarget;

public class AIHurtByTarget extends PathfinderGoalHurtByTarget {
    private final CCEntity ridable;

    public AIHurtByTarget(CCEntity ridable, boolean flag, Class<?>... aclass) {
        super((EntityCreature) ridable, flag, aclass);
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
