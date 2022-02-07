package objects;

public class Flight {
  String destination;
  String Date;
  int countPeople;
  Human human;

  Flight () {
    this.destination = "";
    this.Date = "";
    this.countPeople = 0;
  }

  Flight (String destination, int day, int month, int year, int countPeople) {
    this.destination = destination;
    this.Date = day + "/" + month + "/" + year;
    this.countPeople = countPeople;
  }

  @Override
  public String toString() {
    String infoFlight =
      "Destination: " + destination + ", \n" +
      "Date: " + Date + ", \n" +
      "Count People: " + countPeople;

    return infoFlight;
  }
}
