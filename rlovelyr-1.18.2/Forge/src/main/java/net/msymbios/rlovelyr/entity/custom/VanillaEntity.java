package net.msymbios.rlovelyr.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.msymbios.rlovelyr.entity.internal.InternalEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.SingletonAnimationFactory;

import javax.annotation.Nullable;
import java.util.UUID;

public class VanillaEntity extends InternalEntity implements NeutralMob, IAnimatable {

    // -- Variables --

    private final AnimationFactory cache = new SingletonAnimationFactory(this);

    // -- Constructor --

    public VanillaEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        //this.variant = EntityVariant.Vanilla;
    } // Constructor VanillaEntity ()

    // -- Inherited Methods --
    @Override
    public void registerControllers(AnimationData controllerRegister) {
        //controllerRegister.addAnimationController(InternalAnimation.locomotionAnimation(this));
        //controllerRegister.addAnimationController(InternalAnimation.attackAnimation(this));
    } // registerControllers ()

    @Override
    public AnimationFactory getFactory() { return cache; } // getFactory ()


    // -- Kind Useless but Needed --

    @Override
    public int getRemainingPersistentAngerTime() { return 0; } // getRemainingPersistentAngerTime ()

    @Override
    public void setRemainingPersistentAngerTime(int p_21673_) {} // setRemainingPersistentAngerTime ()

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return null;
    } // getPersistentAngerTarget ()

    @Override
    public void setPersistentAngerTarget(@Nullable UUID p_21672_) {} // setPersistentAngerTarget ()

    @Override
    public void startPersistentAngerTimer() {} // startPersistentAngerTimer ()

} // Class VanillaEntity