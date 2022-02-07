package utils;

import static utils.ArrayCountry.arrCountry;

public class GenerateRandomNumbers {

  public static String getRandomCountry() {
    int n = (int)Math.floor(Math.random() * arrCountry.length);
    return arrCountry[n];
  }

  public static int getRandomNumberForCountFlight() {
    return (int) ((Math.random() * (30 - 1)) + 1);
  }

  public static int getRandomNumberForDay() {
    return (int) ((Math.random() * (31 - 1)) + 1);
  }

  public static int getRandomNumberForMonth() {
    return (int) ((Math.random() * (12 - 1)) + 1);
  }

  public static int getRandomNumberForCountPeople() {
    return (int) ((Math.random() * (100 - 1)) + 1);
  }
}
