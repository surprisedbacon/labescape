package org.xyrise.labescape;

import org.bukkit.plugin.java.JavaPlugin;
import org.xyrise.labescape.commands.SpawnTube;

public final class LabEscape extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("spawntube").setExecutor(new SpawnTube());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
