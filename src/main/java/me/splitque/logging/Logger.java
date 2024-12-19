package me.splitque.logging;

import me.splitque.logging.prefixes.FilePrefix;
import me.splitque.logging.prefixes.Prefix;

public class Logger {
    private String name;
    private String color;
    private LogFile logFile;

    public Logger(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public Logger(String name, String color, LogFile logFile) {
        this.name = name;
        this.color = color;
        this.logFile = logFile;
    }

    public void message(String message) {
        System.out.println(Prefix.MESSAGE(name, color) + message);
        if (logFile != null) logFile.saveLog(FilePrefix.MESSAGE(name) + message);
    }
    public void info(String message) {
        System.out.println(Prefix.INFO(name, color) + message);
        if (logFile != null) logFile.saveLog(FilePrefix.INFO(name) + message);
    }
    public void warn(String message) {
        System.out.println(Prefix.WARN(name, color) + message);
        if (logFile != null) logFile.saveLog(FilePrefix.WARN(name) + message);
    }
    public void error(String message) {
        System.out.println(Prefix.ERROR(name, color) + message);
        if (logFile != null) logFile.saveLog(FilePrefix.ERROR(name) + message);
    }
    public void debug(String message, boolean showMessage) {
        if (showMessage) System.out.println(Prefix.DEBUG(name, color) + message);
        if (showMessage && logFile != null) logFile.saveLog(FilePrefix.DEBUG(name) + message);
    }
    public void errorCode(String message, int code) {
        System.out.println(Prefix.ERROR_CODE(name, color, code) + message);
        if (logFile != null) logFile.saveLog(FilePrefix.ERROR_CODE(name, code) + message);
    }
    public void debugCode(String message, int code, boolean showMessage) {
        if (showMessage) System.out.println(Prefix.DEBUG_CODE(name, color, code) + message);
        if (showMessage && logFile != null) logFile.saveLog(FilePrefix.DEBUG_CODE(name, code) + message);
    }
}
