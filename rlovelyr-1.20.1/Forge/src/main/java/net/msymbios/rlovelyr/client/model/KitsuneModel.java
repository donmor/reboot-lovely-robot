package net.msymbios.rlovelyr.client.model;

import net.minecraft.resources.ResourceLocation;
import net.msymbios.rlovelyr.entity.custom.KitsuneEntity;
import net.msymbios.rlovelyr.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class KitsuneModel extends GeoModel<KitsuneEntity> {

    // -- Methods --
    @Override
    public ResourceLocation getModelResource(KitsuneEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public ResourceLocation getTextureResource(KitsuneEntity animatable) {
        return animatable.getTexture();
    } // getTextureResource ()

    @Override
    public ResourceLocation getAnimationResource(KitsuneEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(KitsuneEntity animatable, long instanceId, AnimationState<KitsuneEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class KitsuneModel