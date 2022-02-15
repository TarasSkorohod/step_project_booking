package main.java.controllers;


import main.java.objects.Flight;
import main.java.services.FlightService;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


import static main.java.utils.ConfigDate.*;
import static main.java.utils.ConfigFormats.FORMAT_FLIGHTS_SEATS;
import static main.java.utils.FormatDate.*;
import static main.java.utils.FormatString.showMessageWithAnswer;
import static main.java.utils.FormatString.showTitleForFlightsWithSeats;


public class FlightController {

    private FlightService flightService = new FlightService();
    private int countOfPassengers = 0;

    public int getPassengersCount() {
        return countOfPassengers;
    }
    public void setPassengersCount(int countOfPassengers) {
        this.countOfPassengers = countOfPassengers;
    }
    public void saveDB(String path) {
        flightService.saveDB(path);
    }
    public void readDB(String path) {
        flightService.readDB(path);
    }
    public void printAllSortedCurrent24Hours(String format) {

        flightService.getAllFlights()
                .stream()
                .sorted(Comparator.comparingLong(Flight::getDepartureDateTime))
                .forEach(f -> printFlight(f, format)
                );
    }
    public void printFlight(Flight flight, String format) {
        String dateTime = String.format("%s %s", dateToStr(flight.getDepartureDateTime(), DATE_FORMAT), dateToStr(flight.getDepartureDateTime(), TIME_FORMAT));
        System.out.printf(format,
                flight.getFlightNumber(),
                dateTime,
                flight.getDestination(),
                timeOfDayLongToString(flight.getDepartureDateTime())
        );
    }
    public Flight getByFlightNumber(String flightNumber) {
        Flight flight = null;

        flight = flightService.getAllFlights()
            .stream()
            .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
            .findFirst().orElse(null);



        return flight;
    }
    public int getMaxSeatNumber() {

        return flightService.getAllFlights()
                        .stream()
                        .mapToInt(Flight::getMaxNumSeats)
                        .max().orElse(-1);

    }
    public List<Flight> getFlightsByCriteria(String destination, String date, int passengersNumber) {

        return flightService.getAllFlights()
                .stream()
                .filter(
                        f -> f.getDestination().equalsIgnoreCase(destination) &&
                                f.getDepartureDateTime() > parseDate(date) &&
                                ((f.getMaxNumSeats() - f.getPassengersOnBoard()) >= passengersNumber)
                )
                .sorted(Comparator.comparingLong(Flight::getDepartureDateTime))
                .collect(Collectors.toList());
    }
    public void displayFlightInfo(Flight flight) {
        showTitleForFlightsWithSeats();
        printFlightWithSeats(flight, FORMAT_FLIGHTS_SEATS, 1);

    }
    public void printFlightWithSeats(Flight flight, String format, int index) {
        if (flight != null && format.length() > 0)
            if (index > 1) {
                format = "   ->" + format;
            }
        String dateTime = String.format("%s %s", dateToStr(flight.getDepartureDateTime(), DATE_FORMAT), dateToStr(flight.getDepartureDateTime(), TIME_FORMAT));
        System.out.printf(format,
                flight.getFlightNumber(),
                dateTime,
                flight.getDestination(),
                timeOfDayLongToString(flight.getDepartureDateTime()),
                flight.getMaxNumSeats() - flight.getPassengersOnBoard()
        );
    }
    public List<Flight> searchFlightsForBooking() {
        String destination = showMessageWithAnswer(
                "Введите место назначения:",
                "^[А-Я][А-Яа-я]+",
                "Вы не правильно ввели место назначения или в списке его нет!");

        String date = showMessageWithAnswer(
                "Введите дату вылета:",
                "^[0-9][0-9]/[0-9][0-9]/[2][0][1-2][0-9]",
                "Вы не правильно ввели дату вылета или рейсов на данную дату нету!");

        countOfPassengers = Integer.parseInt(showMessageWithAnswer(
                "Введите количество билетов:",
                "[0-9]+",
                "Вы указали некорректное число! Осталось " + getMaxSeatNumber() + " мест."));

        return getFlightsByCriteria(destination, date, this.countOfPassengers);
    }
    public void printFlightsWithAction(List<Flight> flights, String format) {
        if (flights.size() > 0)
            flights.forEach(flight -> {
                System.out.printf("%3d. ", flights.indexOf(flight) + +1);
                AtomicInteger index = new AtomicInteger();
                printFlightWithSeats(flight, format, index.addAndGet(1));
            });
    }
    public void printFlightsMenu(List<Flight> flights) {

        System.out.print("     ");
        showTitleForFlightsWithSeats();


        printFlightsWithAction(flights, FORMAT_FLIGHTS_SEATS);
    }
}
