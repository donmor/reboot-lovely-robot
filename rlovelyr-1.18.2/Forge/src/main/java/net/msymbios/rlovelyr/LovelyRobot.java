package net.msymbios.rlovelyr;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.msymbios.rlovelyr.common.util.ObjectUtil;
import net.msymbios.rlovelyr.common.util.internal.Version;
import net.msymbios.rlovelyr.config.LovelyRobotConfig;
import net.msymbios.rlovelyr.entity.LovelyRobotEntities;
import net.msymbios.rlovelyr.item.LovelyRobotItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.msymbios.rlovelyr.LovelyRobot.MODID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MODID)
public class LovelyRobot {

    // -- Variables --

    /**
     * The mod's ID, which is also the mod's namespace.
     */
    public static final String MODID = "rlovelyr";

    /**
     * The mod's version.
     */
    public static final Version VERSION = new Version(ObjectUtil.coalesce(LovelyRobot.class.getPackage().getSpecificationVersion(), "99999.0.0.0"));

    /**
     * The mod's logger.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    // -- Constructor --

    public LovelyRobot() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();

        event.addListener(this::clientSetup);
        event.addListener(this::commonSetup);

        LovelyRobotEntities.register(event);
        LovelyRobotItems.register(event);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        LovelyRobotConfig.register();
    } // LovelyRobot ()

    // -- Methods --
    private void clientSetup(final FMLClientSetupEvent event) {
        LovelyRobotEntities.registerRender();
    } // clientSetup ()

    private void commonSetup(final FMLCommonSetupEvent event) { } // commonSetup ()

} // Class LovelyRobot