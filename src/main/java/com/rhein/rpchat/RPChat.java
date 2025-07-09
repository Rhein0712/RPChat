package com.rhein.rpchat;

import org.bukkit.plugin.java.JavaPlugin;

import com.rhein.rpchat.MeCommand;

import com.rhein.rpchat.WhisperCommand;

public class RPChat extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RPChat enabled.");
        getCommand("me").setExecutor(new MeCommand());
        getCommand("whisper").setExecutor(new WhisperCommand());
        // We'll register commands and events here later
    }

    @Override
    public void onDisable() {
        getLogger().info("RPChat disabled.");
    }
}