package net.msymbios.rlovelyr.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.rlovelyr.LovelyRobotMod;
import net.msymbios.rlovelyr.entity.ModEntities;
import net.msymbios.rlovelyr.item.custom.RobotSpawnItem;

public class ModItems {

    // -- Variables --
    public static final Item BUNNY_SPAWN = registerItem("bunny_spawn", new RobotSpawnItem(ModEntities.BUNNY, new FabricItemSettings().group(ModItemGroup.LOVELY_ROBOT)));
    public static final Item BUNNY2_SPAWN = registerItem("bunny2_spawn", new RobotSpawnItem(ModEntities.BUNNY2, new FabricItemSettings().group(ModItemGroup.LOVELY_ROBOT)));
    public static final Item HONEY_SPAWN = registerItem("honey_spawn", new RobotSpawnItem(ModEntities.HONEY, new FabricItemSettings().group(ModItemGroup.LOVELY_ROBOT)));
    public static final Item VANILLA_SPAWN = registerItem("vanilla_spawn", new RobotSpawnItem(ModEntities.VANILLA, new FabricItemSettings().group(ModItemGroup.LOVELY_ROBOT)));
    public static final Item ROBOT_CORE = registerItem("robot_core", new Item(new FabricItemSettings().group(ModItemGroup.LOVELY_ROBOT)));

    // -- Methods --
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(LovelyRobotMod.MODID, name), item);
    } // registerItem ()

    public static void registerModItems() {
        LovelyRobotMod.LOGGER.debug(LovelyRobotMod.MODID + ": Registering Items");
    } // registerModItems ()

} // Class ModItems
