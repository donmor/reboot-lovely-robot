package net.msymbios.rlovelyr.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.msymbios.rlovelyr.entity.enums.EntityAttribute;
import net.msymbios.rlovelyr.entity.enums.EntityModel;
import net.msymbios.rlovelyr.entity.enums.EntityTexture;
import net.msymbios.rlovelyr.entity.enums.EntityVariant;
import net.msymbios.rlovelyr.entity.goal.AiAutoAttackGoal;
import net.msymbios.rlovelyr.entity.goal.AiBaseDefenseGoal;
import net.msymbios.rlovelyr.entity.goal.AiFollowOwnerGoal;
import net.msymbios.rlovelyr.entity.internal.InternalAnimation;
import net.msymbios.rlovelyr.entity.internal.InternalEntity;
import net.msymbios.rlovelyr.entity.internal.InternalMetric;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;

import static net.msymbios.rlovelyr.entity.internal.Utility.getRandomNumber;

public class BunnyEntity extends InternalEntity implements NeutralMob, IAnimatable {

    // -- Variables --
    private final AnimationFactory cache = new AnimationFactory(this);

    // -- Properties --
    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.MAX_HEALTH))
                .add(Attributes.ATTACK_DAMAGE, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.ATTACK_DAMAGE))
                .add(Attributes.ATTACK_SPEED, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.ATTACK_SPEED))
                .add(Attributes.MOVEMENT_SPEED, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.MOVEMENT_SPEED))
                .add(Attributes.ARMOR, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.ARMOR))
                .add(Attributes.ARMOR_TOUGHNESS, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.ARMOR_TOUGHNESS)).build();
    } // setAttributes ()

    // -- MODEL --
    @Override
    public ResourceLocation getCurrentModelByID(int value) { return InternalMetric.getModel(EntityVariant.Bunny, EntityModel.byId(value)); } // getCurrentModelByID ()

    // TEXTURE
    @Override
    public ResourceLocation getTextureByID(int value) { return InternalMetric.getTexture(EntityVariant.Bunny, EntityTexture.byId(value)); } // getTextureByID ()

    // VARIANT
    @Override
    public String getVariant() {
        return this.getVariant(EntityVariant.Bunny.getName());
    } // getVariant ()

    // STATS
    public float getAttributeRaw(EntityAttribute attribute) {
        return InternalMetric.getAttributeValue(EntityVariant.Bunny, attribute);
    } // getAttributeRaw ()


    // -- Constructor --
    public BunnyEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    } // Constructor BunnyEntity ()

    // -- Animations --
    @Override
    public void registerControllers(AnimationData controllerRegister) {
        controllerRegister.addAnimationController(InternalAnimation.locomotionAnimation(this));
        controllerRegister.addAnimationController(InternalAnimation.attackAnimation(this));
    } // registerControllers ()

    @Override
    public AnimationFactory getFactory() { return cache; } // getFactory ()

    // -- Inherited Methods --
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance instance, MobSpawnType mobSpawnType, SpawnGroupData spawnGroupData, CompoundTag compoundTag) {
        this.setVariant(EntityVariant.Bunny.getName());
        this.setTexture(getRandomNumber(InternalMetric.getTextureCount(EntityVariant.Bunny)));
        this.setMaxLevel(getAttribute(EntityAttribute.MAX_LEVEL));
        return super.finalizeSpawn(levelAccessor, instance, mobSpawnType, spawnGroupData, compoundTag);
    } // finalizeSpawn ()

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, InternalMetric.MeleeAttackMovement, true));
        this.goalSelector.addGoal(4, new AiFollowOwnerGoal(this, InternalMetric.FollowOwnerMovement, InternalMetric.FollowBehindDistance, InternalMetric.FollowCloseDistance, false));
        this.goalSelector.addGoal(4, new AiBaseDefenseGoal(this, InternalMetric.FollowOwnerMovement, InternalMetric.BaseDefenseRange, InternalMetric.BaseDefenseWarpRange));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, InternalMetric.WanderAroundMovement));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, InternalMetric.LookAtRange));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new AiAutoAttackGoal<>(this, Mob.class, InternalMetric.AttackChance, true, false, InternalMetric.AvoidAttackingEntities));
        this.targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, false));
    } // registerGoals ()

    // -- Save Methods --
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, EntityVariant.Bunny.getName());
    } // defineSynchedData ()

    // -- Inherited --
    @Override
    public int getRemainingPersistentAngerTime() { return 0; } // getRemainingPersistentAngerTime ()

    @Override
    public void setRemainingPersistentAngerTime(int p_21673_) {} // setRemainingPersistentAngerTime ()

    @Override
    public UUID getPersistentAngerTarget() {
        return null;
    } // getPersistentAngerTarget ()

    @Override
    public void setPersistentAngerTarget(UUID p_21672_) {} // setPersistentAngerTarget ()

    @Override
    public void startPersistentAngerTimer() {} // startPersistentAngerTimer ()

} // Class BunnyEntity