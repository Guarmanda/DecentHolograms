package eu.decentsoftware.holograms.nms.v1_16_R2;


import eu.decentsoftware.holograms.nms.api.renderer.NmsHologramRendererFactory;

import eu.decentsoftware.holograms.nms.api.renderer.NmsTextHologramRenderer;

class HologramRendererFactory implements NmsHologramRendererFactory {

    private final EntityIdGenerator entityIdGenerator;

    HologramRendererFactory(EntityIdGenerator entityIdGenerator) {
        this.entityIdGenerator = entityIdGenerator;
    }

    @Override
    public NmsTextHologramRenderer createTextRenderer() {
        return new TextHologramRenderer(entityIdGenerator);
    }




}
