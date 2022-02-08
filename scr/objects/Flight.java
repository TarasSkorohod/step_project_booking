package objects;

import java.util.List;

public class Flight {
  String destination; //место назначения
  private String flightNumber;
  int day;
  int month;
  int year;
  int countPeople; //Количество людей
  int vacantSeats; //Свободные места
  List<Passenger> passenger = null;
  int maxPeople = 100; //максимальное количество свободых мест
  private List<Passenger> passengers;


  public Flight () {
    this.destination = "";
    this.day = 0;
    this.month = 0;
    this.year = 0;
    this.countPeople = 0;
    this.vacantSeats = 0;
    this.passenger = null;
  }

  public Flight(String destination, int day, int month, int year, int countPeople) {
    this.destination = destination;
    this.day = day;
    this.month = month;
    this.year = year;
    this.countPeople = countPeople;
  }

  public Flight(String destination, String flightNumber, int day, int month, int year, int countPeople, List<Passenger> passenger) {
    this.destination = destination;
    this.flightNumber = flightNumber;
    this.day = day;
    this.month = month;
    this.year = year;
    this.countPeople = countPeople;
    this.passenger = passenger;
  }

  public String getDestination() {
    return destination;
  }

  public String getDate() {
    return day + "/" + month + "/" + year;
  }
  public String setDate() {
    return day + "/" + month + "/" + year;
  }


  public String getFlightNumber() {
    return flightNumber;
  }

  public int getMaxPeople() {
    return maxPeople;
  }

  public int getPassengersOnBoard() {
    return passengers.size();
  }
  public void setMaxPeople(int maxPeople) {
    this.maxPeople = maxPeople;
  }

  public int getCountPeople() {
    return countPeople;
  }

//  public void setCountPeople(int count) {
//    this.countPeople = count;
//  }

  public void setListPassenger(List<Passenger> passenger) {
    this.passenger = passenger;
  }

  public void setVacantSeats(int count) {
    this.vacantSeats = count;
  }

  public int getVacantSeats() {
    return vacantSeats;
  }

  public void prettyFormat() {
    System.out.println(
      "======================\n" +
      "Destination: " + destination + ", \n" +
      "Date: " + getDate() + ", \n" +
      "Count People: free " + vacantSeats + " out of " + maxPeople);

    System.out.println("======================\n");
  }
  public boolean addPassenger(Passenger passenger) {

    if (!passengers.contains(passenger) &&
      passengers.size() < maxPeople &&
      passenger != null) {

      passengers.add(passenger);
      return true;

    } else

      return false;

  }

  public boolean deletePassenger(Passenger passenger) {

    if (!passengers.contains(passenger)) return false;

    passengers.remove(passenger);
    return true;

  }

  public boolean deletePassenger(int index) {
    if (index >= 0 && index < passengers.size()) {
      if (!passengers.contains(passengers.get(index))) return false;

      passengers.remove(passengers.get(index));
      return true;
    }
    return false;
  }


}
