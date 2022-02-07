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

  public void prettyFormat() {
    System.out.println("---------------\n" +
      "First Name: " + firstName + ", \n" +
      "Last Name: " + lastName + ", \n");
  }
}
