package eu.decentsoftware.holograms.nms.v1_8_R1;

import com.google.common.base.Strings;
import net.minecraft.server.v1_8_R1.WatchableObject;

import java.util.ArrayList;
import java.util.List;

class EntityMetadataBuilder {

    private final List<WatchableObject> watchableObjects;

    private EntityMetadataBuilder() {
        this.watchableObjects = new ArrayList<>();
    }

    List<WatchableObject> toWatchableObjects() {
        return this.watchableObjects;
    }

    EntityMetadataBuilder withCustomName(String customName) {
        this.watchableObjects.add(EntityMetadataType.ENTITY_CUSTOM_NAME.construct(customName));
        boolean visible = !Strings.isNullOrEmpty(customName);
        this.watchableObjects.add(EntityMetadataType.ENTITY_CUSTOM_NAME_VISIBLE.construct(booleanToByte(visible)));
        return this;
    }

    private byte booleanToByte(boolean visible) {
        return (byte) (visible ? 1 : 0);
    }

    static EntityMetadataBuilder create() {
        return new EntityMetadataBuilder();
    }

}
