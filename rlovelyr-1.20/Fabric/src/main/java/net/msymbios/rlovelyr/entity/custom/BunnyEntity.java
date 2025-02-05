package net.msymbios.rlovelyr.entity.custom;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.world.EntityView;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
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
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

import static net.msymbios.rlovelyr.entity.internal.Utility.getRandomNumber;

public class BunnyEntity extends InternalEntity implements GeoEntity {

    // -- Variables --
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    // -- Properties --
    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.MAX_HEALTH))
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.ATTACK_DAMAGE))
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.ATTACK_SPEED))
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.MOVEMENT_SPEED))
                .add(EntityAttributes.GENERIC_ARMOR, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.ARMOR))
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, InternalMetric.getAttributeValue(EntityVariant.Bunny, EntityAttribute.ARMOR_TOUGHNESS));
    } // setAttributes ()

    // -- MODEL --
    @Override
    public Identifier getCurrentModelByID(int value) { return InternalMetric.getModel(EntityVariant.Bunny, EntityModel.byId(value)); } // getCurrentModelByID ()

    // TEXTURE
    @Override
    public Identifier getTextureByID(int value) { return InternalMetric.getTexture(EntityVariant.Bunny, EntityTexture.byId(value)); } // getTextureByID ()

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
    public BunnyEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    } // Constructor RobotEntity ()

    // -- Animations --
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(InternalAnimation.locomotionAnimation(this));
        controllerRegistrar.add(InternalAnimation.locomotionAnimation(this));
    } // registerControllers ()

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    } // getAnimatableInstanceCache ()

    // -- Inherited Methods --
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setVariant(EntityVariant.Bunny.getName());
        this.setTexture(getRandomNumber(InternalMetric.getTextureCount(EntityVariant.Bunny)));
        this.setMaxLevel(getAttribute(EntityAttribute.MAX_LEVEL));

        EquipmentSlot slot = EquipmentSlot.MAINHAND;
        ItemStack diamondSword = new ItemStack(Items.DIAMOND_SWORD);
        this.equipStack(slot, diamondSword);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    } // initialize ()

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, InternalMetric.MeleeAttackMovement, false));
        this.goalSelector.add(4, new AiFollowOwnerGoal(this, InternalMetric.FollowOwnerMovement, InternalMetric.FollowBehindDistance, InternalMetric.FollowCloseDistance, false));
        this.goalSelector.add(4, new AiBaseDefenseGoal(this, InternalMetric.FollowOwnerMovement, InternalMetric.BaseDefenseRange, InternalMetric.BaseDefenseWarpRange));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, InternalMetric.WanderAroundMovement));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, InternalMetric.LookAtRange));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.targetSelector.add(4, new AiAutoAttackGoal(this, MobEntity.class, InternalMetric.AttackChance, false, false, InternalMetric.AvoidAttackingEntities));
        this.targetSelector.add(5, new UniversalAngerGoal(this, true));
    } // initGoals ()

    // -- Save Methods --
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(VARIANT, EntityVariant.Bunny.getName());
    } // initDataTracker ()

    // -- Inherited Methods --
    @Override
    public EntityView method_48926() {
        return this.getWorld();
    } // method_48926 ()

} // Class BunnyEntity