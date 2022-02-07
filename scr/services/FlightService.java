package services;

import DAO.ActionDAO;
import collections.CollectionsFlightDao;
import controllers.FlightController;
import objects.Flight;
import utils.GenerateRandomNumbers;

import java.util.List;
import java.util.Objects;

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
    String date = day + "/" + month + "/" + year;
    searchFreeFlight(destination, date, countPeople);
    actionDAO.saveFlight(flight);
    return flight;
  }

  public static void searchFreeFlight(String destination, String date, int countPeople) {
    for (int i = 0; i < actionDAO.getAllFlight().size(); i++) {
      Flight freeFlight = actionDAO.getFlightByIndex(i);
      if (Objects.equals(freeFlight.getDestination(), destination) && freeFlight.getCountPeople() >= countPeople) {
        freeFlight.prettyFormat();

        deleteFlightByIndex(i);
      }
    }
  }

  public static Flight getFlightByIndex(int index) {
      return getAllFlight().get(index);
  }

  public static void generateFlight() {
    for (int i = 0; i < GenerateRandomNumbers.getRandomNumberForCountFlight(); i++) {
      String destination = GenerateRandomNumbers.getRandomCountry();
      int day = GenerateRandomNumbers.getRandomNumberForDay();
      int month = GenerateRandomNumbers.getRandomNumberForMonth();
      int year = 2022;
      int countPeople = GenerateRandomNumbers.getRandomNumberForCountPeople();

      FlightController.createNewFlight(destination, day, month, year, countPeople);
    }
  }

  public static void deleteFlightByIndex(int index) {
    actionDAO.deleteFlight(index);
  }


}
