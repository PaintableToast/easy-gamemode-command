package de.paintabletoast.system.boot;

import de.paintabletoast.system.command.Command;
import de.paintabletoast.system.event.Event;
import de.paintabletoast.system.manager.PluginHandler;
import de.paintabletoast.system.var.ConfigFile;
import de.paintabletoast.system.var.Message;

public class Base implements PluginHandler {
    private static Base instance;
    public Base() {
        instance = this;
    }
    protected void initPlugin() {
        try {
            loadConfigurationFiles();
            log(Message.PLUGIN_LOAD.getMessage());
            registerCommands();
            registerEvents();
            log(Message.PLUGIN_SUCCESS_LOAD.getMessage());
        } catch (Exception error) {
            logError(error, Message.PLUGIN_ERROR_LOAD.getMessage());
        }
    }
    public static Base getInstance() {
        return instance;
    }
    private void registerCommands() {
        for(Command command : Command.values());
    }
    private void registerEvents() {
        for (Event event : Event.values());
    }
    private void loadConfigurationFiles() {
        for(ConfigFile configfile: ConfigFile.values()) configfile.saveDefaultConfig();
    }
}
