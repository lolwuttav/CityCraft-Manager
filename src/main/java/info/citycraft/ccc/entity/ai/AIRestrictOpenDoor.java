package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalRestrictOpenDoor;

public class AIRestrictOpenDoor extends PathfinderGoalRestrictOpenDoor {
    private final CCEntity ridable;

    public AIRestrictOpenDoor(CCEntity ridable) {
        super((EntityCreature) ridable);
        this.ridable = ridable;
    }

    // shouldExecute
    @Override
    public boolean a() {

        return super.a();
    }

    // shouldContinueExecuting
    @Override
    public boolean b()
    {
        return super.b();
    }
}
