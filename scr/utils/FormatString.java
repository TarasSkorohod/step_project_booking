package utils;


import java.util.Scanner;

import static utils.ConfigFormats.*;

public class FormatString {
  public static String showMessageWithAnswer(String message) {
    System.out.print(message);
    Scanner input = new Scanner(System.in);
    String result = input.nextLine().trim();

    return result;
  }

  public static String showMessageWithAnswer(String message, String pattern, String errorMess) {
    String result = "";
    boolean isValid = true;

    System.out.print(message);
    Scanner input = new Scanner(System.in);

    while (isValid) {
      result = input.nextLine().trim();
      if (result.matches(pattern)) {
        isValid = false;
      }else{
        System.out.print(errorMess + " Попробуйте ещё раз");
      }
    }
    return result;
  }


  public static void showTitleForFlightsWithSeats(){
    System.out.printf(FORMAT_FLIGHTS_SEATS, "Рейс", "Время вылета", "Пункт назначения", "Время перелета", "Своб. места");
  }



  public static void showTitleFroBookingList(){
    System.out.printf(FORMAT_BOOKING, "Номер бронирования", "Время вылета", "Пункт назначения", "Куплено билетов");
  }

}
