package main.java;

import main.java.logger.Logs;
import main.java.objects.BookingApp;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class StartApp {
  public static void main(String[] args) throws FileNotFoundException, ParseException {
    BookingApp app = new BookingApp();

    Logs.log("Set test flights", "info");
    SetTestFlights.setTestFlights();
    Logs.log("App is run", "info");
    Logs.log("Run auth", "info");

    Logs.log("Start app", "info");
    app.start();
  }
}
