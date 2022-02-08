package controllers;

import objects.Flight;
import services.FlightService;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static utils.ConfigDate.DATE_FORMAT;
import static utils.ConfigDate.TIME_FORMAT;
import static utils.ConfigFormats.FORMAT_FLIGHTS_SEATS;
import static utils.FormatDate.*;
import static utils.FormatString.showMessageWithAnswer;
import static utils.FormatString.showTitleForFlightsWithSeats;

public class FlightController {
  private FlightService flightService = new FlightService();
  private int countOfPassengers = 0;


//  public static void getAllFlight() {
//    FlightService.getAllFlight();
//  }

  public static void displayAllFlight() {
    FlightService.displayAllFlight();
  }

  public static Flight getFlightByIndex(int index) {
    FlightService.getFlightByIndex(index);
    return null;
  }

  public static Flight createNewFlight(String destination, int day, int month, int year, int countPeople) {
    return FlightService.createNewFlight(destination, day, month, year, countPeople);
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



  public int getMaxSeatNumber() {

    return flightService.getAllFlights()
      .stream()
      .mapToInt(Flight::getMaxPeople)
      .max().orElse(-1);

  }

  public List<Flight> getFlightsByCriteria(String destination, String date, int passengersNumber) {

    return flightService.getAllFlights()
      .stream()
      .filter(
        f -> f.getDestination().equalsIgnoreCase(destination) &&
          ((f.getMaxPeople() - f.getPassengersOnBoard()) >= passengersNumber)
      )

      .collect(Collectors.toList());
  }
  public List<Flight> searchFlightsForBooking() {
    String destination = showMessageWithAnswer(
      "Введите место назначения:",
      "^[А-Я][А-Яа-я]+",
      "Вы не правильно ввели место назначения или в списке его нет!");

    String date = showMessageWithAnswer(
      "Введите дату вылета:",
      "^[0-9][0-9]/[0-9][0-9]/[2][0][1-2][0-9]",
      "Вы не правильно ввели дату вылета или рейсов на данную дату нету!");

    countOfPassengers = Integer.parseInt(showMessageWithAnswer(
      "Введите количество билетов:",
      "[0-9]+",
      "Вы указали некорректное число! Осталось " + getMaxSeatNumber() + " мест."));

    return getFlightsByCriteria(destination, date, this.countOfPassengers);
  }



  public void saveDB(String path) {
    flightService.saveDB(path);
  }
  public void readDB(String path) {
    flightService.readDB(path);
  }

  public void printFlightWithSeats(Flight flight, String format, int index) {
    if (flight != null && format.length() > 0)
      if (index > 1) {
        format = "   ->" + format;
      }
    String dateTime = String.format("%s %s", dateToStr(Long.valueOf(flight.getDate()), DATE_FORMAT), dateToStr(Long.valueOf(flight.getDate()), TIME_FORMAT));
    System.out.printf(format,
      flight.getFlightNumber(),
      dateTime,
      flight.getDestination(),
      timeOfDayLongToString(Long.valueOf(flight.getDate())),
      flight.getMaxPeople() - flight.getPassengersOnBoard()
    );
    System.out.println();
  }
  public void printFlightsWithAction(List<Flight> flights, String format) {
    if (flights.size() > 0)
      flights.forEach(flight -> {
        System.out.printf("%3d. ", flights.indexOf(flight) + +1);
        AtomicInteger index = new AtomicInteger();
        printFlightWithSeats(flight, format, index.addAndGet(1));
      });
  }
  public void printFlightsMenu(List<Flight> flights) {

    showTitleForFlightsWithSeats();


    printFlightsWithAction(flights, FORMAT_FLIGHTS_SEATS);

    System.out.println("0. Вернуться в меню");

  }
  public void printFlight(Flight flight, String format) {
    String dateTime = String.format("%s %s", dateToStr(Long.valueOf(flight.getDate()), DATE_FORMAT), dateToStr(Long.valueOf(flight.getDate()), TIME_FORMAT));
    System.out.printf(format,
      flight.getFlightNumber(),
      dateTime,
      flight.getDestination(),
      timeOfDayLongToString(Long.valueOf(flight.getDate()))
    );
  }

  public void setPassengersCount(int countOfPassengers) {
    this.countOfPassengers = countOfPassengers;
  }
  public int getPassengersCount() {
    return countOfPassengers;
  }


}
