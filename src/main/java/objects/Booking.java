package main.java.objects;


import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static main.java.utils.ConfigDate.DATE_TIME_FORMAT;

public class Booking implements Serializable {

    private long number;
    private final LocalDateTime dateTime = LocalDateTime.now();
    private List<Passenger> passengers = new ArrayList();
    private Flight flight;

    public Booking(Flight flight) {

        this.number = setBookingNumber();
        this.flight = flight;
    }

    public Booking(Flight flight, List<Passenger> passengers) {
        this.number = setBookingNumber();
        this.flight = flight;
        this.setPassengers(passengers);
    }

    public long getBookingNumber() {
        return this.number;
    }

    private long setBookingNumber() {

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

    public boolean addPassenger(Passenger passenger) {
        if (!passengers.contains(passenger) &&
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

    public Passenger createPassenger(String firstname, String lastname, long birthdate, Gender gender) {
        Passenger result = new Passenger(firstname, lastname, birthdate, gender);
        addPassenger(result);

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return number == booking.number;
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
