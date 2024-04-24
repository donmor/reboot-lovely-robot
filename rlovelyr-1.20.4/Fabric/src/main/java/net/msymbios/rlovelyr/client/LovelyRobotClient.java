package net.msymbios.rlovelyr.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.msymbios.rlovelyr.config.LovelyRobotID;
import net.msymbios.rlovelyr.entity.LovelyRobotEntities;
import net.msymbios.rlovelyr.entity.enums.EntityTexture;
import net.msymbios.rlovelyr.item.LovelyRobotItems;

public class LovelyRobotClient implements ClientModInitializer {

    // -- Method --
    @Override
    public void onInitializeClient() {
        LovelyRobotEntities.registerRender();

        //ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3495eb, LovelyRobotItems.VANILLA_SPAWN);

        ModelPredicateProviderRegistry.register(LovelyRobotItems.VANILLA_SPAWN, new Identifier(LovelyRobotID.STAT_COLOR), (stack, world, entity, seed) -> {
            if (entity == null) return EntityTexture.RANDOM.getId();
            return entity.getActiveItem() != stack ? EntityTexture.RANDOM.getId() : stack.getNbt().getInt(LovelyRobotID.STAT_COLOR);
        });
    } // onInitializeClient ()

} // Class LovelyRobotClient