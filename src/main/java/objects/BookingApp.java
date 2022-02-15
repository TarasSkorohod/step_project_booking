package main.java.objects;

import main.java.DAO.MenuDAO;
import main.java.actions.Actions;
import main.java.logger.Logs;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static main.java.utils.ConfigFiles.*;

public class BookingApp {


    private final AppData appData = new AppData();
    List<MenuDAO> allActions = Actions.getAll(appData);

    public BookingApp() {
        Logs.log("Get DB Flights", "info");
        appData.getFlight().readDB(FLIGHT_FILE);
        Logs.log("Get DB Booking", "info");
        appData.getBooking().readDB(BOOKING_FILE);
    }


    private void printMainMenu() {
        Logs.log("Show commands start menu", "info");
        AtomicInteger index = new AtomicInteger();
        allActions
                .stream()
                .forEach(a -> System.out.printf("%d. %s (Нажмите %s)\n", index.incrementAndGet(), a.getDesc(), a.getTitleAction()));
    }

    public void start() {
        Logs.log("Running start menu", "info");
        Scanner in = new Scanner(System.in);
        Optional<MenuDAO> action;
        Boolean die = false;
        do {
            printMainMenu();
            System.out.print("Выберите действие:");


            String commandUser = in.nextLine().trim();
            action = allActions
                    .stream()
                    .filter(a -> a.getTitleAction().equalsIgnoreCase(commandUser))
                    .findFirst();

            if (action.isPresent()) {
                action.get().doAction();
                die = action.get().exit();
            } else {
                System.out.println("Данной команды нету");
            }

        } while (!die);
    }
}
