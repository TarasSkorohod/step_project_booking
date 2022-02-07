package booking;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {

  private long number;
  private final LocalDateTime dateTime = LocalDateTime.now();
  private List<Passenger> passengers = new ArrayList();
  private Flight flight;

  public Flight(long number, Flight flight) {
    this.number = number;
    this.flight = flight;
  }

  public Flight(long number, List<Passenger> passengers, Flight flight) {
    this.number = setBookingNumber();
    this.passengers = passengers;
    this.flight = flight;
  }

  public Flight(long number) {
    this.number = number;
  }


  public long getBookingNumber() {
    return this.number;
  }

  public long setBookingNumber() {

    return dateTime.getYear() * 10000000000L +
      dateTime.getMonth().getValue() * 100000000 +
      dateTime.getDayOfMonth() * 1000000 +
      dateTime.getHour() * 10000 +
      dateTime.getMinute() * 100 +
      dateTime.getSecond();

  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

}
