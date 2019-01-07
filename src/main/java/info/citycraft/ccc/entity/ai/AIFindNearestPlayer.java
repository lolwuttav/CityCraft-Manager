package info.citycraft.ccc.entity.ai;

import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.AttributeInstance;
import net.minecraft.server.v1_13_R2.Entity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.EntityHuman;
import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.EntityLiving;
import net.minecraft.server.v1_13_R2.EntityPlayer;
import net.minecraft.server.v1_13_R2.GenericAttributes;
import net.minecraft.server.v1_13_R2.PathfinderGoal;
import net.minecraft.server.v1_13_R2.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_13_R2.PathfinderGoalTarget;
import net.minecraft.server.v1_13_R2.ScoreboardTeamBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.List;
import java.util.function.Predicate;

public class AIFindNearestPlayer extends PathfinderGoal {
    private static final Logger LOGGER = LogManager.getLogger();
    private final CCEntity ridable;
    private final EntityInsentient entity;
    private final Predicate<Entity> predicate;
    private final PathfinderGoalNearestAttackableTarget.DistanceComparator sorter;
    private EntityLiving target;

    public AIFindNearestPlayer(CCEntity ridable) {
        this.entity = (EntityInsentient) ridable;
        this.ridable = ridable;
        if (entity instanceof EntityCreature) {
            LOGGER.warn("Use NearestAttackableTargetGoal.class for PathfinderMob mobs!");
        }
        sorter = new PathfinderGoalNearestAttackableTarget.DistanceComparator(entity);
        predicate = (target) -> {
            if (!(target instanceof EntityHuman)) {
                return false;
            } else if (((EntityHuman) target).abilities.isInvulnerable) {
                return false;
            } else {
                double range = maxTargetRange();
                if (target.isSneaking()) {
                    range *= (double) 0.8F;
                }
                if (target.isInvisible()) {
                    float f = ((EntityHuman) target).dk(); // getArmorVisibility
                    if (f < 0.1F) {
                        f = 0.1F;
                    }
                    range *= (double) (0.7F * f);
                }
                return (double) target.g(entity) <= range && PathfinderGoalTarget.a(entity, (EntityLiving) target, false, true);
            }
        };
    }

    // shouldExecute
    @Override
    public boolean a() {
        double range = maxTargetRange();
        List<EntityHuman> list = entity.world.a(EntityHuman.class, entity.getBoundingBox().grow(range, 4.0D, range), predicate);
        if (list.isEmpty()) {
            return false;
        }
        list.sort(sorter);
        target = list.get(0);
        return true;
    }

    // shouldContinueExecuting
    @Override
    public boolean b() {
        EntityLiving target = entity.getGoalTarget();
        if (target == null || !target.isAlive() || (target instanceof EntityHuman && ((EntityHuman) target).abilities.isInvulnerable)) {
            return false;
        }
        ScoreboardTeamBase team = entity.be();
        if (team != null && team == target.be()) {
            return false;
        }
        double range = maxTargetRange();
        return entity.h(target) <= range * range && (!(target instanceof EntityPlayer) || !((EntityPlayer) target).playerInteractManager.isCreative());
    }

    // startExecuting
    @Override
    public void c() {
        entity.setGoalTarget(target, EntityTargetEvent.TargetReason.CLOSEST_PLAYER, true);
        super.c();
    }

    // resetTask
    @Override
    public void d() {
        entity.setGoalTarget(null);
        super.c();
    }

    private double maxTargetRange() {
        AttributeInstance range = this.entity.getAttributeInstance(GenericAttributes.FOLLOW_RANGE);
        return range == null ? 16.0D : range.getValue();
    }
}
