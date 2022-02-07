package services;

import DAO.ActionDAO;
import collections.CollectionsFlightDao;
import controllers.FlightController;
import objects.Flight;
import utils.GenerateRandomNumbers;

import java.util.List;

public class FlightService{
  private static final ActionDAO actionDAO = new CollectionsFlightDao();
  public static List<Flight> getAllFlight() {
    return actionDAO.getAllFlight();
  }

  public static void displayAllFlight() {
      for (int i = 0; i < getAllFlight().size(); i++) {
        System.out.println("======================");
        System.out.println("Index flight - " + i);
        getAllFlight().get(i).prettyFormat();
      }
  }

  public static Flight createNewFlight(String destination, int day, int month, int year, int countPeople) {
    Flight flight = new Flight(destination, day, month, year, countPeople);
    actionDAO.saveFlight(flight);
    return flight;
  }

  public static Flight getFlightByIndex(int index) {
      return getAllFlight().get(index);
  }

  public static void generateFlight() {
    for (int i = 0; i < GenerateRandomNumbers.getRandomNumberForCountFlight(); i++) {
      String destination = "City #" + i;
      int day = GenerateRandomNumbers.getRandomNumberForDay();
      int month = GenerateRandomNumbers.getRandomNumberForMonth();
      int year = GenerateRandomNumbers.getRandomNumberForYear();
      int countPeople = GenerateRandomNumbers.getRandomNumberForCountPeople();

      FlightController.createNewFlight(destination, day, month, year, countPeople);
    }
  }
}
