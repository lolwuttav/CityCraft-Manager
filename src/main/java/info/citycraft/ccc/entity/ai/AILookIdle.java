package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.CityCraftCommander;
import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.PathfinderGoalRandomLookaround;

public class AILookIdle extends PathfinderGoalRandomLookaround {
    private final CCEntity ridable;
    CityCraftCommander plugin = CityCraftCommander.getPlugin(CityCraftCommander.class);

    public AILookIdle(CCEntity ridable) {
        super((EntityInsentient) ridable);
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
