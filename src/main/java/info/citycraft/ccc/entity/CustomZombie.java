package info.citycraft.ccc.entity;

import info.citycraft.ccc.CityCraftCommander;
import info.citycraft.ccc.entity.ai.*;
import info.citycraft.ccc.entity.ai.zombie.AIZombieAttack;
import info.citycraft.ccc.entity.ai.zombie.AIZombieBreakDoor;
import net.minecraft.server.v1_13_R2.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.lang.reflect.Field;

public class CustomZombie extends EntityZombie implements CCEntity {



    private static Field isBreakDoorsTaskSet;
    CityCraftCommander plugin = CityCraftCommander.getPlugin(CityCraftCommander.class);

    static {
        try {
            isBreakDoorsTaskSet = EntityZombie.class.getDeclaredField("bH");
            isBreakDoorsTaskSet.setAccessible(true);
        } catch (NoSuchFieldException ignore) {
        }
    }

    public static void setBreakDoorsTask(Entity entity, boolean enabled) {
        try {
            isBreakDoorsTaskSet.setBoolean(entity, enabled);
        } catch (IllegalAccessException ignore) {
        }
    }

    private final AIZombieBreakDoor breakDoorAI;

    public CustomZombie(World world) {
        super(world);
        breakDoorAI = new AIZombieBreakDoor(this);
    }


    // canDespawn
    @Override
    public boolean isTypeNotPersistent() {
        return !hasCustomName() && !isLeashed();
    }

    // initAI - override vanilla AI
    @Override
    protected void n() {
        // from EntityZombie
        goalSelector.a(5, new AIMoveTowardsRestriction(this, 1.0D));
        goalSelector.a(8, new AIWatchClosest(this, EntityZombie.class, 8.0F));
        goalSelector.a(8, new AILookIdle(this));

        // also from EntityZombie
        goalSelector.a(2, new AIZombieAttack(this, 1.0D, false));
        goalSelector.a(6, new AIMoveThroughVillage(this, 1.0D, false));
        goalSelector.a(7, new AIWanderAvoidWater(this, 1.0D));
        targetSelector.a(1, new AIHurtByTarget(this, true, EntityPigZombie.class));
        targetSelector.a(2, new AIAttackNearest<>(this, EntityZombie.class, false));
        targetSelector.a(5, new AIAttackNearest<>(this, EntityTurtle.class, 10, true, false, EntityTurtle.bC));
    }




    // setBreakDoorsAITask
    @Override
    public void t(boolean enabled) {
        if (dz()) { // canBreakDoors
            if (dH() != enabled) {
                setBreakDoorsTask(this, enabled);
                ((Navigation) this.getNavigation()).a(enabled); // setBreakDoors
                if (enabled) {
                    goalSelector.a(1, breakDoorAI); // addTask
                } else {
                    goalSelector.a(breakDoorAI); // removeTask
                }
            }
        } else if (dH()) {
            goalSelector.a(breakDoorAI); // removeTask
            setBreakDoorsTask(this, false);
        }
    }

    @Override
    protected void mobTick() {
        super.mobTick();
    }

    // processInteract
    @Override
    public boolean a(EntityHuman player, EnumHand hand) {
        return super.a(player, hand);
    }

    @Override
    public CCEntity getType() {
        return null;
    }

    @Override
    public void reloadAttributes() {

    }

    @Override
    public boolean onSpacebar() {
        return false;
    }

    @Override
    public boolean onClick(org.bukkit.entity.Entity entity, EnumHand hand) {
        return false;
    }

    @Override
    public boolean onClick(Block block, BlockFace blockFace, EnumHand hand) {
        return false;
    }

    @Override
    public boolean onClick(EnumHand hand) {
        return false;
    }

    @Override
    public boolean onClick() {
        return false;
    }
}
