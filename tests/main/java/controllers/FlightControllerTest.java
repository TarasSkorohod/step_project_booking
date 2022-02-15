package main.java.controllers;

import main.java.objects.Flight;
import main.java.services.FlightService;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Collectors;

import static main.java.utils.ConfigDate.DATE_FORMAT;
import static main.java.utils.ConfigDate.TIME_FORMAT;
import static main.java.utils.FormatDate.*;
import static main.java.utils.FormatString.showMessageWithAnswer;
import static org.junit.jupiter.api.Assertions.*;

class FlightControllerTest {

  @Test
  void getPassengersCount() {
    int countOfPassengers = 0;

    assertEquals(countOfPassengers, 0);
  }

  @Test
  void setPassengersCount() {
    int countOfPassengers = 0;
    assertEquals(countOfPassengers, 0);

    countOfPassengers = 1;
    assertEquals(countOfPassengers, 1);
  }

  @Test
  void saveDB() {
    FlightService flightService = new FlightService();
    flightService.saveDB("./db/flights.txt");
  }

  @Test
  void readDB() {
    FlightService flightService = new FlightService();
    flightService.readDB("./db/flights.txt");
  }

  @Test
  void printAllSortedCurrent24Hours() {
    String FORMAT_FLIGHTS = "| %-10s | %-20s | %-20s | %-15s |\n";
    String format = FORMAT_FLIGHTS;
    FlightService flightService = new FlightService();
    flightService.getAllFlights()
      .stream()
      .sorted(Comparator.comparingLong(Flight::getDepartureDateTime))
      .forEach(f ->
        printFlight(f, format)
      );


  }



  void printFlight(Flight flight, String format) {
    String dateTime = String.format("%s %s", dateToStr(flight.getDepartureDateTime(), DATE_FORMAT), dateToStr(flight.getDepartureDateTime(), TIME_FORMAT));
    System.out.printf(format,
      flight.getFlightNumber(),
      dateTime,
      flight.getDestination(),
      timeOfDayLongToString(flight.getDepartureDateTime())
    );

    assertEquals(dateTime, "");
  }

  @Test
  void getByFlightNumber() {
    FlightService flightService = new FlightService();
    String flightNumber = "1";
    Flight flight = null;

    flight = flightService.getAllFlights()
      .stream()
      .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
      .findFirst().orElse(null);



    assertEquals(flight, null);
  }
}