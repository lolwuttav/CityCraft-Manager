package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.PathfinderGoalTempt;
import net.minecraft.server.v1_13_R2.RecipeItemStack;

public class AITempt extends PathfinderGoalTempt {
    private final CCEntity ridable;

    public AITempt(CCEntity ridable, double speed, boolean scaredByPlayerMovement, RecipeItemStack temptItem) {
        super((EntityCreature) ridable, speed, scaredByPlayerMovement, temptItem);
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
