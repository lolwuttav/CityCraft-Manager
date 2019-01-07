package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.EntityLiving;
import net.minecraft.server.v1_13_R2.PathfinderGoalNearestAttackableTarget;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class AIAttackNearest<T extends EntityLiving> extends PathfinderGoalNearestAttackableTarget<T> {
    private final CCEntity ridable;

    public AIAttackNearest(CCEntity ridable, Class<T> targetClass, boolean checkSight) {
        this(ridable, targetClass, checkSight, false);
    }

    public AIAttackNearest(CCEntity ridable, Class<T> targetClass, boolean checkSight, boolean onlyNearby) {
        this(ridable, targetClass, 10, checkSight, onlyNearby, null);
    }

    public AIAttackNearest(CCEntity ridable, Class<T> targetClass, int chance, boolean checkSight, boolean onlyNearby, @Nullable Predicate<? super T> predicate) {
        super((EntityCreature) ridable, targetClass, chance, checkSight, onlyNearby, predicate);
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
