package de.paintabletoast.system.boot;

import de.paintabletoast.system.manager.PluginHandler;
import de.paintabletoast.system.var.Message;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements PluginHandler {
    @Override
    public void onEnable() {
        logLogo();
        Base base = new Base();
        base.initPlugin();
    }
    @Override
    public void onDisable() {
        logLogo();
        log(Message.PLUGIN_STOP.getMessage());
    }
    private void logLogo() {
        log("\n" +
                "\n" +
                " ________  ________  _____ ______   _______   _____ ______   ________  ________  _______      \n" +
                "|\\   ____\\|\\   __  \\|\\   _ \\  _   \\|\\  ___ \\ |\\   _ \\  _   \\|\\   __  \\|\\   ___ \\|\\  ___ \\     \n" +
                "\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|\\ \\  \\\\\\__\\ \\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\   __/|    \n" +
                " \\ \\  \\  __\\ \\   __  \\ \\  \\\\|__| \\  \\ \\  \\_|/_\\ \\  \\\\|__| \\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\ \\  \\_|/__  \n" +
                "  \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\ \\  \\    \\ \\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\ \\  \\_|\\ \\ \n" +
                "   \\ \\_______\\ \\__\\ \\__\\ \\__\\    \\ \\__\\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\ \\_______\\ \\_______\\\n" +
                "    \\|_______|\\|__|\\|__|\\|__|     \\|__|\\|_______|\\|__|     \\|__|\\|_______|\\|_______|\\|_______|\n" +
                "                                                                                              \n" +
                "                                                                                              \n" +
                "                                                                                              \n" +
                "\n");
    }
}
