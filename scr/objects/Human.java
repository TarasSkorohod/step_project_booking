package objects;

public class Human {
  String firstName;
  String lastName;

  Human() {
    this.firstName = "";
    this.lastName = "";
  }

  Human (String firstName, String lastName) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    String infoHuman =
      "First Name: " + firstName + ", \n" +
      "Last Name: " + lastName;

    return infoHuman;
  }
}
