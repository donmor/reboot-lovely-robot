package net.msymbios.rlovelyr.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.msymbios.rlovelyr.LovelyRobot;
import net.msymbios.rlovelyr.config.internal.Client;
import net.msymbios.rlovelyr.config.internal.Common;
import net.msymbios.rlovelyr.entity.internal.InternalMetric;
import net.msymbios.rlovelyr.entity.internal.enums.EntityAttribute;
import net.msymbios.rlovelyr.entity.internal.enums.EntityVariant;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import java.util.HashMap;

@Mod.EventBusSubscriber(modid = LovelyRobot.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LovelyRobotConfig {

    // -- Variables --

    @Nonnull
    public static final Common COMMON;

    @Nonnull
    public static final Client CLIENT;

    @Nonnull
    public static final ForgeConfigSpec COMMON_SPEC;

    @Nonnull
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON = commonSpecPair.getLeft();
        COMMON_SPEC = commonSpecPair.getRight();

        Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT = clientSpecPair.getLeft();
        CLIENT_SPEC = clientSpecPair.getRight();

        InternalMetric.ATTRIBUTES.put(EntityVariant.Bunny, new HashMap<>() {{
            put(EntityAttribute.MAX_LEVEL,               COMMON.bunnyAttributeMaxLevel.get().floatValue());
            put(EntityAttribute.MAX_HEALTH,              COMMON.bunnyAttributeMaxHealth.get().floatValue());
            put(EntityAttribute.ATTACK_DAMAGE,           COMMON.bunnyAttributeAttackDamage.get().floatValue());
            put(EntityAttribute.ATTACK_SPEED,            COMMON.bunnyAttributeAttackSpeed.get().floatValue());
            put(EntityAttribute.MOVEMENT_SPEED,          COMMON.bunnyAttributeMovementSpeed.get().floatValue());
            put(EntityAttribute.DEFENSE,                 COMMON.bunnyAttributeDefense.get().floatValue());
            put(EntityAttribute.ARMOR,                   COMMON.bunnyAttributeArmor.get().floatValue());
            put(EntityAttribute.ARMOR_TOUGHNESS,         COMMON.bunnyAttributeArmorToughness.get().floatValue());
            put(EntityAttribute.BASE_DEFENSE_RANGE,      15F);
            put(EntityAttribute.BASE_DEFENSE_WARP_RANGE, 10F);
        }});

        InternalMetric.ATTRIBUTES.put(EntityVariant.Bunny2, new HashMap<>() {{
            put(EntityAttribute.MAX_LEVEL,               COMMON.bunny2AttributeMaxLevel.get().floatValue());
            put(EntityAttribute.MAX_HEALTH,              COMMON.bunny2AttributeMaxHealth.get().floatValue());
            put(EntityAttribute.ATTACK_DAMAGE,           COMMON.bunny2AttributeAttackDamage.get().floatValue());
            put(EntityAttribute.ATTACK_SPEED,            COMMON.bunny2AttributeAttackSpeed.get().floatValue());
            put(EntityAttribute.MOVEMENT_SPEED,          COMMON.bunny2AttributeMovementSpeed.get().floatValue());
            put(EntityAttribute.DEFENSE,                 COMMON.bunny2AttributeDefense.get().floatValue());
            put(EntityAttribute.ARMOR,                   COMMON.bunny2AttributeArmor.get().floatValue());
            put(EntityAttribute.ARMOR_TOUGHNESS,         COMMON.bunny2AttributeArmorToughness.get().floatValue());
            put(EntityAttribute.BASE_DEFENSE_RANGE,      15F);
            put(EntityAttribute.BASE_DEFENSE_WARP_RANGE, 10F);
        }});

        InternalMetric.ATTRIBUTES.put(EntityVariant.Dragon, new HashMap<>() {{
            put(EntityAttribute.MAX_LEVEL,               COMMON.dragonAttributeMaxLevel.get().floatValue());
            put(EntityAttribute.MAX_HEALTH,              COMMON.dragonAttributeMaxHealth.get().floatValue());
            put(EntityAttribute.ATTACK_DAMAGE,           COMMON.dragonAttributeAttackDamage.get().floatValue());
            put(EntityAttribute.ATTACK_SPEED,            COMMON.dragonAttributeAttackSpeed.get().floatValue());
            put(EntityAttribute.MOVEMENT_SPEED,          COMMON.dragonAttributeMovementSpeed.get().floatValue());
            put(EntityAttribute.DEFENSE,                 COMMON.dragonAttributeDefense.get().floatValue());
            put(EntityAttribute.ARMOR,                   COMMON.dragonAttributeArmor.get().floatValue());
            put(EntityAttribute.ARMOR_TOUGHNESS,         COMMON.dragonAttributeArmorToughness.get().floatValue());
            put(EntityAttribute.BASE_DEFENSE_RANGE,      15F);
            put(EntityAttribute.BASE_DEFENSE_WARP_RANGE, 10F);
        }});

        InternalMetric.ATTRIBUTES.put(EntityVariant.Honey, new HashMap<>() {{
            put(EntityAttribute.MAX_LEVEL,               COMMON.honeyAttributeMaxLevel.get().floatValue());
            put(EntityAttribute.MAX_HEALTH,              COMMON.honeyAttributeMaxHealth.get().floatValue());
            put(EntityAttribute.ATTACK_DAMAGE,           COMMON.honeyAttributeAttackDamage.get().floatValue());
            put(EntityAttribute.ATTACK_SPEED,            COMMON.honeyAttributeAttackSpeed.get().floatValue());
            put(EntityAttribute.MOVEMENT_SPEED,          COMMON.honeyAttributeMovementSpeed.get().floatValue());
            put(EntityAttribute.DEFENSE,                 COMMON.honeyAttributeDefense.get().floatValue());
            put(EntityAttribute.ARMOR,                   COMMON.honeyAttributeArmor.get().floatValue());
            put(EntityAttribute.ARMOR_TOUGHNESS,         COMMON.honeyAttributeArmorToughness.get().floatValue());
            put(EntityAttribute.BASE_DEFENSE_RANGE,      15F);
            put(EntityAttribute.BASE_DEFENSE_WARP_RANGE, 10F);
        }});

        InternalMetric.ATTRIBUTES.put(EntityVariant.Vanilla, new HashMap<>() {{
            put(EntityAttribute.MAX_LEVEL,               COMMON.vanillaAttributeMaxLevel.get().floatValue());
            put(EntityAttribute.MAX_HEALTH,              COMMON.vanillaAttributeMaxHealth.get().floatValue());
            put(EntityAttribute.ATTACK_DAMAGE,           COMMON.vanillaAttributeAttackDamage.get().floatValue());
            put(EntityAttribute.ATTACK_SPEED,            COMMON.vanillaAttributeAttackSpeed.get().floatValue());
            put(EntityAttribute.MOVEMENT_SPEED,          COMMON.vanillaAttributeMovementSpeed.get().floatValue());
            put(EntityAttribute.DEFENSE,                 COMMON.vanillaAttributeDefense.get().floatValue());
            put(EntityAttribute.ARMOR,                   COMMON.vanillaAttributeArmor.get().floatValue());
            put(EntityAttribute.ARMOR_TOUGHNESS,         COMMON.vanillaAttributeArmorToughness.get().floatValue());
            put(EntityAttribute.BASE_DEFENSE_RANGE,      15F);
            put(EntityAttribute.BASE_DEFENSE_WARP_RANGE, 10F);
        }});
    }

    // -- Methods --
    public static void register() {
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_SPEC);
    } // register ()

} // Class LovelyRobotConfig