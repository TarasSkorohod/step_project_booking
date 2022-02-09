package objects;

import DAO.ActionDAO;
import actions.Action;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static utils.ConfigFiles.BOOKING_FILE;
import static utils.ConfigFiles.FLIGHT_FILE;

public class BookingApp {
  private final AppData appData = new AppData();
  List<ActionDAO> allActions = Action.getAll(appData);

  public BookingApp() {
    appData.getFlight().readDB(FLIGHT_FILE);
    appData.getBooking().readDB(BOOKING_FILE);
  }
  private void printMainMenu() {
    AtomicInteger index = new AtomicInteger();
    allActions
      .stream()
      .forEach(a -> System.out.printf("%d. %s (Нажмите %s)\n", index.incrementAndGet(), a.getDesc(), a.getTitleAction()));
  }
}
