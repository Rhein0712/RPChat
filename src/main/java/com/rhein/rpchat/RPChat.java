package com.rhein.rpchat;

import org.bukkit.plugin.java.JavaPlugin;

public class RPChat extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RPChat enabled.");
        // We'll register commands and events here later
    }

    @Override
    public void onDisable() {
        getLogger().info("RPChat disabled.");
    }
}