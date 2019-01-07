package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityAnimal;
import net.minecraft.server.v1_13_R2.PathfinderGoalBreed;

public class AIBreed extends PathfinderGoalBreed {
    private final CCEntity ridable;

    public AIBreed(CCEntity ridable, double speed, Class<? extends EntityAnimal> targetClass) {
        super((EntityAnimal) ridable, speed, targetClass);
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
