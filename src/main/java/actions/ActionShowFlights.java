package main.java.actions;

import main.java.DAO.MenuDAO;
import main.java.objects.AppData;

import static main.java.utils.FormatDate.printNow;
import static main.java.utils.ConfigFormats.*;
import static main.java.utils.FormatString.showTitleForFlights;


public class ActionShowFlights extends Action implements MenuDAO {
    public ActionShowFlights(AppData appData) {
        super(appData);
    }

    @Override
    public String getTitleAction() {
        return "1";
    }

    @Override
    public String getDesc() {
        return "Онлайн-табло";
    }

    @Override
    public void doAction() {
        System.out.printf("%s\n", "Рейсы из аэропорта \"Жуляны\":" + printNow());
        showTitleForFlights();
        this.appData.getFlight().printAllSortedCurrent24Hours(FORMAT_FLIGHTS);

    }
}
