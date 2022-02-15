package main.java.actions;

import main.java.DAO.MenuDAO;
import main.java.logger.Logs;
import main.java.objects.AppData;

import java.util.ArrayList;
import java.util.List;


public class Actions {
    public static List<MenuDAO> getAll(AppData appData) {

        List<MenuDAO> actions = new ArrayList<>();

        Logs.log("Add action to Array", "info");

        actions.add(new ActionShowFlights(appData));
        actions.add(new ActionShowFlightById(appData));
        actions.add(new ActionAddToBooking(appData));
        actions.add(new ActionCancelBooking(appData));
        actions.add(new ActionShowMyFlights(appData));
        actions.add(new ActionExit(appData));

        return actions;

    }
}
