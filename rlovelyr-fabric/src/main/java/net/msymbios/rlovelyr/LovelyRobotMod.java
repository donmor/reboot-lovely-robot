package net.msymbios.rlovelyr;

import net.fabricmc.api.ModInitializer;
import net.msymbios.rlovelyr.entity.ModEntities;
import net.msymbios.rlovelyr.item.ModItems;
import software.bernie.geckolib3.GeckoLib;

public class LovelyRobotMod implements ModInitializer {

	// -- Variables --
	public static final String MODID = "rlovelyr";
	//public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	// -- Methods --
	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		GeckoLib.initialize();

		ModEntities.registerEntityAttribute();
	} // onInitialize ()

} // Class LovelyRobotMod