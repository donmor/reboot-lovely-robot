package net.msymbios.rlovelyr.common.network;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.msymbios.rlovelyr.common.network.message.SetLevelCommandMessage;
import net.msymbios.rlovelyr.common.network.message.SetColorCommandMessage;
import net.msymbios.rlovelyr.config.LovelyRobotID;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NetworkHandler {

    // -- Variables --

    /**
     * The protocol version.
     */
    private static final String PROTOCOL_VERSION = Integer.toString(1);

    /**
     * The simple channel handler.
     */
    private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
            .named(LovelyRobotID.getId("channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    /**
     * Incremented for each registered message.
     */
    private static int id = 0;

    // -- Methods --

    /**
     * Initialises all message handlers.
     */
    public static void register() {
        HANDLER.registerMessage(id++, SetLevelCommandMessage.class, SetLevelCommandMessage::encode, SetLevelCommandMessage::decode, SetLevelCommandMessage::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
        HANDLER.registerMessage(id++, SetColorCommandMessage.class, SetColorCommandMessage::encode, SetColorCommandMessage::decode, SetColorCommandMessage::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
        //HANDLER.registerMessage(id++, SetXpCommandMessage.class, SetXpCommandMessage::encode, SetXpCommandMessage::decode, SetXpCommandMessage::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    } // register ()

    /**
     * Sends the given message to the server.
     *
     * @param message the message to send.
     */
    public static void sendToServer(Message message) {
        HANDLER.sendToServer(message);
    } // sendToServer ()

    /**
     * Sends the given message to the given player's client.
     *
     * @param player  the player to send the message to.
     * @param message the message to send.
     */
    public static void sendToClient(Player player, Message message) {
        HANDLER.sendTo(message, ((ServerPlayer) player).connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    } // sendToClient ()

    /**
     * Sends the given message to every player's client except the given players.
     *
     * @param world           the world the players are in.
     * @param message         the message to send.
     * @param playersToIgnore the players to not send the message to.
     */
    public static void sendToAllClients(Level world, Message message, List<Player> playersToIgnore) {
        for (Player player : world.players()) {
            if (!playersToIgnore.contains(player)) {
                sendToClient(player, message);
            }
        }
    } // sendToAllClients ()

    /**
     * Sends the message either to the server or all player's clients.
     *
     * @param world   the world.
     * @param message the message to send.
     */
    public static void sync(Level world, Message message) {
        if (world.isClientSide) sendToServer(message);
        else sendToAllClients(world, message, new ArrayList<>());
    } // sync ()

} // Class NetworkHandler