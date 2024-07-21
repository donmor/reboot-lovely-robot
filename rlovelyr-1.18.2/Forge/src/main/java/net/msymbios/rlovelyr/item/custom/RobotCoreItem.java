package net.msymbios.rlovelyr.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.msymbios.rlovelyr.config.LovelyRobotID;
import net.msymbios.rlovelyr.entity.internal.enums.EntityTexture;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.msymbios.rlovelyr.item.utils.Utility.*;

public class RobotCoreItem extends Item {

    // -- Constructor --

    public RobotCoreItem(Properties properties) {
        super(properties);
    } // Constructor RobotCoreItem ()

    // -- Inherited Methods --

    /**
     * Appends tooltip information to the given ItemStack in the specified world, using the provided list of Text elements and TooltipContext.
     **/
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        if (stack.hasTag()) {
            CompoundTag nbt = stack.getOrCreateTag();
            addNameTooltip(tooltip, nbt);
            addTypeTooltip(tooltip, nbt);
            addColorTooltip(tooltip, nbt);
            addLevelTooltip(tooltip, nbt);
        } else {
            CompoundTag compound = stack.getOrCreateTag();
            compound.putInt(LovelyRobotID.STAT_COLOR, EntityTexture.RANDOM.getId());
            compound.putInt(LovelyRobotID.STAT_LEVEL, 0);
            stack.setTag(compound);
        }
    } // appendHoverText ()

} // Class RobotCoreItem