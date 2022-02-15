package main.java.logger;

import main.java.utils.ConfigDate;
import main.java.utils.FormatDate;

public class Logs implements ConfigDate {
  public static void log(String msg, String typeLog) {
    String logWithFile = "[" + FormatDate.printNowTimeForLogger() + "] " + typeLog.toUpperCase() + " - " + msg + "\n"; // для вывода в файл
    SaveLogs.writeLogs(logWithFile);
  }
}
