package com.rhein.rpchat;

import com.rhein.rpchat.commands.*;
import com.rhein.rpchat.listeners.*;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RPChat extends JavaPlugin {

    private ChatModeManager manager;
    private File staffFile;
    private FileConfiguration staffConfig;

    @Override
    public void onEnable() {
        getLogger().info("RPChat mode enabled.");

        setupStaffConfig();

        manager = new ChatModeManager();
        loadStaffAccess();

        getCommand("me").setExecutor(new MeCommand());
        getCommand("whisper").setExecutor(new WhisperCommand(manager));
        getCommand("yell").setExecutor(new YellCommand(manager));
        getCommand("rp").setExecutor(new RPCommand(manager));
        getCommand("ooc").setExecutor(new OOCCommand(manager));
        getCommand("looc").setExecutor(new LOOCCommand());
        getCommand("staff").setExecutor(new StaffCommand(manager));
        getCommand("staffadd").setExecutor(new StaffAddCommand(manager, this));
        getCommand("staffremove").setExecutor(new StaffRemoveCommand(manager, this));

        getServer().getPluginManager().registerEvents(new RPListener(manager), this);
        getServer().getPluginManager().registerEvents(new StaffListener(manager), this);
    }

    @Override
    public void onDisable() {
        saveStaffAccess();
        getLogger().info("RPChat mode disabled.");
    }

    private void setupStaffConfig() {
        staffFile = new File(getDataFolder(), "staff.yml");
        if (!staffFile.exists()) {
            staffFile.getParentFile().mkdirs();
            saveResource("staff.yml", false); // Only works if you bundled a blank staff.yml, otherwise use saveStaffAccess()
        }
        staffConfig = YamlConfiguration.loadConfiguration(staffFile);
    }

    private void loadStaffAccess() {
        List<String> list = staffConfig.getStringList("staff");
        for (String uuidString : list) {
            try {
                UUID uuid = UUID.fromString(uuidString);
                manager.addStaffAccess(uuid);
            } catch (IllegalArgumentException ignored) {}
        }
    }

    public void saveStaffAccess() {
        List<String> uuidStrings = manager.getStaffAccessUUIDs().stream()
                .map(UUID::toString)
                .collect(Collectors.toList());

        staffConfig.set("staff", uuidStrings);

        try {
            staffConfig.save(staffFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}