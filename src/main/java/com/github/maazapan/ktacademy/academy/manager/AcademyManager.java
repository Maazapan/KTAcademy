package com.github.maazapan.ktacademy.academy.manager;

import com.github.maazapan.ktacademy.KTAcademy;
import com.github.maazapan.ktacademy.academy.Academy;
import com.github.maazapan.ktacademy.academy.rooms.ClassRoom;
import com.github.maazapan.ktacademy.academy.villages.Village;

import java.util.HashMap;
import java.util.Map;

public class AcademyManager {

    private final Map<Village, Academy> academies;
    private KTAcademy plugin;

    public AcademyManager(KTAcademy plugin) {
        this.academies = new HashMap<>();
        this.plugin = plugin;
    }


    /**
     * Create a new classroom at the academy.
     *
     * @param village village to create
     * @param day     day to create
     */
    public void createRoom(Village village, int day) {
        Academy academy = academies.containsKey(village) ? academies.get(village) : new Academy(village);
        ClassRoom classRoom = new ClassRoom(day);

        academy.getClassRooms().add(classRoom);
        academies.put(village, academy);
    }

    /**
     * Check if the day is taken.
     *
     * @param village village to check
     * @param day     day to check
     * @return boolean
     */
    public boolean isTakenDay(Village village, int day) {
        Academy academy = academies.get(village);

        if (academy == null) return false;
        for (ClassRoom classRoom : academy.getClassRooms()) {
            if (classRoom.getDay() == day) return true;
        }
        return false;
    }

    public Map<Village, Academy> getAcademies() {
        return academies;
    }
}
