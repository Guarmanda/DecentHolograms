package eu.decentsoftware.holograms.nms.paper_v26_3;

import eu.decentsoftware.holograms.nms.api.DecentHologramsNmsException;
import org.bukkit.craftbukkit.entity.CraftEntityType;
import org.bukkit.entity.EntityType;

final class EntityTypeRegistry {

    private EntityTypeRegistry() {
        throw new IllegalStateException("Utility class");
    }

    static double getEntityTypeHeight(EntityType entityType) {
        return findEntityTypes(entityType).getHeight();
    }

    static net.minecraft.world.entity.EntityType<?> findEntityTypes(EntityType entityType) {
        try {
            return CraftEntityType.bukkitToMinecraft(entityType);
        } catch (IllegalArgumentException e) {
            throw new DecentHologramsNmsException("Invalid entity type: " + entityType, e);
        }
    }
}
