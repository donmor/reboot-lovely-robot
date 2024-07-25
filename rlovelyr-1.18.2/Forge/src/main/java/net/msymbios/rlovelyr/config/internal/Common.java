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

    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> ownerMaxRobotNum;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> movementMeleeAttack;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> movementFollowOwner;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> movementWanderAround;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> followDistanceMax;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> followDistanceMin;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> lookRange;

    // -- RENDERER --

    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> width;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> height;

    // -- LEVEL | EXPERIENCE ---
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> experienceBase;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> experienceMultiplier;

    // -- COMBAT --
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> attackChance;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> healInterval;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> waryTime;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Boolean> globalAutoHeal;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Boolean> lootEnchantment;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> lootEnchantmentLevel;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> maxLootEnchantment;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> baseDefenceRange;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> baseDefenceWarpRange;

    // -- PROTECTION --
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> protectionLimitFire;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> protectionLimitFall;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> protectionLimitBlast;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> protectionLimitProjectile;

    // -- ENTITY --

    // BUNNY
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> bunnyAttributeMaxLevel;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunnyAttributeMaxHealth;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunnyAttributeAttackDamage;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunnyAttributeAttackSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunnyAttributeMovementSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunnyAttributeArmor;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunnyAttributeArmorToughness;

    // BUNNY2
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> bunny2AttributeMaxLevel;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunny2AttributeMaxHealth;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunny2AttributeAttackDamage;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunny2AttributeAttackSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunny2AttributeMovementSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunny2AttributeArmor;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> bunny2AttributeArmorToughness;

    // DRAGON
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> dragonAttributeMaxLevel;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> dragonAttributeMaxHealth;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> dragonAttributeAttackDamage;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> dragonAttributeAttackSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> dragonAttributeMovementSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> dragonAttributeArmor;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> dragonAttributeArmorToughness;

    // HONEY
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> honeyAttributeMaxLevel;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> honeyAttributeMaxHealth;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> honeyAttributeAttackDamage;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> honeyAttributeAttackSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> honeyAttributeMovementSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> honeyAttributeArmor;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> honeyAttributeArmorToughness;

    // KITSUNE
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> kitsuneAttributeMaxLevel;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> kitsuneAttributeMaxHealth;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> kitsuneAttributeAttackDamage;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> kitsuneAttributeAttackSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> kitsuneAttributeMovementSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> kitsuneAttributeArmor;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> kitsuneAttributeArmorToughness;

    // NEKO
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> nekoAttributeMaxLevel;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> nekoAttributeMaxHealth;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> nekoAttributeAttackDamage;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> nekoAttributeAttackSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> nekoAttributeMovementSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> nekoAttributeArmor;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> nekoAttributeArmorToughness;

    // VANILLA
    @Nonnull public final ForgeConfigSpec.ConfigValue<Integer> vanillaAttributeMaxLevel;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> vanillaAttributeMaxHealth;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> vanillaAttributeAttackDamage;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> vanillaAttributeAttackSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> vanillaAttributeMovementSpeed;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> vanillaAttributeArmor;
    @Nonnull public final ForgeConfigSpec.ConfigValue<Double> vanillaAttributeArmorToughness;

    // -- Constructor --

    /**
     * @param builder the builder used to create the config.
     */
    public Common(@Nonnull ForgeConfigSpec.Builder builder) {
        Config.setInsertionOrderPreserved(true);

        builder.push("General");
        ownerMaxRobotNum = builder
                .comment("Maximum number of robots owned by an owner.", "Note: [-1] means unlimited!", "Example: [30]")
                .worldRestart()
                .define("owner-max-robot", 30);

        movementMeleeAttack = builder
                .comment("Movement speed when it is melee attacking.", "Example: [0.8]")
                .worldRestart()
                .define("movement-melee-attack", 0.8);

        movementFollowOwner = builder
                .comment("Movement speed when following player.", "Example: [0.7]")
                .worldRestart()
                .define("movement-follow-owner", 0.7);

        movementWanderAround = builder
                .comment("Movement speed while it is wandering around.", "Example: [0.6]")
                .worldRestart()
                .define("movement-wander-around", 0.6);

        followDistanceMax = builder
                .comment("Maximum distance allowed while following.", "Example: [10]")
                .worldRestart()
                .define("follow-distance-max", 10.0);

        followDistanceMin = builder
                .comment("Minimum distance allowed while following.", "Example: [2]")
                .worldRestart()
                .define("follow-distance-min", 0.2);

        lookRange = builder
                .comment("How much should the head rotate while looking.", "Example: [8]")
                .worldRestart()
                .define("look-range", 8.0);
        builder.pop();

        builder.push("Renderer");
        width = builder
                .comment("Entity hit-box width.", "Example: [0.4]")
                .worldRestart()
                .define("width", 0.4);

        height = builder
                .comment("Entity hit-box height.", "Example: [1.9]")
                .worldRestart()
                .define("height", 1.9);
        builder.pop();

        builder.push("Level & Experience");
        experienceBase = builder
                .comment("Basic experience required to level up.", "Example: [50]")
                .worldRestart()
                .define("experience-base", 50);

        experienceMultiplier = builder
                .comment("Increase level experience multiplier.", "Example: [2]")
                .worldRestart()
                .define("experience-multiplier", 2);
        builder.pop();

        builder.push("Combat");
        attackChance = builder
                .comment("Probability of attacking when attacked.", "Example: [5]")
                .worldRestart()
                .define("attack-chance", 5);

        healInterval = builder
                .comment("Automatic recovery interval.", "Example: [50]")
                .worldRestart()
                .define("heal-interval", 50);

        waryTime = builder
                .comment("Time while being in combat mode.", "Example: [50]")
                .worldRestart()
                .define("wary-time", 50);

        globalAutoHeal = builder
                .comment("Enable/disable global robots healing.", "Example: [true/false]")
                .worldRestart()
                .define("global-heal", true);

        lootEnchantment = builder
                .comment("Enable looting enchantments.", "Example: [true/false]")
                .worldRestart()
                .define("loot-enchantment", true);

        lootEnchantmentLevel = builder
                .comment("Levels required for looting enchantments.", "Example: [10]")
                .worldRestart()
                .define("loot-enchantment-level", 10);

        maxLootEnchantment = builder
                .comment("Maximum level of looting enchantments.", "Example: [3]")
                .worldRestart()
                .define("max-loot-enchantment", 3);

        baseDefenceRange = builder
                .comment("Base range to defend.", "Example: [15F]")
                .worldRestart()
                .define("base-defence-range", 15.0);

        baseDefenceWarpRange = builder
                .comment("Range till teleport back to base.", "Example: [10F]")
                .worldRestart()
                .define("base-defence-warp-range", 10.0);
        builder.pop();

        builder.push("Protection");
        protectionLimitFire = builder
                .comment("Fire protection upper limit.", "Example: [80]")
                .worldRestart()
                .define("limit-fire", 80);

        protectionLimitFall = builder
                .comment("Fall protection upper limit.", "Example: [80]")
                .worldRestart()
                .define("limit-fall", 80);

        protectionLimitBlast = builder
                .comment("Blast protection upper limit.", "Example: [80]")
                .worldRestart()
                .define("limit-blast", 80);

        protectionLimitProjectile = builder
                .comment("Projectile protection upper limit.", "Example: [80]")
                .worldRestart()
                .define("limit-projectile", 80);
        builder.pop();

        builder.push("Entity");

        builder.push("Bunny");
        bunnyAttributeMaxLevel = builder
                .comment("Maximum Level", "Example: [200]")
                .worldRestart()
                .define("max-level", 200);

        bunnyAttributeMaxHealth = builder
                .comment("Maximum Health", "Example: [30.0]")
                .worldRestart()
                .define("max-health", 30.0);

        bunnyAttributeAttackDamage = builder
                .comment("Attack Damage", "Example: [5.0]")
                .worldRestart()
                .define("attack-damage", 5.0);

        bunnyAttributeAttackSpeed = builder
                .comment("Attack Speed", "Example: [ 1.2]")
                .worldRestart()
                .define("attack-speed",  1.2);

        bunnyAttributeMovementSpeed = builder
                .comment("Movement Speed", "Example: [0.4]")
                .worldRestart()
                .define("movement-speed", 0.6);

        bunnyAttributeArmor = builder
                .comment("Armor", "Example: [0.0]")
                .worldRestart()
                .define("armor", 5.0);

        bunnyAttributeArmorToughness = builder
                .comment("Armor Toughness", "Example: [0.0]")
                .worldRestart()
                .define("armor-toughness",0.0);
        builder.pop();

        builder.push("Bunny2");
        bunny2AttributeMaxLevel = builder
                .comment("Maximum Level", "Example: [200]")
                .worldRestart()
                .define("max-level", 200);

        bunny2AttributeMaxHealth = builder
                .comment("Maximum Health", "Example: [30.0]")
                .worldRestart()
                .define("max-health", 30.0);

        bunny2AttributeAttackDamage = builder
                .comment("Attack Damage", "Example: [5.0]")
                .worldRestart()
                .define("attack-damage", 5.0);

        bunny2AttributeAttackSpeed = builder
                .comment("Attack Speed", "Example: [ 1.2]")
                .worldRestart()
                .define("attack-speed",  1.2);

        bunny2AttributeMovementSpeed = builder
                .comment("Movement Speed", "Example: [0.4]")
                .worldRestart()
                .define("movement-speed", 0.6);

        bunny2AttributeArmor = builder
                .comment("Armor", "Example: [0.0]")
                .worldRestart()
                .define("armor", 5.0);

        bunny2AttributeArmorToughness = builder
                .comment("Armor Toughness", "Example: [0.0]")
                .worldRestart()
                .define("armor-toughness",0.0);
        builder.pop();

        builder.push("Dragon");
        dragonAttributeMaxLevel = builder
                .comment("Maximum Level", "Example: [200]")
                .worldRestart()
                .define("max-level", 200);

        dragonAttributeMaxHealth = builder
                .comment("Maximum Health", "Example: [30.0]")
                .worldRestart()
                .define("max-health", 30.0);

        dragonAttributeAttackDamage = builder
                .comment("Attack Damage", "Example: [5.0]")
                .worldRestart()
                .define("attack-damage", 5.0);

        dragonAttributeAttackSpeed = builder
                .comment("Attack Speed", "Example: [ 1.2]")
                .worldRestart()
                .define("attack-speed",  1.2);

        dragonAttributeMovementSpeed = builder
                .comment("Movement Speed", "Example: [0.4]")
                .worldRestart()
                .define("movement-speed", 0.4);

        dragonAttributeArmor = builder
                .comment("Armor", "Example: [0.0]")
                .worldRestart()
                .define("armor", 5.0);

        dragonAttributeArmorToughness = builder
                .comment("Armor Toughness", "Example: [0.0]")
                .worldRestart()
                .define("armor-toughness",0.0);
        builder.pop();

        builder.push("Honey");
        honeyAttributeMaxLevel = builder
                .comment("Maximum Level", "Example: [200]")
                .worldRestart()
                .define("max-level", 200);

        honeyAttributeMaxHealth = builder
                .comment("Maximum Health", "Example: [30.0]")
                .worldRestart()
                .define("max-health", 30.0);

        honeyAttributeAttackDamage = builder
                .comment("Attack Damage", "Example: [5.0]")
                .worldRestart()
                .define("attack-damage", 5.0);

        honeyAttributeAttackSpeed = builder
                .comment("Attack Speed", "Example: [ 1.2]")
                .worldRestart()
                .define("attack-speed",  1.2);

        honeyAttributeMovementSpeed = builder
                .comment("Movement Speed", "Example: [0.4]")
                .worldRestart()
                .define("movement-speed", 0.4);

        honeyAttributeArmor = builder
                .comment("Armor", "Example: [0.0]")
                .worldRestart()
                .define("armor", 5.0);

        honeyAttributeArmorToughness = builder
                .comment("Armor Toughness", "Example: [0.0]")
                .worldRestart()
                .define("armor-toughness",0.0);
        builder.pop();

        builder.push("Kitsune");
        kitsuneAttributeMaxLevel = builder
                .comment("Maximum Level", "Example: [200]")
                .worldRestart()
                .define("max-level", 200);

        kitsuneAttributeMaxHealth = builder
                .comment("Maximum Health", "Example: [30.0]")
                .worldRestart()
                .define("max-health", 30.0);

        kitsuneAttributeAttackDamage = builder
                .comment("Attack Damage", "Example: [5.0]")
                .worldRestart()
                .define("attack-damage", 5.0);

        kitsuneAttributeAttackSpeed = builder
                .comment("Attack Speed", "Example: [ 1.2]")
                .worldRestart()
                .define("attack-speed",  1.2);

        kitsuneAttributeMovementSpeed = builder
                .comment("Movement Speed", "Example: [0.4]")
                .worldRestart()
                .define("movement-speed", 0.4);

        kitsuneAttributeArmor = builder
                .comment("Armor", "Example: [0.0]")
                .worldRestart()
                .define("armor", 5.0);

        kitsuneAttributeArmorToughness = builder
                .comment("Armor Toughness", "Example: [0.0]")
                .worldRestart()
                .define("armor-toughness",0.0);
        builder.pop();

        builder.push("Neko");
        nekoAttributeMaxLevel = builder
                .comment("Maximum Level", "Example: [200]")
                .worldRestart()
                .define("max-level", 200);

        nekoAttributeMaxHealth = builder
                .comment("Maximum Health", "Example: [30.0]")
                .worldRestart()
                .define("max-health", 30.0);

        nekoAttributeAttackDamage = builder
                .comment("Attack Damage", "Example: [5.0]")
                .worldRestart()
                .define("attack-damage", 5.0);

        nekoAttributeAttackSpeed = builder
                .comment("Attack Speed", "Example: [ 1.2]")
                .worldRestart()
                .define("attack-speed",  1.2);

        nekoAttributeMovementSpeed = builder
                .comment("Movement Speed", "Example: [0.4]")
                .worldRestart()
                .define("movement-speed", 0.4);

        nekoAttributeArmor = builder
                .comment("Armor", "Example: [0.0]")
                .worldRestart()
                .define("armor", 5.0);

        nekoAttributeArmorToughness = builder
                .comment("Armor Toughness", "Example: [0.0]")
                .worldRestart()
                .define("armor-toughness",0.0);
        builder.pop();

        builder.push("Vanilla");
        vanillaAttributeMaxLevel = builder
                .comment("Maximum Level", "Example: [200.0]")
                .worldRestart()
                .define("max-level", 200);

        vanillaAttributeMaxHealth = builder
                .comment("Maximum Health", "Example: [30.0]")
                .worldRestart()
                .define("max-health", 30.0);

        vanillaAttributeAttackDamage = builder
                .comment("Attack Damage", "Example: [5.0]")
                .worldRestart()
                .define("attack-damage", 5.0);

        vanillaAttributeAttackSpeed = builder
                .comment("Attack Speed", "Example: [ 1.2]")
                .worldRestart()
                .define("attack-speed",  1.2);

        vanillaAttributeMovementSpeed = builder
                .comment("Movement Speed", "Example: [0.6]")
                .worldRestart()
                .define("movement-speed", 0.6);

        vanillaAttributeArmor = builder
                .comment("Armor", "Example: [0.0]")
                .worldRestart()
                .define("armor", 5.0);

        vanillaAttributeArmorToughness = builder
                .comment("Armor Toughness", "Example: [0.0]")
                .worldRestart()
                .define("armor-toughness",0.0);
        builder.pop();

        builder.pop();
    } // Constructor Common ()

} // Class Common