package main.java.services;

import main.java.DAO.AuthDAO;
import main.java.authorization.User;
import main.java.logger.Logs;

import java.util.ArrayList;

public class UserService implements AuthDAO {
  private static ArrayList<User> array = new ArrayList<User>();

  public boolean isLogin(String username, String passworld) {
    boolean flag=false;
    for (User ui:array){
      if(ui.getUsername().equals(username)&&
        ui.getPassword().equals(passworld))
      {
        Logs.log("User correct", "info");
        flag=true;
        break;
      }
    }

    return flag;
  }

  public void regist(User user) {
    Logs.log("User register", "info");
    array.add(user);
  }
}
