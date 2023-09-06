package com.github.maazapan.ktacademy.academy;

import com.github.maazapan.ktacademy.academy.rooms.ClassRoom;
import com.github.maazapan.ktacademy.academy.villages.Village;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Academy {

    private final Village village;
    private Location location;

    private final List<ClassRoom> classRooms;

    public Academy(Village village) {
        this.classRooms = new ArrayList<>();
        this.village = village;
    }

    public Location getLocation() {
        return location;
    }

    public Village getVillage() {
        return village;
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
