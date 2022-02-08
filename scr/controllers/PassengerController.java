package controllers;

import objects.Passenger;
import services.PassengerService;

public class PassengerController {
  public static void getAllPassenger() {
    PassengerService.getAllPassenger();
  }

  public static void createNewPassenger(String firstName, String lastName) {
    PassengerService.createNewPassenger(firstName, lastName);
  }

  public static Passenger getPassengerByIndex(int index) {
    return PassengerService.getPassengerByIndex(index);
  }

  public static void deletePassenger(int index) {
    PassengerService.deletePassenger(index);
  }
}
