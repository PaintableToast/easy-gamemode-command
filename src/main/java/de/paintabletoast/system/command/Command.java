package de.paintabletoast.system.command;

import de.paintabletoast.system.boot.Core;
import de.paintabletoast.system.manager.PluginHandler;
import de.paintabletoast.system.var.FileReplace;
import de.paintabletoast.system.var.Message;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public enum Command implements PluginHandler {
    GAMEMODE("gamemode", new GameModeCommand(), new GameModeCommand());
    private final Core core = JavaPlugin.getPlugin(Core.class);
    private String command;
    private CommandHandler commandExecutor;
    private TabCompleter completer;
    Command(String command, CommandHandler commandExecutor) {
        this.command = command;
        this.commandExecutor = commandExecutor;
        registerCommand();
    }
    Command(String command, CommandHandler commandExecutor, TabCompleter tabcompleter) {
        this.command = command;
        this.commandExecutor = (CommandHandler) commandExecutor;
        this.completer = tabcompleter;
        registerCommand();
    }
    private void registerCommand() {
        try {
            core.getCommand(command).setExecutor(commandExecutor);
            if(this.getCompleter() != null) {
                core.getCommand(command).setTabCompleter(completer);
            }
            log(Message.COMMAND_SUCCESS.getMessage().replace(FileReplace.COMMAND.getPart(), command));
        } catch (Exception error) {
            logError(error, Message.COMMAND_ERROR.getMessage().replace(FileReplace.COMMAND.getPart(), command));
        }
    }
    private TabCompleter getCompleter() {
        return completer;
    }

}
