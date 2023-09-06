package com.github.maazapan.ktacademy.academy.rooms.desk;

import org.bukkit.Location;

import java.util.UUID;

public class DeskRoom {

    private final UUID deskUUID;

    private final Location location;
    private boolean taken;

    public DeskRoom(UUID deskUUID, Location location) {
        this.location = location;
        this.deskUUID = deskUUID;
        this.taken = false;
    }

    public Location getLocation() {
        return location;
    }

    public UUID getDeskUUID() {
        return deskUUID;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
