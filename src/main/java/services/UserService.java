package main.java.services;

import main.java.DAO.AuthDAO;
import main.java.authorization.User;
import main.java.collections.CollectionUsersDAO;

import java.util.ArrayList;
import java.util.List;

public class UserService implements AuthDAO {
  private ArrayList<User> array = new ArrayList<User>();
  private AuthDAO authDAO = new CollectionUsersDAO();


  public boolean isLogin(String username, String passworld) {
    boolean flag = false;
    for (User ui : array) {
      if (ui.getUsername().equals(username) &&
        ui.getPassword().equals(passworld)) {
        flag = true;
        break;
      }
    }
    return flag;
  }
  public void regist(User user) {
    array.add(user);
  }

  @Override
  public void saveDB(String filePath) {
    authDAO.saveDB(filePath);
  }

  @Override
  public void readDB(String filePath) {
    authDAO.readDB(filePath);
  }


  @Override
  public void saveUser(User user) {
    authDAO.saveUser(user);
  }

  @Override
  public void loadToDB(List<User> list) {
    authDAO.loadToDB(list);
  }
}
