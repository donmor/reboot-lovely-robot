package net.msymbios.rlovelyr.config;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.msymbios.rlovelyr.LovelyRobot;

public class LovelyRobotID {

    // -- Items Group --
    public static final String DEFAULT_GROUP = "lovely_robot";

    // -- Items --

    // GENERAL
    public static final String ROBOT_CORE = "robot_core";

    // SPAWN
    public static final String BUNNY_SPAWN = "bunny_spawn";
    public static final String BUNNY2_SPAWN = "bunny2_spawn";
    public static final String DRAGON_SPAWN = "dragon_spawn";
    public static final String HONEY_SPAWN = "honey_spawn";
    public static final String KITSUNE_SPAWN = "kitsune_spawn";
    public static final String NEKO_SPAWN = "neko_spawn";
    public static final String VANILLA_SPAWN = "vanilla_spawn";

    // -- Entities --

    // ROBOTS
    public static final String BUNNY = "bunny";
    public static final String BUNNY2 = "bunny2";
    public static final String DRAGON = "dragon";
    public static final String HONEY = "honey";
    public static final String KITSUNE = "kitsune";
    public static final String NEKO = "neko";
    public static final String VANILLA = "vanilla";

    // -- Stats --
    public static final String STAT_CUSTOM_NAME = "custom_name";
    public static final String STAT_COLOR = "color";
    public static final String STAT_TYPE = "type";
    public static final String STAT_MAX_LEVEL = "max_level";
    public static final String STAT_LEVEL = "level";
    public static final String STAT_EXP = "exp";
    public static final String STAT_FIRE_PROTECTION = "fire_protection";
    public static final String STAT_FALL_PROTECTION = "fall_protection";
    public static final String STAT_BLAST_PROTECTION = "blast_protection";
    public static final String STAT_PROJECTILE_PROTECTION = "projectile_protection";

    // -- Animators --
    public static final String ANIM_DEFAULT = "default";

    // -- Attributes --
    public static final String ATTR_MAX_HEALTH = "max_health";
    public static final String ATTR_MAX_LEVEL = "max_level";
    public static final String ATTR_ATTACK_DAMAGE = "attack_damage";
    public static final String ATTR_ATTACK_SPEED = "attack_speed";
    public static final String ATTR_MOVEMENT_SPEED = "movement_speed";
    public static final String ATTR_DEFENSE = "defense";
    public static final String ATTR_ARMOR = "armor";
    public static final String ATTR_ARMOR_TOUGHNESS = "armor_toughness";
    public static final String ATTR_BASE_DEFENSE = "base_defense_range";
    public static final String ATTR_BASE_DEFENSE_WARP = "base_defense_warp_range";

    // -- Models --
    public static final String MOD_DEFAULT = "default";
    public static final String MOD_ARMED = "armed";

    // -- Textures --
    public static final String TEX_WHITE = "white";
    public static final String TEX_ORANGE = "orange";
    public static final String TEX_MAGENTA = "magenta";
    public static final String TEX_LIGHT_BLUE = "light_blue";
    public static final String TEX_YELLOW = "yellow";
    public static final String TEX_LIME = "lime";
    public static final String TEX_PINK = "pink";
    public static final String TEX_GRAY = "gray";
    public static final String TEX_LIGHT_GRAY = "light_gray";
    public static final String TEX_CYAN = "cyan";
    public static final String TEX_PURPLE = "purple";
    public static final String TEX_BLUE = "blue";
    public static final String TEX_BROWN = "brown";
    public static final String TEX_GREEN = "green";
    public static final String TEX_RED = "red";
    public static final String TEX_BLACK = "black";
    public static final String TEX_RANDOM = "random";

    // -- Methods --

    public static TranslatableComponent getTranslation(final String key) {
        return new TranslatableComponent(LovelyRobot.MODID + "." + key);
    } // getTranslation ()

    public static TranslatableComponent getTranslation(final String key, Object... objects) {
        return new TranslatableComponent(LovelyRobot.MODID + "." + key, objects);
    } // getTranslation ()

    public static ResourceLocation getId(final String path) {
        return new ResourceLocation(LovelyRobot.MODID, path);
    } // getId ()

    public static ResourceLocation getId(final String namespace, final String path) {
        if (namespace == null || namespace.isEmpty())
            return getId(path);
        return new ResourceLocation(namespace, path);
    } // getId ()

} // Class LovelyRobotID