package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityMonster;
import net.minecraft.server.v1_13_R2.IRangedEntity;
import net.minecraft.server.v1_13_R2.PathfinderGoalBowShoot;

public class AIShootBow<T extends EntityMonster & IRangedEntity> extends PathfinderGoalBowShoot<T> {
    private final CCEntity ridable;
    private final T entity;

    public AIShootBow(CCEntity ridable, double moveSpeedAmp, int attackCooldown, float maxAttackDistance) {
        super((T) ridable, moveSpeedAmp, attackCooldown, maxAttackDistance);
        this.ridable = ridable;
        this.entity = (T) ridable;
    }

    // shouldExecute
    @Override
    public boolean a() {
        return entity.getGoalTarget() != null && g(); // isBowInMainHand
    }

    // shouldContinueExecutin
    @Override
    public boolean b() {
        return (entity.getGoalTarget() != null || !entity.getNavigation().p()) && g(); // noPath isBowInMainHand
    }
}
