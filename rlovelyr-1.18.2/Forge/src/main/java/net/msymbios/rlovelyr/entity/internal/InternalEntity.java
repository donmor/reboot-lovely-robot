package net.msymbios.rlovelyr.entity.internal;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.msymbios.rlovelyr.entity.internal.enums.*;

import javax.annotation.Nullable;

public abstract class InternalEntity extends TamableAnimal {

    // -- Variables --
    public EntityVariant variant = EntityVariant.Vanilla;
    protected EntityModel model = EntityModel.Default;

    // -- Properties --


    // TEXTURE
    public ResourceLocation getTexture() {
        return InternalMetric.getTexture(this.variant, EntityTexture.byId(4));
        //return InternalMetric.getTexture(this.variant, EntityTexture.byId(getTextureID()));
    } // getTexture ()

    // MODEL
    public ResourceLocation getCurrentModel() {
        return InternalMetric.getModel(this.variant, model);
        //return InternalMetric.getModel(this.variant, model);
    } // getCurrentModel ()

    // ANIMATOR
    public ResourceLocation getAnimator() { return InternalMetric.getAnimator(this.variant); } // getAnimator ()

    // -- Constructor --

    protected InternalEntity(EntityType<? extends TamableAnimal> entity, Level level) {
        super(entity, level);
    } // Constructor InternalEntity ()

    // -- Custom Methods --

    /**
     * @return the additional attributes to add to the entity.
     */
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_DAMAGE, 0.0)
                .add(Attributes.ATTACK_SPEED, 0.0)
                .add(Attributes.FOLLOW_RANGE, 48.0); // Follow range determines max pathfinding distance.
    } // createAttributes ()

    // -- Inherited Methods --

    @Nullable @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    } // getBreedOffspring ()

} // Class InternalEntity