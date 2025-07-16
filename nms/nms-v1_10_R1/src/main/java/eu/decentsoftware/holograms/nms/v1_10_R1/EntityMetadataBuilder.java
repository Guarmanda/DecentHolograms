package eu.decentsoftware.holograms.nms.v1_10_R1;

import com.google.common.base.Strings;
import net.minecraft.server.v1_10_R1.DataWatcher;

import java.util.ArrayList;
import java.util.List;

class EntityMetadataBuilder {

    private final List<DataWatcher.Item<?>> watchableObjects;

    private EntityMetadataBuilder() {
        this.watchableObjects = new ArrayList<>();
    }

    List<DataWatcher.Item<?>> toWatchableObjects() {
        return this.watchableObjects;
    }

    EntityMetadataBuilder withCustomName(String customName) {
        this.watchableObjects.add(EntityMetadataType.ENTITY_CUSTOM_NAME.construct(customName));
        boolean visible = !Strings.isNullOrEmpty(customName);
        this.watchableObjects.add(EntityMetadataType.ENTITY_CUSTOM_NAME_VISIBLE.construct(visible));
        return this;
    }

    static EntityMetadataBuilder create() {
        return new EntityMetadataBuilder();
    }

}
