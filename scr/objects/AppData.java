package objects;


import controllers.BookingController;
import controllers.FlightController;

public class AppData {
  private static final BookingController booking = new BookingController();
  private static final FlightController flight = new FlightController();

  public static BookingController getBooking() {
    return booking;
  }

  public static FlightController getFlight() {
    return flight;
  }

}
