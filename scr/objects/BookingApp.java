package objects;

import DAO.ActionDAO;
import DAO.MenuDAO;
import actions.Action;
import services.FlightService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static utils.ConfigFiles.BOOKING_FILE;
import static utils.ConfigFiles.FLIGHT_FILE;

public class BookingApp {

  private final AppData appData = new AppData();
  List<MenuDAO> allActions = Action.getAll(appData);

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

  public void start() {
    FlightService.generateFlight();

    Scanner in = new Scanner(System.in);
    Optional<MenuDAO> actions;
    Boolean die = false;
    do {
      printMainMenu();
      System.out.print("Выберите действие: ");


      String commandUser = in.nextLine().trim();
      actions = allActions
        .stream()
        .filter(a -> a.getTitleAction().equalsIgnoreCase(commandUser))
        .findFirst();

      if (actions.isPresent()) {
        actions.get().doAction();
        die = actions.get().exit();
      } else {
        System.out.println("Данной команды нету");
      }

    } while (!die);
  }
}
