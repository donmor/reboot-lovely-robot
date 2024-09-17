package net.msymbios.rlovelyr.client;

import net.fabricmc.api.ClientModInitializer;
import net.msymbios.rlovelyr.item.LovelyRobotItems;

public class LovelyRobotClient implements ClientModInitializer {

    // -- Inherited Method --

    @Override
    public void onInitializeClient() {
        LovelyRobotItems.registerModels();
    } // onInitializeClient ()

} // Class LovelyRobotClient