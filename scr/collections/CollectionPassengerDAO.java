package collections;

import DAO.PassengerDAO;
import objects.Passenger;
import java.util.ArrayList;
import java.util.List;

public final class CollectionPassengerDAO implements PassengerDAO {
  List<Passenger> passengers = new ArrayList<>(0);


  @Override
  public List<Passenger> getAllPassenger() {
    return passengers;
  }
  @Override
  public void savePassenger(Passenger passenger) {
    int index = 0;
    for (Passenger item : passengers) {
      if (item.equals(passenger)) {
        passengers.set(index, passenger);
        return;
      }
      index++;
    }
    passengers.add(passenger);
  }
  @Override
  public Passenger getPassengerByIndex(int index) {
    try {
      return passengers.get(index);
    } catch (Exception e) {
      System.out.println("No passengers found " + e.getMessage());
      return null;
    }
  }
  @Override
  public boolean deletePassenger(int index) {
    boolean result = false;
    if (index >= 0 && index < passengers.size()){
      passengers.remove(index);
      result = true;
    }
    return result;
  }
}
