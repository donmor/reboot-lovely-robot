package net.msymbios.rlovelyr.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.msymbios.rlovelyr.entity.client.layer.BunnyLayer;
import net.msymbios.rlovelyr.entity.client.model.BunnyModel;
import net.msymbios.rlovelyr.entity.custom.BunnyEntity;
import net.msymbios.rlovelyr.entity.internal.InternalMetric;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BunnyRenderer extends GeoEntityRenderer<BunnyEntity> {

    // -- Constructor --
    public BunnyRenderer(EntityRendererManager renderManager) {
        super(renderManager, new BunnyModel());
        this.shadowRadius = InternalMetric.SHADOW_RADIUS.get();
        addLayer(new BunnyLayer(this));
    } // Constructor BunnyRenderer ()

    // -- Methods --
    @Override
    public ResourceLocation getTextureLocation(BunnyEntity instance) {
        return instance.getTexture();
    } // getTextureLocation ()

} // Class BunnyRenderer