package main.java.controllers;

import main.java.objects.Booking;
import main.java.objects.Flight;
import main.java.objects.Passenger;
import main.java.services.BookingService;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static main.java.utils.ConfigDate.DATE_TIME_FORMAT;
import static main.java.utils.ConfigFormats.FORMAT_BOOKING;
import static main.java.utils.FormatString.showMessageWithAnswer;
import static main.java.utils.FormatString.showTitleFroBookingList;


public class BookingController {

    private BookingService bookingService = new BookingService();
    private FlightController flightController = new FlightController();

    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

//    public void displayAllBookings() {
//        bookingService.displayAllBookings();
//    }

    public void saveBooking(Booking booking) {
        bookingService.saveBooking(booking);
    }

    public void saveDB(String filePath) {
        bookingService.saveDB(filePath);
    }

    public void readDB(String filePath) {
        bookingService.readDB(filePath);
    }

    public void deleteBookingByIndex(int index) {
        bookingService.deleteBookingByIndex(index);
    }

    public void deleteBookingByObject(Booking booking) {
        bookingService.deleteBookingByObject(booking);
    }

    public int count() {
        return bookingService.count();
    }

    public Booking getBookingById(int index) {
        return bookingService.getBookingById(index);
    }

    public Booking getBookingByBookingNumber(long bookingNumber) {

        return bookingService.getAllBookings()
                .stream()
                .filter(booking -> booking.getBookingNumber() == bookingNumber)
                .findAny().orElse(null);
    }

    public Booking createBooking(Flight flight, List<Passenger> passengers) {
        Booking result = null;

        if (flight != null && passengers.size() > 0) {
            result = new Booking(flight, passengers);
            passengers.forEach(passenger -> flight.addPassenger(passenger));
            saveBooking(result);
        }
        return result;
    }

    public void cancelBooking(long bookingNumber) {
        Booking booking = getBookingByBookingNumber(bookingNumber);
        if (booking != null) {
            booking.getPassengers().forEach(passenger ->
                    booking.getFlight().deletePassenger(passenger));
            deleteBookingByObject(booking);
        }
    }

    public List<Booking> getAllBookingsByFullName(String firstname, String lastname) {
        return bookingService.getAllBookings().stream()
                        .filter(b ->
                                bookingContainsFirstName(b, firstname) && bookingContainsLastName(b, lastname))
                        .collect(Collectors.toList());
    }

    private boolean bookingContainsFirstName(Booking booking, String firstname) {
        return !booking.getPassengers().stream()
                        .filter(p -> p.getFirstname().equalsIgnoreCase(firstname))
                        .collect(Collectors.toList()).isEmpty();
    }

    private boolean bookingContainsLastName(Booking booking, String lastname) {
        return
                !booking.getPassengers().stream()
                        .filter(p -> p.getLastname().equalsIgnoreCase(lastname))
                        .collect(Collectors.toList()).isEmpty();
    }

    private List<Passenger> createPassengersListForBooking(int count) {
        List<Passenger> result = new ArrayList();

        for (int i = 0; i < count; i++) {
            String firstname = showMessageWithAnswer(
                    String.format("Введите имя %d пассажира:", i + 1),
                    "^[А-Я][А-Яа-я]+",
                    "Вы ввели запрещенные символы или цифры!");
            String lastname = showMessageWithAnswer(
                    String.format("Введите фамилию %d пассажира:", i + 1),
                    "^[А-Я][А-Яа-я]+",
                    "Вы ввели запрещенные символы или цифры!");
            result.add(new Passenger(firstname, lastname));
        }
        return result;
    }

    public void makingBooking(Flight flight, int passengersNumberForBooking) {
        AtomicInteger index = new AtomicInteger();
        flightController.printFlight(flight, "");

        if (passengersNumberForBooking > 0) {
            createBooking(flight, createPassengersListForBooking(passengersNumberForBooking));

        }
    }

    private void printBooking(Booking booking, String format) {
        if (booking != null && format.length() > 0) {
            System.out.printf(format,
                    booking.getBookingNumber(),
                    booking.getDateTime().format(DateTimeFormatter
                            .ofPattern(DATE_TIME_FORMAT)),
                    booking.getFlight().getDestination(),
                    booking.getPassengers().size());

        }
    }


    public void printBookingInfo(Booking booking, String bookingFormat) {


        printBooking(booking, bookingFormat);

        System.out.println("Куплены билеты для:");
        booking.getPassengers().stream()
                .forEach(person -> {
                    System.out.printf("%d. %s %s",
                            booking.getPassengers().indexOf(person) + 1,
                            person.getFirstname(),
                            person.getLastname()
                    );
                    System.out.println();
                });
    }

    public boolean isEmptyBookings() {
        return this.count() == 0;
    }

    public void printCancelBookingMenu(List<Booking> bookings) {

        showTitleFroBookingList();

        printAllBookings(bookings, FORMAT_BOOKING);
    }

    public void printAllBookings(List<Booking> bookings, String format) {
        if (bookings.size() > 0)
            bookings.forEach(booking -> {
                System.out.printf("%d. ", bookings.indexOf(booking) + 1);
                printBookingInfo(booking, format);
            });
    }

    public boolean bookingNumberIsSet(long bookingNumber) {
        return getBookingByBookingNumber(bookingNumber) != null;
    }
}
