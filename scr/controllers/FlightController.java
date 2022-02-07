package controllers;

import objects.Flight;
import services.FlightService;

public class FlightController {
  public static void getAllFlight() {

//    FlightService.getAllFlight();
  }

  public static void displayAllFlight() {
    FlightService.displayAllFlight();
  }

  public static void getFlightByIndex(int index) {
    FlightService.getFlightByIndex(index);
  }

  public static Flight createNewFlight(String destination, int day, int month, int year, int countPeople) {
    return FlightService.createNewFlight(destination, day, month, year, countPeople);
  }
}
