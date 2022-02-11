package main.java.logger;

import main.java.utils.ConfigDate;
import main.java.utils.FormatDate;

import static main.java.utils.ConfigColor.*;

public class Logs implements ConfigDate {
  public static void log(String msg, String typeLog) {
    String logWithTerminal = ANSI_YELLOW  + "[" + FormatDate.printNowTimeForLogger() + "] " + msg + ANSI_RESET; // для вывода в терминал
    String logWithFile = "[" + FormatDate.printNowTimeForLogger() + "] " + typeLog.toUpperCase() + " - " + msg + "\n"; // для вывода в файл
    SaveLogs.writeLogs(logWithFile);
  }
}
