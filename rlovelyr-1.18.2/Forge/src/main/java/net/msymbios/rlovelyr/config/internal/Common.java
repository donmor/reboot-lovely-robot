package net.msymbios.rlovelyr.config.internal;

import com.electronwill.nightconfig.core.Config;
import net.minecraftforge.common.ForgeConfigSpec;

import javax.annotation.Nonnull;

/**
 * Config options shared by both the client and server.
 */
public class Common {

    // -- Variables --

    // -- GENERAL --
    public final ForgeConfigSpec.ConfigValue<Integer> ownerMaxRobotNum;
    public final ForgeConfigSpec.ConfigValue<Float> movementMeleeAttack;
    public final ForgeConfigSpec.ConfigValue<Float> movementFollowOwner;
    public final ForgeConfigSpec.ConfigValue<Float> movementWanderAround;
    public final ForgeConfigSpec.ConfigValue<Float> followDistanceMax;
    public final ForgeConfigSpec.ConfigValue<Float> followDistanceMin;
    public final ForgeConfigSpec.ConfigValue<Float> lookRange;

    // -- RENDERER --
    public final ForgeConfigSpec.ConfigValue<Float> width;
    public final ForgeConfigSpec.ConfigValue<Float> height;

    // -- LEVEL | EXPERIENCE ---
    public final ForgeConfigSpec.ConfigValue<Integer> experienceBase;
    public final ForgeConfigSpec.ConfigValue<Integer> experienceMultiplier;

    // -- COMBAT --
    public final ForgeConfigSpec.ConfigValue<Integer> attackChance;
    public final ForgeConfigSpec.ConfigValue<Integer> healInterval;
    public final ForgeConfigSpec.ConfigValue<Integer> waryTime;
    public final ForgeConfigSpec.ConfigValue<Boolean> globalAutoHeal;
    public final ForgeConfigSpec.ConfigValue<Boolean> lootEnchantment;
    public final ForgeConfigSpec.ConfigValue<Integer> lootEnchantmentLevel;
    public final ForgeConfigSpec.ConfigValue<Integer> maxLootEnchantment;
    public final ForgeConfigSpec.ConfigValue<Float> baseDefenceRange;
    public final ForgeConfigSpec.ConfigValue<Float> baseDefenceWarpRange;

    // -- PROTECTION --
    public final ForgeConfigSpec.ConfigValue<Integer> protectionLimitFire;
    public final ForgeConfigSpec.ConfigValue<Integer> protectionLimitFall;
    public final ForgeConfigSpec.ConfigValue<Integer> protectionLimitBlast;
    public final ForgeConfigSpec.ConfigValue<Integer> protectionLimitProjectile;

    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeMaxLevel;
    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeMaxHealth;
    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeAttackDamage;
    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeAttackSpeed;
    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeMovementSpeed;
    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeDefense;
    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeArmor;
    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeArmorToughness;
    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeBaseDefenceRange;
    //public final ForgeConfigSpec.ConfigValue<Float> vanillaAttributeBaseDefenceWarpRange;

    // -- Constructor --

    /**
     * @param builder the builder used to create the config.
     */
    public Common(@Nonnull ForgeConfigSpec.Builder builder) {
        Config.setInsertionOrderPreserved(true);

        builder.push("General");
        ownerMaxRobotNum = builder.worldRestart()
                .comment("Maximum number of robots owned by an owner.", "Note: [-1] means unlimited!", "Example: [30]")
                .define("owner-max-robot", 30);

        movementMeleeAttack = builder.worldRestart()
                .comment("Movement speed when it is melee attacking.", "Example: [0.8F]")
                .define("movement-melee-attack", 0.8F);

        movementFollowOwner = builder.worldRestart()
                .comment("Movement speed when following player.", "Example: [0.7F]")
                .define("movement-follow-owner", 0.7F);

        movementWanderAround = builder.worldRestart()
                .comment("Movement speed while it is wandering around.", "Example: [0.6F]")
                .define("movement-wander-around", 0.6F);

        followDistanceMax = builder.worldRestart()
                .comment("Maximum distance allowed while following.", "Example: [10F]")
                .define("follow-distance-max", 10F);

        followDistanceMin = builder.worldRestart()
                .comment("Minimum distance allowed while following.", "Example: [2F]")
                .define("follow-distance-min", 2F);

        lookRange = builder.worldRestart()
                .comment("How much should the head rotate while looking.", "Example: [8F]")
                .define("look-range", 8F);
        builder.pop();

        builder.push("Renderer");
        width = builder.worldRestart()
                .comment("Entity hit-box width.", "Example: [0.4F]")
                .define("width", 0.4F);

        height = builder.worldRestart()
                .comment("Entity hit-box height.", "Example: [0.4F]")
                .define("height", 0.4F);
        builder.pop();

        builder.push("Level & Experience");
        experienceBase = builder.worldRestart()
                .comment("Basic experience required to level up.", "Example: [50]")
                .define("experience-base", 50);

        experienceMultiplier = builder.worldRestart()
                .comment("Increase level experience multiplier.", "Example: [2]")
                .define("experience-multiplier", 2);
        builder.pop();

        builder.push("Combat");
        attackChance = builder.worldRestart()
                .comment("Probability of attacking when attacked.", "Example: [5]")
                .define("attack-chance", 5);

        healInterval = builder.worldRestart()
                .comment("Automatic recovery interval.", "Example: [50]")
                .define("heal-interval", 50);

        waryTime = builder.worldRestart()
                .comment("Time while being in combat mode.", "Example: [50]")
                .define("wary-time", 50);

        globalAutoHeal = builder.worldRestart()
                .comment("Enable/disable global robots healing.", "Example: [true/false]")
                .define("global-heal", true);

        lootEnchantment = builder.worldRestart()
                .comment("Enable looting enchantments.", "Example: [true/false]")
                .define("loot-enchantment", true);

        lootEnchantmentLevel = builder.worldRestart()
                .comment("Levels required for looting enchantments.", "Example: [10]")
                .define("loot-enchantment-level", 10);

        maxLootEnchantment = builder.worldRestart()
                .comment("Maximum level of looting enchantments.", "Example: [3]")
                .define("max-loot-enchantment", 3);

        baseDefenceRange = builder.worldRestart()
                .comment("Base range to defend.", "Example: [15F]")
                .define("base-defence-range", 15F);

        baseDefenceWarpRange = builder.worldRestart()
                .comment("Range till teleport back to base.", "Example: [10F]")
                .define("base-defence-warp-range", 10F);
        builder.pop();

        builder.push("Protection");
        protectionLimitFire = builder.worldRestart()
                .comment("Fire protection upper limit.", "Example: [80]")
                .define("limit-fire", 80);

        protectionLimitFall = builder.worldRestart()
                .comment("Fall protection upper limit.", "Example: [80]")
                .define("limit-fall", 80);

        protectionLimitBlast = builder.worldRestart()
                .comment("Blast protection upper limit.", "Example: [80]")
                .define("limit-blast", 80);

        protectionLimitProjectile = builder.worldRestart()
                .comment("Projectile protection upper limit.", "Example: [80]")
                .define("limit-projectile", 80);
        builder.pop();

    } // Constructor Common ()

} // Class Common