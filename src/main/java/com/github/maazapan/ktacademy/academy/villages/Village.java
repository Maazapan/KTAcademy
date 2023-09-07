package com.github.maazapan.ktacademy.academy.villages;

public enum Village {

    AMEGAKURE,
    KONOHAGAKURE,
    SUNAGAKURE,
    IWAGAKURE,
    KUMOGAKURE,
    KIRIGAKURE,
    GLOBAL;


    public static boolean exists(String village) {
        for (Village value : values()) {
            if (village.equalsIgnoreCase(value.toString())) return true;
        }
        return false;
    }
}
