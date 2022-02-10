package actions;

import DAO.ActionDAO;
import DAO.MenuDAO;
import controllers.FlightController;
import objects.AppData;

import static utils.ConfigFiles.FLIGHT_FILE;
import static utils.ConfigFormats.FORMAT_FLIGHTS;
import static utils.FormatDate.printNow;
import static utils.FormatString.showTitleForFlights;

public class ActionShowFlights extends Actions implements MenuDAO {
  public ActionShowFlights(AppData appData){
    super(appData);
  }
  @Override
  public String getTitleAction(){
    return "1";
  }
  @Override
  public String getDesc(){
    return "<<Онлайн-табло>>";
  }
  @Override
  public void doAction() {
    System.out.printf("%s\n", "Рейсы из аэропорта \"Киев\":" + printNow());
    showTitleForFlights();

//    AppData.getFlight().printAllSortedCurrent24Hours(FORMAT_FLIGHTS);
    FlightController.displayAllFlight();

  }
}
