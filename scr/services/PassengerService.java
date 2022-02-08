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

  public static void createNewPassenger(String firstName, String lastName) {
    Passenger passenger = new Passenger(firstName, lastName);
  }

  public static Passenger getPassengerByIndex(int index) {
    return getAllPassenger().get(index);
  }

  public static void deletePassenger(int index) {

  }
}
