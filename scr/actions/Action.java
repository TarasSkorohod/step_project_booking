package actions;

import controllers.FlightController;

import java.util.Scanner;

public class Action {
    public static void action() {
        System.out.println("1.Онлайн-табло");
        System.out.println("2.Посмотреть информацию о рейсе");
        System.out.println("3.Поиск и бронировка рейса");
        System.out.println("4.Отменить бронирование");
        System.out.println("5.Мои рейсы");
        System.out.println("6.Выход");
        System.out.println("----------------------");

        Scanner in = new Scanner(System.in);
        System.out.print("Выберите пункт меню: ");
        String scan = in.next();


       switch(scan){
           case "1":
//               FlightController.displayAllFlight();
           case "3":
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
       }
        in.close();
    }

}






