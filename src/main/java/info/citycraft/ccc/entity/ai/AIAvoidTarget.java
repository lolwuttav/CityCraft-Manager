package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.Entity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.IEntitySelector;
import net.minecraft.server.v1_13_R2.PathfinderGoalAvoidTarget;

import java.util.function.Predicate;

public class AIAvoidTarget<T extends Entity> extends PathfinderGoalAvoidTarget<T> {
    private final CCEntity ridable;

    public AIAvoidTarget(CCEntity ridable, Class<T> targetClass, float distance, double farSpeed, double nearSpeed) {
        this(ridable, targetClass, (var0) -> true, distance, farSpeed, nearSpeed, IEntitySelector.e);
    }

    public AIAvoidTarget(CCEntity ridable, Class<T> targetClass, float distance, double farSpeed, double nearSpeed, Predicate<Entity> var8) {
        this(ridable, targetClass, (var0) -> true, distance, farSpeed, nearSpeed, var8);
    }

    public AIAvoidTarget(CCEntity ridable, Class<T> targetClass, Predicate<? super Entity> avoidSelector, float distance, double farSpeed, double nearSpeed, Predicate<Entity> entitySelector) {
        super((EntityCreature) ridable, targetClass, avoidSelector, distance, farSpeed, nearSpeed, entitySelector);
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
