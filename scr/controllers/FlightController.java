package controllers;

import objects.Flight;
import services.FlightService;

public class FlightController {
  public static void getAllFlight() {
    FlightService.getAllFlight();
  }

  public static void displayAllFlight() {
    FlightService.displayAllFlight();
  }

  public static Flight getFlightByIndex(int index) {
    FlightService.getFlightByIndex(index);
    return null;
  }

  public static Flight createNewFlight(String destination, int day, int month, int year, int countPeople) {
    return FlightService.createNewFlight(destination, day, month, year, countPeople);
  }

  public static void generateFlight() {
    FlightService.generateFlight();
  }
}
