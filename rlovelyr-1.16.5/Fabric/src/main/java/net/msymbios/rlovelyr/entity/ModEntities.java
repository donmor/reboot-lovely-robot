package net.msymbios.rlovelyr.entity;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.rlovelyr.LovelyRobotMod;
import net.msymbios.rlovelyr.entity.client.Bunny2Renderer;
import net.msymbios.rlovelyr.entity.client.BunnyRenderer;
import net.msymbios.rlovelyr.entity.client.HoneyRenderer;
import net.msymbios.rlovelyr.entity.client.VanillaRenderer;
import net.msymbios.rlovelyr.entity.custom.Bunny2Entity;
import net.msymbios.rlovelyr.entity.custom.BunnyEntity;
import net.msymbios.rlovelyr.entity.custom.HoneyEntity;
import net.msymbios.rlovelyr.entity.custom.VanillaEntity;

public class ModEntities {

    // -- Variables --
    public static final EntityType<BunnyEntity> BUNNY = Registry.register(Registry.ENTITY_TYPE, new Identifier(LovelyRobotMod.MODID, "bunny"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BunnyEntity::new).dimensions(EntityDimensions.fixed(0.4F, 2F)).build());
    public static final EntityType<Bunny2Entity> BUNNY2 = Registry.register(Registry.ENTITY_TYPE, new Identifier(LovelyRobotMod.MODID, "bunny2"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Bunny2Entity::new).dimensions(EntityDimensions.fixed(0.4F, 2F)).build());
    public static final EntityType<HoneyEntity> HONEY = Registry.register(Registry.ENTITY_TYPE, new Identifier(LovelyRobotMod.MODID, "honey"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HoneyEntity::new).dimensions(EntityDimensions.fixed(0.4F, 2F)).build());
    public static final EntityType<VanillaEntity> VANILLA = Registry.register(Registry.ENTITY_TYPE, new Identifier(LovelyRobotMod.MODID, "vanilla"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, VanillaEntity::new).dimensions(EntityDimensions.fixed(0.4F, 2F)).build());

    // -- Methods --
    public static void registerEntityAttribute(){
        FabricDefaultAttributeRegistry.register(BUNNY, BunnyEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(BUNNY2, Bunny2Entity.setAttributes());
        FabricDefaultAttributeRegistry.register(HONEY, HoneyEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(VANILLA, VanillaEntity.setAttributes());
    } // registerEntityAttribute ()

    public static void registerEntityRenderer(){
        EntityRendererRegistry.INSTANCE.register(BUNNY, BunnyRenderer::new);
        EntityRendererRegistry.INSTANCE.register(BUNNY2, Bunny2Renderer::new);
        EntityRendererRegistry.INSTANCE.register(VANILLA, VanillaRenderer::new);
        EntityRendererRegistry.INSTANCE.register(HONEY, HoneyRenderer::new);
    } // registerEntityRenderer ()

} // Class ModEntities
