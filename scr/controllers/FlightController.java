package controllers;

import objects.Flight;
import services.FlightService;

public class FlightController {
//  public static void getAllFlight() {
//    FlightService.getAllFlight();
//  }

  public static void displayAllFlight() {
    FlightService.displayAllFlight();
  }

  public static Flight getFlightByIndex(int index) {
    return FlightService.getFlightByIndex(index);
  }

  public static void createNewFlight(String destination, int day, int month, int year, int countPeople) {
    FlightService.createNewFlight(destination, day, month, year, countPeople);
  }

  public static void generateFlight() {
    FlightService.generateFlight();
  }

  public static void deleteFlightByIndex(int i) {
    FlightService.deleteFlightByIndex(i);
  }

  public static void searchFreeFlight(String place, int day, int month, int year, int number) {
    FlightService.searchFreeFlight(place, day, month, year, number);
  }
}
