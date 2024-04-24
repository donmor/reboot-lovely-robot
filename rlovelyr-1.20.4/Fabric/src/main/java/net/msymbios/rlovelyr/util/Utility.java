package net.msymbios.rlovelyr.util;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.msymbios.rlovelyr.config.LovelyRobotID;
import net.msymbios.rlovelyr.entity.enums.EntityState;
import net.msymbios.rlovelyr.entity.enums.EntityTexture;
import net.msymbios.rlovelyr.entity.enums.EntityVariant;

import java.util.List;

public class Utility {

    // -- Variables --
    public static final double PI = 3.14159265358979323846;

    // -- Methods --

    /**
     * Inverts a boolean value.
     *
     * @param  value  the boolean value to be inverted
     * @return       the inverted boolean value
     */
    public static boolean invertBoolean(boolean value) {
        return !value;
    } // invertBoolean ()

    // -- FORMATTING --

    /**
     * Returns the formatting color based on the provided EntityTexture.
     * @param texture The EntityTexture to determine the formatting color for.
     * @return The corresponding Formatting color for the EntityTexture.
     */
    public static Formatting getFormattingColor(EntityTexture texture) {
        Formatting value = Formatting.WHITE;

        // Determine the formatting color based on the EntityTexture
        switch (texture) {
            case RANDOM -> value = Formatting.WHITE;
            case WHITE -> value = Formatting.WHITE;
            case ORANGE -> value = Formatting.GOLD;
            case MAGENTA -> value = Formatting.DARK_PURPLE;
            case LIGHT_BLUE -> value = Formatting.AQUA;
            case YELLOW -> value = Formatting.YELLOW;
            case LIME -> value = Formatting.GREEN;
            case PINK -> value = Formatting.LIGHT_PURPLE;
            case GRAY -> value = Formatting.DARK_GRAY;
            case LIGHT_GRAY -> value = Formatting.GRAY;
            case CYAN -> value = Formatting.AQUA;
            case PURPLE -> value = Formatting.DARK_PURPLE;
            case BLUE -> value = Formatting.BLUE;
            case BROWN -> value = Formatting.GOLD;
            case GREEN -> value = Formatting.DARK_GREEN;
            case RED -> value = Formatting.RED;
            case BLACK -> value = Formatting.GRAY;
        }

        return value;
    } // getFormattingColor ()

    // TRANSLATABLE

    /**
     * Retrieves the translatable string based on the given entity variant.
     *
     * @param  variant  the entity variant for which the translatable string is to be retrieved
     * @return          the translatable message key corresponding to the entity variant
     */
    public static String getTranslation(EntityVariant variant) {
        String value = LovelyRobotID.TRANS_MSG_BUNNY;
        switch (variant) {
            case Bunny -> value = LovelyRobotID.TRANS_MSG_BUNNY;
            case Bunny2 -> value = LovelyRobotID.TRANS_MSG_BUNNY2;
            case Dragon -> value = LovelyRobotID.TRANS_MSG_DRAGON;
            case Honey -> value = LovelyRobotID.TRANS_MSG_HONEY;
            case Kitsune -> value = LovelyRobotID.TRANS_MSG_KITSUNE;
            case Neko -> value = LovelyRobotID.TRANS_MSG_NEKO;
            case Vanilla -> value = LovelyRobotID.TRANS_MSG_VANILLA;
        }
        return value;
    } // getTranslation ()

    /**
     * Retrieves the translatable message key based on the given entity State.
     *
     * @param  state  the entity state for which the translatable message key is needed
     * @return        the translatable message key corresponding to the entity state
     */
    public static String getTranslation(EntityState state){
        String value = LovelyRobotID.TRANS_MSG_FOLLOW;
        switch (state) {
            case Follow -> value = LovelyRobotID.TRANS_MSG_FOLLOW;
            case Defense -> value = LovelyRobotID.TRANS_MSG_DEFENCE;
            case Standby -> value = LovelyRobotID.TRANS_MSG_STANDBY;
        }
        return value;
    } // getTranslation ()

    /**
     * Retrieves the corresponding translatable message key based a given Texture.
     *
     * @param  texture the entity texture for which the translatable message key is needed
     * @return         the message key corresponding to the EntityTexture
     */
    public static String getTranslation(EntityTexture texture) {
        String value = LovelyRobotID.TRANS_MSG_PINK;
        switch (texture) {
            case RANDOM -> value = LovelyRobotID.TRANS_MSG_RANDOM;
            case WHITE -> value = LovelyRobotID.TRANS_MSG_WHITE;
            case ORANGE -> value = LovelyRobotID.TRANS_MSG_ORANGE;
            case MAGENTA -> value = LovelyRobotID.TRANS_MSG_MAGENTA;
            case LIGHT_BLUE -> value = LovelyRobotID.TRANS_MSG_LIGHT_BLUE;
            case YELLOW -> value = LovelyRobotID.TRANS_MSG_YELLOW;
            case LIME -> value = LovelyRobotID.TRANS_MSG_LIME;
            case PINK -> value = LovelyRobotID.TRANS_MSG_PINK;
            case GRAY -> value = LovelyRobotID.TRANS_MSG_GRAY;
            case LIGHT_GRAY -> value = LovelyRobotID.TRANS_MSG_LIGHT_GRAY;
            case CYAN -> value = LovelyRobotID.TRANS_MSG_CYAN;
            case PURPLE -> value = LovelyRobotID.TRANS_MSG_PURPLE;
            case BLUE -> value = LovelyRobotID.TRANS_MSG_BLUE;
            case BROWN -> value = LovelyRobotID.TRANS_MSG_BROWN;
            case GREEN -> value = LovelyRobotID.TRANS_MSG_GREEN;
            case RED -> value = LovelyRobotID.TRANS_MSG_RED;
            case BLACK -> value = LovelyRobotID.TRANS_MSG_BLACK;
        }
        return value;
    } // getTranslation ()

    // TOOLTIP

    public static void addNameTooltip(List<Text> tooltip, NbtCompound nbt) {
        EntityTexture texture = EntityTexture.byId(nbt.getInt(LovelyRobotID.STAT_COLOR));
        String customName = nbt.getString(LovelyRobotID.STAT_CUSTOM_NAME);
        if (!customName.isEmpty()) tooltip.add(Text.literal(customName).formatted(Utility.getFormattingColor(texture)));
    } // appendTooltip ()

    public static void addTypeTooltip(List<Text> tooltip, NbtCompound nbt) {
        var defaultFormatting = Formatting.GRAY;
        var textFormatting = Formatting.WHITE;
        String type = nbt.getString(LovelyRobotID.STAT_TYPE);
        if (!type.isEmpty()) tooltip.add(Text.translatable(LovelyRobotID.TRANS_MSG_TYPE).append(Text.literal(": ")).formatted(defaultFormatting).append(Text.translatable(type).formatted(textFormatting)));
    } // appendTooltip ()

    public static void addColorTooltip(List<Text> tooltip, NbtCompound nbt) {
        var defaultFormatting = Formatting.GRAY;
        EntityTexture texture = EntityTexture.byId(nbt.getInt(LovelyRobotID.STAT_COLOR));
        tooltip.add(Text.translatable(LovelyRobotID.TRANS_MSG_COLOR).append(Text.literal(": ")).formatted(defaultFormatting).append(Text.translatable(Utility.getTranslation(texture)).formatted(Utility.getFormattingColor(texture))));
    } // appendTooltip ()

    public static void addLevelTooltip(List<Text> tooltip, NbtCompound nbt) {
        var defaultFormatting = Formatting.GRAY;
        var textFormatting = Formatting.GOLD;
        int level = nbt.getInt(LovelyRobotID.STAT_LEVEL);
        if(level > 0) tooltip.add(Text.translatable(LovelyRobotID.TRANS_MSG_LEVEL).append(Text.literal(": ")).formatted(defaultFormatting).append(Text.literal("" + level).formatted(textFormatting)));
    } // appendTooltip ()

} // Class Utility