package net.msymbios.rlovelyr.entity.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.msymbios.rlovelyr.config.LovelyRobotResource;
import net.msymbios.rlovelyr.entity.custom.BunnyEntity;
import net.msymbios.rlovelyr.entity.internal.enums.EntityState;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class BunnyLayer extends GeoLayerRenderer<BunnyEntity> {

    // -- Constructor --
    public BunnyLayer(IGeoRenderer<BunnyEntity> entityRendererIn) {
        super(entityRendererIn);
    } // Constructor BunnyLayer ()

    // -- Inherited Methods --
    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLightIn, BunnyEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType armorRenderType = RenderType.armorCutoutNoCull(LovelyRobotResource.BUNNY_LAYER_EMPTY);
        if(entity.getAutoAttack()) {
            if(entity.getCurrentState() == EntityState.Defense) armorRenderType = RenderType.armorCutoutNoCull(LovelyRobotResource.BUNNY_LAYER_BASE_DEFENSE);
            else armorRenderType = RenderType.armorCutoutNoCull(LovelyRobotResource.BUNNY_LAYER_AUTO_ATTACK);
        }
        getRenderer().render(getEntityModel().getModel(entity.getCurrentModel()), entity, partialTicks, armorRenderType, poseStack, bufferSource, bufferSource.getBuffer(armorRenderType), packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
    } // render ()

} // Class BunnyLayer