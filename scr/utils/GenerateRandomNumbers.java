package utils;

public class GenerateRandomNumbers {
  public static int getRandomNumberForCountFlight() {
    return (int) ((Math.random() * (30 - 1)) + 1);
  }

  public static int getRandomNumberForDay() {
    return (int) ((Math.random() * (31 - 1)) + 1);
  }

  public static int getRandomNumberForMonth() {
    return (int) ((Math.random() * (12 - 1)) + 1);
  }

  public static int getRandomNumberForYear() {
    return (int) ((Math.random() * (2999 - 2022)) + 2022);
  }

  public static int getRandomNumberForCountPeople() {
    return (int) ((Math.random() * (100 - 1)) + 1);
  }
}
