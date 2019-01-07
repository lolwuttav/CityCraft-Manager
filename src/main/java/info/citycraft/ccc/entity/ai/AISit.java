package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityTameableAnimal;
import net.minecraft.server.v1_13_R2.PathfinderGoalSit;

public class AISit extends PathfinderGoalSit {
    private final CCEntity ridable;

    public AISit(CCEntity ridable) {
        super((EntityTameableAnimal) ridable);
        this.ridable = ridable;
    }

    // shouldExecute
    @Override
    public boolean a() {

        return super.a();
    }
}
