package objects;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static utils.ConfigDate.DATE_TIME_FORMAT;

public class Booking implements Serializable {
  private long number;
  private final LocalDateTime dateTime = LocalDateTime.now();
  private List<Passenger> passengers = new ArrayList();
  private Flight flight;

  public Booking(long number, Flight flight) {
    this.number = number;
    this.flight = flight;
  }

  public Booking(long number, List<Passenger> passengers,Flight flight) {
    this.number = number;
    this.passengers = passengers;
    this.flight = flight;
  }

  public long getBookingNumber() {
    return this.number;
  }

  public long setBookingNumber(long number) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Booking booking = (Booking) o;
    return number == number;
  }

  @Override
  public int hashCode() {
    int result = 11;
    int coef = 31;

    result = coef * result + (int) number;

    return (int) number;
  }

  @Override
  public String toString() {
    return "Booking{" +
      "number=" + number +
      ", dateTime='" + dateTime.format(DateTimeFormatter
      .ofPattern(DATE_TIME_FORMAT)) + '\'' +
      ", flight=" + flight +
      ", passengers=" + passengers +
      '}';
  }

}
