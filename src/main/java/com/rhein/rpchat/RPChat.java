package com.rhein.rpchat;

import org.bukkit.plugin.java.JavaPlugin;

import com.rhein.rpchat.MeCommand;

public class RPChat extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RPChat enabled.");
        getCommand("me").setExecutor(new MeCommand());
        // We'll register commands and events here later
    }

    @Override
    public void onDisable() {
        getLogger().info("RPChat disabled.");
    }
}