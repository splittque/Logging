package me.splitque.logging.prefixes;

import java.time.LocalDate;
import java.time.LocalTime;

public class FilePrefix {
    private static final String TIME = "[" + LocalDate.now() + " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] ";
    public static String MESSAGE(String name) {
        if (name == null || name.isBlank()) return TIME;
        if (name != null & !name.isBlank()) return TIME + "(" + name + ") ";
        return null;
    }
    public static String INFO(String name) {
        if (name == null || name.isBlank()) return TIME + "INFO: ";
        if (name != null & !name.isBlank()) return TIME + "(" + name + ") " + "INFO: ";
        return null;
    }
    public static String WARN(String name) {
        if (name == null || name.isBlank()) return TIME + "WARN: ";
        if (name != null & !name.isBlank()) return TIME + "(" + name + ") " + "WARN: ";
        return null;
    }
    public static String ERROR(String name) {
        if (name == null || name.isBlank()) return TIME + "ERROR: ";
        if (name != null & !name.isBlank()) return TIME + "(" + name + ") " + "ERROR: ";
        return null;
    }
    public static String DEBUG(String name) {
        if (name == null || name.isBlank()) return TIME + "DEBUG: ";
        if (name != null & !name.isBlank()) return TIME + "(" + name + ") " + "DEBUG: ";
        return null;
    }
    public static String ERROR_CODE(String name, int code) {
        if (name == null || name.isBlank()) return TIME + "ERROR" + "(" + code + "): ";
        if (name != null & !name.isBlank()) return TIME + "(" + name + ") " + "ERROR" + "(" + code + "): ";
        return null;
    }
    public static String DEBUG_CODE(String name, int code) {
        if (name == null || name.isBlank()) return TIME + "DEBUG" + "(" + code + "): ";
        if (name != null & !name.isBlank()) return TIME + "(" + name + ") " + "DEBUG" + "(" + code + "): ";
        return null;
    }
}
