package net.msymbios.rlovelyr.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.msymbios.rlovelyr.LovelyRobot;
import net.msymbios.rlovelyr.common.item.InternalItems;
import net.msymbios.rlovelyr.config.LovelyRobotID;
import net.msymbios.rlovelyr.item.custom.RobotCoreItem;

public class LovelyRobotItems extends InternalItems {

    // -- Variables --

    // MISCELLANEOUS
    public static final Item ROBOT_CORE = register(LovelyRobotID.getId(LovelyRobotID.ROBOT_CORE), new RobotCoreItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));

    // SPAWNS
    public static final Item BUNNY_SPAWN = register(LovelyRobotID.getId(LovelyRobotID.BUNNY_SPAWN), new RobotCoreItem(new FabricItemSettings()));
    public static final Item BUNNY2_SPAWN = register(LovelyRobotID.getId(LovelyRobotID.BUNNY2_SPAWN), new RobotCoreItem(new FabricItemSettings()));
    public static final Item DRAGON_SPAWN = register(LovelyRobotID.getId(LovelyRobotID.DRAGON_SPAWN), new RobotCoreItem(new FabricItemSettings()));
    public static final Item HONEY_SPAWN = register(LovelyRobotID.getId(LovelyRobotID.HONEY_SPAWN), new RobotCoreItem(new FabricItemSettings()));
    public static final Item KITSUNE_SPAWN = register(LovelyRobotID.getId(LovelyRobotID.KITSUNE_SPAWN), new RobotCoreItem(new FabricItemSettings()));
    public static final Item NEKO_SPAWN = register(LovelyRobotID.getId(LovelyRobotID.NEKO_SPAWN), new RobotCoreItem(new FabricItemSettings()));
    public static final Item VANILLA_SPAWN = register(LovelyRobotID.getId(LovelyRobotID.VANILLA_SPAWN), new RobotCoreItem(new FabricItemSettings()));

    // -- Methods --

    public static void register() {
        LovelyRobot.LOGGER.info("Registering Items: " + LovelyRobot.MODID );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(LovelyRobotItems::spawnEggItemsEntry);
        ItemGroupEvents.modifyEntriesEvent(LovelyRobotItemsGroup.DEFAULT_KEY).register(LovelyRobotItems::allItemsEntry);
    } // register ()

    private static void spawnEggItemsEntry(FabricItemGroupEntries entries) {
        entries.add(BUNNY_SPAWN);
        entries.add(BUNNY2_SPAWN);
        entries.add(DRAGON_SPAWN);
        entries.add(HONEY_SPAWN);
        entries.add(KITSUNE_SPAWN);
        entries.add(NEKO_SPAWN);
        entries.add(VANILLA_SPAWN);
    } // spawnEggItemsEntry ()

    private static void allItemsEntry(FabricItemGroupEntries entries) {
        entries.add(ROBOT_CORE);

        entries.add(BUNNY_SPAWN);
        entries.add(BUNNY2_SPAWN);
        entries.add(DRAGON_SPAWN);
        entries.add(HONEY_SPAWN);
        entries.add(KITSUNE_SPAWN);
        entries.add(NEKO_SPAWN);
        entries.add(VANILLA_SPAWN);
    } // allItemsEntry ()

    public static void registerModels() {
        ModelPredicateProviderRegistry.register(LovelyRobotID.getId(LovelyRobotID.ITEM_TAG_VARIANT), (stack, world, entity, seed) -> stack.getNbt() != null && stack.getNbt().contains(LovelyRobotID.STAT_COLOR) ? stack.getNbt().getInt(LovelyRobotID.STAT_COLOR) : 16);

        // Register the model for each item
        registerModel(LovelyRobotItems.BUNNY_SPAWN, LovelyRobotID.getId(LovelyRobotID.ITEM_TAG_VARIANT), LovelyRobotID.STAT_COLOR);
        registerModel(LovelyRobotItems.BUNNY2_SPAWN, LovelyRobotID.getId(LovelyRobotID.ITEM_TAG_VARIANT), LovelyRobotID.STAT_COLOR);
        registerModel(LovelyRobotItems.DRAGON_SPAWN, LovelyRobotID.getId(LovelyRobotID.ITEM_TAG_VARIANT), LovelyRobotID.STAT_COLOR);
        registerModel(LovelyRobotItems.HONEY_SPAWN, LovelyRobotID.getId(LovelyRobotID.ITEM_TAG_VARIANT), LovelyRobotID.STAT_COLOR);
        registerModel(LovelyRobotItems.KITSUNE_SPAWN, LovelyRobotID.getId(LovelyRobotID.ITEM_TAG_VARIANT), LovelyRobotID.STAT_COLOR);
        registerModel(LovelyRobotItems.NEKO_SPAWN, LovelyRobotID.getId(LovelyRobotID.ITEM_TAG_VARIANT), LovelyRobotID.STAT_COLOR);
        registerModel(LovelyRobotItems.VANILLA_SPAWN, LovelyRobotID.getId(LovelyRobotID.ITEM_TAG_VARIANT), LovelyRobotID.STAT_COLOR);
    } // registerModels ()

    private static void registerModel(Item item, String tag, String key) {
        // Use ModelPredicateProviderRegistry to register custom model predicate
        // Check if item stack has the tag and return the value for the model predicate
        ModelPredicateProviderRegistry.register(item, LovelyRobotID.getId(tag), (stack, world, entity, seed) -> stack.getNbt() != null && stack.getNbt().contains(key) ? stack.getNbt().getInt(key) : 16);
    } // registerModel ()

    private static void registerModel(Item item, Identifier tag, String key) {
        // Use ModelPredicateProviderRegistry to register custom model predicate
        // Check if item stack has the tag and return the value for the model predicate
        ModelPredicateProviderRegistry.register(item, tag, (stack, world, entity, seed) -> stack.getNbt() != null && stack.getNbt().contains(key) ? stack.getNbt().getInt(key) : 16);
    } // registerModel ()

} // Class LovelyRobotItems