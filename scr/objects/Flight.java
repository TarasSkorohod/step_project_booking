package objects;

public class Flight {
  String destination; //место назначения
  int day;
  int month;
  int year;
  int countPeople; //Количество людей
  int vacantSeats; //Свободные места
  Passenger passenger;
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

  public Flight(String destination, int day, int month, int year, int countPeople, Passenger passenger) {
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

  public void setVacantSeats(int count) {
    this.vacantSeats = count;
  }

  public int getVacantSeats() {
    return vacantSeats;
  }

  public void prettyFormat() {
    String pass;
    if (passenger == null) {
      pass = "0 count";
    } else {
      pass = passenger.toString();
    }
    System.out.println(
      "======================\n" +
      "Destination: " + destination + ", \n" +
      "Date: " + getDate() + ", \n" +
      "Count People: free " + vacantSeats + " out of " + maxPeople + " \n" +
      "Passenger: " + pass);
  }
}
