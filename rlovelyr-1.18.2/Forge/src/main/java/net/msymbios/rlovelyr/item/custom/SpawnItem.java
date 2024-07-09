package net.msymbios.rlovelyr.item.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;

public class SpawnItem extends SpawnEggItem {

    // -- Constructor --

    public SpawnItem(EntityType<? extends Mob> mob, Properties properties) {
        super(mob, 0xFFFFFF, 0xFFFFFF, properties);
    } // Constructor SpawnItem ()

    // -- Inherited Methods --

} // Class SpawnItem