package me.splitque.logging;

import me.splitque.logging.prefixes.FilePrefix;
import me.splitque.logging.prefixes.Prefix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private String name;
    private String color;
    private String file;
    private List<String> logList;
    private Object obj;
    private Path logPath;

    public Logger(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public Logger(String name, String color, Object obj, String path) {
        this.name = name;
        this.color = color;
        this.file = LocalDate.now() + " " + LocalTime.now().getHour() + "-" + LocalTime.now().getMinute() + ".txt";
        this.logList = new ArrayList<>();
        this.obj = obj;
        this.logPath = Paths.get(getJarDir(this.obj) + "/" + path + "/" + this.file);

        try {
            if (!Files.exists(logPath)) {
                Files.createDirectories(logPath.getParent());
                Files.createFile(logPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void message(String message) {
        System.out.println(Prefix.MESSAGE(name, color) + message);
        saveLog(FilePrefix.MESSAGE(name) + message);
    }
    public void info(String message) {
        System.out.println(Prefix.INFO(name, color) + message);
        saveLog(FilePrefix.INFO(name) + message);
    }
    public void warn(String message) {
        System.out.println(Prefix.WARN(name, color) + message);
        saveLog(FilePrefix.WARN(name) + message);
    }
    public void error(String message) {
        System.out.println(Prefix.ERROR(name, color) + message);
        saveLog(FilePrefix.ERROR(name) + message);
    }
    public void debug(String message, boolean showMessage) {
        if (showMessage) System.out.println(Prefix.DEBUG(name, color) + message);
        if (showMessage) saveLog(FilePrefix.DEBUG(name) + message);
    }
    public void errorCode(String message, int code) {
        System.out.println(Prefix.ERROR_CODE(name, color, code) + message);
        saveLog(FilePrefix.ERROR_CODE(name, code) + message);
    }
    public void debugCode(String message, int code, boolean showMessage) {
        if (showMessage) System.out.println(Prefix.DEBUG_CODE(name, color, code) + message);
        if (showMessage) saveLog(FilePrefix.DEBUG_CODE(name, code) + message);
    }

    private void saveLog(String message) {
        if (logPath != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logPath.toFile()))) {
                logList.add(message);
                for (String line : logList) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String getJarDir(Object obj) {
        String jarDir = "";
        try {
            jarDir = new File(obj.getClass()
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI())
                    .getParent();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return jarDir;
    }
}
