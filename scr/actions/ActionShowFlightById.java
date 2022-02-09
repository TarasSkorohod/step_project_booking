package actions;

import DAO.ActionDAO;
import DAO.MenuDAO;
import collections.CollectionsFlightDao;
import controllers.FlightController;
import objects.AppData;
import objects.Flight;

import static utils.FormatString.showMessageWithAnswer;

public class ActionShowFlightById extends Actions implements MenuDAO {

  private static final ActionDAO actionDAO = new CollectionsFlightDao();


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

    String flightNumber = showMessageWithAnswer("Введите номер рейса:");


    Flight flight = this.appData.getFlight().getByFlightNumber(flightNumber);
    FlightController.getFlightByIndex(flight.getMaxNumSeats());

    if (flight != null) {
      appData.getFlight().displayFlightInfo(flight);
    } else {
      System.out.println("Извините, но данного рейса нету в списке!");
    }
  }
}
