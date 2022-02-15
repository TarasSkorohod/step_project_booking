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
    saveFlight();
    ActionDAO flightDao = new CollectionFlightDAO();

    for (int i = 0; i < flightDao.getAllFlight().size(); i++) {
      Flight item = flightDao.getAllFlight().get(i);

      assertEquals(item, "booking.Flight{flightNumber='1', departureDate ='01/01/1970', departureTime ='03:03', destination='Dnipro', passengersOnBoard=0, maxNumSeats=100}");
    }

  }

  @Test
  void saveFlight() {
    ActionDAO flightDao = new CollectionFlightDAO();
    Flight flight = new Flight("1", 232323L, "Dnipro", 100);
    flightDao.saveFlight(flight);
  }

  @Test
  void saveDB() {
    ActionDAO flightDao = new CollectionFlightDAO();
    flightDao.saveDB("./db/flights.txt");
  }

  @Test
  void readDB() {
    ActionDAO flightDao = new CollectionFlightDAO();
    flightDao.readDB("./db/flights.txt");
  }

  @Test
  void deleteFlight() {
    ActionDAO flightDao = new CollectionFlightDAO();

    Flight flight = new Flight("1", 232323L, "Dnipro", 100);
    flightDao.saveFlight(flight);

    assertEquals(flightDao.getAllFlight().size(), 1);
    flightDao.remove(0);
    assertEquals(flightDao.getAllFlight().size(), 0);
  }

  @Test
  void testDeleteFlight() {
    ActionDAO flightDao = new CollectionFlightDAO();

    Flight flight = new Flight("1", 232323L, "Dnipro", 100);
    flightDao.saveFlight(flight);

    assertEquals(flightDao.getAllFlight().size(), 1);
    flightDao.remove(flight);
    assertEquals(flightDao.getAllFlight().size(), 0);
  }

  @Test
  void count() {
    ActionDAO flightDao = new CollectionFlightDAO();

    Flight flight = new Flight("1", 232323L, "Dnipro", 100);
    flightDao.saveFlight(flight);

    assertEquals(flightDao.getAllFlight().size(), 1);
  }

  @Test
  void getFlightById() {
    ActionDAO flightDao = new CollectionFlightDAO();
    int index = 0;

    Flight flight = new Flight("1", 232323L, "Dnipro", 100);
    flightDao.saveFlight(flight);

    if (index < flightDao.getAllFlight().size() && index >= 0) {
      flightDao.getAllFlight().get(index);
      assertEquals(flightDao.getAllFlight().get(index).toString(), "booking.Flight{flightNumber='1', departureDate ='01/01/1970', departureTime ='03:03', destination='Dnipro', passengersOnBoard=0, maxNumSeats=100}");
    }
  }
}