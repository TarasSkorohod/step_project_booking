package controllers;

import services.FlightService;

public class FlightController {
  public static void getAllFlight() {
    FlightService.getAllFlight();
  }

  public static void displayAllFlight() {
    FlightService.displayAllFlight();
  }

  public static void getFlightByIndex(int index) {
    FlightService.getFlightByIndex(index);
  }

  public static void createNewFlight(String destination, int day, int month, int year, int countPeople) {
    FlightService.createNewFlight(destination, day, month, year, countPeople);
  }
}
