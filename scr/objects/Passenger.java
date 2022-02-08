package objects;

import java.io.Serializable;

import static utils.ConfigDate.DATE_FORMAT;
import static utils.FormatDate.dateToStr;

public class Passenger implements Serializable {
  private String firstname;
  private String lastname;
  private Long birthDate;
  private Gender gender;

  public Passenger(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.birthDate = Long.valueOf(0);
    this.gender = Gender.UNKNOWN;
  }

  public Passenger(String firstname, String lastname, Long birthDate, Gender gender) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.birthDate = birthDate;
    this.gender = gender;
  }



  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public Long getBirthDate() {
    return birthDate;
  }

  public Gender getGender() {
    return gender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Passenger passenger = (Passenger) o;
    return firstname.equals(passenger.getFirstname()) &&
      lastname.equals(passenger.getLastname()) &&
      birthDate.equals(passenger.getBirthDate()) &&
      gender == passenger.getGender();
  }

  @Override
  public int hashCode() {
    int result = firstname.hashCode();
    result = 31 * result + lastname.hashCode();
    result = 31 * result + birthDate.hashCode();
    result = 31 * result + gender.hashCode();
    return result;
  }


  @Override
  public String toString() {
    return "Passenger: \n" +
      "First Name: " + firstname + "," +
      "\n Last Name: " + lastname + "," +
      "\n Birth Date: " + dateToStr(birthDate, DATE_FORMAT) + "," +
      "Gender=" + gender;
  }


}
