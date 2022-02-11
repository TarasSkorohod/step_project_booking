package main.java;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class StartApp {
  public static void main(String[] args) throws FileNotFoundException, ParseException {
    SetTestFlights.setTestFlights();
    App.app();
  }
}
