package main.java.logger;

import java.io.*;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SaveLogs {
  public static String filePath = "./logs/logger.log";

  public static void writeLogs(String msg) {

    try {
      FileWriter writer = new FileWriter(filePath, true);
      BufferedWriter bufferWriter = new BufferedWriter(writer);
      bufferWriter.write(msg);
      bufferWriter.close();
    }
    catch (IOException e) {
      System.out.println(e);
    }
  }
}
