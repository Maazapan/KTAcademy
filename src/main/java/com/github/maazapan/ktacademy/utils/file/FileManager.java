package com.github.maazapan.ktacademy.utils.file;

import com.github.maazapan.ktacademy.utils.KatsuUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.List;

public class FileManager {

    private final Plugin plugin;

    public FileManager(Plugin plugin) {
        this.plugin = plugin;
    }

    public int getInt(String path, FileType fileType) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + "/" + fileType .getFileName()));
        return config.getInt(path);
    }

    public List<String> getStringList(String path, FileType fileType) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + "/" + fileType .getFileName()));
        return config.getStringList(path);
    }

    public String get(String path, FileType fileType) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + "/" + fileType.getFileName()));
        String prefix = config.getString("config.prefix");

        if (!config.isSet(path)) {
            return null;
        }
        return KatsuUtils.coloredHex(prefix + config.getString(path));
    }

    public String getWithoutPrefix(String path, FileType fileType) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + "/" + fileType .getFileName()));

        if (!config.isSet(path)) {
            return null;
        }
        return KatsuUtils.coloredHex(config.getString(path));
    }
}
