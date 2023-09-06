package com.github.maazapan.ktacademy;

import com.github.maazapan.ktacademy.commands.AcademyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class KTAcademy extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        this.registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        getCommand("academy").setExecutor(new AcademyCommand(this));
    }
}
