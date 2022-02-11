package main.java.collections;

import main.java.DAO.AuthDAO;
import main.java.authorization.User;
import java.io.*;
import java.util.List;


public class CollectionUsersDAO implements AuthDAO {
  private List<User> UserList;
  @Override
  public boolean isLogin(String username, String passworld) {
    return false;
  }

  @Override
  public void regist(User user) {

  }

  @Override
  public void saveDB(String filePath) {
    try {
      File af = new File(filePath);
      FileOutputStream fileOutput = new FileOutputStream(af.getAbsoluteFile());
      ObjectOutputStream streamOutput = new ObjectOutputStream(fileOutput);

      streamOutput.writeObject(UserList);
      streamOutput.close();
      fileOutput.close();

    } catch (IOException e) {
      e.getStackTrace();
    }
  }

  @Override
  public void readDB(String filePath) {
    List<User> ListUser = null;

    File file = new File(filePath);
    FileInputStream fi = null;
    ObjectInputStream oi = null;

    try {

      fi = new FileInputStream(file.getAbsoluteFile());
      oi = new ObjectInputStream(fi);

      ListUser = (List<User>) oi.readObject();


      oi.close();
      fi.close();
      loadToDB(ListUser);

    } catch (ClassNotFoundException | IOException e) {
      e.getStackTrace();
    }

  }

  @Override
  public void saveUser(User user) {
    if (user != null) {
      if (UserList.contains(user)) {
        UserList.set(UserList.indexOf(user), user);
      } else {
        UserList.add(user);
      }
    }
  }

  @Override
  public void loadToDB(List<User> listUser) {
    if (listUser != null){
      listUser.forEach(this::saveUser);
    }
  }
}
