package main.java.authorization;

import main.java.DAO.AuthDAO;
import main.java.services.UserService;

import java.util.Scanner;

public class Auth {
  public static void startAuth() {
    boolean exit = true;
    do {
      System.out.println("---------- Добро пожаловать ----------");
      System.out.println("1.Вход \n2.Регистрация\n3.Выход");
      System.out.print("Пожалуйста, введите ваш выбор: ");
      Scanner sc = new Scanner(System.in);
      AuthDAO uid = new UserService();
      String choice = sc.nextLine();
      switch (choice) {

        // логин
        case "1":
          System.out.println("---------- Логин ----------");

          System.out.print("Пожалуйста, введите логин: ");
          String name = sc.nextLine();
          System.out.print("Пожалуйста, введите ваш пароль: ");
          String password = sc.nextLine();

          boolean flag = uid.isLogin(name, password);
          if (flag) {
            System.out.println("«Успешный вход»");
            exit = false;
            System.out.println("==============================");
          } else {
            System.out.println("«Неверное имя пользователя или пароль, вход не выполнен»");
          }
          break;

        // зарегистрироваться
        case "2":
          System.out.println("---------- Регистрация ----------");

          System.out.print("Пожалуйста, введите имя пользователя: ");
          String newName = sc.nextLine();
          System.out.print("Пожалуйста, введите пароль: ");
          String newPassword = sc.nextLine();

          User u = new User();
          u.setPassword(newPassword);
          u.setUsername(newName);

          uid.regist(u);

          System.out.println("Регистрация прошла успешно");
          break;

        // Выход
        case "3":
          System.out.println("«Спасибо за ваше использование»");
          sc.close();
          System.exit(0);
          break;
        default:
          System.out.println("«Неверный ввод, пожалуйста, введите заново»");
          break;
      }
    } while (exit == true);
  }
}
