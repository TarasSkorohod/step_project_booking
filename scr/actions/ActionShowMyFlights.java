package actions;

import DAO.MenuDAO;
import objects.AppData;
import objects.Booking;

import java.util.List;

import static utils.ConfigFormats.FORMAT_BOOKING;
import static utils.FormatString.showMessageWithAnswer;

public class ActionShowMyFlights extends Actions implements MenuDAO {
  public ActionShowMyFlights(AppData appData) {
    super(appData);
  }

  @Override
  public String getTitleAction() {
    return "5";
  }

  @Override
  public String getDesc() {
    return "Мои рейсы";
  }

  @Override
  public void doAction() {

    String firstname = showMessageWithAnswer(
      "Введите имя:",
      "^[А-Я][А-Яа-я]+",
      "Вы не корректно ввели имя!");

    String lastname = showMessageWithAnswer(
      "Введите фамилию:",
      "^[А-Я][А-Яа-я]+",
      "Вы не корректно ввели фамилию!");

    List<Booking> bookings = appData.getBooking().getAllBookingsByFullName(firstname, lastname);
    if (bookings.size() > 0 ) {

      appData.getBooking().printAllBookings(bookings, FORMAT_BOOKING);
      System.out.println();
    } else {
      System.out.printf("По данным пользователя '%s %s' бронировки не найдено!\n", firstname, lastname);
    }

  }
}
