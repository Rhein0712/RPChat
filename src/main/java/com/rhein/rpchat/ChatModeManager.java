package com.rhein.rpchat;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ChatModeManager {
    private final Set<UUID> rpModePlayers = new HashSet<>();

    public void enableRP(UUID playerId) {
        rpModePlayers.add(playerId);
    }

    public void disableRP(UUID playerId) {
        rpModePlayers.remove(playerId);
    }

    public boolean isInRP(UUID playerId) {
        return rpModePlayers.contains(playerId);
    }
}