package main.java.authorization;

import java.io.Serializable;

public class User implements Serializable {
  private String username;
  private String password;

  public User(){
    this.username = "";
    this.password = "";
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public boolean setPassword(String password) {
    this.password = password;
    return false;
  }
}
