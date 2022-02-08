package objects;

import services.PassengerService;

import java.util.List;

public class Flight {
  String destination; //место назначения
  int day;
  int month;
  int year;
  int countPeople; //Количество людей
  int vacantSeats; //Свободные места
  List<Passenger> passenger = null;
  int maxPeople = 100; //максимальное количество свободых мест

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

  public Flight(String destination, int day, int month, int year, int countPeople, List<Passenger> passenger) {
    this.destination = destination;
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
}
