package services;

import DAO.ActionDAO;
import collections.CollectionsFlightDao;
import objects.Flight;
import utils.GenerateRandomNumbers;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FlightService{
  private static final ActionDAO actionDAO = new CollectionsFlightDao();
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
    Flight flight = new Flight(destination, day, month, year, countPeople);
    actionDAO.saveFlight(flight);
    return flight;
  }

  //Поиск свободных рейсов
  public static void searchFreeFlight(String destination, int day, int month, int year, int countPeople) {
//    Flight flight = new Flight(destination, day, month, year, countPeople);

    for (int i = 0; i < actionDAO.getAllFlight().size(); i++) {
      Flight freeFlight = actionDAO.getFlightByIndex(i);
      if (Objects.equals(freeFlight.getDestination(), destination) && freeFlight.getVacantSeats() >= countPeople) {
        displayingAvailableFlights(freeFlight, i);
        flightBooking(countPeople, scan);
//        BookingController.saveBooking(flightByIndex);
//        deleteFlightByIndex(i);
      }
    }
  }

  //Отображение доступных рейсов
  private static void displayingAvailableFlights(Flight freeFlight, int index) {
    System.out.println("======================");
    System.out.println("Index flight - " + index);
    freeFlight.prettyFormat();
  }

  //бронирование рейса
  private static void flightBooking(int count, Scanner scan) {
    System.out.print("Введите номер рейса: ");
    int indexFlight = scan.nextInt();

    Flight flightByIndex = getFlightByIndex(indexFlight);
    int finishCountSeats = flightByIndex.getVacantSeats() - count;

    flightByIndex.setVacantSeats(finishCountSeats);
    flightByIndex.prettyFormat();


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

      createNewFlight(destination, day, month, year, countPeople);
      Flight flight = getFlightByIndex(i);
      flight.setVacantSeats(vacantSeats);
    }
  }

  public static boolean deleteFlightByIndex(int index) {
    return actionDAO.deleteFlight(index);
  }
}
