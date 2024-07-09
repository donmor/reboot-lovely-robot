package net.msymbios.rlovelyr.config.internal;

import com.electronwill.nightconfig.core.Config;
import net.minecraftforge.common.ForgeConfigSpec;

import javax.annotation.Nonnull;

/**
 * Config options only available to each client.
 */
public class Client {

    // -- Variables --

    // -- RENDERER --
    public final ForgeConfigSpec.ConfigValue<Float> shadowRadius;

    // -- Constructor --

    /**
     * @param builder the builder used to create the config.
     */
    public Client(@Nonnull ForgeConfigSpec.Builder builder) {
        Config.setInsertionOrderPreserved(true);

        builder.push("Renderer");
        shadowRadius = builder
                .comment("Entity shadow cast size on the ground.", "Example: [0.4F]")
                .define("shadow-radius", 0.4F);
        builder.pop();

    } // Constructor Client ()

} // Class Client