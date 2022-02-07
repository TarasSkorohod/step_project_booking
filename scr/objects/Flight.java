package objects;

public class Flight {
  String destination;
  String Date;
  int countPeople;
  Passenger passenger;
  int maxPeople = 100;

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
}
