package eu.decentsoftware.holograms.nms.v1_10_R1;

import eu.decentsoftware.holograms.nms.api.DecentHologramsNmsException;
import org.bukkit.entity.EntityType;

import java.util.EnumMap;
import java.util.Map;

final class EntityTypeRegistry {

    private static final Map<EntityType, EntityTypeInfo> ENTITY_TYPE_INFO_MAP = new EnumMap<>(EntityType.class);

    static {
        // Living Entities:
        register(EntityType.ARMOR_STAND, 30);
        register(EntityType.CREEPER, 50);
        register(EntityType.SKELETON, 51);
        register(EntityType.SPIDER, 52);
        register(EntityType.GIANT, 53);
        register(EntityType.ZOMBIE, 54);
        register(EntityType.SLIME, 55);
        register(EntityType.GHAST, 56);
        register(EntityType.PIG_ZOMBIE, 57);
        register(EntityType.ENDERMAN, 58);
        register(EntityType.CAVE_SPIDER, 59);
        register(EntityType.SILVERFISH, 60);
        register(EntityType.BLAZE, 61);
        register(EntityType.MAGMA_CUBE, 62);
        register(EntityType.ENDER_DRAGON, 63);
        register(EntityType.WITHER, 64);
        register(EntityType.BAT, 65);
        register(EntityType.WITCH, 66);
        register(EntityType.ENDERMITE, 67);
        register(EntityType.GUARDIAN, 68);
        register(EntityType.SHULKER, 69);
        register(EntityType.PIG, 90);
        register(EntityType.SHEEP, 91);
        register(EntityType.COW, 92);
        register(EntityType.CHICKEN, 93);
        register(EntityType.SQUID, 94);
        register(EntityType.WOLF, 95);
        register(EntityType.MUSHROOM_COW, 96);
        register(EntityType.SNOWMAN, 97);
        register(EntityType.OCELOT, 98);
        register(EntityType.IRON_GOLEM, 99);
        register(EntityType.HORSE, 100);
        register(EntityType.RABBIT, 101);
        register(EntityType.POLAR_BEAR, 102);
        register(EntityType.VILLAGER, 120);
        // Objects:
        register(EntityType.BOAT, 1);
        register(EntityType.DROPPED_ITEM, 2);
        register(EntityType.MINECART, 10);
        register(EntityType.PRIMED_TNT, 50);
        register(EntityType.ENDER_CRYSTAL, 51);
        register(EntityType.ARROW, 60);
        register(EntityType.SNOWBALL, 61);
        register(EntityType.EGG, 62);
        register(EntityType.FALLING_BLOCK, 70);
        register(EntityType.FIREBALL, 63);
        register(EntityType.SMALL_FIREBALL, 64);
        register(EntityType.ENDER_PEARL, 65);
        register(EntityType.WITHER_SKULL, 66);
        register(EntityType.SHULKER_BULLET, 67);
        register(EntityType.ITEM_FRAME, 71);
        register(EntityType.ENDER_SIGNAL, 72);
        register(EntityType.SPLASH_POTION, 73);
        register(EntityType.THROWN_EXP_BOTTLE, 75);
        register(EntityType.FIREWORK, 76);
        register(EntityType.LEASH_HITCH, 77);
        register(EntityType.FISHING_HOOK, 90);
        register(EntityType.SPECTRAL_ARROW, 91);
        register(EntityType.TIPPED_ARROW, 92);
        register(EntityType.DRAGON_FIREBALL, 93);
    }

    private EntityTypeRegistry() {
        throw new IllegalStateException("Utility class");
    }

    private static void register(EntityType entityType, int typeId) {
        ENTITY_TYPE_INFO_MAP.put(entityType, new EntityTypeInfo(typeId));
    }

    static int getEntityTypeId() {
        EntityTypeInfo entityTypeInfo = ENTITY_TYPE_INFO_MAP.get(EntityType.ARMOR_STAND);
        if (entityTypeInfo == null) {
            throw new DecentHologramsNmsException("Invalid entity type: " + EntityType.ARMOR_STAND);
        }
        return entityTypeInfo.getTypeId();
    }

    private static class EntityTypeInfo {

        private final int typeId;

        EntityTypeInfo(int typeId) {
            this.typeId = typeId;
        }

        int getTypeId() {
            return typeId;
        }

    }

}
