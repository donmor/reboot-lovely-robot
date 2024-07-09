package net.msymbios.rlovelyr.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.msymbios.rlovelyr.LovelyRobot;
import net.msymbios.rlovelyr.config.internal.Client;
import net.msymbios.rlovelyr.config.internal.Common;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;

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
    }

    // -- Methods --
    public static void register() {
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_SPEC);
    } // register ()

} // Class LovelyRobotConfig