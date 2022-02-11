import actions.Action;
import objects.BookingApp;
import services.FlightService;

public class App {
  public static void main(String[] args) {
    FlightService.generateFlight();
    BookingApp app = new BookingApp();
    app.start();
  }
}
