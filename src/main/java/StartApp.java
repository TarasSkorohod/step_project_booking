package main.java;

import main.java.logger.Logs;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class StartApp {
  public static void main(String[] args) throws FileNotFoundException, ParseException {
    Logs.log("Set test flights");
    SetTestFlights.setTestFlights();
    App.app();
  }
}
