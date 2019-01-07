package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.IRangedEntity;
import net.minecraft.server.v1_13_R2.PathfinderGoalArrowAttack;

public class AIAttackRanged extends PathfinderGoalArrowAttack {
    private final CCEntity ridable;

    public AIAttackRanged(CCEntity ridable, double moveSpeed, int maxAttackTime, float maxAttackDistance) {
        super((IRangedEntity) ridable, moveSpeed, maxAttackTime, maxAttackDistance);
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
