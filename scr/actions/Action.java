package actions;

import DAO.MenuDAO;
import controllers.FlightController;
import objects.AppData;
import java.util.ArrayList;
import java.util.List;

public class Action {
    public Action(AppData appData) {

    }

    public static List<MenuDAO> getAll(AppData appData) {

        List<MenuDAO> actions = new ArrayList<>();

        actions.add(new ActionShowFlights(appData));
        actions.add(new ActionShowFlightById(appData));
        actions.add(new ActionAddToBooking(appData));
        actions.add(new ActionCancelBooking(appData));
        actions.add(new ActionShowMyFlights(appData));

        actions.add(new ActionExit(appData));

        return actions;
    }
}