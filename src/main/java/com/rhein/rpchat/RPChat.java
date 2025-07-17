package com.rhein.rpchat;

import com.rhein.rpchat.commands.*;
import com.rhein.rpchat.listeners.*;

import main.java.com.rhein.rpchat.commands.LOOCCommand;
import main.java.com.rhein.rpchat.commands.StaffAddCommand;
import main.java.com.rhein.rpchat.commands.StaffCommand;
import main.java.com.rhein.rpchat.commands.StaffRemoveCommand;
import main.java.com.rhein.rpchat.listeners.StaffListener;

import org.bukkit.Bukkit;
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
        getCommand("ooc").setExecutor(new OOCCommand(manager));
        getCommand("looc").setExecutor(new LOOCCommand());
        getCommand("staff").setExecutor(new StaffCommand(manager));
        getCommand("staffadd").setExecutor(new StaffAddCommand(manager));
        getCommand("staffremove").setExecutor(new StaffRemoveCommand(manager));

        getServer().getPluginManager().registerEvents(new RPListener(manager), this);
        // getServer().getPluginManager().registerEvents(new OOCListener(manager), this);
        getServer().getPluginManager().registerEvents(new StaffListener(manager), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("RPChat mode disabled.");
    }
}