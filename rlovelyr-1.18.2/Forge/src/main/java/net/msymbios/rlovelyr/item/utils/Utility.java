package net.msymbios.rlovelyr.item.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.msymbios.rlovelyr.config.LovelyRobotID;
import net.msymbios.rlovelyr.entity.internal.enums.EntityTexture;

import java.util.List;

public class Utility {

    // -- Variables --

    public static final double PI = 3.14159265358979323846;

    // -- Methods --

    /**
     * Gets the custom name of a LivingEntity.
     *
     * @param entity the LivingEntity to get the custom name from
     * @return the custom name of the LivingEntity, or an empty string if not present
     */
    public static String getEntityCustomName(LivingEntity entity) {
        String customName = "";
        try {customName = entity.getCustomName().getString();}
        catch (Exception ignored) {} // Custom name not found, return empty string
        return customName;
    } // getEntityCustomName ()

    /**
     * Inverts a boolean value.
     *
     * @param  value  the boolean value to be inverted
     * @return       the inverted boolean value
     */
    public static boolean invertBoolean(boolean value) {
        return !value;
    } // invertBoolean ()

    // TOOLTIP

    /**
     * Adds a custom name tooltip to the given list of texts based on the NBT compound.
     *
     * @param tooltip The list of texts to which the tooltip will be added
     * @param nbt The NBT compound containing the entity texture and custom name
     * */
    public static void addNameTooltip(List<Component> tooltip, CompoundTag nbt) {
        EntityTexture texture = EntityTexture.byId(nbt.getInt(LovelyRobotID.STAT_COLOR));
        String customName = nbt.getString(LovelyRobotID.STAT_CUSTOM_NAME);
        if (!customName.isEmpty()) tooltip.add(Component.nullToEmpty(customName).copy().withStyle(Utility.getFormattingColor(texture)));
    } // appendTooltip ()

    /**
     * Adds a type tooltip to the given list of texts based on the NBT compound.
     *
     * @param tooltip The list of texts to which the tooltip will be added
     * @param nbt The NBT compound containing the type information
     * */
    public static void addTypeTooltip(List<Component> tooltip, CompoundTag nbt) {
        // Define default and text formatting for the tooltip
        var defaultFormatting = ChatFormatting.GRAY;
        var textFormatting = ChatFormatting.WHITE;

        // Retrieve the type information from the NBT compound
        String type = nbt.getString(LovelyRobotID.STAT_TYPE);

        // Add the type tooltip if the type is not empty
        if (!type.isEmpty()) tooltip.add(new TranslatableComponent(LovelyRobotID.TRANS_MSG_TYPE).append(Component.nullToEmpty(": ")).withStyle(defaultFormatting).append(new TranslatableComponent(type).withStyle(textFormatting)));
    } // appendTooltip ()

    /**
     * Adds a color tooltip to the given list of texts based on the NBT compound.
     *
     * @param tooltip The list of texts to which the tooltip will be added
     * @param nbt The NBT compound containing the color information
     * */
    public static void addColorTooltip(List<Component> tooltip, CompoundTag nbt) {
        // Retrieve the texture information from the NBT compound
        var texture = EntityTexture.byId(nbt.getInt(LovelyRobotID.STAT_COLOR));

        // Define default and text formatting for the tooltip
        var defaultFormatting = ChatFormatting.GRAY;
        var textFormatting = Utility.getFormattingColor(texture);

        // Add the color tooltip to the list
        tooltip.add(new TranslatableComponent(LovelyRobotID.TRANS_MSG_COLOR).append(Component.nullToEmpty(": ")).withStyle(defaultFormatting).append(new TranslatableComponent(LovelyRobotID.getTranslation(texture)).withStyle(textFormatting)));
    } // appendTooltip ()

    /**
     * Adds a level tooltip to the given list of texts based on the NBT compound.
     *
     * @param tooltip The list of texts to which the tooltip will be added
     * @param nbt The NBT compound containing the level information
     * */
    public static void addLevelTooltip(List<Component> tooltip, CompoundTag nbt) {
        // Define default and text formatting for the tooltip
        var defaultFormatting = ChatFormatting.GRAY;
        var textFormatting = ChatFormatting.GOLD;

        // Retrieve the level information from the NBT compound
        int level = nbt.getInt(LovelyRobotID.STAT_LEVEL);

        // Add the level tooltip to the list if the level is greater than 0
        if(level > 0) tooltip.add(new TranslatableComponent(LovelyRobotID.TRANS_MSG_LEVEL).append(Component.nullToEmpty(": ")).withStyle(defaultFormatting).append(Component.nullToEmpty("" + level)).withStyle(textFormatting));
    } // appendTooltip ()

    // -- FORMATTING --

    /**
     * Returns the formatting color based on the provided EntityTexture.
     * @param texture The EntityTexture to determine the formatting color for.
     * @return The corresponding Formatting color for the EntityTexture.
     */
    public static ChatFormatting getFormattingColor(EntityTexture texture) {
        ChatFormatting value = ChatFormatting.WHITE;

        // Determine the formatting color based on the EntityTexture
        switch (texture) {
            case RANDOM -> value = ChatFormatting.WHITE;
            case WHITE -> value = ChatFormatting.WHITE;
            case ORANGE -> value = ChatFormatting.GOLD;
            case MAGENTA -> value = ChatFormatting.DARK_PURPLE;
            case LIGHT_BLUE -> value = ChatFormatting.AQUA;
            case YELLOW -> value = ChatFormatting.YELLOW;
            case LIME -> value = ChatFormatting.GREEN;
            case PINK -> value = ChatFormatting.LIGHT_PURPLE;
            case GRAY -> value = ChatFormatting.DARK_GRAY;
            case LIGHT_GRAY -> value = ChatFormatting.GRAY;
            case CYAN -> value = ChatFormatting.AQUA;
            case PURPLE -> value = ChatFormatting.DARK_PURPLE;
            case BLUE -> value = ChatFormatting.BLUE;
            case BROWN -> value = ChatFormatting.GOLD;
            case GREEN -> value = ChatFormatting.DARK_GREEN;
            case RED -> value = ChatFormatting.RED;
            case BLACK -> value = ChatFormatting.GRAY;
        }

        return value;
    } // getFormattingColor ()

} // Class Utility