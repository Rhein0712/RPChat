package com.rhein.rpchat;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ChatModeManager {

    private final Set<UUID> rpModePlayers = new HashSet<>();
    private final Set<UUID> staffModePlayers = new HashSet<>();
    private final Set<UUID> staffAccessPlayers = new HashSet<>();

    // --- RP mode ---
    public void enableRP(UUID playerId) {
        rpModePlayers.add(playerId);
        staffModePlayers.remove(playerId); // Exit staff mode when entering RP
    }

    public void disableRP(UUID playerId) {
        rpModePlayers.remove(playerId);
    }

    public boolean isInRP(UUID playerId) {
        return rpModePlayers.contains(playerId);
    }

    // --- Staff mode ---
    public void enableStaff(UUID playerId) {
        if (hasStaffAccess(playerId)) {
            staffModePlayers.add(playerId);
            rpModePlayers.remove(playerId); // Exit RP mode when entering staff
        }
    }

    public void disableStaff(UUID playerId) {
        staffModePlayers.remove(playerId);
    }

    public boolean isInStaff(UUID playerId) {
        return staffModePlayers.contains(playerId);
    }

    // --- Staff access (permission control) ---
    public void addStaffAccess(UUID playerId) {
        staffAccessPlayers.add(playerId);
    }

    public void removeStaffAccess(UUID playerId) {
        staffAccessPlayers.remove(playerId);
        staffModePlayers.remove(playerId); // Also remove from staff mode if active
    }

    public boolean hasStaffAccess(UUID playerId) {
        return staffAccessPlayers.contains(playerId);
    }
}