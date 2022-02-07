package objects;

import java.util.List;

public class Flight {
  private String destination;
  private String Date;
  private String flightNumber;
  int countPeople;
  Passenger passenger;
  int maxPeople = 100;
  private List<Passenger> passengers;
  private int maxNumSeats;



  public Flight () {
    this.destination = "";
    this.Date = "";
    this.countPeople = 0;
  }

  public Flight(String destination, int day, int month, int year, int countPeople) {
    this.destination = destination;
    this.Date = day + "/" + month + "/" + year;
    this.countPeople = countPeople;
  }

  public String getDestination() {
    return destination;
  }

  public String getDate() {
    return Date;
  }

  public int getCountPeople() {
    return countPeople;
  }

  public void prettyFormat() {
    System.out.println(
      "======================\n" +
      "Destination: " + destination + ", \n" +
      "Date: " + Date + ", \n" +
      "Count People: free " + countPeople + " out of " + maxPeople + " \n");
  }

  public boolean addPassenger(Passenger passenger) {

    if (!passengers.contains(passenger) &&
      passengers.size() < maxNumSeats &&
      passenger != null) {

      passengers.add(passenger);
      return true;

    } else return false;
  }
}
