package actions;

import DAO.ActionDAO;
import DAO.MenuDAO;
import objects.AppData;
import objects.Booking;
import objects.Flight;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static utils.ConfigFormats.FORMAT_BOOKING;
import static utils.FormatString.showMessageWithAnswer;

public class ActionCancelBooking extends Actions implements MenuDAO {
  public ActionCancelBooking(AppData appData) {
    super(appData);
  }

  @Override
  public String getTitleAction() {
    return "4";
  }

  @Override
  public String getDesc() {
    return "Отменить бронирование";
  }

  @Override
  public void doAction() {
    Scanner input = new Scanner(System.in);

    boolean cancel = true;

    if (appData.getBooking().isEmptyBookings()) {
      System.out.println("Вы пока не бронировали билеты!");
      cancel = false;
    }

    while (cancel) {
      appData.getBooking().printCancelBookingMenu(appData.getBooking().getAllBookings());

      System.out.println("Введите корректный ID бронирования:");

      long idBooking;

      try {
        idBooking = input.nextLong();
      } catch (InputMismatchException e) {
        idBooking = -1;
      }

      if (appData.getBooking().bookingNumberIsSet(idBooking)) {
        appData.getBooking().cancelBooking(idBooking);
        cancel = false;
      } else {
        System.out.printf("Бронирования по ID %d не найдено! Введите корректный ID бронирования:\n", idBooking);
      }
    }
  }
}
