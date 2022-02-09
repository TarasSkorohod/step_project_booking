package actions;

import DAO.ActionDAO;
import controllers.BookingController;
import controllers.FlightController;
import objects.AppData;
import objects.Booking;
import objects.Flight;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import static utils.ConfigFiles.BOOKING_FILE;
import static utils.ConfigFiles.FLIGHT_FILE;
import static utils.ConfigFormats.FORMAT_BOOKING;
import static utils.FormatString.showMessageWithAnswer;

public class Action {
    public static   void action() {
        FlightController.generateFlight();
        Scanner in = new Scanner(System.in);
        String scan;

        do {
            System.out.println("----------------------");
            System.out.println("1.Онлайн-табло");
            System.out.println("2.Посмотреть информацию о рейсе");
            System.out.println("3.Поиск и бронировка рейса");
            System.out.println("4.Отменить бронирование");
            System.out.println("5.Мои рейсы");
            System.out.println("6.Выход");
            System.out.println("----------------------");
            System.out.print("Выберите пункт меню: ");
            scan = in.next();
            System.out.println("----------------------");

            switch(scan){
                case "1":
                    System.out.println("<<Онлайн-табло>>");
                    System.out.println("Рейсы Киева");
                    FlightController.displayAllFlight();
                    break;
                case "2":
                    System.out.println("Рейсы Киева");
                    FlightController.displayAllFlight();
                    System.out.print("Введите номер рейса: ");
                    int indexFlight = in.nextInt();
                    Flight flight = FlightController.getFlightByIndex(indexFlight);
                    assert flight != null;
                    flight.toString();
                    break;
                case "3":
//                    List<Flight> searchResult = AppData.getFlight().searchFlightsForBooking();
//                    if (searchResult.size() != 0) {
//                        boolean controlSearchAndBooking = true;
//
//                        while (controlSearchAndBooking) {
//                            AppData.getFlight().printFlightsMenu(searchResult);
//
//                            System.out.println("Введите число от 1 до " + searchResult.size() + " для выбора рейса или введите 0, чтобы вернуться в меню:");
//
//                            int choiceSearchAndBooking;
//
//                            try {
//                                Scanner input = new Scanner(System.in);
//                                choiceSearchAndBooking = input.nextInt();
//
//                            }catch (InputMismatchException e) {
//                                choiceSearchAndBooking = -1;
//                            }
//                            if (choiceSearchAndBooking >= 1 && choiceSearchAndBooking <= searchResult.size()) {
//                                AppData.getBooking().makingBooking(
//                                  searchResult.get(choiceSearchAndBooking - 1),
//                                  AppData.getFlight().getPassengersCount()
//                                );
//                                AppData.getFlight().setPassengersCount(0);
//                                controlSearchAndBooking = false;
//                            } else if (choiceSearchAndBooking == 0) {
//                                controlSearchAndBooking = false;
//                            } else
//                                System.out.println("Your choice is wrong. Please enter the flight order number [1-" +
//                                    searchResult.size() + "] to book or 0 to return.");
//                        }
//                    }
//                    else{
//                        System.out.println("По данным критериям рейс не найдет, попробуйте ещё раз...");
//                    }


                    System.out.println("<<Поиск и бронировка рейса>>");
                    System.out.print("Место назначения: ");
                    String place = in.next();
                    System.out.print("День: ");
                    int day = in.nextInt();
                    System.out.print("месяц: ");
                    int month = in.nextInt();
                    System.out.print("Год: ");
                    int year = in.nextInt();
                    System.out.print("Количество человек: ");
                    int number = in.nextInt();

                    FlightController.searchFreeFlight(place, day, month, year, number);
                    break;
                case "4":
                    System.out.println("<<Отменить бронирование>>");
                    boolean cancel = true;

                    if (AppData.getBooking().isEmptyBookings()) {
                        System.out.println("Вы пока не бронировали билеты!");
                        cancel = false;
                    }
                    while (cancel) {
                        AppData.getBooking().printCancelBookingMenu(AppData.getBooking().getAllBookings());
                        System.out.println("Введите корректный ID бронирования:");
                        long idBooking;
                        try {
                            idBooking = in.nextLong();
                        } catch (InputMismatchException e) {
                            idBooking = -1;
                        }
                        if (AppData.getBooking().bookingNumberIsSet(idBooking)) {
                            AppData.getBooking().cancelBooking(idBooking);
                            cancel = false;
                        } else {
                            System.out.printf("Бронирования по ID %d не найдено! Введите корректный ID бронирования:\n", idBooking);
                        }
                    }
                    break;
                case "5":
                    String firstname = showMessageWithAnswer(
                      "Введите имя:",
                      "^[А-Я][А-Яа-я]+",
                      "Вы не корректно ввели имя!");

                    String lastname = showMessageWithAnswer(
                      "Введите фамилию:",
                      "^[А-Я][А-Яа-я]+",
                      "Вы не корректно ввели фамилию!");
                    List<Booking> bookings = AppData.getBooking().getAllBookingsByFullName(firstname, lastname);
                    if (bookings.size() > 0 ) {

                        AppData.getBooking().printAllBookings(bookings, FORMAT_BOOKING);
                        System.out.println();
                    } else {
                        System.out.printf("По данным пользователя '%s %s' бронировки не найдено!\n", firstname, lastname);
                    }
                    break;
                case "6":
                    System.out.println("Выход из программы");
                    AppData.getFlight().saveDB(FLIGHT_FILE);
                    AppData.getBooking().saveDB(BOOKING_FILE);
                    break;
            }
        } while (!scan.equals("6"));

        in.close();
    }

    public static List<ActionDAO> getAll(AppData appData) {
        return null;
    }
}