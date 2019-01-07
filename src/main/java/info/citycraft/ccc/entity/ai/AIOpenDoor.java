package info.citycraft.ccc.entity.ai;

import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.PathfinderGoalOpenDoor;
import info.citycraft.ccc.entity.CCEntity;

public class AIOpenDoor extends PathfinderGoalOpenDoor {
    private final CCEntity ridable;

    public AIOpenDoor(CCEntity ridable, boolean shouldClose) {
        super((EntityInsentient) ridable, shouldClose);
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
