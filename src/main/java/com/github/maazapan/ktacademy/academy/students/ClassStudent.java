package com.github.maazapan.ktacademy.academy.students;

import org.bukkit.entity.Player;

import java.util.UUID;

public class ClassStudent {

    private final UUID uuid;
    private UUID deskUUID;

    private final int level;

    public ClassStudent(Player player) {
        this.uuid = player.getUniqueId();
        this.level = player.getLevel();
    }

    public int getLevel() {
        return level;
    }

    public UUID getUUID() {
        return uuid;
    }

    public UUID getDeskUUID() {
        return deskUUID;
    }

    public void setDeskUUID(UUID deskUUID) {
        this.deskUUID = deskUUID;
    }
}
