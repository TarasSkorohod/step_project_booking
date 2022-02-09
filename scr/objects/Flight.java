package objects;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static utils.ConfigDate.*;

public class Flight {
  private String flightNumber;
  private long departureDateTime;
  private String destination;
  private int maxNumSeats;
  int vacantSeats; //Свободные места
  int maxPeople = 100; //максимальное количество свободых мест
  int countPeople; //Количество людей
  private List<Passenger> passengers;

 @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Flight flight = (Flight) o;
    return flightNumber.equals(flight.getFlightNumber());
  }

  @Override
  public int hashCode() {

    int result = 11;
    int coef = 31;

    return coef * result + flightNumber.hashCode();

  }
  public void prettyFormat() {
    System.out.println(
      "======================\n" +
        "Destination: " + destination + ", \n" +
        "Date: " + getDepartureDateTime() + ", \n" +
        "Count People: free " + vacantSeats + " out of " + maxPeople + " \n");
  }


  @Override
  public String toString() {
    return "booking.Flight{" +
      "flightNumber='" + flightNumber + '\'' +
      ", departureDate ='" +
      Instant.ofEpochMilli(departureDateTime)
        .atZone(ZoneId.of(TIME_ZONE))
        .toLocalDateTime()
        .format(DateTimeFormatter
          .ofPattern(DATE_FORMAT)) + '\'' +
      ", departureTime ='" +
      Instant.ofEpochMilli(departureDateTime)
        .atZone(ZoneId.of(TIME_ZONE))
        .toLocalDateTime()
        .format(DateTimeFormatter
          .ofPattern(TIME_FORMAT)) + '\'' +
      ", destination='" + destination + '\'' +
      ", passengersOnBoard=" + getPassengersOnBoard() +
      ", maxNumSeats=" + maxNumSeats;
  }

  public Flight(String flightNumber, long departureDateTime, String destination, int maxNumSeats) {

    this.flightNumber = flightNumber;
    this.departureDateTime = departureDateTime;
    this.destination = destination;
    this.maxNumSeats = maxNumSeats;
    this.passengers = new ArrayList();

  }
  public Flight(String destination, int day, int month, int year, int countPeople) {
    this.destination = "";
    this.vacantSeats = 0;
  }

  public Flight(String destination) {
    this.destination = destination;

  }

  public Flight(String destination,int countPeople) {
    this.destination = destination;
    this.countPeople = countPeople;
  }


  public void setVacantSeats(int count) {
    this.vacantSeats = count;
  }

  public int getVacantSeats() {
    return vacantSeats;
  }
  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public long getDepartureDateTime() {
    return departureDateTime;
  }

  public void setDepartureDateTime(long departureDateTime) {
    this.departureDateTime = departureDateTime;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public int getPassengersOnBoard() {
    return passengers.size();
  }

  public int getMaxNumSeats() {
    return maxNumSeats;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }

  public boolean addPassenger(Passenger passenger) {

    if (!passengers.contains(passenger) &&
      passengers.size() < maxNumSeats &&
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

  public void setListPassenger(List<Passenger> allPassenger) {
  }
}
