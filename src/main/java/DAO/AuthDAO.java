package main.java.DAO;

import main.java.authorization.User;

public interface AuthDAO {
  public abstract boolean isLogin(String username,String passworld);
  public abstract void regist(User user);
}
