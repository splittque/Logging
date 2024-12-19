package me.splitque.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LogFile {
    private List<String> logs = new ArrayList<>();
    private String file;
    private Path logsPath;

    public LogFile(String path) {
        this.file = LocalDate.now() + " " + LocalTime.now().getHour() + "-" + LocalTime.now().getMinute() + ".txt";
        this.logsPath = Paths.get(path + "/" + this.file);

        try {
            if (!Files.exists(logsPath)) {
                Files.createDirectories(logsPath.getParent());
                Files.createFile(logsPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public LogFile(String path, String file) {
        this.file = file;
        this.logsPath = Paths.get(path + "/" + this.file);

        try {
            if (!Files.exists(logsPath)) {
                Files.createDirectories(logsPath.getParent());
                Files.createFile(logsPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveLog(String message) {
        if (logsPath != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logsPath.toFile()))) {
                logs.add(message);
                for (String line : logs) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
