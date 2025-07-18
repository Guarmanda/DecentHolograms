package eu.decentsoftware.holograms.nms.v1_8_R2;

import eu.decentsoftware.holograms.shared.DecentPosition;
import eu.decentsoftware.holograms.shared.reflect.ReflectField;
import net.minecraft.server.v1_8_R2.DataWatcher;
import net.minecraft.server.v1_8_R2.MathHelper;
import net.minecraft.server.v1_8_R2.Packet;
import net.minecraft.server.v1_8_R2.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R2.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_8_R2.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_8_R2.PacketPlayOutSpawnEntityLiving;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

class EntityPacketsBuilder {

    private static final ReflectField<DataWatcher> SPAWN_ENTITY_LIVING_PACKET_DATA_WATCHER_FIELD = new ReflectField<>(
            PacketPlayOutSpawnEntityLiving.class, "l");
    private final List<Packet<?>> packets;

    private EntityPacketsBuilder() {
        this.packets = new ArrayList<>();
    }

    void sendTo(Player player) {
        for (Packet<?> packet : packets) {
            sendPacket(player, packet);
        }
    }

    EntityPacketsBuilder withSpawnEntityLiving(int entityId, DecentPosition position, DataWatcher dataWatcher) {
        PacketDataSerializerWrapper serializer = prepareSpawnEntityData(entityId, position);
        serializer.writeByte(MathHelper.d(position.getYaw() * 256.0F / 360.0F));
        serializer.writeShort();
        serializer.writeShort();
        serializer.writeShort();
        serializer.writeByte(127);

        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving();
        serializer.writeToPacket(packet);
        SPAWN_ENTITY_LIVING_PACKET_DATA_WATCHER_FIELD.set(packet, dataWatcher);

        packets.add(packet);
        return this;
    }

    private PacketDataSerializerWrapper prepareSpawnEntityData(int entityId, DecentPosition position) {
        PacketDataSerializerWrapper serializer = PacketDataSerializerWrapper.getInstance();
        serializer.writeVarInt(entityId);
        serializer.writeByte(EntityTypeRegistry.getEntityTypeId(EntityType.ARMOR_STAND));
        serializer.writeInt(MathHelper.floor(position.getX() * 32));
        serializer.writeInt(MathHelper.floor(position.getY() * 32));
        serializer.writeInt(MathHelper.floor(position.getZ() * 32));
        serializer.writeByte(MathHelper.d(position.getYaw() * 256.0F / 360.0F));
        serializer.writeByte(MathHelper.d(position.getPitch() * 256.0F / 360.0F));
        return serializer;
    }

    EntityPacketsBuilder withEntityMetadata(int entityId, List<DataWatcher.WatchableObject> watchableObjects) {
        PacketDataSerializerWrapper serializer = PacketDataSerializerWrapper.getInstance();
        serializer.writeVarInt(entityId);
        serializer.writeWatchableObjects(watchableObjects);

        PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata();
        serializer.writeToPacket(packet);

        packets.add(packet);
        return this;
    }

    EntityPacketsBuilder withTeleportEntity(int entityId, DecentPosition position) {
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport(
                entityId,
                MathHelper.floor(position.getX() * 32.0),
                MathHelper.floor(position.getY() * 32.0),
                MathHelper.floor(position.getZ() * 32.0),
                (byte) ((int) (position.getYaw() * 256.0F / 360.0F)),
                (byte) ((int) (position.getPitch() * 256.0F / 360.0F)),
                false // onGround
        );
        packets.add(packet);
        return this;
    }

    EntityPacketsBuilder withRemoveEntity(int entityId) {
        PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(entityId);
        packets.add(packet);
        return this;
    }

    private void sendPacket(Player player, Packet<?> packet) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    static EntityPacketsBuilder create() {
        return new EntityPacketsBuilder();
    }

}
