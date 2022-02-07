package actions;

import java.util.Scanner;

public class Action {
    public static void main(String[] args) {
        System.out.println("1.Онлайн-табло");
        System.out.println("2.Посмотреть информацию о рейсе");
        System.out.println("3.Поиск и бронировка рейса");
        System.out.println("4.Отменить бронирование");
        System.out.println("5.Мои рейсы");
        System.out.println("6.Выход");
        System.out.println("----------------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Выберите пункт меню: ");
        in.nextInt();
        in.close();
    }
}
