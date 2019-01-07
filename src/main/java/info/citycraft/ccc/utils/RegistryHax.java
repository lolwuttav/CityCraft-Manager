package info.citycraft.ccc.utils;

import com.mojang.datafixers.types.Type;
import info.citycraft.ccc.entity.CCEntity;
import net.minecraft.server.v1_13_R2.*;
import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;

public class RegistryHax {
    private static Field entityClass;
    private static Field entityFunction;
    private static Method enchantmentMethod;
    private static Method biomebase_addSpawn;



    static {
        try {
            entityClass = EntityTypes.class.getDeclaredField("aS");
            entityClass.setAccessible(true);
            entityFunction = EntityTypes.class.getDeclaredField("aT");
            entityFunction.setAccessible(true);

            enchantmentMethod = Enchantment.class.getDeclaredMethod("a", String.class, Enchantment.class);
            enchantmentMethod.setAccessible(true);

            biomebase_addSpawn = BiomeBase.class.getDeclaredMethod("a", EnumCreatureType.class, BiomeBase.BiomeMeta.class);
            biomebase_addSpawn.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException ignore) {
        }
    }

    public static void injectNewEntityTypes(String name, String extend_from, Class<? extends Entity> clazz, Function<? super World, ? extends Entity> function) {
        Map<Object, Type<?>> dataTypes = (Map<Object, Type<?>>) DataConverterRegistry.a().getSchema(15190).findChoiceType(DataConverterTypes.n).types();
        dataTypes.put("minecraft:" + name, dataTypes.get("minecraft:" + extend_from));
        EntityTypes.a(name, EntityTypes.a.a(clazz, function));
        Logger.info("Successfully injected new entity: &a" + name);
    }

    public static boolean injectReplacementEntityTypes(EntityTypes<?> entityTypes, Class<? extends CCEntity> clazz, Function<? super World, ? extends CCEntity> function) {
        MinecraftKey key = IRegistry.ENTITY_TYPE.getKey(entityTypes);
        try {
            entityClass.set(entityTypes, clazz);
            entityFunction.set(entityTypes, function);
        } catch (IllegalAccessException ignore) {
            return false;
        }
        IRegistry.ENTITY_TYPE.a(IRegistry.ENTITY_TYPE.a(entityTypes), key, entityTypes);
        return true;
    }


/*
    public static void addMobsToBiomes() {
        if (Config.GIANT_ENABLED && RidableGiant.CONFIG.SPAWN_NATURALLY) {
            if (RidableGiant.CONFIG.SPAWN_BIOMES.isEmpty()) {
                Logger.warn("Giant is configured to spawn naturally in biomes, but no biomes are set!");
            } else {
                Logger.info("Adding Giant to spawn naturally in biomes");
                RidableGiant.CONFIG.SPAWN_BIOMES.forEach(data -> injectSpawn(data, EntityTypes.GIANT));
            }
        }
            if (RidableIllusioner.CONFIG.SPAWN_BIOMES.isEmpty()) {
                Logger.warn("Illusioner is configured to spawn naturally in biomes, but no biomes are set!");
            } else {
                Logger.info("Adding Illusioner to spawn naturally in biomes");
                RidableIllusioner.CONFIG.SPAWN_BIOMES.forEach(data -> injectSpawn(data, EntityTypes.ILLUSIONER));
            }
        }
*/

/*
    private static void injectSpawn(BiomeData data, EntityTypes<? extends EntityInsentient> type) {
        Logger.debug("- " + data.getBiome());
        BiomeBase biome = IRegistry.BIOME.get(new MinecraftKey(data.getBiome()));
        if (biome != null) {
            try {
                biomebase_addSpawn.invoke(biome, EnumCreatureType.MONSTER, new BiomeBase.BiomeMeta(type, data.getWeight(), data.getMin(), data.getMax()));
            } catch (IllegalAccessException | InvocationTargetException ignore) {
            }
        } else {
            Logger.error("Could not find biome named &e" + data.getBiome());
        }
    }
*/
}