package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.AttributeInstance;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.EntityLiving;
import net.minecraft.server.v1_13_R2.EntityPlayer;
import net.minecraft.server.v1_13_R2.GenericAttributes;
import net.minecraft.server.v1_13_R2.PathfinderGoal;
import net.minecraft.server.v1_13_R2.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_13_R2.PathfinderGoalTarget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.List;
import java.util.function.Predicate;

public class AIFindNearestEntity extends PathfinderGoal {
    private static final Logger LOGGER = LogManager.getLogger();
    private final CCEntity ridable;
    private final EntityInsentient entity;
    private final Predicate<EntityLiving> predicate;
    private final PathfinderGoalNearestAttackableTarget.DistanceComparator sorter;
    private EntityLiving target;
    private final Class<? extends EntityLiving> targetClass;

    public AIFindNearestEntity(CCEntity ridable, Class<? extends EntityLiving> targetClass) {
        this.ridable = ridable;
        this.entity = (EntityInsentient) ridable;
        this.targetClass = targetClass;
        if (entity instanceof EntityCreature) {
            AIFindNearestEntity.LOGGER.warn("Use NearestAttackableTargetGoal.class for PathfinderMob mobs!");
        }
        sorter = new PathfinderGoalNearestAttackableTarget.DistanceComparator(entity);
        predicate = (target) -> {
            double range = maxTargetRange();
            if (target.isSneaking()) {
                range *= (double) 0.8F;
            }
            return !target.isInvisible() && (double) target.g(entity) <= range && PathfinderGoalTarget.a(entity, target, false, true);
        };
    }

    // shouldExecute
    @Override
    public boolean a() {
        double range = maxTargetRange();
        List list = entity.world.a(targetClass, entity.getBoundingBox().grow(range, 4.0D, range), predicate);
        if (list.isEmpty()) {
            return false;
        }
        list.sort(sorter);
        target = (EntityLiving) list.get(0);
        return true;
    }

    // shouldContinueExecuting
    @Override
    public boolean b() {
        EntityLiving target = entity.getGoalTarget();
        if (target == null || !target.isAlive()) {
            return false;
        }
        double range = maxTargetRange();
        return entity.h(target) <= range * range && (!(target instanceof EntityPlayer) || !((EntityPlayer) target).playerInteractManager.isCreative());
    }

    // startExecuting
    @Override
    public void c() {
        entity.setGoalTarget(target, EntityTargetEvent.TargetReason.CLOSEST_ENTITY, true);
        super.c();
    }

    // resetTask
    @Override
    public void d() {
        entity.setGoalTarget(null);
        super.c();
    }

    protected double maxTargetRange() {
        AttributeInstance range = entity.getAttributeInstance(GenericAttributes.FOLLOW_RANGE);
        return range == null ? 16.0D : range.getValue();
    }
}
