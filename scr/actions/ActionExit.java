package actions;

import DAO.ActionDAO;
import DAO.MenuDAO;
import objects.AppData;
import objects.Flight;

import static utils.ConfigFiles.*;
import static utils.FormatString.showMessageWithAnswer;


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

    AppData.getBooking().saveDB(BOOKING_FILE);
  }

  @Override
  public boolean exit() {
    return true;
  }
}