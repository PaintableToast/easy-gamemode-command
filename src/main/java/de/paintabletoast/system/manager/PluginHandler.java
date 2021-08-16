package de.paintabletoast.system.manager;

import org.bukkit.Bukkit;

public interface PluginHandler {
    default void log(String message) {
        Bukkit.getConsoleSender().sendMessage(message);
    }
    default void logError(Exception error) {
        logErrorLogo();
        error.printStackTrace();
    }
    default void logError(String message) {
        logErrorLogo();
        log(message);
    }
    default void logError(Exception error, String message) {
        logErrorLogo();
        log(message);
        error.printStackTrace();
    }
    default void logErrorLogo() {
        log("\n" +
                "\n" +
                " _______   ________  ________  ________  ________     \n" +
                "|\\  ___ \\ |\\   __  \\|\\   __  \\|\\   __  \\|\\   __  \\    \n" +
                "\\ \\   __/|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\   \n" +
                " \\ \\  \\_|/_\\ \\   _  _\\ \\   _  _\\ \\  \\\\\\  \\ \\   _  _\\  \n" +
                "  \\ \\  \\_|\\ \\ \\  \\\\  \\\\ \\  \\\\  \\\\ \\  \\\\\\  \\ \\  \\\\  \\| \n" +
                "   \\ \\_______\\ \\__\\\\ _\\\\ \\__\\\\ _\\\\ \\_______\\ \\__\\\\ _\\ \n" +
                "    \\|_______|\\|__|\\|__|\\|__|\\|__|\\|_______|\\|__|\\|__|\n" +
                "                                                      \n" +
                "                                                      \n" +
                "                                                      \n" +
                "\n");
    }
}