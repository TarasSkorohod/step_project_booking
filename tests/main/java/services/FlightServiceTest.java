package main.java.services;

import main.java.DAO.ActionDAO;
import main.java.collections.CollectionFlightDAO;
import main.java.objects.Flight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {
  @Test
  void getAllFlights() {
    ActionDAO flightDao = new CollectionFlightDAO();
    List<Flight> allFlight = flightDao.getAllFlight();

    assertEquals(allFlight.toString(), "[]");
    System.out.println("get all flights");
  }

  @Test
  void displayAllFlights() {
  }

  @Test
  void saveFlight() {
  }

  @Test
  void saveDB() {
  }

  @Test
  void readDB() {
  }

  @Test
  void deleteFlight() {
  }

  @Test
  void testDeleteFlight() {
  }

  @Test
  void count() {
  }

  @Test
  void getFlightById() {
  }
}