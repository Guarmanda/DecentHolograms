package eu.decentsoftware.holograms.nms.v1_10_R1;

import eu.decentsoftware.holograms.shared.reflect.ReflectUtil;
import net.minecraft.server.v1_10_R1.DataWatcher;
import net.minecraft.server.v1_10_R1.DataWatcherObject;
import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.EntityArmorStand;

class EntityMetadataType<T> {

    private static final DataWatcherObject<Byte> ENTITY_PROPERTIES_OBJECT
            = ReflectUtil.getFieldValue(Entity.class, "aa");
    private static final DataWatcherObject<String> ENTITY_CUSTOM_NAME_OBJECT
            = ReflectUtil.getFieldValue(Entity.class, "aA");
    private static final DataWatcherObject<Boolean> ENTITY_CUSTOM_NAME_VISIBLE_OBJECT
            = ReflectUtil.getFieldValue(Entity.class, "aB");
    private static final DataWatcherObject<Boolean> ENTITY_HAS_NO_GRAVITY_OBJECT
            = ReflectUtil.getFieldValue(Entity.class, "aD");
    private static final DataWatcherObject<Byte> ARMOR_STAND_PROPERTIES_OBJECT
            = ReflectUtil.getFieldValue(EntityArmorStand.class, "a");

    static final EntityMetadataType<Byte> ENTITY_PROPERTIES = new EntityMetadataType<>(ENTITY_PROPERTIES_OBJECT);
    static final EntityMetadataType<String> ENTITY_CUSTOM_NAME = new EntityMetadataType<>(ENTITY_CUSTOM_NAME_OBJECT);
    static final EntityMetadataType<Boolean> ENTITY_CUSTOM_NAME_VISIBLE = new EntityMetadataType<>(ENTITY_CUSTOM_NAME_VISIBLE_OBJECT);
    static final EntityMetadataType<Boolean> ENTITY_HAS_NO_GRAVITY = new EntityMetadataType<>(ENTITY_HAS_NO_GRAVITY_OBJECT);
    static final EntityMetadataType<Byte> ARMOR_STAND_PROPERTIES = new EntityMetadataType<>(ARMOR_STAND_PROPERTIES_OBJECT);

    private final DataWatcherObject<T> dataWatcherObject;

    private EntityMetadataType(DataWatcherObject<T> dataWatcherObject) {
        this.dataWatcherObject = dataWatcherObject;
    }

    DataWatcher.Item<T> construct(T value) {
        return new DataWatcher.Item<>(dataWatcherObject, value);
    }

    void addToDataWatcher(DataWatcher dataWatcher, T value) {
        dataWatcher.register(dataWatcherObject, value);
    }

}
