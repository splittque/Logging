package me.splitque.logging;

import me.splitque.logging.variables.Color;
import me.splitque.manager.JarManager;
import org.junit.jupiter.api.Test;

public class Tests extends JarManager {
    @Test
    public void loggerWithoutFileTest() {
        Logger log = new Logger("Test", Color.BLUE);
        log.message("message");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.debug("debug", true);
        log.debug("debug", false);
        log.errorCode("error", 1);
        log.debugCode("debug", 2, true);

        Logger log1 = new Logger("", Color.CYAN);
        log1.message("message");
        log1.info("info");
        log1.warn("warn");
        log1.error("error");
        log1.debug("debug", true);
        log1.debug("debug", false);
        log1.errorCode("error", 1);
        log1.debugCode("debug", 2, true);

        Logger log2 = new Logger(null, Color.CYAN);
        log2.message("message");
        log2.info("info");
        log2.warn("warn");
        log2.error("error");
        log2.debug("debug", true);
        log2.debug("debug", false);
        log2.errorCode("error", 1);
        log2.debugCode("debug", 2, true);
    }
    @Test
    public void loggerWithFileTest() {
        LogFile file = new LogFile(getJarDir() + "/logs");
        Logger log = new Logger("Test", Color.BLUE, file);
        log.message("message");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.debug("debug", true);
        log.debug("debug", false);
        log.errorCode("error", 1);
        log.debugCode("debug", 2, true);

        Logger log1 = new Logger("", Color.CYAN, file);
        log1.message("message");
        log1.info("info");
        log1.warn("warn");
        log1.error("error");
        log1.debug("debug", true);
        log1.debug("debug", false);
        log1.errorCode("error", 1);
        log1.debugCode("debug", 2, true);

        Logger log2 = new Logger(null, Color.CYAN, file);
        log2.message("message");
        log2.info("info");
        log2.warn("warn");
        log2.error("error");
        log2.debug("debug", true);
        log2.debug("debug", false);
        log2.errorCode("error", 1);
        log2.debugCode("debug", 2, true);
    }
}