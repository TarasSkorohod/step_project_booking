package DAO;

import objects.Passenger;
import java.util.List;

public interface PassengerDAO {
  List<Passenger> getAllPassenger();
  void savePassenger(Passenger passenger);
  Passenger getPassengerByIndex(int index);
  boolean deletePassenger(int index);
}
