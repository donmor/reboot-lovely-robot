package net.msymbios.rlovelyr.entity.internal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.msymbios.rlovelyr.LovelyRobot;
import net.msymbios.rlovelyr.entity.enums.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InternalMetric {

    // -- GENERAL --
    public static ForgeConfigSpec.ConfigValue<Float> MOVEMENT_MELEE_ATTACK;
    public static ForgeConfigSpec.ConfigValue<Float> MOVEMENT_FOLLOW_OWNER;
    public static ForgeConfigSpec.ConfigValue<Float> MOVEMENT_WANDER_AROUND;
    public static ForgeConfigSpec.ConfigValue<Float> FOLLOW_DISTANCE_MAX;
    public static ForgeConfigSpec.ConfigValue<Float> FOLLOW_DISTANCE_MIN;
    public static ForgeConfigSpec.ConfigValue<Float> LOOK_RANGE;

    // -- RENDERER --
    public static ForgeConfigSpec.ConfigValue<Float> SHADOW_RADIUS;
    public static ForgeConfigSpec.ConfigValue<Float> WIDTH;
    public static ForgeConfigSpec.ConfigValue<Float> HEIGHT;

    // -- LEVEL | EXPERIENCE ---
    public static ForgeConfigSpec.ConfigValue<Integer> EXPERIENCE_BASE;
    public static ForgeConfigSpec.ConfigValue<Integer> EXPERIENCE_MULTIPLIER;

    // -- COMBAT --
    public static ForgeConfigSpec.ConfigValue<Integer> ATTACK_CHANCE;
    public static ForgeConfigSpec.ConfigValue<Boolean> GLOBAL_AUTO_HEAL;
    public static ForgeConfigSpec.ConfigValue<Integer> HEAL_INTERVAL;
    public static ForgeConfigSpec.ConfigValue<Integer> WARY_TIME;
    public static ForgeConfigSpec.ConfigValue<Boolean> LOOT_ENCHANTMENT;
    public static ForgeConfigSpec.ConfigValue<Integer> LOOT_ENCHANTMENT_LEVEL;
    public static ForgeConfigSpec.ConfigValue<Integer> MAX_LOOT_ENCHANTMENT;
    public static ForgeConfigSpec.ConfigValue<Integer> BASE_DEFENCE_RANGE;
    public static ForgeConfigSpec.ConfigValue<Integer> BASE_DEFENCE_WARP_RANGE;

    // -- PROTECTION --
    public static ForgeConfigSpec.ConfigValue<Integer> PROTECTION_LIMIT_FIRE;
    public static ForgeConfigSpec.ConfigValue<Integer> PROTECTION_LIMIT_FALL;
    public static ForgeConfigSpec.ConfigValue<Integer> PROTECTION_LIMIT_BLAST;
    public static ForgeConfigSpec.ConfigValue<Integer> PROTECTION_LIMIT_PROJECTILE;

    public static Predicate<LivingEntity> AvoidAttackingEntities = entity -> entity instanceof MonsterEntity && !(entity instanceof CreeperEntity); //&& !(entity instanceof Bunny2Entity) && !(entity instanceof BunnyEntity) && !(entity instanceof HoneyEntity);

    // -- Properties --
    public static HashMap<EntityVariant, EntityAnimator> ENTITY_ANIMATOR = new HashMap(){{
        put(EntityVariant.Bunny, EntityAnimator.Default);
        put(EntityVariant.Bunny2, EntityAnimator.Default);
        put(EntityVariant.Dragon, EntityAnimator.Default);
        put(EntityVariant.Honey, EntityAnimator.Default);
        put(EntityVariant.Kitsune, EntityAnimator.Default);
        put(EntityVariant.Neko, EntityAnimator.Default);
        put(EntityVariant.Vanilla, EntityAnimator.Default);
    }};

    public static HashMap<EntityVariant, HashMap<EntityModel, ResourceLocation>> ENTITY_MODEL = new HashMap(){{
        put(EntityVariant.Bunny, new HashMap() {{
            put(EntityModel.Default,    new ResourceLocation(LovelyRobot.MODID, "geo/bunny.geo.json"));
            put(EntityModel.Armed,      new ResourceLocation(LovelyRobot.MODID, "geo/bunny.attack.geo.json"));
        }});

        put(EntityVariant.Bunny2, new HashMap() {{
            put(EntityModel.Default,    new ResourceLocation(LovelyRobot.MODID, "geo/bunny2.geo.json"));
            put(EntityModel.Armed,      new ResourceLocation(LovelyRobot.MODID, "geo/bunny2.attack.geo.json"));
        }});

        put(EntityVariant.Dragon, new HashMap() {{
            put(EntityModel.Default,    new ResourceLocation(LovelyRobot.MODID, "geo/dragon.geo.json"));
            put(EntityModel.Armed,      new ResourceLocation(LovelyRobot.MODID, "geo/dragon.attack.geo.json"));
        }});

        put(EntityVariant.Honey, new HashMap() {{
            put(EntityModel.Default,    new ResourceLocation(LovelyRobot.MODID, "geo/honey.geo.json"));
            put(EntityModel.Armed,      new ResourceLocation(LovelyRobot.MODID, "geo/honey.attack.geo.json"));
        }});

        put(EntityVariant.Kitsune, new HashMap() {{
            put(EntityModel.Default,    new ResourceLocation(LovelyRobot.MODID, "geo/kitsune.geo.json"));
            put(EntityModel.Armed,      new ResourceLocation(LovelyRobot.MODID, "geo/kitsune.attack.geo.json"));
        }});

        put(EntityVariant.Neko, new HashMap() {{
            put(EntityModel.Default,    new ResourceLocation(LovelyRobot.MODID, "geo/neko.geo.json"));
            put(EntityModel.Armed,      new ResourceLocation(LovelyRobot.MODID, "geo/neko.attack.geo.json"));
        }});

        put(EntityVariant.Vanilla, new HashMap() {{
            put(EntityModel.Default,    new ResourceLocation(LovelyRobot.MODID, "geo/vanilla.geo.json"));
            put(EntityModel.Armed,      new ResourceLocation(LovelyRobot.MODID, "geo/vanilla.attack.geo.json"));
        }});
    }};

    public static HashMap<EntityTexture, List<EntityVariant>> ENTITY_TEXTURE = new HashMap(){{
        List<EntityVariant> list = new ArrayList() {{
            add(EntityVariant.Bunny);
            add(EntityVariant.Bunny2);
            add(EntityVariant.Dragon);
            add(EntityVariant.Honey);
            add(EntityVariant.Kitsune);
            add(EntityVariant.Neko);
            add(EntityVariant.Vanilla);
        }};
        put(EntityTexture.BLUE, list);
        put(EntityTexture.BLACK, list);
        put(EntityTexture.CYAN, list);
        put(EntityTexture.BROWN, list);
        put(EntityTexture.LIME, list);
        put(EntityTexture.GRAY, list);
        put(EntityTexture.GREEN, list);
        put(EntityTexture.LIGHT_BLUE, list);
        put(EntityTexture.LIGHT_GRAY, list);
        put(EntityTexture.MAGENTA, list);
        put(EntityTexture.ORANGE, list);
        put(EntityTexture.PINK, list);
        put(EntityTexture.PURPLE, list);
        put(EntityTexture.RED, list);
        put(EntityTexture.WHITE, list);
        put(EntityTexture.YELLOW, list);
    }};

    public static HashMap<EntityAnimator, ResourceLocation> ANIMATOR = new HashMap() {{
        put(EntityAnimator.Default,    new ResourceLocation(LovelyRobot.MODID, "animations/default.animation.json"));
    }};

    public static HashMap<EntityVariant, HashMap<EntityTexture, ResourceLocation>> TEXTURE = new HashMap(){{
        put(EntityVariant.Bunny,    setTexture(EntityVariant.Bunny));
        put(EntityVariant.Bunny2,    setTexture(EntityVariant.Bunny2));
        put(EntityVariant.Dragon,    setTexture(EntityVariant.Dragon));
        put(EntityVariant.Honey,    setTexture(EntityVariant.Honey));
        put(EntityVariant.Kitsune,    setTexture(EntityVariant.Kitsune));
        put(EntityVariant.Neko,    setTexture(EntityVariant.Neko));
        put(EntityVariant.Vanilla,    setTexture(EntityVariant.Vanilla));
    }};

    public static HashMap<EntityVariant, HashMap<EntityAttribute, Float>> ATTRIBUTES = new HashMap();

    // -- Methods --

    // ANIMATOR
    public static ResourceLocation getAnimator(EntityVariant variant) {
        EntityAnimator selectedAnimator = ENTITY_ANIMATOR.get(variant);
        if (selectedAnimator != null && ANIMATOR.containsKey(selectedAnimator)) return ANIMATOR.get(selectedAnimator);
        return null; // Animator not found
    } // getAnimator ()

    public static ResourceLocation getAnimator(EntityVariant variant, EntityAnimator animator) {
        EntityAnimator selectedAnimator = ENTITY_ANIMATOR.get(variant);
        if (selectedAnimator != null && selectedAnimator == animator && ANIMATOR.containsKey(animator)) return ANIMATOR.get(animator);
        return null; // Animator not found for the specified parameters
    } // getAnimator ()

    // MODEL
    public static ResourceLocation getModel(EntityVariant variant, EntityModel model) {
        if (ENTITY_MODEL.containsKey(variant) && ENTITY_MODEL.get(variant).containsKey(model)) return ENTITY_MODEL.get(variant).get(model);
        return null;  // Return a default or error identifier if the combination is not found
    } // getModel ()

    // TEXTURE
    public static ResourceLocation getTexture(EntityVariant variant) {
        EntityTexture randomTexture = EntityTexture.byId(getRandomTextureID(variant));
        if (ENTITY_TEXTURE.containsKey(randomTexture) && ENTITY_TEXTURE.get(randomTexture).contains(variant)) {
            if (TEXTURE.containsKey(variant) && TEXTURE.get(variant).containsKey(randomTexture)) return TEXTURE.get(variant).get(randomTexture);
        }

        return null; // Return a default or error identifier if the combination is not found
    } // getTexture ()

    public static ResourceLocation getTexture(EntityVariant variant, EntityTexture texture) {
        if (ENTITY_TEXTURE.containsKey(texture) && ENTITY_TEXTURE.get(texture).contains(variant)) {
            if (TEXTURE.containsKey(variant) && TEXTURE.get(variant).containsKey(texture)) return TEXTURE.get(variant).get(texture);
        }

        EntityTexture randomTexture = EntityTexture.byId(getRandomTextureID(variant));
        // If the texture doesn't exist for the specified variant, return the default texture
        if (TEXTURE.containsKey(variant) && TEXTURE.get(variant).containsKey(randomTexture))
            return TEXTURE.get(variant).get(randomTexture);

        return null; // Return a default or error identifier if the combination is not found
    } // getTexture ()

    public static boolean checkTextureID(EntityVariant variant, EntityTexture texture) {
        if (ENTITY_TEXTURE.containsKey(texture) && ENTITY_TEXTURE.get(texture).contains(variant))
            return TEXTURE.containsKey(variant) && TEXTURE.get(variant).containsKey(texture);
        return false;
    } // checkTextureID ()

    public static int getRandomTextureID(EntityVariant variant) {
        List<EntityTexture> textures = ENTITY_TEXTURE.keySet().stream().filter(entityTexture -> ENTITY_TEXTURE.get(entityTexture).contains(variant)).collect(Collectors.toList());
        if (!textures.isEmpty()) {
            EntityTexture randomTexture = textures.get(new Random().nextInt(textures.size()));
            return randomTexture.getId(); // Replace with the appropriate method to get the ID
        }

        // Return a default or error ID if no valid variant is found
        return -1;
    } // getRandomTextureID ()

    private static HashMap<EntityTexture, ResourceLocation> setTexture(EntityVariant variant){
        String path = variant.getName() + "/" + variant.getName();
        return new HashMap() {{
            put(EntityTexture.WHITE,         new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_00.png")); // White
            put(EntityTexture.ORANGE,        new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_01.png")); // Orange
            put(EntityTexture.MAGENTA,       new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_02.png")); // Magenta
            put(EntityTexture.LIGHT_BLUE,    new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_03.png")); // Light Blue
            put(EntityTexture.YELLOW,        new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_04.png")); // Yellow
            put(EntityTexture.LIME,          new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_05.png")); // Lime
            put(EntityTexture.PINK,          new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_06.png")); // Pink
            put(EntityTexture.GRAY,          new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_07.png")); // Gray
            put(EntityTexture.LIGHT_GRAY,    new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_08.png")); // Light Gray
            put(EntityTexture.CYAN,          new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_09.png")); // Cyan
            put(EntityTexture.PURPLE,        new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_10.png")); // Purple
            put(EntityTexture.BLUE,          new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_11.png")); // Blue
            put(EntityTexture.BROWN,         new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_12.png")); // Brown
            put(EntityTexture.GREEN,         new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_13.png")); // Green
            put(EntityTexture.RED,           new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_14.png")); // Red
            put(EntityTexture.BLACK,         new ResourceLocation(LovelyRobot.MODID, "textures/entity/" + path + "_15.png")); // Black
        }};
    } // setTexture ()

    // ATTRIBUTE
    public static float getAttribute(EntityVariant variant, EntityAttribute attribute) {
        return ATTRIBUTES.get(variant).get(attribute);
    } // getAttribute ()

    private static HashMap<EntityAttribute, Float> setAttribute(float maxLevel, float maxHealth, float attackDamage, float attackSpeed, float movementSpeed, float defense){
        return new HashMap(){{
            put(EntityAttribute.MAX_LEVEL, maxLevel);                // Max Level
            put(EntityAttribute.MAX_HEALTH, maxHealth);             // Max Health
            put(EntityAttribute.ATTACK_DAMAGE, attackDamage);    // Attack Damage
            put(EntityAttribute.ATTACK_SPEED, attackSpeed);       // Attack Speed
            put(EntityAttribute.MOVEMENT_SPEED,  movementSpeed); // Movement Speed
            put(EntityAttribute.DEFENSE, defense);                     // Defense
            put(EntityAttribute.ARMOR, 0F);
            put(EntityAttribute.ARMOR_TOUGHNESS, 0F);
            put(EntityAttribute.BASE_DEFENSE_RANGE, 15F);
            put(EntityAttribute.BASE_DEFENSE_WARP_RANGE, 10F);
        }};
    } // setAttribute ()

} // Class ModMetrics