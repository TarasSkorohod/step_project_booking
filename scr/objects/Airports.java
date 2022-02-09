package objects;

public enum Airports {
  ZHULIANY("Жуляны"),
  FRA("Frankfurt"),
  KATOWICE("Katowice");

  private final String firstname;

  Airports(String firstname) {
    this.firstname = firstname;
  }

  public String getFirstname() {
    return firstname;
  }
}
