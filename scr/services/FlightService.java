package services;

import DAO.ActionDAO;
import collections.CollectionsFlightDao;
import objects.Flight;

import java.util.List;

public class FlightService{
  private static ActionDAO actionDAO;

  FlightService() {
    this.actionDAO = new CollectionsFlightDao();
  }

  public static List<Flight> getAllFlight() {
    return actionDAO.getAllFlight();
  }

  public static void displayAllFlight() {
    System.out.println("Hello world!");
  }
}
