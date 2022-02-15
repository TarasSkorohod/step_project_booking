package main.java.actions;



import main.java.DAO.MenuDAO;
import main.java.objects.AppData;
import main.java.objects.Flight;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ActionAddToBooking extends Action implements MenuDAO {
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

        System.out.println("=====================================================================================================");
        List<Flight> searchResult = appData.getFlight().searchFlightsForBooking();
        System.out.println("=====================================================================================================");

        if (searchResult.size() != 0) {
            boolean controlSearchAndBooking = true;

            while (controlSearchAndBooking) {
                appData.getFlight().printFlightsMenu(searchResult);
                System.out.println("=====================================================================================================");

                System.out.print("Введите число от 1 до " + searchResult.size() + " для выбора рейса или введите 0, чтобы вернуться в меню: ");

                int choiceSearchAndBooking;
                try {
                    Scanner input = new Scanner(System.in);
                    choiceSearchAndBooking = input.nextInt();
                    System.out.println("=====================================================================================================");
                } catch (InputMismatchException e) {
                    choiceSearchAndBooking = -1;
                }

                if (choiceSearchAndBooking >= 1 && choiceSearchAndBooking <= searchResult.size()) {
                    appData.getBooking().makingBooking(
                            searchResult.get(choiceSearchAndBooking - 1),
                            appData.getFlight().getPassengersCount()
                    );
                    appData.getFlight().setPassengersCount(0);
                    controlSearchAndBooking = false;
                } else if (choiceSearchAndBooking == 0) {
                    controlSearchAndBooking = false;
                } else
                    System.out.println(
                            "Ваш выбор неверен. Пожалуйста, введите номер заказа на рейс [1-" +
                                    searchResult.size() + "] для бронирования или 0 для возврата.");
            }
        }
        else{
            System.out.println("По данным критериям рейс не найдет, попробуйте ещё раз...");
            System.out.println("==============================================================================\n");
        }
    }

}
