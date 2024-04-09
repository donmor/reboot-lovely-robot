package net.msymbios.rlovelyr;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LovelyRobot implements ModInitializer {

	// -- Variables --
	public static final String MODID = "rlovelyr";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	} // onInitialize ()

} // Class LovelyRobot