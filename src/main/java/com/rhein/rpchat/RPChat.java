package com.rhein.rpchat;

import com.rhein.rpchat.commands.*;
import com.rhein.rpchat.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class RPChat extends JavaPlugin {

    private ChatModeManager manager;

    @Override
    public void onEnable() {
        getLogger().info("RPChat mode enabled.");

        manager = new ChatModeManager();

        getCommand("me").setExecutor(new MeCommand());
        getCommand("whisper").setExecutor(new WhisperCommand(manager));
        getCommand("yell").setExecutor(new YellCommand(manager));
        getCommand("rp").setExecutor(new RPCommand(manager));

        getServer().getPluginManager().registerEvents(new RPListener(manager), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("RPChat mode disabled.");
    }
}