package actions;

import DAO.ActionDAO;
import DAO.MenuDAO;
import objects.AppData;
import objects.Flight;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ActionAddToBooking extends Actions implements MenuDAO {
  public ActionAddToBooking(AppData appData) {
    super(appData);
  }

  @Override
  public String getTitleAction() {
    return "3";
  }

  @Override
  public String getDesc() {
    return "Поиск и бронировка рейса";
  }

  @Override
  public void doAction() {

    List<Flight> searchResult = AppData.getFlight().searchFlightsForBooking();

    if (searchResult.size() != 0) {
      boolean controlSearchAndBooking = true;

      while (controlSearchAndBooking) {
        AppData.getFlight().printFlightsMenu(searchResult);

        System.out.println("Введите число от 1 до " + searchResult.size() + " для выбора рейса или введите 0, чтобы вернуться в меню:");

        int choiceSearchAndBooking;
        try {
          Scanner input = new Scanner(System.in);
          choiceSearchAndBooking = input.nextInt();

        } catch (InputMismatchException e) {
          choiceSearchAndBooking = -1;
        }

        if (choiceSearchAndBooking >= 1 && choiceSearchAndBooking <= searchResult.size()) {
          AppData.getBooking().makingBooking(
            searchResult.get(choiceSearchAndBooking - 1),
            AppData.getFlight().getPassengersCount()
          );
          AppData.getFlight().setPassengersCount(0);
          controlSearchAndBooking = false;
        } else if (choiceSearchAndBooking == 0) {
          controlSearchAndBooking = false;
        } else
          System.out.println(
            "Your choice is wrong. Please enter the flight order number [1-" +
              searchResult.size() + "] to book or 0 to return.");
      }
    }
    else{
      System.out.println("По данным критериям рейс не найдет, попробуйте ещё раз...");
    }
  }
}
