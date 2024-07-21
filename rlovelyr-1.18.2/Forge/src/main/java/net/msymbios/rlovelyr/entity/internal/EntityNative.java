package net.msymbios.rlovelyr.entity.internal;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.msymbios.rlovelyr.config.LovelyRobotID;
import net.msymbios.rlovelyr.entity.internal.enums.EntityVariant;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Internal Variant contains properties used to determine textures, spawning and stats.
 * <p>
 * NOTE: If the key of anything type changes it must be reflected in the find method using the version.
 */
public class EntityNative {

    // -- Variables --

    /**
     * The list of all available variants types.
     */
    public static final List<EntityNative> TYPES = new ArrayList<>();

    public static final EntityNative VANILLA = create(LovelyRobotID.VARIANT_VANILLA).addCombatStats(30F, 5F, 1.2F, 0F, 0F, 0F, 0.6F);

    /**
     * The key used to identify the variant (for things like translation text components).
     */
    @Nonnull
    public final String key;

    /**
     * The standard texture for the variant.
     */
    @Nonnull
    public final ResourceLocation entityTexture;

    /**
     * The translation text component for the variant's name.
     */
    @Nonnull
    public final TranslatableComponent name;

    // -- STATS

    /**
     * The bonus max health the blockling type gives.
     */
    protected float maxHealth = 0.0f;

    /**
     * The bonus attack damage the blockling type gives.
     */
    protected float attackDamage = 0.0f;

    /**
     * The bonus attack speed the blockling type gives.
     */
    protected float attackSpeed = 3.0f;

    /**
     * The bonus armour the blockling type gives.
     */
    protected float armour = 0.0f;

    /**
     * The bonus armour toughness the blockling type gives.
     */
    protected float armourToughness = 0.0f;

    /**
     * The bonus knockback resistance the blockling type gives.
     */
    protected float knockbackResistance = 0.0f;

    /**
     * The bonus move speed the blockling type gives.
     */
    protected float moveSpeed = 0.0f;

    /**
     * The bonus mining speed the blockling type gives.
     */
    protected float miningSpeed = 0.0f;

    /**
     * The bonus woodcutting speed the blockling type gives.
     */
    protected float woodcuttingSpeed = 0.0f;

    /**
     * The bonus farming speed the blockling type gives.
     */
    protected float farmingSpeed = 0.0f;

    // -- Constructors --

    public EntityNative(@Nonnull String key) {
        this.key = key;
        this.entityTexture = Objects.requireNonNull(InternalMetric.getTexture(EntityVariant.byName(key)));//LovelyRobotID.getTexture(key);
        this.name = LovelyRobotID.getTranslation(LovelyRobotID.VARIANT_PREFIX, key);
    } // Constructor EntityNative ()

    // -- Methods --

    /**
     * Creates and adds a new blockling type to the list of blockling types.
     *
     * @param key                the key used to identify the blockling type (for things like translation text components).
     * @return the instance of the blockling type.
     */
    @Nonnull
    protected static EntityNative create(@Nonnull String key) {
        EntityNative type = new EntityNative(key);
        TYPES.add(type);
        return type;
    } // create ()

    /**
     * Sets the combat stats for the blockling type.
     *
     * @param maxHealth           the bonus max health the blockling type gives.
     * @param attackDamage        the bonus attack damage health the blockling type gives.
     * @param attackSpeed         the bonus attack speed health the blockling type gives.
     * @param armour              the bonus armour the blockling type gives.
     * @param armourToughness     the bonus armour toughness health the blockling type gives.
     * @param knockbackResistance the bonus knockback resistance health the blockling type gives.
     * @param moveSpeed           the bonus move speed the blockling type gives.
     */
    @Nonnull
    protected EntityNative addCombatStats(float maxHealth, float attackDamage, float attackSpeed, float armour, float armourToughness, float knockbackResistance, float moveSpeed) {
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.armour = armour;
        this.armourToughness = armourToughness;
        this.knockbackResistance = knockbackResistance;
        this.moveSpeed = moveSpeed;
        return this;
    } // addCombatStats ()

    /**
     * Sets the gathering stats for the blockling type.
     *
     * @param miningSpeed      the bonus mining speed the blockling type gives.
     * @param woodcuttingSpeed the bonus woodcutting speed the blockling type gives.
     * @param farmingSpeed     the bonus farming speed the blockling type gives.
     */
    @Nonnull
    protected EntityNative addGatheringStats(float miningSpeed, float woodcuttingSpeed, float farmingSpeed) {
        this.miningSpeed = miningSpeed;
        this.woodcuttingSpeed = woodcuttingSpeed;
        this.farmingSpeed = farmingSpeed;
        return this;
    } // addGatheringStats ()

    /**
     * @return the bonus max health the blockling type gives.
     */
    public float getMaxHealth() {
        return maxHealth;
    } // getMaxHealth ()

    /**
     * @return the bonus attack damage the blockling type gives.
     */
    public float getAttackDamage() {
        return attackDamage;
    } // getAttackDamage ()

    /**
     * @return the bonus armour the blockling type gives.
     */
    public float getArmour() {
        return armour;
    } // getArmour ()

    /**
     * @return the bonus move speed the blockling type gives.
     */
    public float getMoveSpeed() {
        return moveSpeed;
    } // getMoveSpeed ()

    /**
     * @return the bonus attack speed the blockling type gives.
     */
    public float getAttackSpeed() {
        return attackSpeed;
    } // getAttackSpeed ()

    /**
     * @return the bonus armour toughness the blockling type gives.
     */
    public float getArmourToughness() {
        return armourToughness;
    } // getArmourToughness ()

    /**
     * @return the bonus knockback resistance the blockling type gives.
     */
    public float getKnockbackResistance() {
        return knockbackResistance;
    } // getKnockbackResistance ()

    /**
     * @return the bonus mining speed the blockling type gives.
     */
    public float getMiningSpeed() {
        return miningSpeed;
    } // getMiningSpeed ()

    /**
     * @return the bonus woodcutting speed the blockling type gives.
     */
    public float getWoodcuttingSpeed() {
        return woodcuttingSpeed;
    } // getWoodcuttingSpeed ()

    /**
     * @return the bonus farming speed the blockling type gives.
     */
    public float getFarmingSpeed() {
        return farmingSpeed;
    } // getFarmingSpeed ()

} // Class EntityNative