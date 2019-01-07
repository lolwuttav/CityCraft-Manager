package info.citycraft.ccc.entity.ai.creeper;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.*;

public class AICreeperAttackTurtleEgg extends PathfinderGoalRemoveBlock {
    private final CCEntity ridable;

    public AICreeperAttackTurtleEgg(Block block, CCEntity ridable, double d0, int i) {
        super(block, (EntityCreature) ridable, d0, i);
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

    // playBreakingSound
    @Override
    public void a(GeneratorAccess generatoraccess, BlockPosition blockposition) {
        super.a();
    }

    // playBrokenSound
    @Override
    public void a(World world, BlockPosition blockposition) {
        world.a(null, blockposition, SoundEffects.ENTITY_TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + world.random.nextFloat() * 0.2F);
    }

    // getTargetDistanceSq
    @Override
    public double g() {
        return 1.3D;
    }
}

