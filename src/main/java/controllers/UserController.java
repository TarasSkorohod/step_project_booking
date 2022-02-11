package main.java.controllers;


import main.java.authorization.User;
import main.java.services.UserService;

public class UserController {
  private UserService userService = new UserService();

  public void saveUser(User user) {userService.saveUser(user);}

  public void saveDB(String filePath) {
    userService.saveDB(filePath);
  }

  public void readDB(String filePath) {
    userService.readDB(filePath);
  }
}
