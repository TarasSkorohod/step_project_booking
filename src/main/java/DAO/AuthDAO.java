package main.java.DAO;

import main.java.authorization.User;


import java.util.List;

public interface AuthDAO {
  public abstract boolean isLogin(String username,String passworld);
  public abstract void regist(User user);
  void saveDB(String filePath);
  void readDB(String filePath);
  void saveUser(User user);

  void loadToDB(List<User> list);
}
