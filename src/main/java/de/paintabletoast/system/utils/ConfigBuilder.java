package de.paintabletoast.system.utils;

import de.paintabletoast.system.boot.Core;
import de.paintabletoast.system.var.FileReplace;
import de.paintabletoast.system.var.Message;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import de.paintabletoast.system.manager.PluginHandler;

import java.io.*;

public class ConfigBuilder implements PluginHandler {
    private final Core core = JavaPlugin.getPlugin(Core.class);
    private String name;
    private File file;
    private YamlConfiguration config;
    public ConfigBuilder(String name) {
        this.name = name;
    }
    private ConfigBuilder save() {
        if (config != null && this.file != null) {
            try {
                if (this.config.getConfigurationSection("").getKeys(true).size() != 0) {
                    this.config.save(file);
                }
            } catch (IOException error) {
                logError(error);
            }
            return this;
        } else {
            return this;
        }
    }
    private YamlConfiguration get() {
        if (this.config == null) {
            this.reload();
        }
        return this.config;
    }
    public ConfigBuilder saveDefaultConfig() {
        file = new File(core.getDataFolder(), name);
        core.saveResource(name, false);
        return this;
    }
    public ConfigBuilder reload() {
        if (file == null) {
            file = new File(core.getDataFolder(), name);
        }
        config = YamlConfiguration.loadConfiguration(file);
        try {
            Reader def_config_stream = new InputStreamReader(core.getResource(name), "UTF8");
            if (def_config_stream != null) {
                YamlConfiguration def_config = YamlConfiguration.loadConfiguration(def_config_stream);
                config.setDefaults(def_config);
            }
        } catch (NullPointerException | UnsupportedEncodingException error) {
            logError(error);
        }
        return this;
    }
    public ConfigBuilder set(String key, Object value) {
        get().set(key, value);
        save();
        return this;
    }
    public Object get(String key) {
        return this.get().get(key);
    }

    public String getString(String path) {
        return this.getPreString(path).replace(FileReplace.PREFIX.getPart(), Message.PREFIX.getMessage())
                .replace(FileReplace.CONSOLE_PREFIX.getPart(), Message.CONSOLE_PREFIX.getMessage())
                .replace(FileReplace.INFORMATION.getPart(), Message.INFORMATION_TAG.getMessage())
                .replace(FileReplace.PLUGIN_NAME.getPart(), core.getName());
    }

    public String getPreString(String path) {
        return ((String)get(path))
                .replace("&", "§")
                .replace(FileReplace.ENTER.getPart(), "\n");
    }
}
