package com.github.maazapan.ktacademy.academy.rooms;

import com.github.maazapan.ktacademy.academy.rooms.desk.DeskRoom;
import com.github.maazapan.ktacademy.academy.students.ClassStudent;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

    private final List<ClassStudent> classStudents;
    private final List<DeskRoom> deskRooms;

    private final int day;

    public ClassRoom(int day) {
        this.classStudents = new ArrayList<>();
        this.deskRooms = new ArrayList<>();
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public List<ClassStudent> getClassStudents() {
        return classStudents;
    }

    public List<DeskRoom> getDeskRooms() {
        return deskRooms;
    }
}
