package main.java.actions;

import main.java.DAO.MenuDAO;
import main.java.objects.AppData;
import main.java.objects.Flight;


import static main.java.utils.FormatString.showMessageWithAnswer;

public class ActionShowFlightById extends Action implements MenuDAO {

    public ActionShowFlightById(AppData appData) {
        super(appData);
    }

    @Override
    public String getTitleAction() {
        return "2";
    }

    @Override
    public String getDesc() {
        return "Посмотреть информацию о рейсе";
    }

    @Override
    public void doAction() {

        String flightNumber = showMessageWithAnswer("Введите номер рейса [пример: BZ4911]:").toUpperCase();


        Flight flight = this.appData.getFlight().getByFlightNumber(flightNumber);

        if (flight != null) {
            appData.getFlight().displayFlightInfo(flight);
        } else {
            System.out.println("Извините, но данного рейса нету в списке!");
        }
    }
}
