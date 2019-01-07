package info.citycraft.ccc.entity.ai.zombie;

import info.citycraft.ccc.CityCraftCommander;
import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityZombie;
import net.minecraft.server.v1_13_R2.PathfinderGoalZombieAttack;

public class AIZombieAttack extends PathfinderGoalZombieAttack {
    private CCEntity ridable;
    CityCraftCommander plugin = CityCraftCommander.getPlugin(CityCraftCommander.class);

    public AIZombieAttack(CCEntity ridable, double d0, boolean flag) {
        super((EntityZombie) ridable, d0, flag);
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
