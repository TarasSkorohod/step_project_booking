package main.java.objects;

import main.java.controllers.BookingController;
import main.java.controllers.FlightController;
import main.java.controllers.UserController;

public class AppData {

    private final BookingController booking = new BookingController();
    private final FlightController flight = new FlightController();
    private final UserController user = new UserController();

    public BookingController getBooking() {
        return this.booking;
    }

    public FlightController getFlight() {
        return this.flight;
    }


    public UserController getUser () {return this.user;}

}
