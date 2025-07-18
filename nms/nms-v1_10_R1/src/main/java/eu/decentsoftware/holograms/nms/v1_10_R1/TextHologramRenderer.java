package eu.decentsoftware.holograms.nms.v1_10_R1;

import eu.decentsoftware.holograms.nms.api.NmsHologramPartData;
import eu.decentsoftware.holograms.nms.api.renderer.NmsTextHologramRenderer;
import eu.decentsoftware.holograms.shared.DecentPosition;
import net.minecraft.server.v1_10_R1.DataWatcher;
import org.bukkit.entity.Player;

class TextHologramRenderer implements NmsTextHologramRenderer {

    private final int armorStandEntityId;
    private final DataWatcher dataWatcher;

    TextHologramRenderer(EntityIdGenerator entityIdGenerator) {
        this.armorStandEntityId = entityIdGenerator.getFreeEntityId();
        this.dataWatcher = DataWatcherBuilder.create()
                .withInvisible()
                .withNoGravity()
                .withArmorStandProperties()
                .toDataWatcher();
    }

    @Override
    public void display(Player player, NmsHologramPartData<String> data) {
        String content = data.getContent();
        DecentPosition position = data.getPosition();
        EntityPacketsBuilder.create()
                .withSpawnEntityLiving(armorStandEntityId, offsetPosition(position), dataWatcher)
                .withEntityMetadata(armorStandEntityId, EntityMetadataBuilder.create()
                        .withCustomName(content)
                        .toWatchableObjects())
                .sendTo(player);
    }

    @Override
    public void updateContent(Player player, NmsHologramPartData<String> data) {
        EntityPacketsBuilder.create()
                .withEntityMetadata(armorStandEntityId, EntityMetadataBuilder.create()
                        .withCustomName(data.getContent())
                        .toWatchableObjects())
                .sendTo(player);
    }

    @Override
    public void move(Player player, NmsHologramPartData<String> data) {
        EntityPacketsBuilder.create()
                .withTeleportEntity(armorStandEntityId, offsetPosition(data.getPosition()))
                .sendTo(player);
    }

    @Override
    public void hide(Player player) {
        EntityPacketsBuilder.create()
                .withRemoveEntity(armorStandEntityId)
                .sendTo(player);
    }

    @Override
    public double getHeight(NmsHologramPartData<String> data) {
        return 0.25d;
    }

    @Override
    public int[] getEntityIds() {
        return new int[]{armorStandEntityId};
    }

    private DecentPosition offsetPosition(DecentPosition position) {
        return position.subtractY(0.5);
    }
}
