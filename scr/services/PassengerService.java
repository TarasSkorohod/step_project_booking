package services;


import DAO.PassengerDAO;
import collections.CollectionPassengerDAO;
import objects.Passenger;

import java.util.List;

public class PassengerService {
  private static final PassengerDAO passengerDAO = new CollectionPassengerDAO();
  public static List<Passenger> getAllPassenger() {
    return passengerDAO.getAllPassenger();
  }

  public static Passenger createNewPassenger(Passenger passenger) {
    passengerDAO.savePassenger(passenger);
    return passenger;
  }

  public static Passenger getPassengerByIndex(int index) {
    return getAllPassenger().get(index);
  }

  public static void deletePassenger(int index) {

  }

  public static void displayAllPassenger() {
    for (int i = 0; i < getAllPassenger().size(); i++) {
      System.out.println("======================");
      System.out.println("Index passenger - " + i);
      System.out.println(getAllPassenger().get(i));
    }
  }
}
