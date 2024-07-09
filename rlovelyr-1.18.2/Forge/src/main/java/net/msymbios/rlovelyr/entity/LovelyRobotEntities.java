package net.msymbios.rlovelyr.entity;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msymbios.rlovelyr.LovelyRobot;
import net.msymbios.rlovelyr.config.LovelyRobotConfig;
import net.msymbios.rlovelyr.config.LovelyRobotID;
import net.msymbios.rlovelyr.entity.client.renderer.VanillaRenderer;
import net.msymbios.rlovelyr.entity.custom.VanillaEntity;
import net.msymbios.rlovelyr.entity.internal.InternalEntity;

public class LovelyRobotEntities {

    // -- Variables --
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, LovelyRobot.MODID);
    public static final RegistryObject<EntityType<VanillaEntity>> VANILLA = register(LovelyRobotID.VANILLA, MobCategory.CREATURE, LovelyRobotConfig.COMMON.width.get(), LovelyRobotConfig.COMMON.height.get(), VanillaEntity::new);

    // -- Methods --
    private static <T extends InternalEntity> RegistryObject<EntityType<T>> register(String name, MobCategory category, float width, float height, EntityType.EntityFactory<T> factory) {
        return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, category).sized(width, height).build(LovelyRobotID.getId(name).toString()));
    } // register ()

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    } // register ()

    /**
     * Registers default attributes for various entities.
     * */
    public static void registerAttribute(EntityAttributeCreationEvent event) {
        //event.put(LovelyRobotEntities.BUNNY.get(), BunnyEntity.createAttributes().build());
        //event.put(LovelyRobotEntities.BUNNY2.get(), Bunny2Entity.createAttributes().build());
        //event.put(LovelyRobotEntities.DRAGON.get(), DragonEntity.createAttributes().build());
        //event.put(LovelyRobotEntities.HONEY.get(), HoneyEntity.createAttributes().build());
        //event.put(LovelyRobotEntities.KITSUNE.get(), KitsuneEntity.createAttributes().build());
        //event.put(LovelyRobotEntities.NEKO.get(), NekoEntity.createAttributes().build());
        event.put(LovelyRobotEntities.VANILLA.get(), VanillaEntity.createAttributes().build());
    } // registerAttributes ()

    /**
     * Registers entity renderers for various entities.
     * */
    public static void registerRender() {
        //EntityRenderers.register(LovelyRobotEntities.BUNNY.get(), BunnyRenderer::new);
        //EntityRenderers.register(LovelyRobotEntities.BUNNY2.get(), Bunny2Renderer::new);
        //EntityRenderers.register(LovelyRobotEntities.DRAGON.get(), DragonRenderer::new);
        //EntityRenderers.register(LovelyRobotEntities.HONEY.get(), HoneyRenderer::new);
        //EntityRenderers.register(LovelyRobotEntities.KITSUNE.get(), KitsuneRenderer::new);
        //EntityRenderers.register(LovelyRobotEntities.NEKO.get(), NekoRenderer::new);
        EntityRenderers.register(LovelyRobotEntities.VANILLA.get(), VanillaRenderer::new);
    } // registerRenderer ()

} // Class LovelyRobotEntities