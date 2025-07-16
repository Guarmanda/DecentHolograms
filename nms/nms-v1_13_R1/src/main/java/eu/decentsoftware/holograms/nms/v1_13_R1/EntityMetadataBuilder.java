package eu.decentsoftware.holograms.nms.v1_13_R1;

import com.google.common.base.Strings;
import net.minecraft.server.v1_13_R1.DataWatcher;
import net.minecraft.server.v1_13_R1.IChatBaseComponent;
import org.bukkit.craftbukkit.v1_13_R1.util.CraftChatMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class EntityMetadataBuilder {

    private final List<DataWatcher.Item<?>> watchableObjects;

    private EntityMetadataBuilder() {
        this.watchableObjects = new ArrayList<>();
    }

    List<DataWatcher.Item<?>> toWatchableObjects() {
        return this.watchableObjects;
    }

    EntityMetadataBuilder withCustomName(String customName) {
        IChatBaseComponent iChatBaseComponent = CraftChatMessage.fromStringOrNull(customName);
        Optional<IChatBaseComponent> optionalIChatBaseComponent = Optional.ofNullable(iChatBaseComponent);
        this.watchableObjects.add(EntityMetadataType.ENTITY_CUSTOM_NAME.construct(optionalIChatBaseComponent));
        boolean visible = !Strings.isNullOrEmpty(customName);
        this.watchableObjects.add(EntityMetadataType.ENTITY_CUSTOM_NAME_VISIBLE.construct(visible));
        return this;
    }

    static EntityMetadataBuilder create() {
        return new EntityMetadataBuilder();
    }

}
