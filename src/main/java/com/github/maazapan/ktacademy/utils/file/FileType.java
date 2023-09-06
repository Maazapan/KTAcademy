package com.github.maazapan.ktacademy.utils.file;

public enum FileType {

    CONFIG("config.yml"),
    MESSAGES("messages.yml");

    private final String fileName;

    FileType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
