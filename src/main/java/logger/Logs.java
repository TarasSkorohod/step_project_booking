package main.java.logger;

import main.java.utils.ConfigDate;
import main.java.utils.FormatDate;

import static main.java.utils.ConfigColor.*;

public class Logs implements ConfigDate {
  public static void log(String msg) {
    String logWithTime = ANSI_YELLOW  + "[" + FormatDate.printNowTimeForLogger() + "] " + msg + ANSI_RESET;
    SaveLogs.writeLogs(logWithTime);
  }
}
