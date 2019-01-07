package info.citycraft.ccc.entity.ai.zombie;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.PathfinderGoalBreakDoor;

public class AIZombieBreakDoor extends PathfinderGoalBreakDoor {
    private final CCEntity ccEntity;

    public AIZombieBreakDoor(CCEntity ccEntity) {
        super((EntityInsentient) ccEntity);
        this.ccEntity = ccEntity;
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
