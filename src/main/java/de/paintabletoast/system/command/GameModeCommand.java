package de.paintabletoast.system.command;

import de.paintabletoast.system.manager.PluginHandler;
import de.paintabletoast.system.var.FileReplace;
import de.paintabletoast.system.var.Message;
import de.paintabletoast.system.var.Permission;
import de.paintabletoast.system.var.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameModeCommand implements CommandHandler, TabCompleter, PluginHandler {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            final Player player = (Player) sender;
            switch (args.length) {
                case 1:
                    if(player.hasPermission(Permission.GAMEMODE_USE.getPermission()))
                        try {
                            player.setGameMode(GameMode.valueOf(args[0].toUpperCase()));
                            sendSoundMessage(player, Sounds.GAMEMODE_SELF.getSound(), Message.GAMEMODE_SELF.getMessage().replace(FileReplace.GAMEMODE.getPart(), args[0]));
                        } catch (Exception error1) {
                            try {
                                player.setGameMode(GameMode.getByValue(Integer.valueOf(args[0])));
                                sendSoundMessage(player, Sounds.GAMEMODE_SELF.getSound(), Message.GAMEMODE_SELF.getMessage().replace(FileReplace.GAMEMODE.getPart(), args[0]));
                            } catch (Exception error2) {
                                sendSoundMessage(player, Sounds.WRONG_COMMAND.getSound(), Message.WRONG_COMMAND_ARGUMENTATION.getMessage().replace(FileReplace.COMMAND_ARGUMENT.getPart(), Message.GAMEMODE_COMMAND.getMessage()));
                            }
                        }
                    else
                        sendNoPermission(player);
                        break;
                case 2:
                    if(player.hasPermission(Permission.GAMEMODE_OTHER.getPermission()))
                        if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
                            final Player target = Bukkit.getPlayer(args[0]);
                            try {
                                target.setGameMode(GameMode.valueOf(args[1].toUpperCase()));
                                sendSoundMessage(player, Sounds.GAMEMODE_OTHER.getSound(), Message.GAMEMODE_OTHER.getMessage().replace(FileReplace.GAMEMODE.getPart(), args[1]).replace(FileReplace.PLAYER.getPart(), args[0]));
                            } catch (Exception error1) {
                                try {
                                    sendSoundMessage(player, Sounds.GAMEMODE_OTHER.getSound(), Message.GAMEMODE_OTHER.getMessage().replace(FileReplace.GAMEMODE.getPart(), args[1]).replace(FileReplace.PLAYER.getPart(), args[0]));
                                    target.setGameMode(GameMode.getByValue(Integer.valueOf(args[1])));
                                } catch (Exception error2) {
                                    sendSoundMessage(player, Sounds.WRONG_COMMAND.getSound(), Message.WRONG_COMMAND_ARGUMENTATION.getMessage().replace(FileReplace.COMMAND_ARGUMENT.getPart(), Message.GAMEMODE_COMMAND.getMessage()));
                                }
                            }
                        }
                    else
                        sendSoundMessage(player, Sounds.PLAYER_NOT_ONLINE.getSound(), Message.PLAYER_NOT_ONLINE.getMessage().replace(FileReplace.PLAYER.getPart(), args[1]));
                    else
                        sendNoPermission(player);
                    break;
                default:
                    sendSoundMessage(player, Sounds.WRONG_COMMAND.getSound(), Message.WRONG_COMMAND_ARGUMENTATION.getMessage().replace(FileReplace.COMMAND_ARGUMENT.getPart(), Message.GAMEMODE_COMMAND.getMessage()));
            }
        } else
            log(Message.NO_CONSOLE.getMessage());
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        switch (args.length) {
            case 1:
            case 2:
                final ArrayList<String> tabs = new ArrayList<>();
                for(GameMode gameMode : GameMode.values())
                    tabs.add(gameMode.name().toLowerCase());
                for (final String name : tabs)
                    if(name.contains(args[args.length - 1])) {
                        tabs.clear();
                        tabs.add(name);
                    }
                return tabs;
        }
        return null;
    }
}
