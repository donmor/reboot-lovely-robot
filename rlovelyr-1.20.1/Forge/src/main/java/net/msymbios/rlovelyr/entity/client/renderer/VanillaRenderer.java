package net.msymbios.rlovelyr.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.msymbios.rlovelyr.entity.client.layer.VanillaLayer;
import net.msymbios.rlovelyr.entity.client.model.VanillaModel;
import net.msymbios.rlovelyr.entity.custom.VanillaEntity;
import net.msymbios.rlovelyr.entity.internal.InternalMetric;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VanillaRenderer extends GeoEntityRenderer<VanillaEntity>  {

    // -- Constructor --
    public VanillaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new VanillaModel());
        this.shadowRadius = InternalMetric.SHADOW_RADIUS;
        addRenderLayer(new VanillaLayer(this));
    } // Constructor VanillaRenderer ()

    // -- Methods --
    @Override
    public @NotNull ResourceLocation getTextureLocation(VanillaEntity instance) {
        return instance.getTexture();
    } // getTextureLocation ()

} // Class VanillaRenderer