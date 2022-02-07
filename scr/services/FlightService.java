package services;

import DAO.ActionDAO;
import collections.CollectionsFlightDao;
import objects.Flight;

import java.util.List;

public class FlightService{
  private static final ActionDAO actionDAO = new CollectionsFlightDao();

  public static List<Flight> getAllFlight() {
    return actionDAO.getAllFlight();
  }

  public static void displayAllFlight() {
//    if (getAllFlight().size() != 0) {
      for (int i = 0; i < getAllFlight().size(); i++) {
        System.out.println("======================");
        System.out.println("Index flight - " + i);
        getAllFlight().get(i).prettyFormat();
      }
//    } else {
//      System.out.println("Flight not found!");
//    }
  }

  public static Flight createNewFlight(String destination, int day, int month, int year, int countPeople) {
    Flight flight = new Flight(destination, day, month, year, countPeople);
    actionDAO.saveFlight(flight);
    return flight;
  }

  public static Flight getFlightByIndex(int index) {
      return getAllFlight().get(index);
  }
}
