package me.splitque.logging.prefixes;

import me.splitque.logging.variables.Color;

import java.time.LocalDate;
import java.time.LocalTime;

public class Prefix {
    private static final String TIME = Color.CYAN + "[" + LocalDate.now() + " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] ";
    public static String MESSAGE(String name, String color) {
        if (name == null || name.isBlank()) return TIME + color;
        if (name != null & !name.isBlank()) return TIME + color + "(" + name + ") ";
        return null;
    }
    public static String INFO(String name, String color) {
        if (name == null || name.isBlank()) return TIME + Color.BRIGHT_WHITE + "INFO: ";
        if (name != null & !name.isBlank()) return TIME + color + "(" + name + ") " + Color.BRIGHT_WHITE + "INFO: ";
        return null;
    }
    public static String WARN(String name, String color) {
        if (name == null || name.isBlank()) return TIME + Color.YELLOW + "WARN: ";
        if (name != null & !name.isBlank()) return TIME + color + "(" + name + ") " + Color.YELLOW + "WARN: ";
        return null;
    }
    public static String ERROR(String name, String color) {
        if (name == null || name.isBlank()) return TIME + Color.RED + "ERROR: ";
        if (name != null & !name.isBlank()) return TIME + color + "(" + name + ") " + Color.RED + "ERROR: ";
        return null;
    }
    public static String DEBUG(String name, String color) {
        if (name == null || name.isBlank()) return TIME + Color.DARK_GRAY + "DEBUG: ";
        if (name != null & !name.isBlank()) return TIME + color + "(" + name + ") " + Color.DARK_GRAY + "DEBUG: ";
        return null;
    }

    public static String ERROR_CODE(String name, String color, int code) {
        if (name == null || name.isBlank()) return TIME + Color.RED + "ERROR" + "(" + code + "): ";
        if (name != null & !name.isBlank()) return TIME + color + "(" + name + ") " + Color.RED + "ERROR" + "(" + code + "): ";
        return null;
    }
    public static String DEBUG_CODE(String name, String color, int code) {
        if (name == null || name.isBlank()) return TIME + Color.DARK_GRAY + "DEBUG" + "(" + code + "): ";
        if (name != null & !name.isBlank()) return TIME + color + "(" + name + ") " + Color.DARK_GRAY + "DEBUG" + "(" + code + "): ";
        return null;
    }
}
