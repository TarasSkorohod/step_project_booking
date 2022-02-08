package actions;

import controllers.BookingController;
import controllers.FlightController;
import objects.Flight;


import java.util.Scanner;

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
                    flight.prettyFormat();
                    break;
                case "3":
                    System.out.println("<<Поиск и бронировка рейса>>");
                    System.out.print("Место назначения: ");
                    String place = in.nextLine();
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
                    System.out.print("Введите id бронирования, чтобы отменить его: ");
                    int id = in.nextInt();
                    break;
                case "5":
                    System.out.println("<<Мои рейсы>>");
                    System.out.print("Введите ваше Имя: ");
                    String name = in.next();
                    System.out.print("Введите вашу фамилию: ");
                    String surname = in.next();
                    break;
                case "6":
                    break;
            }
        } while (!scan.equals("6"));

        in.close();
    }

}