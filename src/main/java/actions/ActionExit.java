package main.java.actions;

import main.java.DAO.MenuDAO;
import main.java.objects.AppData;

import static main.java.utils.ConfigFiles.*;

public class ActionExit  extends Action implements MenuDAO {

    public ActionExit(AppData appData) {
        super(appData);
    }

    @Override
    public String getTitleAction() {
        return "6";
    }

    @Override
    public String getDesc() {
        return "Выход из программы";
    }

    @Override
    public void doAction() {

        appData.getFlight().saveDB(FLIGHT_FILE);
        appData.getBooking().saveDB(BOOKING_FILE);
    }

    @Override
    public boolean exit() {
        return true;
    }
}
