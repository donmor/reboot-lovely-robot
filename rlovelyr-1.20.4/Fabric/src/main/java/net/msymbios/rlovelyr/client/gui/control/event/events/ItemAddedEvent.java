package net.msymbios.rlovelyr.client.gui.control.event.events;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import net.msymbios.rlovelyr.util.interfaces.IEvent;

/**
 * An event used when an item is added to a control.
 */
@Environment(EnvType.CLIENT)
public class ItemAddedEvent implements IEvent {
    /**
     * The item that was added.
     */
    public final Item item;

    /**
     * @param item the item that was added.
     */
    public ItemAddedEvent(Item item) {
        this.item = item;
    }
}
