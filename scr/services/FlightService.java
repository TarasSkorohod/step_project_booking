package services;

import DAO.ActionDAO;
import collections.CollectionsFlightDao;
import controllers.FlightController;
import objects.Booking;
import objects.Flight;
import objects.Passenger;
import utils.GenerateRandomNumbers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class FlightService{
  private static final ActionDAO actionDAO = new CollectionsFlightDao();

  private static List<Booking> bookingsList;
  private static Booking flightByIndex;
  private static Object i;


  public static List<Flight> getAllFlight() {
    return actionDAO.getAllFlight();
  }
  private static Scanner scan = new Scanner(System.in);

  public static void displayAllFlight() {
    for (int i = 0; i < getAllFlight().size(); i++) {
      System.out.println("======================");
      System.out.println("Index flight - " + i);
      getAllFlight().get(i).prettyFormat();
    }
  }
  public static Flight createNewFlight(String destination, int day, int month, int year, int countPeople) {
//    Flight flight = new Flight(destination, day, month, year, countPeople);
    Flight flight = new Flight(
      "String flightNumber",
      1556175797428L,
      "String destination",
      10);
    actionDAO.saveFlight(flight);
    return flight;
  }

  //Поиск свободных рейсов
  public static void searchFreeFlight(String destination, int day, int month, int year, int countPeople) {
    Flight freeFlight = null;
    for (int i = 0; i < actionDAO.getAllFlight().size(); i++) {
      freeFlight = actionDAO.getFlightByIndex(i);


    }

  }


  //Отображение доступных рейсов
  public static void displayingAvailableFlights() {
    System.out.println("======================");
    System.out.println("Index flight - " );
  }

  //бронирование рейса
  private static void flightBooking(int count, Scanner scan) {
    System.out.print("Введите номер рейса: ");
    int indexFlight = scan.nextInt();

    Flight flightByIndex = getFlightByIndex(indexFlight);
    int finishCountSeats = flightByIndex.getVacantSeats() - count;

    flightByIndex.setVacantSeats(finishCountSeats);
    flightByIndex.toString();
  }

  //бронирование пассажиров
  private static void passengerBooking(Scanner scan, int count) {
    for (int index = 0; index < count; index++) {
      System.out.printf("\n<< Пассажир № %s >>\n", index);
      System.out.print("Введите имя: ");
      String firstName = scan.next();

      System.out.print("Введите фамилию: ");
      String lastName = scan.next();


      Passenger passenger = new Passenger(firstName, lastName);
      PassengerService.createNewPassenger(passenger);
      System.out.printf("Пассажир № %s - добавлен\n", index);
    }
  }

  public static Flight getFlightByIndex(int index) {
      return getAllFlight().get(index);
  }

  //Генереация рейсов для пункта - Онлайн табло
  public static void generateFlight() {
    for (int i = 0; i < GenerateRandomNumbers.getRandomNumberForCountFlight(); i++) {
      String destination = GenerateRandomNumbers.getRandomCountry();
      int day = GenerateRandomNumbers.getRandomNumberForDay();
      int month = GenerateRandomNumbers.getRandomNumberForMonth();
      int year = 2022;
      int countPeople = GenerateRandomNumbers.getRandomNumberForCountPeople();
      int vacantSeats = GenerateRandomNumbers.getRandomNumberForCountVacantSeats();

      FlightController.createNewFlight(destination, day, month, year, countPeople);
      Flight flight = getFlightByIndex(i);
      flight.setVacantSeats(vacantSeats);
      flight.setFlightNumber(Integer.toString(i));
    }
  }



  public static boolean deleteFlightByIndex(int index) {
    return actionDAO.deleteFlight(index);
  }
//  public static void searchFreeFlight(String place, int day, int month, int year, int number) {
//     FlightService.searchFreeFlight(place, day, month, year, number);
//  }
  public void saveDB(String path) {
    actionDAO.saveDB(path);
  }
  public void readDB(String path) {
    actionDAO.readDB(path);
  }
  public List<Flight> getAllFlights() {
    return actionDAO.getAll();
  }



}
