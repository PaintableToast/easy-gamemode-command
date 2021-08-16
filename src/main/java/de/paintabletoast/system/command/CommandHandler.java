package de.paintabletoast.system.command;

import de.paintabletoast.system.var.Message;
import de.paintabletoast.system.var.Sounds;
import org.bukkit.Sound;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public interface CommandHandler extends CommandExecutor {
    default void playSound(final Player player, final Sound sound) {
        player.playSound(player.getLocation(), sound, 1, 1);
    }
    default void sendSoundMessage(final Player player, final Sound sound, final String message) {
        player.sendMessage(message);
        playSound(player, sound);
    }
    default void sendNoPermission(final Player player) {
        sendSoundMessage(player, Sounds.NO_PERMISSION.getSound(), Message.NO_PERMISSION.getMessage());
    }
}
