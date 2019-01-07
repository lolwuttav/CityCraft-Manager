package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalMeleeAttack;

public class AIAttackMelee extends PathfinderGoalMeleeAttack {
    private final CCEntity ridable;

    public AIAttackMelee(CCEntity ridable, double speed, boolean longMemory) {
        super((EntityCreature) ridable, speed, longMemory);
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
