package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityLiving;
import net.minecraft.server.v1_13_R2.EntityTameableAnimal;
import net.minecraft.server.v1_13_R2.PathfinderGoalRandomTargetNonTamed;

import java.util.function.Predicate;

public class AITargetNonTamed<T extends EntityLiving> extends PathfinderGoalRandomTargetNonTamed<T> {
    private final CCEntity ridable;

    public AITargetNonTamed(CCEntity ridable, Class<T> targetClass, boolean checkSight, Predicate<? super T> predicate) {
        super((EntityTameableAnimal) ridable, targetClass, checkSight, predicate);
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
